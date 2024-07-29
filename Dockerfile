###############################################################################
FROM gradle:8.9.0-jdk22-alpine AS base

ENV WORKDIR=/app
WORKDIR ${WORKDIR}

RUN apk add --update --no-cache make
RUN apk upgrade --update --no-cache openssl libcrypto3 libssl3 # FIX CVE-2024-5535
RUN apk upgrade --update --no-cache --available # FIX CVE-2024-5535 CVE-2024-4741

###############################################################################
FROM base AS lint

ENV WORKDIR=/app
WORKDIR ${WORKDIR}

RUN apk add --update --no-cache make nodejs npm
RUN apk add --update --no-cache yamllint

RUN npm install -g --ignore-scripts markdownlint-cli

# [!TIP] Use a bind-mount to "/app" to override following "copys"
# for lint and test against "current" sources in this stage

# YAML sources
COPY ./.github ${WORKDIR}/
COPY ./compose.yaml ${WORKDIR}/

# Markdown sources
COPY ./docs ${WORKDIR}/
COPY ./README.md ${WORKDIR}/
COPY ./LICENSE.md ${WORKDIR}/
COPY ./CODE_OF_CONDUCT.md ${WORKDIR}/

# Code source
COPY ./algorithm-exercises-java ${WORKDIR}/algorithm-exercises-java
COPY ./settings.gradle ${WORKDIR}/
COPY ./Makefile ${WORKDIR}/

# code linting conf
COPY ./checkstyle.xml ${WORKDIR}/

# markdownlint conf
COPY ./.markdownlint.yaml ${WORKDIR}/

# yamllint conf
COPY ./.yamllint ${WORKDIR}/
COPY ./.yamlignore ${WORKDIR}/
COPY ./.gitignore ${WORKDIR}/

CMD ["make", "lint"]

###############################################################################
FROM base AS development

COPY ./algorithm-exercises-java ${WORKDIR}/algorithm-exercises-java
COPY ./settings.gradle ${WORKDIR}/
COPY ./Makefile ${WORKDIR}/
COPY ./checkstyle.xml ${WORKDIR}/
COPY ./gradle ${WORKDIR}/
COPY ./gradlew ${WORKDIR}/

###############################################################################
FROM development AS builder

ENV WORKDIR=/app
WORKDIR ${WORKDIR}

## build
RUN make build

# CMD []

###############################################################################
### In testing stage, can't use USER, due permissions issue
## in github actions environment:
##
## https://docs.github.com/en/actions/creating-actions/dockerfile-support-for-github-actions
##
FROM development AS testing

ENV LOG_LEVEL=INFO
ENV BRUTEFORCE=false
ENV WORKDIR=/app
WORKDIR ${WORKDIR}

RUN ls -alh

CMD ["make", "test"]

###############################################################################
### In production stage
## in the production phase, "good practices" such as
## WORKDIR and USER are maintained
##
FROM eclipse-temurin:22.0.2_9-jre-alpine AS production
RUN apk upgrade --update --no-cache openssl libcrypto3 libssl3 # FIX CVE-2024-5535
RUN apk upgrade --update --no-cache --available # FIX CVE-2024-5535 CVE-2024-4741

ENV LOG_LEVEL=INFO
ENV BRUTEFORCE=false
ENV WORKDIR=/app
WORKDIR ${WORKDIR}

RUN adduser -D worker
RUN mkdir -p /app
RUN chown worker:worker /app

RUN apk add --update --no-cache make
COPY ./Makefile ${WORKDIR}/
COPY --from=builder /app/algorithm-exercises-java/build/libs/algorithm-exercises-java.jar ${WORKDIR}/algorithm-exercises-java.jar

RUN ls -alh

USER worker
CMD ["make", "run"]

# checkov:skip= CKV_DOCKER_2: production image isn't a service process (yet)

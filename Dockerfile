ARG BUILDTIME_IMAGE=gradle:8.14.2-jdk21-alpine
ARG RUNTIME_IMAGE=eclipse-temurin:24.0.1_9-jre-alpine

###############################################################################
FROM ${BUILDTIME_IMAGE} AS base

RUN apk add --update --no-cache make \
  # FIX CVE-2024-5535
  && apk upgrade --update --no-cache openssl libcrypto3 libssl3 \
  # FIX CVE-2024-5535 CVE-2024-4741
  && apk upgrade --update --no-cache --available

  ENV WORKDIR=/app
WORKDIR ${WORKDIR}

###############################################################################
FROM base AS lint

ENV WORKDIR=/app
WORKDIR ${WORKDIR}

RUN  apk add --update --no-cache make nodejs npm\
  && apk add --update --no-cache yamllint \
  && npm install -g --ignore-scripts markdownlint-cli \
  && npm install -g --ignore-scripts markdownlint-cli prettier

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

# JSON linting conf
COPY ./.prettierrc.yaml ${WORKDIR}/

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

FROM ${RUNTIME_IMAGE} AS production

RUN apk add --update --no-cache make \
  # FIX CVE-2024-5535
  && apk upgrade --update --no-cache openssl libcrypto3 libssl3 \
  # FIX CVE-2024-5535 CVE-2024-4741
  && apk upgrade --update --no-cache --available

ENV LOG_LEVEL=INFO
ENV BRUTEFORCE=false
ENV WORKDIR=/app
WORKDIR ${WORKDIR}

RUN adduser -D worker \
  && mkdir -p /app \
  && chown worker:worker /app

COPY ./Makefile ${WORKDIR}/
COPY --from=builder /app/algorithm-exercises-java/build/libs/algorithm-exercises-java.jar ${WORKDIR}/algorithm-exercises-java.jar

RUN ls -alh

USER worker
CMD ["make", "run"]

# checkov:skip= CKV_DOCKER_2: production image isn't a service process (yet)

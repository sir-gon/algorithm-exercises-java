###############################################################################
FROM gradle:8.8.0-jdk21-alpine AS base

ENV WORKDIR=/app
WORKDIR ${WORKDIR}

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
COPY ./checkstyle.xml ${WORKDIR}/checkstyle.xml

# markdownlint conf
COPY ./.markdownlint.yaml ${WORKDIR}/

# yamllint conf
COPY ./.yamllint ${WORKDIR}/
COPY ./.yamlignore ${WORKDIR}/

CMD ["make", "lint"]

###############################################################################
FROM base AS development

RUN apk add --update --no-cache make

###############################################################################
FROM development AS builder

WORKDIR /app

## Copy sources to builder stage
COPY ./algorithm-exercises-java ${WORKDIR}/algorithm-exercises-java
COPY ./config ${WORKDIR}/config
COPY ./gradle ${WORKDIR}/gradle
COPY ./gradlew ${WORKDIR}/gradlew
COPY ./settings.gradle ${WORKDIR}/settings.gradle
COPY ./Makefile ${WORKDIR}/Makefile

## build
RUN chmod +x gradlew
RUN gradle --console=verbose build

###############################################################################
### In testing stage, can't use USER, due permissions issue
## in github actions environment:
##
## https://docs.github.com/en/actions/creating-actions/dockerfile-support-for-github-actions
##
FROM builder AS testing

ENV LOG_LEVEL=INFO
ENV BRUTEFORCE=false

WORKDIR /app

RUN ls -alh

CMD ["make", "test"]

###############################################################################
### In production stage
## in the production phase, "good practices" such as
## WORKDIR and USER are maintained
##
FROM eclipse-temurin:22.0.1_8-jre-alpine AS production

ENV LOG_LEVEL=INFO
ENV BRUTEFORCE=false

RUN adduser -D worker
RUN mkdir -p /app
RUN chown worker:worker /app

WORKDIR /app

COPY --from=builder ./algorithm-exercises-java/build/libs/algorithm-exercises-java.jar ${WORKDIR}/algorithm-exercises-java.jar
RUN ls -alh

USER worker

# CMD []

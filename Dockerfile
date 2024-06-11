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
COPY ./config ${WORKDIR}/config
COPY ./Makefile ${WORKDIR}/

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
FROM builder AS testing

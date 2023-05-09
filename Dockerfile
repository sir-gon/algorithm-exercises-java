###############################################################################
FROM gradle:8.0.2-jdk19-alpine as development

RUN apk add --update --no-cache make

WORKDIR /app

###############################################################################
FROM development as builder

WORKDIR /app

## Copy sources to builder stage
COPY ./ /app

## build
RUN chmod +x gradlew
RUN gradle --console=verbose build

###############################################################################
FROM builder as testing

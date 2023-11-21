###############################################################################
FROM gradle:8.4.0-jdk20-alpine AS development

RUN apk add --update --no-cache make

WORKDIR /app

###############################################################################
FROM node:20.2.0-alpine3.16 AS lint

ENV WORKDIR=/app
WORKDIR ${WORKDIR}

COPY ./algorithm-exercises-java ${WORKDIR}/algorithm-exercises-java
RUN apk add --update --no-cache make
RUN npm install -g markdownlint-cli

###############################################################################
FROM development AS builder

WORKDIR /app

## Copy sources to builder stage
COPY ./algorithm-exercises-java /app/algorithm-exercises-java
COPY ./config /app/config
COPY ./gradle /app/gradle
COPY ./gradlew /app/gradlew
COPY ./settings.gradle /app/settings.gradle
COPY ./Makefile /app/Makefile

## build
RUN chmod +x gradlew
RUN gradle --console=verbose build

###############################################################################
FROM builder AS testing

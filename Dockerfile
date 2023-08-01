###############################################################################
FROM gradle:8.0.2-jdk19-alpine AS development

RUN apk add --update --no-cache make

WORKDIR /app

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

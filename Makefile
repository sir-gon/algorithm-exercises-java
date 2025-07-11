## REFERENCES:
## (1) Passing environment variable with fallback value to Makefile:
##    https://stackoverflow.com/a/70772707/6366150
## (2) Export environment variables inside "make environment"
##		https://stackoverflow.com/a/49524393/6366150
## (3) Uppercase to lowercase and vice versa
##		https://community.unix.com/t/uppercase-to-lowercase-and-vice-versa/285278/6
## (4) How do I trim leading and trailing whitespace from each line of some output?
## 		https://unix.stackexchange.com/a/279222/233927
############################################################################

## (1) ## Allowed values: info | warn | error | debug
LOG_LEVEL ?= info
## (3) (4)
LOG_LEVEL :=$(shell echo '${LOG_LEVEL}'| tr '[:lower:]' '[:upper:]'| tr -d '[:blank:]')

## (1) ## Allowed values: true | false
BRUTEFORCE ?= false
## (3) (4)
BRUTEFORCE :=$(shell echo '${BRUTEFORCE}'| tr '[:lower:]' '[:upper:]'| tr -d '[:blank:]')

# Package Manager
# GRADLE=./gradlew
GRADLE=gradle

# DOCKER
BUILDKIT_PROGRESS=plain
DOCKER_COMPOSE=docker compose

.MAIN: test
.PHONY: all clean dependencies help list test outdated
.EXPORT_ALL_VARIABLES: # (2)

help: list

list:
	@LC_ALL=C $(MAKE) -pRrq -f $(lastword $(MAKEFILE_LIST)) : 2>/dev/null | awk -v RS= -F: '/^# File/,/^# Finished Make data base/ {if ($$1 !~ "^[#.]") {print $$1}}' | sort | egrep -v -e '^[^[:alnum:]]' -e '^$@$$'

env:
	@echo "################################################################################"
	@echo "## Environment: ################################################################"
	@echo "################################################################################"
	@printenv | grep -E "LOG_LEVEL|BRUTEFORCE|BUILDKIT_PROGRESS"
	@echo "################################################################################"

## Dependency management
dependencies:
	@echo "################################################################################"
	@echo "## Dependencies: ###############################################################"
	@echo "################################################################################"
	$(GRADLE) dependencies --refresh-dependencies
	@echo "################################################################################"

outdated:
	$(GRADLE) dependencyUpdates

update: # TODO: Implement dependency update (dependency file)
	@echo "NOT IMPLEMENTED YET"

upgrade: # TODO: Implement dependency upgrade (download and install latest)
	@echo "NOT IMPLEMENTED YET"

clean:
	$(GRADLE) clean

## Building process
build: env
	$(GRADLE) --console=verbose clean build \
		--exclude-task test \
		--exclude-task checkstyleMain \
		--exclude-task checkstyleTest

## Source code linting and formatting
lint/json:
	prettier --check ./algorithm-exercises-java/**/*.json

lint/markdown:
	markdownlint '**/*.md' --ignore node_modules && echo '✔  Your code looks good.'

lint/yaml:
	yamllint --stric . && echo '✔  Your code looks good.'

lint: lint/markdown lint/yaml lint/json test/styling test/static

format/json:
	prettier --write ./algorithm-exercises-java/**/*.json

format/sources: # TODO: Implement source code formatting
	@echo "NOT IMPLEMENTED YET"

format: format/sources format/json

## Static code analysis
test/styling: dependencies
	$(GRADLE) --console=verbose clean checkstyleMain checkstyleTest

test/static: dependencies

## Unit tests and coverage
test: env
	$(GRADLE) --console=verbose clean test -x checkstyleMain checkstyleTest

coverage: test

coverage/html: test
	open algorithm-exercises-java/build/reports/jacoco/test/html/index.html

## Docker Compose commands
compose/build: env
	${DOCKER_COMPOSE} --profile lint build
	${DOCKER_COMPOSE} --profile testing build
	${DOCKER_COMPOSE} --profile production build

compose/rebuild: env
	${DOCKER_COMPOSE} --profile lint build --no-cache
	${DOCKER_COMPOSE} --profile testing build --no-cache
	${DOCKER_COMPOSE} --profile production build --no-cache

compose/lint/markdown: compose/build
	${DOCKER_COMPOSE} --profile lint run --rm algorithm-exercises-java-lint make lint/markdown

compose/lint/yaml: compose/build
	${DOCKER_COMPOSE} --profile lint run --rm algorithm-exercises-java-lint make lint/yaml

compose/test/styling: compose/build
	${DOCKER_COMPOSE} --profile lint run --rm algorithm-exercises-java-lint make test/styling

compose/test/static: compose/build
	${DOCKER_COMPOSE} --profile lint run --rm algorithm-exercises-java-lint make test/static

compose/lint: compose/lint/markdown compose/lint/yaml compose/test/styling compose/test/static

compose/test: compose/build
	${DOCKER_COMPOSE} --profile testing run --rm algorithm-exercises-java-test make test

compose/run: compose/build
	${DOCKER_COMPOSE} --profile testing run --rm algorithm-exercises-java make run
all: env dependencies lint test

run:
	ls -alh

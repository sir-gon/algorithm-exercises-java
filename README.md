[![Java CI with Gradle](https://github.com/sir-gon/projecteuler-java/actions/workflows/gradle.yml/badge.svg?branch=main)](https://github.com/sir-gon/projecteuler-java/actions/workflows/gradle.yml) [![codecov](https://codecov.io/gh/sir-gon/projecteuler-java/branch/main/graph/badge.svg?token=7QAS85D3HB)](https://codecov.io/gh/sir-gon/projecteuler-java)

![GitHub](https://img.shields.io/github/license/sir-gon/projecteuler-java) ![GitHub language count](https://img.shields.io/github/languages/count/sir-gon/projecteuler-java) ![GitHub top language](https://img.shields.io/github/languages/top/sir-gon/projecteuler-java)

# What is this?

[Project Euler](https://projecteuler.net/) provide some algorithms and mathematical problems to solve to be used as experience tests.

Use this answers to learn some tip and tricks for algorithms tests.

# Why I publish solutions?

As Project Euler says:

https://projecteuler.net/about#publish


```
I learned so much solving problem XXX, so is it okay to publish my solution elsewhere?
It appears that you have answered your own question. There is nothing quite like that "Aha!" moment when you finally beat a problem which you have been working on for some time. It is often through the best of intentions in wishing to share our insights so that others can enjoy that moment too. Sadly, that will rarely be the case for your readers. Real learning is an active process and seeing how it is done is a long way from experiencing that epiphany of discovery. Please do not deny others what you have so richly valued yourself.

However, the rule about sharing solutions outside of Project Euler does not apply to the first one-hundred problems, as long as any discussion clearly aims to instruct methods, not just provide answers, and does not directly threaten to undermine the enjoyment of solving later problems. Problems 1 to 100 provide a wealth of helpful introductory teaching material and if you are able to respect our requirements, then we give permission for those problems and their solutions to be discussed elsewhere.
```


If you have better answers or optimal solutions, fork and PR-me

Enjoy 😁 !

# Using Java runtime

## Testing silently

Every problem is a function with unit test.
Unit test has test cases and input data to solve the problem.

Run all tests:

```
gradle clean test
```

### Testing with full logs

Run all tests with debug outputs:

```
LOG_LEVEL=debug gradle clean test
```

Use one of following values: debug, warning, error, info.

## Testing using make

```
make test
```

### Enable all large BRUTEFORCE tests

Direct in host using a make:

```
make test -e BRUTEFORCE=true
```

### Enable all DEBUG outputs


```
make test -e LOG_LEVEL=debug
```

### Enable all large BRUTEFORCE tests and all DEBUG outputs

```
make test -e LOG_LEVEL=debug -e BRUTEFORCE=true
```

# Running with Docker 🐳

## Build a complete image with and run all tests
Running container with testing (final) target.

Designed to store all application files and dependencies as a complete runnable image.
Coverage results will be stored in host **/coverage** directory (mounted as volume).

```
# Build a complete image
docker-compose build projecteuler-java
docker-compose run --rm projecteuler-java gradle clean test
```

## Enable BRUTEFORCE tests with full DEBUG output

With docker-compose:

```
docker-compose --profile testing run --rm projecteuler-java make test -e LOG_LEVEL=DEBUG -e BRUTEFORCE=true
```

Using make:
```
make docker/compose-run -e LOG_LEVEL=DEBUG -e BRUTEFORCE=true
```

## Build and run a development image

Running container with development target.
Designed to develop on top of this image. All source application is mounted as a volume in **/app** directory.
Dependencies should be installed to run (not present in this target) so, you must install dependencies before run (or after a dependency add/change).

```
# install node_modules dependencies using docker runtime and store them in host directory
docker-compose build --compress projecteuler-java-dev
docker-compose run --rm projecteuler-java-dev gradle clean test
```

# About development

Developed with runtime:

```
java --version
openjdk 19.0.2 2023-01-17
OpenJDK Runtime Environment Temurin-19.0.2+7 (build 19.0.2+7)
OpenJDK 64-Bit Server VM Temurin-19.0.2+7 (build 19.0.2+7, mixed mode, sharing)
```

## Coverage
[![Coverage](https://codecov.io/gh/sir-gon/projecteuler-java/branch/main/graphs/tree.svg?token=7QAS85D3HB)](https://codecov.io/gh/sir-gon/projecteuler-java)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fsir-gon%2Fprojecteuler-java.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fsir-gon%2Fprojecteuler-java?ref=badge_shield)


## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fsir-gon%2Fprojecteuler-java.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fsir-gon%2Fprojecteuler-java?ref=badge_large)
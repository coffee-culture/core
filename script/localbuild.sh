#!/usr/bin/env bash

PROJECT_NAME=coffeeculture/core
GIT_BRANCH=${GIT_BRANCH:-$(git rev-parse --abbrev-ref HEAD)}

set -e
cd "$(dirname "$0")/.."

printf "\nLocal build for $PROJECT_NAME. \n"
printf " --> git branch: $GIT_BRANCH\n\n"

printf "\nFormatting source and executing build... \n\n"
./gradlew formatKotlin build
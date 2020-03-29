# core
Validate &amp; standardize incoming updates.

## Requirements & Dependencies
### Environment Variables
```
    DOCKERHUB_USERNAME | DockerHub Username.
    DOCKERHUB_PASSWORD | DockerHub Password
```

## Building the Project
### Using scripts
```
script/localbuild   | runs formatter, builds project, runs all checks
* script/test       | runs full test suite, including spinning up dependent containers
script/cibuild      | runs build and push scripts within Docker container
script/build        | builds Docker release image within Docker container
script/push         | pushes image to DockerHub

* not yet implemented
```
### Using the Gradle Wrapper
```
./gradlew formatKotlin  | formats source to Kotlin styleguide as best as possible
./gradlew build         | builds project, runs all checks
./gradlew bootRun       | builds project, runs all checks, starts app
```

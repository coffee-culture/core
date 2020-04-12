FROM adoptopenjdk/openjdk14:jdk-14_36-alpine-slim as build

WORKDIR /app
COPY . ./

RUN ./gradlew build

FROM adoptopenjdk/openjdk14:jre-14_36-alpine as release
EXPOSE 8080

WORKDIR /app
COPY --from=build /app/build/libs/core-0.0.1-SNAPSHOT.jar /app

CMD java -jar /app/core-0.0.1-SNAPSHOT.jar

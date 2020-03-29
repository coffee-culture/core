FROM openjdk:14-alpine as build

WORKDIR /app
COPY . ./

RUN ./gradlew build

FROM openjdk:14-alpine as release
EXPOSE 8080

WORKDIR /app
COPY --from=build /app/build/libs/core-0.0.1-SNAPSHOT.jar /app

CMD java -jar /app/core-0.0.1-SNAPSHOT.jar
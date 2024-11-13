# Maven build stage
FROM maven:3.9.9-amazoncorretto-21-debian-bookworm AS build
WORKDIR /app
COPY quiz-test/pom.xml .
COPY quiz-test/src ./src
RUN mvn clean package -DskipTests

# JDK runtime stage
FROM openjdk:21-slim-bullseye
WORKDIR /app
COPY --from=build /app/target/quiz-test-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

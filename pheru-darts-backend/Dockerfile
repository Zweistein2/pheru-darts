#### Stage 1: Build the fat jar
FROM maven:3.6.0-jdk-11-slim AS build

COPY src /home/app/src

COPY pom.xml /home/app

# run maven command to build the jar
RUN mvn -f /home/app/pom.xml clean package -DskipTests -Dmaven.test.skip=true

#### Stage 2: Serve the Spring Boot Application
FROM openjdk:8-jdk-alpine

# Add user with no root-privileges for security reasons
RUN addgroup -S dart && adduser -S dart -G dart
USER dart:dart

# Add the fat jar to the container so it can start
COPY --from=build /home/app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
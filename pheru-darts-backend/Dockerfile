FROM openjdk:8-jdk-alpine

# Add user with no root-privileges for security reasons
RUN addgroup -S dart && adduser -S dart -G dart
USER dart:dart

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
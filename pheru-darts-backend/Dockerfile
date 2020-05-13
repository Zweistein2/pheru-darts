FROM openjdk:8-jdk-alpine

# Create the fat jar
RUN mvn clean install

# Add user with no root-privileges for security reasons
RUN addgroup -S dart && adduser -S dart -G dart
USER dart:dart

# Add the fat jar to the container so it can start
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
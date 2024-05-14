FROM openjdk:20-slim
ADD target/the-walking-dead-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

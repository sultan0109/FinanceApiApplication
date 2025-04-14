FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/financial-api.jar /app/financial-api.jar
ENTRYPOINT ["java", "-jar", "financial-api.jar"]


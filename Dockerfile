FROM maven:3.9.6-eclipse-temurin-17 as builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /build/target/Finance-api-0.0.1-SNAPSHOT.jar /app/financial-api.jar
ENTRYPOINT ["java", "-jar", "financial-api.jar"]

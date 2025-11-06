FROM maven:3.9.6-sapmachine-21-slim AS builder
WORKDIR /app
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY src src
RUN ./mvnw clean install -DskipTests
FROM sapmachine/jdk-alpine:21
ENV PORT 8080
EXPOSE 8080
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
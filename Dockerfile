FROM eclipse-temurin:22-jre-alpine

WORKDIR /app

COPY target/URLShortener-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

FROM amazoncorretto:21
LABEL author="leonardogloria"
WORKDIR /app
COPY cerveja-service-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT  ["java", "-jar", "app.jar"]
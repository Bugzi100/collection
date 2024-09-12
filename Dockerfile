FROM openjdk:22-jdk
WORKDIR /app
COPY target/collection-0.0.1-SNAPSHOT.jar /app/collection.jar
ENTRYPOINT ["java", "-jar", "/app/collection.jar"]
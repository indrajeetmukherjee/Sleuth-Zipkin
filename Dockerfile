FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/sleuth-webmvc-example-0.0.1-SNAPSHOT-exec.jar tracing.jar
EXPOSE 8081
CMD ["java", "-jar", "tracing.jar"]
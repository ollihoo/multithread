FROM openjdk:8-jdk-alpine
VOLUME /config
EXPOSE 8080
ADD target/multithreading-0.1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

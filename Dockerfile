FROM amazoncorretto:18-alpine-jdk
MAINTAINER Agustin Vessoni
COPY target/Vessoni-0.0.1-SNAPSHOT.jar vess-app.jar
ENTRYPOINT ["java", "-jar","/vess-app.jar"]
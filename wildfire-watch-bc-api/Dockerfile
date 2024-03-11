FROM gradle:6.3.0-jdk11 AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

FROM openjdk:11-jre-slim

ENV JAVA_HOME=/docker-java-home
ENV PATH $PATH:$JAVA_HOME/bin


EXPOSE 8090

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/ca.bc.gov.wildfirewatch-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/app/ca.bc.gov.wildfirewatch-0.0.1-SNAPSHOT.jar"]

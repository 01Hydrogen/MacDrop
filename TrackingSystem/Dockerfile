# To build:  docker build -t macdrop-tracking .

#check jdk version
FROM eclipse-temurin:8-jdk
RUN mkdir /opt/app
COPY ./target/TrackingSystem-1.0-SNAPSHOT.jar /opt/app/tracking.jar
CMD ["java", "-jar", "/opt/app/tracking.jar"]

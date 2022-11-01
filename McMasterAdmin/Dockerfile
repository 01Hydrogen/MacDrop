# To build:  docker build -t macdrop-mcmaster-admin .

#check jdk version
FROM eclipse-temurin:8-jdk
RUN mkdir /opt/app
COPY ./target/McMasterAdmin-1.0-SNAPSHOT.jar /opt/app/mcmaster-admin.jar
CMD ["java", "-jar", "/opt/app/mcmaster-admin.jar"]
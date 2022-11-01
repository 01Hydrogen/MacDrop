# To build:  docker build -t macdrop-user .

#check jdk version
FROM eclipse-temurin:8-jdk
RUN mkdir /opt/app
COPY ./target/UserManagement-1.0-SNAPSHOT.jar /opt/app/user.jar
CMD ["java", "-jar", "/opt/app/user.jar"]

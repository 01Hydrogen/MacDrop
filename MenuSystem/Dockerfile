# To build:  docker build -t macdrop-menu .

#check jdk version
FROM eclipse-temurin:8-jdk
RUN mkdir /opt/app
COPY ./target/MenuSystem-1.0-SNAPSHOT.jar /opt/app/menu.jar
CMD ["java", "-jar", "/opt/app/menu.jar"]

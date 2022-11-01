# To build:  docker build -t macdrop-bookstore .

#check jdk version
FROM eclipse-temurin:8-jdk
RUN mkdir /opt/app
COPY ./target/Bookstore-1.0-SNAPSHOT.jar /opt/app/bookstore.jar
CMD ["java", "-jar", "/opt/app/bookstore.jar"]

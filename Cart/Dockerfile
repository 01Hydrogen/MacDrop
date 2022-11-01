# To build:  docker build -t macdrop-cart .

#check jdk version
FROM eclipse-temurin:8-jdk
RUN mkdir /opt/app
COPY ./target/Cart-1.0-SNAPSHOT.jar /opt/app/cart.jar
CMD ["java", "-jar", "/opt/app/cart.jar"]

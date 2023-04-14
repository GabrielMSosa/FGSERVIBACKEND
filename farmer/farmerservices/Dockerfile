FROM openjdk:17-jdk-alpine as builder
WORKDIR /fgservice/farmer/farmerservices
COPY ./farmer/farmerservices/pom.xml .
COPY ./farmer/farmerservices/mvnw .
COPY ./farmer/farmerservices/.mvn ./.mvn
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip

COPY ./farmer/farmerservices/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /fgservice
EXPOSE 8087
COPY --from=builder /fgservice/farmer/farmerservices/target/farmerservices-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "farmerservices-0.0.1-SNAPSHOT.jar"]

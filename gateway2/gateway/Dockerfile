FROM openjdk:17-jdk-alpine as builder
WORKDIR /fgservice/gateway2/gateway
COPY ./gateway2/gateway/pom.xml .
COPY ./gateway2/gateway/mvnw .
COPY ./gateway2/gateway/.mvn ./.mvn
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip

COPY ./gateway2/gateway/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /fgservice
EXPOSE 8080
COPY --from=builder /fgservice/gateway2/gateway/target/gateway-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "gateway-0.0.1-SNAPSHOT.jar"]
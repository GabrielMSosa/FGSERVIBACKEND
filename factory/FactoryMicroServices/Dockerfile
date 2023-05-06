
FROM openjdk:17-jdk-alpine as builder
WORKDIR /fgservice/factory/FactoryMicroServices
COPY ./factory/FactoryMicroServices/pom.xml .
COPY ./factory/FactoryMicroServices/mvnw .
COPY ./factory/FactoryMicroServices/.mvn ./.mvn
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip

COPY ./factory/FactoryMicroServices/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /fgservice
EXPOSE 8085
COPY --from=builder /fgservice/factory/FactoryMicroServices/target/factoryMicroServices-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "factoryMicroServices-0.0.1-SNAPSHOT.jar"]

FROM openjdk:17-jdk-alpine as builder
WORKDIR /fgservice/auth2/auth
COPY ./auth2/auth/pom.xml .
COPY ./auth2/auth/mvnw .
COPY ./auth2/auth/.mvn ./.mvn
RUN dos2unix ./mvnw
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip

COPY ./auth2/auth/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /fgservice
EXPOSE 8086
COPY --from=builder /fgservice/auth2/auth/target/auth-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "auth-0.0.1-SNAPSHOT.jar"]

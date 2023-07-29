FROM openjdk:17-jdk-alpine as builder
WORKDIR /fgservice/msvc-frontend/msvc-frontend
COPY ./msvc-frontend/msvc-frontend/pom.xml .
COPY ./msvc-frontend/msvc-frontend/mvnw .
COPY ./msvc-frontend/msvc-frontend/.mvn ./.mvn
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip

COPY ./msvc-frontend/msvc-frontend/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /fgservice
EXPOSE 8073
COPY --from=builder /fgservice/msvc-frontend/msvc-frontend/target/msvc-frontend-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "msvc-frontend-0.0.1-SNAPSHOT.jar"]

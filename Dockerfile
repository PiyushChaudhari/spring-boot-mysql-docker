FROM openjdk:8
ADD target/spring-boot-mysql-docker-0.0.1-SNAPSHOT.jar spring-boot-mysql-docker-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-mysql-docker-0.0.1-SNAPSHOT.jar"]
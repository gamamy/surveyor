FROM openjdk:11
LABEL maintainer="gama"
ADD target/surveryor-0.0.1-SNAPSHOT.jar surveryor.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "surveryor.jar"]
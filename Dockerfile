FROM openjdk:17-jdk-alpine
WORKDIR application
COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar ./
ENTRYPOINT ["java","-jar","D387_sample_code-0.0.2-SNAPSHOT.jar"]
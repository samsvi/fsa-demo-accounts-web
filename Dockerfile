FROM openjdk:17-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} /opt/app.jar
ENTRYPOINT ["java","-jar","/opt/app.jar","--spring.config.location=/opt/config/application.yml"]
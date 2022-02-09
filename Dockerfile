#FROM openjdk:11
#ADD target/*.jar app.jar
#EXPOSE 9998
#ENTRYPOINT ["java","-jar", "app.jar"]
#
#FROM adoptopenjdk:11-jre-hotspot
#ARG JAR_FILE=*.jar
#COPY ${JAR_FILE} application.jar
#ENTRYPOINT ["java", "-jar", "application.jar"]


FROM openjdk:11
ADD target/*.jar spring-boot-docker.jar
EXPOSE 9998
ENTRYPOINT ["java", "-jar","spring-boot-docker.jar"]


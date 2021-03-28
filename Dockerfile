  
#https://medium.com/swlh/build-a-docker-image-using-maven-and-spring-boot-58147045a400
FROM openjdk:8
ARG JAR_FILE=/target/*.jar
#ADD ${JAR_FILE} alc-autobots-checklist.jar
VOLUME /tmp
EXPOSE 7070
#CMD docker rmi $(docker images -qa -f 'dangling=true')
COPY ${JAR_FILE} student-service.jar
ENTRYPOINT ["java", "-jar", "/student-service.jar"]

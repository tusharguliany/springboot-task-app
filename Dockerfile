FROM openjdk:11
VOLUME /tmp
COPY target/task-app.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
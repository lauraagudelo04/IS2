FROM openjdk:23
VOLUME /tmp
EXPOSE 8443
COPY target/ucobet-generales-ms-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/bootsecurity.12 /bootsecurity.12/
ENTRYPOINT ["java", "-jar", "/app.jar"]
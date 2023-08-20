FROM amazoncorretto:17.0.3
COPY ./target/fetch-gitrepo-0.0.1-SNAPSHOT.jar /opt/

ENTRYPOINT ["java", "-jar", "/opt/fetch-gitrepo-0.0.1-SNAPSHOT.jar"]
USER nobody
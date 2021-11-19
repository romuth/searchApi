FROM openjdk:11-oracle
VOLUME /tmp
ADD target/searchApi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar", "example.searchapi.SearchApiApplication"]
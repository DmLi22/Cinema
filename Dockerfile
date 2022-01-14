FROM adoptopenjdk/openjdk11

ADD target/j20-cinema-1.0-SNAPSHOT.jar /home/j20-cinema-1.0-SNAPSHOT.jar

ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=linux-docker -jar  home/j20-cinema-1.0-SNAPSHOT.jar" ]
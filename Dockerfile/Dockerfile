FROM openjdk:8u222-jre
VOLUME /tmp
EXPOSE 8080
ADD server/target.jar target.jar
CMD java -jar target.jar --server.port=8080
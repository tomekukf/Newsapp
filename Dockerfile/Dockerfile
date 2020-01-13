FROM openjdk:8u222-jre
VOLUME /tmp
EXPOSE 8097
ADD server/App.jar App.jar
CMD java -jar App.jar --server.port=8097

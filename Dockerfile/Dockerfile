FROM openjdk:8u222-jre
VOLUME /tmp
EXPOSE 8097
ADD server/Newsapp.jar Newsapp.jar
CMD java -jar Newsapp.jar --server.port=8097

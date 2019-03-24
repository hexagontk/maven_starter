
FROM openjdk:11
ENV PROJECT maven_starter

COPY target/${PROJECT}-*-*.jar /opt/$PROJECT/${PROJECT}.jar
WORKDIR /opt/$PROJECT
EXPOSE 9090
ENTRYPOINT java -jar /opt/$PROJECT/${PROJECT}.jar

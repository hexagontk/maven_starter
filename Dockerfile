
FROM eclipse-temurin:11-jre-alpine
ENV PROJECT maven_starter

USER 1000
COPY --chown=1000:1000 target/${PROJECT}-*.jar /opt/$PROJECT/${PROJECT}.jar
WORKDIR /opt/$PROJECT
EXPOSE 9090
ENTRYPOINT java -jar /opt/$PROJECT/${PROJECT}.jar

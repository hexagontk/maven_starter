
Maven Starter Application
=========================
This is a Hexagon service created from a template.

Software Requirements
---------------------
To build the application you will need:
* JDK 11+ for compiling the sources.
* An Internet connection to download the dependencies.

To run the application:
* JRE 11+ (JDK is not required at runtime).

Development
-----------
* Build: `./mvnw compile`
* Rebuild: `./mvnw clean package`
* Run: `./mvnw exec:java`
* Test (*\*Test*): `./mvnw test`
* Integration Test (*\*IT*): `./mvnw verify`
* Test Coverage: `./mvnw test verify jacoco:report`
* Run Container (after assemble): `docker-compose up -d`

The reports are located in the `target` directory after building the project.

Maven Wrapper Setup
-------------------
You can change Gradle version in `.mvn/wrapper/maven-wrapper.properties`.

Usage
-----
After building the project (`./mvnw package`), an archive with the application's executable JAR is
stored in `target/<projectName>-<version>-jar-with-dependencies.jar`.

You can run the application executing the following command:
`java -jar target/<projectName>-<version>-jar-with-dependencies.jar`

Logs are stored in the `log` directory inside the script's execution directory.

Once the application is running, you can send a request executing:
`curl http://localhost:9090/text`

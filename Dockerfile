FROM adoptopenjdk:16-jre-hotspot
WORKDIR /app
COPY target/populationAPI-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "populationAPI-0.0.1-SNAPSHOT.jar"]

FROM openjdk:8-alpine

COPY target/uberjar/luminus-shadow-reframe-immutant.jar /luminus-shadow-reframe-immutant/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/luminus-shadow-reframe-immutant/app.jar"]

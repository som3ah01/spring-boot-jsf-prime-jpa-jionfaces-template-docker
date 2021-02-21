FROM openjdk:latest

ADD target/jsf-joinfaces-jpa-specifications-template-0.1.jar app.jar

ENTRYPOINT [ "java" ,"-jar", "app.jar" ]

EXPOSE 8081
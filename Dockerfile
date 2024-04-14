FROM openjdk:17
EXPOSE 8080
WORKDIR /app
COPY target/team9-backend-0.0.1-SNAPSHOT.jar team9-backend-0.0.1-SNAPSHOT.jar

ENV SPRING_DATASOURCE_URL=jdbc:mysql://team9.ct6mko20gddw.ap-southeast-1.rds.amazonaws.com:3306/team9
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENTRYPOINT ["java","-jar","/team9-backend-0.0.1-SNAPSHOT.jar"]


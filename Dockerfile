# Use the official OpenJDK 17 image as the base image
FROM openjdk:17

# Expose port 8080
EXPOSE 8080

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host into the container
# Make sure the 'target' directory and the JAR file are present in the build context
COPY target/team9-backend-0.0.1-SNAPSHOT.jar team9-backend-0.0.1-SNAPSHOT.jar

ENV SPRING_DATASOURCE_URL=jdbc:mysql://team9.ct6mko20gddw.ap-southeast-1.rds.amazonaws.com:3306/team9
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

CMD ["java","-jar","/team9-backend-0.0.1-SNAPSHOT.jar"]


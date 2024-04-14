# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container at /app
COPY target/nus-team-9.jar /app/

# Set environment variables
ENV SPRING_DATASOURCE_URL=jdbc:mysql://team9.ct6mko20gddw.ap-southeast-1.rds.amazonaws.com:3306/team9
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the Spring Boot application when the container launches
CMD ["java", "-jar", "nus-team-9.jar"]
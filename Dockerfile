# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Expose port 8080 to the outside world
EXPOSE 8080

# Set a build argument for the JAR file path
ARG JAR_FILE
COPY ${JAR_FILE} /app/nus-team-9.jar

# Set environment variables
ENV SPRING_DATASOURCE_URL=jdbc:mysql://team9.ct6mko20gddw.ap-southeast-1.rds.amazonaws.com:3306/team9
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

# Run the Spring Boot application when the container launches
ENTRYPOINT ["java", "-jar", "/app/nus-team-9.jar"]
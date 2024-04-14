# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-alpine

# Expose port 8080
EXPOSE 8080

# Copy the JAR file from the host into the container
# Assumes that the JAR file is located in the target directory
COPY ./target/nus-team-9.jar nus-team-9.jar

# Set environment variables
ENV SPRING_DATASOURCE_URL=jdbc:mysql://team9.ct6mko20gddw.ap-southeast-1.rds.amazonaws.com:3306/team9
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

# Command to run the application
ENTRYPOINT ["java", "-jar", "/nus-team-9.jar"]

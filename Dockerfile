# Start with a base image containing Java runtime
FROM maven:3.8.4-openjdk-17 as build
 
# Set the working directory in the Docker image
WORKDIR /app
 
# Copy the Maven project
COPY pom.xml .
 
# Fetch all dependencies
RUN mvn dependency:go-offline
 
# Copy the project source
COPY src src
 
# Package the application
RUN mvn package -DskipTests
 
# For the final image, use the Java runtime image
FROM openjdk:17-alpine

# Set environment variables
ENV SPRING_DATASOURCE_URL=jdbc:mysql://team9.ct6mko20gddw.ap-southeast-1.rds.amazonaws.com:3306/team9
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

# Copy the jar file from the build stage to the final image
COPY --from=build /app/target/*.jar app.jar
 
# Expose the port the app runs on
EXPOSE 8080


 
# Run the jar file 
ENTRYPOINT ["java","-jar","/app.jar"]

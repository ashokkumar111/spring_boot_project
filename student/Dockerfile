# Use an official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container (replace with your actual JAR file name)
COPY target/student-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the Spring Boot app will run on
EXPOSE 8080

# Command to run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

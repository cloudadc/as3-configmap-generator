# Use openjdk 13 as a base image
FROM openjdk:13

# Set Label
LABEL maintainer "kylinsoong.1214@gmail.com"

# Set the working directory to /app
WORKDIR /app

# Copy the runable jar into the container at /app
ADD target/cis-as3-cm-generator-0.0.1.jar /app

# Make port 8080 available to the world outside this container
EXPOSE 8080

ENV APP_DATACENTER_NAME="local"
ENV APP_VERSION_NUMBER="0.0"

# Run  when the container launches
CMD ["java", "-jar", "cis-as3-cm-generator-0.0.1.jar"]

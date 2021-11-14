FROM amazoncorretto:17.0.1
COPY fibonacci-jvm-server.jar fibonacci-jvm-server.jar

# The only command to run when an image is being executed.
# Only the last CMD will work.
CMD ["java","-jar","fibonacci-jvm-server.jar"]

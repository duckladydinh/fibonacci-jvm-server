# You can manually build the image by running:
#  ./gradlew build && docker build build/libs -f Dockerfile -t hub.docker.com/duckladydinh/fibonacci-jvm-server:1.0-SNAPSHOT
#
# You can manually run the image by running:
#  docker run -it -p 9999:9999 hub.docker.com/duckladydinh/fibonacci-jvm-server:1.0-SNAPSHOT
#
FROM amazoncorretto:17.0.1
COPY fibonacci-jvm-server.jar fibonacci-jvm-server.jar

# The only command to run when an image is being executed.
# Only the last CMD will work.
CMD ["java","-jar","fibonacci-jvm-server.jar"]

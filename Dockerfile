FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./build/libs/meteorology-0.0.1-SNAPSHOT.jar meteorology.jar
ENTRYPOINT ["java","-jar","/meteorology.jar"]
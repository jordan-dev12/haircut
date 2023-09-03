FROM openjdk:17-oracle
EXPOSE 8080 
ADD target/hairbook.jar hairbook.jar
ENTRYPOINT ["java","-jar","/hairbook.jar"]


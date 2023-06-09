FROM openjdk:17-alpine
ADD target/product-1.0.0-SNAPSHOT.jar nagp-product-service.jar
ENTRYPOINT ["java", "-jar", "nagp-product-service.jar"]
# Nagp Product Services
Sample Product Micro Service built using Springboot & MongoDB. It having REST API Endpoints to handle product management in ecommerce platform. 

## Steps to setup the product service




#### 1. Clone the service application ####

https://github.com/rvpashok/nagp-product-service.git

#### 2. Database setup ####

Install MongoDB and create database `ProductDB` and create collections `Products`

Based on the installation, change the MongoDB username and password in Product Microservice configuration file.

i. Open the `src/main/resources/application.properties` file

ii. Change the username and password in `spring.data.mongodb.username` and `spring.data.mongodb.password` property.

#### 3. Build and Deploy the Service ####

Follow below steps to run the app: 

i. Open command prompty or IDE terminal from project root directory and run `maven clean install -U` or `mvn package`

ii. Once JAR combiled and build successfully then run the application using `JAVA -JAR target/product-1.0.0-SNAPSHOT.jar` or Run the JAR directly using IDE options.

iii. By default app will start and run in http://localhost:8080

iv. Use health check endpoint to validate the app http://localhost:8080/productservices/ping


#### 3. Docker image reference ####

i. It's dockerized application, same product microservice docker image can find in below path: 
https://hub.docker.com/r/rvpashok/nagp-product-service





    
## API Reference

#### Ping

```http
  GET /productservices/ping
```


#### Get All Products

```http
  GET /productservices/products
```


#### Get Product ById
```http
  GET /productservices/products/{productId}
```

#### Create Product
```http
  POST /productservices/products/
```
*Sample ProductRequest Body:*

`{
    "productId": "String",
    "description": "String",
    "skus": [
    ],
    "category": {
        "categoryId": "String",
        "name": "String"
    },
    "quantity": long
}`

#### Delete Product ById
```http
  DELETE /productservices/products/{productId}
```




## Authors

- [@rvpashok](https://github.com/rvpashok)


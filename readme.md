# Getting Started

### How it works
This API has been build in compliance of the SIX Group code challenge. The API uses the Spring framework.
This API also uses MySQL Driver and Spring Data JPA packages.

The Database is generated automatically in the local MySQL server. Nevertheless, it needs to be populated before attempting to use the API.
Set up the properties for the database in the application.properties file at src\main\resources.

### Disclaimer
The database 'order' was renamed to 'market_orders' to avoid problems. This was done because the strin 'order' is a reserved keyword in SQL.

### Requirements
Java 11

### Add the database configuration at applicacitons.properties 
This step is necessary

/src/main/resources/application.properties

Update the following properties

* url 
* username 
* password

#### Execution
usar mvn para ejecutar

Windows example:

    .\mvnw.cmd spring-boot:run

### Additional Links
Testing

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)













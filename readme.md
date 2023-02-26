# Getting Started

### How it works
This API has been build in compliance of the SIX Group code challenge. The API uses the Spring framework.
This API also uses MySQL Driver and Spring Data JPA packages.

This API is a basic implementation, it can be improved extensively. 

The Database is generated automatically in the local MySQL server. No entries need to be input, the tests will take care of that.

### Disclaimer
The database 'order' was renamed to 'market_orders' to avoid problems. This was done because the string 'order' is a reserved keyword in SQL.

### Requirements
Java 11

### Add the database configuration at applicacitons.properties 
This step is necessary

Please, set up a MySQL server and input appropiate properties for the database access in the application.properties file at /src/main/resources/application.properties. The following steps may help:
    1.- Go to MySQL Workbench and create a new connection.
    2.- Set up the Username
    3.- Set up the Hostname
    4.- Set up Port
    5.- Now go to /src/main/resources/application.properties and set up the configuration there.
        * url 
        * username 
        * password
    6.- Go to MySQL Workbench and use the recently created connection and create a schema called sixservice.

### Testing
To test the API you need to open the repository in VSCode, go to the testing sidebar tool and scan for tests. After that, run all tests. If everything is set up properly the API just be launched, test will be ran, the database will automatically be updated and the reports will be generated. The reports can be found in JSON format at target\cucumber-reports.

#### Execution
use mvn to execute the API

Windows example:

    .\mvnw.cmd spring-boot:run

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guidess
The following guides illustrate how to use some features concretely:

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)













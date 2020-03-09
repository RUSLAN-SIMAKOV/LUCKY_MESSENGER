#LUCKY MESSENGER

This is a simple REST API for adding comment into database and creating notification.

## Table of contents 
* [Description](#description)
* [Prerequisites](#prerequisites)
* [Technologies used](#technologies-used)
* [Deployment](#deployment)
* [Author](#author)


## Description

Let me introduce you Lucky messenger: not very fast and not the most reliable functionality.
Adding comment would fail with 30% probability and take random time from 0 to 1 second.
If comment created successful would creat notification. 
Adding notification would fail with 10% probability and take random time from 0 to 2 second.
If notification created successful - in database status 'delivered 'will be true.
If notification created not successful - in database status 'delivered 'will be false.
You can check comments and notifications in data base using "h2 console", just use address 
http://localhost:8080/h2-console/ in Web-browser.
You can add comments and notifications using Swagger, just use address
http://localhost:8080/swagger-ui.html#/ in Web-browser.



### Prerequisites

To run this project you need to install next software: 
* [Java 13](https://www.oracle.com/technetwork/java/javase/downloads/jdk13-downloads-5066655.html) - 
Development environment 
* [Maven](https://maven.apache.org/) - Dependency Management

## Technologies used

*  spring-boot-starter-data-jpa 2.2.5
*  spring-boot-starter-web 2.2.5
*  H2 Database 1.4.200
*  lombok 1.18.12
*  spring-boot-starter-test 2.2.5
*  springfox-swagger2 2.9.2
*  spring-boot-maven-plugin 2.2.5

## Deployment

Add this project to your IDE as Maven project.

Add Java SDK 13 in project structure.

Enjoy to test everything)
## Author
 [Ruslan Simakov](ua667766706@gmail.com)
If you have questions - feel free to write me.
Have a nice day))


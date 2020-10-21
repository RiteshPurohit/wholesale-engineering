#) wholesale-engineering

A simple microservice that retrieves the detail of all the accounts and can also retrieve all the transactions related to each account.

#) Development Technologies
-) Java 8,
-) SprintBoot 2.3.4.RELEASE,
-) Lombok Plugin 1.18.2 (A plugin that adds first-class support for Project Lombok .Project Lombok is a java library that 
automatically plugs into your editor and build tools and auto generates the getters,setters,equals,
hashcode and toString methods with the annotations.)

#) Starting the application locally
Cockroach database need to be started before you can run the app locally at port 8082.
JDBC Connection Details:

spring.datasource.url=jdbc:postgresql://localhost:26257/account_db?sslmode=disable
spring.datasource.username=root

#) Notes
All the datetime values saved in the database with type as timestamp and retrieved as ZoneDateTime format.
Since Cockroach database uses UTC time zone so System should also use UTC time zone.
# Car Rental Application

## Description

Auto Car Rental is a Spring Boot JPA project that books clients into a race track drive experience in their dream cars for the day. Each booking is done through a reservation system enabling the application to show knowledge of Spring JPA, Spring Security, REST APIs, Testing APIs (using Postman and JUnit), Dockerizing the application and deploying to the cloud using Microsoft Azure's platform.

## API Documentation

The API consists of three layers: clients, cars and reservations for cars. 
- localhost:8080/cars - returns a list of all cars
- localhost:8080/cars/{id} - returns a car by id
- localhost:8080/clients returns a list of all clients 
- localhost:8080/clients/{id} returns a client by id
- localhost:8080/reservations returns list of all reservations
- localhost:8080/reservations/{id} returns a reservation by id

The full documentation is available on the Postman collection


### Features and Releases

The application is due to have the following features:
- comments: users will be allowed to write a review on driving their dream car
- static web page: the web page for the application will be the last feature for a user interface
- security: security is not yet fully configured as all fronts of security need to be configured


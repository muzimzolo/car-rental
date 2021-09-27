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

You may request full access to API end-points to have full freedom of testing the API.
The "/clients**" and "/reservations**" API end-points are accessed via a SQL view with a User Role

The full documentation is available on the Postman collection


### Features and Releases

Currently on main branch this is the first version of the application with new features due

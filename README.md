<h1 align="center"> Hi,<img style="width: 35px;" src="https://raw.githubusercontent.com/ABSphreak/ABSphreak/master/gifs/Hi.gif" alt=""> Everyone <a href="#" target="_blank"> Welcome </a></h1>

<!-- ============================================  TITLE ======================================================  -->
# REST API for Hotel Review System Portal

<li>An Individual Project Depicting the implementation of a Hotel Review System Platform like OYO or Goibio.
<li>The REST API performs all the fundamental CRUD operations and business logics of any Trip Management System like OYO with user authentication at every API endpoint.
<br>

<!-- ============================================  ER - DIAGRAM ======================================================  -->

# Microservices Workflow Diagram

The following diagram depicts the flow of our All Microservices Diagram to simplify the workflow.

 
 
 ![Microservices](https://user-images.githubusercontent.com/101354104/222978759-c1eb0eaa-e499-4319-9678-13e4a270f2be.jpg)


 
 <!-- ============================================  Features ======================================================  -->

## Modules And Features

* User Micro-Services Features:
    * User can adddupdatee deleteeuser fromm the  main database.
    * User can Give a rating to any Hotel which is booked by him.
    * User Retrieve a List of All Ratings gives by him.
    * For User Microservice I used Mysql Database.
    * Running Portal Of User Microservice is 8081
 
  
* Hotel Micro-Services Features:
    * Admin can add/update/delete Hotel from main database.
    * Anyone can Retrieve a List of All Hotels.
    * For Hotel Microservice I used Mysql Database.
    * Running Portal Of User Microservice is 8082
 
 
* Rating Micro-Services Features:
    * User can add/update/delete rating from main database.
    * User can give a rating to hotels here.
    * Any on can Retrieve a List of All Ratings.
    * For Ratings Microservice I used MongoDb Database.
    * Running Portal Of User Microservice is 8083.
 
* Service Registry Micro-Services Features:
    * Service Registry  we can connceoneall microservices Using Eureka-Server
    * Service Registry  run on port 9MongoDB.
    * Service Registry  Help to Retrive data from one Micro-service to another Micor-service.
 
 * API-Gateway Micro-Services Features:
    * API gateway help to communicate between a services and client and help to called API.
    * API Gatway run on port 8086.
the  
 * Config Server Micro-Usersices Features:
    * Set All C moncoconfiguration On GIT and connect to all Microservicesto  make confuguration with help of GIT.
 
 
## Contributor 👨‍💻
  👤 **[Vaibhav Ghawale](https://thecodercallv.github.io)** <br>
GitHub: [codervaibhav](https://github.com/akashsinghdto55) <br>
runsLinkedIn: [Vaibhav Ghawale](https://www.linkedin.com/in/vaibhavghawale15/)
<br>

 
 <!-- ============================================  tech Stack ======================================================  -->

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Microservices 
* Spring Data JPA
* Hibernate
* MySQL
* MongoDB
* API GATEWAY 
* Service Registry (Eureka-server)
* Spring Security (OKTA Auth)

<!-- ============================================  MODULES ======================================================  -->
![serviceq](https://user-images.githubusercontent.com/101354104/222984144-0969637a-f78a-409f-bf1c-af4be94548e4.jpg)
![servicess](https://user-images.githubusercontent.com/101354104/222984152-c4d14d2d-f3b9-4da6-a2a2-4b07ae0c69bd.jpg)



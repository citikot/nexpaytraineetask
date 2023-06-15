# Nexpay Trainee Task
## Simple Spring Boot REST application

----------------------------------------------------------------


- [X] Write an application that will 
  - [X] **create**
  - [X] **get** 
  - [X] **delete** 
  - [X] **update** (implemented additionally)
  
    user (name with surname) from database.
  

- [X] For each operation create separate REST end-points.

Database can be any, on your choose (i.e., H2). ( **PostgreSQL chosen** )

Application should use Java 11 or 17 with Spring Boot and Maven.
( **11 chosen** )

Use of any other libraries at your own discretion. (**lombok** implemented)

Examples how application works:

- New user with name “John” and surname “Smith” should be created by sending request to 
one of the end-points that accept name and surname as request data. User data will be saved 
to the database.


- Endpoint that gets user by ID number and returns name and surname from the database.


- Endpoint that accepts user ID and remove user from the database (**soft delete** implemented)


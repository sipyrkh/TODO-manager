# TODO-manager

## Overview
This repository contains a set of automated tests for a Todo API, implemented in Java using the TestNG framework, Gradle for project management, RestAssured for API testing, and Jackson for handling JSON data. The tests cover various CRUD operations on the Todo API, including creating, retrieving, updating, and deleting Todo items.

### Technologies Used
Java: The programming language used for the tests.
Gradle: Build automation tool used for project management.
RestAssured: A Java library for testing RESTful APIs.
TestNG: A testing framework inspired by JUnit but supporting more test configurations.
Jackson: A suite of data-processing tools for Java to convert between JSON and Java objects.

### Getting Started
### Prerequisites
***Java 11 or higher***

**Gradle 6.0 or higher**

### Installation

Clone the repository:
 
```
git clone https://github.com/sipyrkh/TODO-manager.git
cd todo-api-tests
```
Build the project:

 
`gradle build`

Run the tests:

`gradle test`

### Test Classes
**TodoTests**: Contains the main tests for the Todo API:

**testCreateTodo**: Tests the creation of a new Todo item.

**testGetTodos**: Tests the retrieval of Todo items.

**testUpdateTodo**: Tests the updating of an existing Todo item.

**testDeleteTodo**: Tests the deletion of a Todo item.

# Library Management System

## Project Overview
This project is a **Library Management System** developed in Java 
      for **Assignment 3 (Advanced OOP API with JDBC)**.  
The goal of the project is to practice **object-oriented programming concepts** 
together with **real database interaction** using PostgreSQL.

The application is a **command-line based system** that allows managing books in a library.  
All operations are demonstrated directly from the `Main` class.

## Technologies Used
- Java (JDK 17 or higher)
- PostgreSQL
- JDBC (PreparedStatement)
- IntelliJ IDEA

## Project Structure
src/
 ├── Main.java
 ├── model/
 │   ├── LibraryItem.java
 │   ├── Book.java
 │   ├── Author.java
 │   ├── Validatable.java
 │   └── Borrowable.java
 ├── repository/
 │   └── BookRepository.java
 ├── service/
 │   └── BookService.java
 ├── exception/
 │   ├── InvalidInputException.java
 │   ├── DuplicateResourceException.java
 │   ├── ResourceNotFoundException.java
 │   └── DatabaseOperationException.java
 └── utils/
     └── DatabaseConnection.java
```

The project follows a **layered architecture** where:
model represents entities
repository handles database operations
service contains business logic
utils manages database connection


OOP Design Explanation

 Abstract Class
LibraryItem is an abstract class that defines common fields such as `id` and `title`.
It also declares abstract methods that must be implemented by subclasses.

Inheritance
Book extends `LibraryItem` and provides concrete implementations of abstract methods.

Interfaces
Validatable is used to validate input data.
Borrowable is used to represent borrow and return behavior.

Composition
A `Book` object contains an `Author` object.

Polymorphism
Methods like `displayInfo()` are called using base class references, showing runtime polymorphism.

Database Design

Database Name
`library_db`

Table: `books`
```sql
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    available BOOLEAN NOT NULL DEFAULT true
);
```

### Business Logic
If `available = true`, the book is not borrowed.
If `available = false`, the book is currently borrowed.

This column helps represent the real-world state of a book in the library.

## CRUD Operations
The following operations are implemented using **PreparedStatement**:
- Create a new book
- Read all books from the database
- Delete a book by ID

All CRUD operations are tested and demonstrated through console output.

## How to Run the Project
1. Create a PostgreSQL database named `library_db`
2. Execute the provided SQL schema to create the `books` table
3. Add PostgreSQL JDBC Driver to the project libraries
4. Update database credentials in `DatabaseConnection.java`
5. Run `Main.java`

## Sample Output
```
All Books:
Book: Animal Farm | Author: George Orwell | Available: true
Book: Crime and Punishment | Author: Fyodor Dostoevsky | Available: true
Book deleted


## Exception Handling
Custom exceptions are implemented to handle different error scenarios:
- InvalidInputException
- DuplicateResourceException
- ResourceNotFoundException
- DatabaseOperationException

This improves readability and error handling across the project.


## Reflection
This assignment helped me better understand:
- How to apply OOP concepts in a real Java project
- How JDBC works with PostgreSQL
- How to structure a project using layered architecture
- The importance of validation and exception handling


## Author
Hamid Niazi

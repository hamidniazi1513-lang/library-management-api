Library Management System – Advanced OOP & SOLID Architecture.
Project Overview!

This project is an Advanced Library Management System implemented in Java for Assignment 4, building on the previous milestone.
The system demonstrates the application of SOLID principles, advanced object-oriented programming (OOP) features, and database interaction using PostgreSQL.

It is a command-line based application that allows managing books, authors, and borrowing operations while following a clean layered architecture:
controller → service → repository → database.

The project emphasizes:
SOLID design principles (SRP, OCP, LSP, ISP, DIP)
Polymorphism, inheritance, and abstraction
Advanced Java features (interfaces, generics, lambdas, reflection, default/static methods)
Robust exception handling
JDBC-based CRUD operations

Technologies Used
Java (JDK 17+)
PostgreSQL
JDBC (PreparedStatement)
IntelliJ IDEA

Project Structure
assignment4-solid-library-api/
├── src/
│   ├── controller/          
│   ├── service/            
│   │   └── interfaces/
│   ├── repository/          
│   │   └── interfaces/
│   ├── model/               
│   ├── dto/                 
│   ├── exception/           
│   ├── utils/               
│   │   ├── DatabaseConnection.java
│   │   ├── SortingUtils.java
│   │   └── ReflectionUtils.java
│   └── Main.java           
├── resources/
│   └── schema.sql           
├── docs/
│   ├── screenshots/
│   └── uml.png
├── README.md
└── .gitignore

# Handles user input and delegates to services
 # Contains business logic, validation, and SOLID application
 # Handles database CRUD operations
 # Abstract classes and entity subclasses
 # Data transfer objects (optional)
# Custom exceptions
# Reflection, sorting, database utilities
 # Driver class demonstrating all features
# Database schema & sample inserts
 
OOP & SOLID Design
Abstract Base Class
LibraryItem (abstract): defines shared fields (id, name/title) and methods.
Contains 2 abstract methods and 1 concrete method, allowing polymorphism.

Subclasses (LSP-compliant)
Book extends LibraryItem with additional fields (author, available).
Author extends base class to demonstrate correct inheritance and substitutability.
Methods overridden to implement domain-specific behavior.

Composition
Book has an Author object → demonstrates real-world aggregation.

Interfaces (ISP + Advanced Features)
Validatable<T>: validates inputs with default methods for reusable logic.
Borrowable: defines borrowing/return operations, includes default & static methods.

Generics
Generic repository interface CrudRepository<T> enables CRUD operations for any entity.

Lambdas
Used in sorting lists, filtering, and comparators in utilities and services.

Reflection / RTTI
ReflectionUtils demonstrates runtime inspection: class name, fields, methods, and annotations.

Database Design
Database Name: library_db
Tables

books

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    available BOOLEAN NOT NULL DEFAULT true
);


authors

CREATE TABLE authors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

Relationships: Book → Author (composition)
Sample inserts included in schema.sql
Demonstrates FK constraints and real-world entity relationships

Layered Architecture
Controller Layer
Handles CLI input
Delegates all operations to Service layer
No business logic

Service Layer
Implements validation, business rules, and SOLID principles
Uses repository interfaces (DIP)
Handles exceptions:
InvalidInputException
DuplicateResourceException
ResourceNotFoundException
DatabaseOperationException
Repository Layer
Implements generic CRUD repository using JDBC
No business logic, only database interaction

Utilities
DatabaseConnection.java → centralized JDBC connection
SortingUtils.java → lambdas for sorting/filtering
ReflectionUtils.java → runtime inspection of classes

CRUD Operations
The system supports:
Create: Add new books/authors
Read: List all entities with sorting/filtering
Update: Modify entity data with validation
Delete: Remove entities with FK checks
All operations are demonstrated via console output in Main.java.

Advanced Features Demonstrated
Polymorphism: Using base class references to call subclass methods
SOLID Principles: SRP, OCP, LSP, ISP, DIP fully applied
Generics: CrudRepository<T> for reusable repository logic
Lambdas: Sorting/filtering of entities in services/utilities
Reflection: Inspect classes and list methods/fields dynamically
Interfaces: Default & static methods for reusable functionality

Exception Handling
InvalidInputException → invalid inputs
DuplicateResourceException → duplicate entries
ResourceNotFoundException → entity not found
DatabaseOperationException → database-level failures
Exceptions are thrown in the service layer, keeping the controller clean.

How to Run the Project
Create a PostgreSQL database named library_db
Execute schema.sql to create tables and sample data
Add PostgreSQL JDBC Driver to project libraries
Update credentials in DatabaseConnection.java
Run Main.java to interact with the system


Sample Output
All Books:
Book: Animal Farm | Author: George Orwell | Available: true
Book: Crime and Punishment | Author: Fyodor Dostoevsky | Available: true

Adding a new book: Success
Updating a book: Success
Deleting a book: Success

Reflection Utility Output:
Class: Book
Fields: id, name, author, available
Methods: displayInfo(), borrowBook(), returnBook()


README Highlights / Documentation
SOLID Principles Applied
SRP: Each class has a single responsibility
OCP: Abstract base class allows extension without modification
LSP: Subclasses can be used in place of the base class safely
ISP: Interfaces are small and focused (Validatable, Borrowable)
DIP: Service layer depends on repository interfaces, not concrete classes

Advanced OOP Features
Generics: CrudRepository<T>
Lambdas: Sorting/filtering entities
Reflection: Inspect runtime class info
Interface default/static methods: Reusable validation and borrowing methods

Database Section
books and authors with FK relationship
Constraints: PRIMARY KEY, NOT NULL, FK
Sample inserts included in resources/schema.sql

Architecture Explanation
Controller → delegates to Service → uses Repository → JDBC database operations
Demonstrates layered, maintainable architecture

Execution Instructions
Run Main.java after setting up DB connection
Use CLI menu to test CRUD, validation, sorting, and reflection features

Screenshots
Successful CRUD operations
Validation failures
Reflection utility output
Sorted lists showing lambdas

Reflection
Learned to apply SOLID in real-world APIs
Practiced advanced OOP concepts in Java
Improved understanding of layered architecture and JDBC

Author

Hamid Niazi

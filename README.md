# Advanced Java Projects

### Project Overview
This repository contains multiple management systems built using **Advanced Java**. The projects include:

1. **Student Management System**
2. **Employee Management System**
3. **Supermarket Management System**

These applications were designed to manage various operations, such as record-keeping, user management, and report generation, making administrative tasks easier and more efficient.

---

## Technologies Used

1. **Java (Advanced Java)**:
   - Core language used for backend logic and application flow.
   - Implemented object-oriented programming (OOP) principles for modular, maintainable, and scalable code.

2. **JDBC (Java Database Connectivity)**:
   - Used for interacting with the database.
   - Managed CRUD (Create, Read, Update, Delete) operations to handle data persistence.

3. **MySQL**:
   - Database management system used to store and manage all records (students, employees, products).
   - Ensured data consistency and efficient querying.

4. **Swing**:
   - Used for creating the graphical user interface (GUI) in Java.
   - Allowed for the development of desktop applications with a user-friendly interface.

5. **Apache Tomcat (Optional for Web-based Systems)**:
   - Used as a servlet container for running web-based versions of the management systems, if applicable.

---

## Individual Project Descriptions

### 1. **Student Management System**
   - **Purpose**: This system manages student records, including registration, attendance, grades, and personal information.
   - **Features**:
     - Add, update, and delete student records.
     - View student performance and attendance reports.
     - Search for students by ID, name, or course.
     - Database integration for efficient data handling.

### 2. **Employee Management System**
   - **Purpose**: This system manages employee data such as personal details, payroll, attendance, and performance.
   - **Features**:
     - Manage employee records, including contact details, role, and department.
     - Calculate and generate payroll reports.
     - Track attendance and leave applications.
     - Performance monitoring and report generation.

### 3. **Supermarket Management System**
   - **Purpose**: This system manages the day-to-day operations of a supermarket, including product management, billing, and inventory.
   - **Features**:
     - Add, update, and delete product listings.
     - Generate bills and manage customer transactions.
     - Track inventory and receive alerts when stock is low.
     - Report generation for sales and inventory analysis.

---

## Features Across All Projects

- **CRUD Operations**: All systems allow for creating, reading, updating, and deleting records from the database.

- **Data Validation**: Input validation is implemented to ensure data integrity and prevent errors during form submissions.

- **User-Friendly GUI**: Each system has an intuitive interface built using Java Swing, making it easy for users to navigate and manage records.

- **Database Integration**: All applications use MySQL for data storage, ensuring that information is stored securely and can be retrieved efficiently.

---

## Setup and Installation

To run these projects locally, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/sandhani60/Java_Management_Projects.git


Database Setup:

Install and configure MySQL.
Create a database for each project (e.g., student_management, employee_management, supermarket_management).
Import the provided SQL scripts to set up the necessary tables.
Configure JDBC:

Ensure your JDBC connection is set up correctly in the Java files (provide the database name, username, and password in the Connection string).
Compile and Run the Java Application:

Open the project in your preferred IDE (e.g., Eclipse or IntelliJ IDEA).
Compile and run the project:

javac Main.java
java Main

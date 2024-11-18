# CampusManager

CampusManager is a menu-driven, school database management system implemented in Java, using JDBC and MySQL. The system allows users to manage entities such as students, teachers, courses, and classes with CRUD functionalities and dynamic query execution.

## Features

- ✅ Database Management: Perform Create, Read, Update, and Delete operations for school entities.
- ✅ Multi-Entity Support: Manage students, teachers, subjects, and more.
- ✅ Robust Validation: Ensures data integrity with user-friendly interaction.
- ✅ Seamless Integration: Connects to MySQL using JDBC for real-time database interactions.


## Prerequisites

- 🛠 Java Development Kit (JDK): Ensure JDK 8 or later is installed.
- 🛠 MySQL Server: Install MySQL and ensure it is running.
- 🛠 MySQL JDBC Driver: Add the JDBC driver to your CLASSPATH if not already included.

## Setup Instructions

- Step 1: Clone the Repository

	•	git clone https://github.com/yourusername/CampusManager.git
	•   cd CampusManager

- Step 2: Start MySQL Server

Start your MySQL server to ensure the database is available:

	•	mysql.server start

- Step 3: Create the Database

Log into the MySQL client and create a database called campusmanager:

	•	CREATE DATABASE campusmanager;

- Step 4: Run SQL Scripts

Execute the SQL scripts in the correct order to set up the database schema and insert sample data:

	•	mysql -u <your-username> -p campusmanager < sql/CampusManagerCreate.sql
	•	mysql -u <your-username> -p campusmanager < sql/CampusManagerInsert.sql
	•	mysql -u <your-username> -p campusmanager < sql/CampusManagerAlter.sql
	•	mysql -u <your-username> -p campusmanager < sql/CampusManagerUpdate.sql

## Compile and Run

- Step 1: Compile the Source Code

Navigate to the src directory and compile all Java files:

	•	cd src
	•	javac -d ../bin $(find . -name "*.java")

- Step 2: Run the Program

Navigate to the bin directory and execute the main program:

	•	cd ../bin
	•	java main.SchoolDB


## File Descriptions

SQL Scripts

	•	CampusManagerCreate.sql: Defines the schema for the database, including tables and relationships.
	•	CampusManagerInsert.sql: Inserts initial data for testing and demonstration purposes.
	•	CampusManagerAlter.sql: Updates the schema, such as adding constraints or new columns.
	•	CampusManagerUpdate.sql: Updates specific records or applies data patches.

Source Code

	•	dao/: Handles database operations using JDBC.
	•	service/: Implements business logic and calls DAO methods.
	•	model/: Contains POJOs representing database entities.
	•	main/: The entry point for the application.


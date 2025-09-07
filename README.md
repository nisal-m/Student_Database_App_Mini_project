# Student_Database_App_Mini_project
1.Open MySQL and create the database:


CREATE DATABASE studentdb;
USE studentdb;
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    grade VARCHAR(10) NOT NULL
);

2.Project Structure:

StudentManagement/
 ├── src/
 │    ├── Student.java
 │    ├── StudentDAO.java
 │    ├── StudentManagementSystem.java
 │    └── DBConnection.java
 └── lib/
      └── mysql-connector-j-8.x.x.jar


3.Update DBConnection.java with your database credentials and port:

4.Run StudentManagementSystem.java

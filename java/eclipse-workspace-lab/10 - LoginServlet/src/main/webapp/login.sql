CREATE DATABASE IF NOT EXISTS loginservlet;

USE loginservlet;

DROP TABLE IF EXISTS students;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sname VARCHAR(100) NOT NULL,
    passwd VARCHAR(100) NOT NULL
);

INSERT INTO students (sname, passwd) VALUES ('Ashish', 'a');
INSERT INTO students (sname, passwd) VALUES ('a', 'a');

SELECT * FROM students;
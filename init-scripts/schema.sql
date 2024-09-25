CREATE DATABASE IF NOT EXISTS springbootdb;

USE springbootdb;
CREATE TABLE IF NOT EXISTS quote (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      quote VARCHAR(255),
                      email VARCHAR(255)
);

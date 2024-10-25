GRANT ALL PRIVILEGES ON springbootdb.* TO 'root'@'%';
FLUSH PRIVILEGES;

CREATE DATABASE IF NOT EXISTS springbootdb;

USE springbootdb;
CREATE TABLE IF NOT EXISTS quote (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      quote VARCHAR(255),
                      email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS current_quote (
                                     id INT PRIMARY KEY,
                                     quote VARCHAR(255),
                                     email VARCHAR(255)
);

CREATE DATABASE payroll_db;
USE payroll_db;

CREATE TABLE employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(50),
    basic_salary DOUBLE,
    hra DOUBLE,
    da DOUBLE,
    pf DOUBLE,
    net_salary DOUBLE
);


ALTER TABLE employee ADD status VARCHAR(10) DEFAULT 'ACTIVE';

CREATE TABLE payroll_history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT,
    month VARCHAR(20),
    net_salary DOUBLE,
    generated_on TIMESTAMP	
);
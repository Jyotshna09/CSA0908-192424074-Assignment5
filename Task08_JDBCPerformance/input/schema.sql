CREATE DATABASE IF NOT EXISTS BusPassDB;
USE BusPassDB;

CREATE TABLE IF NOT EXISTS BusPass (
    pass_id VARCHAR(20) PRIMARY KEY,
    register_number VARCHAR(20),
    student_name VARCHAR(100),
    route_number INT,
    amount DOUBLE
);
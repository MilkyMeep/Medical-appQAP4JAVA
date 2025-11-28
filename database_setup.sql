- Medical Persistence App Database Setup
-- pg/postgre commands
CREATE DATABASE medical_db;

--table
CREATE TABLE patients (
    patient_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL
);

 -- optional data
INSERT INTO patients (first_name, last_name, date_of_birth) VALUES 
('John', 'Doe', '1990-05-15'),
('Jane', 'Smith', '1985-08-22'),
('Bob', 'Johnson', '1978-12-10');
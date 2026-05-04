-- Create database
CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;

-- Create students table
CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(10) NOT NULL,
    course VARCHAR(50) NOT NULL,
    enrollment_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data
INSERT INTO students (name, email, phone, course, enrollment_date) VALUES
('Rajesh Kumar', 'rajesh@example.com', '9876543210', 'B.Tech', '2024-01-15'),
('Priya Singh', 'priya@example.com', '9876543211', 'B.Sc', '2024-02-20'),
('Amit Patel', 'amit@example.com', '9876543212', 'BCA', '2024-03-10');

# Student Management System

A simple, responsive web application for managing student records using PHP and MySQL.

## Features

- ✅ View all students in a responsive table
- ✅ Add new student records
- ✅ Edit existing student records
- ✅ Delete student records with confirmation
- ✅ Responsive design for all devices
- ✅ Clean and user-friendly interface

## Requirements

- PHP 7.0 or higher
- MySQL 5.7 or higher
- XAMPP / WAMP / LAMP server

## Installation & Setup

### Step 1: Start Server
Start your Apache and MySQL servers using XAMPP/WAMP/LAMP.

### Step 2: Create Database
1. Open phpMyAdmin (usually at `http://localhost/phpmyadmin`)
2. Import the `schema.sql` file:
   - Click "Import" tab
   - Choose `schema.sql`
   - Click "Go"
   - Or manually run the SQL queries in the file

### Step 3: Configure Database Connection (if needed)
Edit `db.php` and update these values if different from defaults:
```php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "student_db";
```

### Step 4: Place Files in Web Root
Copy all files to your web server's root directory:
- **XAMPP**: `C:\xampp\htdocs\21\`
- **WAMP**: `C:\wamp64\www\21\`
- **LAMP**: `/var/www/html/21/`

## Running the Application

1. Open your browser and go to:
   ```
   http://localhost/21/
   ```

2. You should see the Student Management page with sample data.

## File Structure

```
21/
├── index.php          # Main page - displays all students
├── add.php            # Form to add new student
├── edit.php           # Form to edit student record
├── db.php             # Database connection
├── schema.sql         # Database schema
├── styles.css         # Responsive styling
└── README.md          # This file
```

## How to Use

### View Students
- The homepage displays all students in a table

### Add Student
1. Click "+ Add Student" button
2. Fill in all fields
3. Click "Add Student"

### Edit Student
1. Click "Edit" button in the student's row
2. Modify the details
3. Click "Update Student"

### Delete Student
1. Click "Delete" button in the student's row
2. Confirm the deletion in the popup
3. Student will be removed from database

## Responsive Design

The application is fully responsive and works on:
- 📱 Mobile phones (480px and below)
- 📱 Tablets (768px)
- 💻 Desktop screens

## Database Details

### Students Table Columns:
- `id` - Primary Key (Auto-increment)
- `name` - Student name
- `email` - Student email (Unique)
- `phone` - Phone number
- `course` - Course enrolled
- `enrollment_date` - Date of enrollment
- `created_at` - Record creation timestamp

## Sample Data

The database comes with 3 sample students:
1. Rajesh Kumar - B.Tech
2. Priya Singh - B.Sc
3. Amit Patel - BCA

Feel free to edit or delete them!

## Troubleshooting

**Error: Connection failed**
- Check if MySQL server is running
- Verify database credentials in `db.php`

**No students displayed**
- Import `schema.sql` in phpMyAdmin
- Check database name in `db.php`

**Page not found**
- Verify files are in correct web root directory
- Check URL is correct

## Security Note

This is a simple educational project. For production:
- Use prepared statements to prevent SQL injection
- Add user authentication
- Validate and sanitize all inputs
- Use HTTPS
- Add access controls

---

**Created for Web Technology Lab Exam**

<?php
include 'db.php';

$id = $_GET['id'] ?? null;
$error = $success = "";
$student = null;

if (!$id) {
    header("Location: index.php");
    exit;
}

// Fetch student data
$sql = "SELECT * FROM students WHERE id = $id";
$result = $conn->query($sql);

if ($result->num_rows === 0) {
    header("Location: index.php");
    exit;
}

$student = $result->fetch_assoc();

// Handle form submission
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $name = $_POST['name'] ?? '';
    $email = $_POST['email'] ?? '';
    $phone = $_POST['phone'] ?? '';
    $course = $_POST['course'] ?? '';
    $enrollment_date = $_POST['enrollment_date'] ?? '';

    // Validation
    if (empty($name) || empty($email) || empty($phone) || empty($course) || empty($enrollment_date)) {
        $error = "All fields are required!";
    } else {
        $name = $conn->real_escape_string($name);
        $email = $conn->real_escape_string($email);
        $phone = $conn->real_escape_string($phone);
        $course = $conn->real_escape_string($course);

        $sql = "UPDATE students SET name='$name', email='$email', phone='$phone', course='$course', enrollment_date='$enrollment_date' WHERE id=$id";

        if ($conn->query($sql) === TRUE) {
            $success = "Student updated successfully!";
            $student = ['id' => $id, 'name' => $name, 'email' => $email, 'phone' => $phone, 'course' => $course, 'enrollment_date' => $enrollment_date];
        } else {
            $error = "Error updating student: " . $conn->error;
        }
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Student</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <div class="form-header">
            <h1>Edit Student Record</h1>
            <a href="index.php" class="btn btn-back">← Back</a>
        </div>

        <?php if ($error): ?>
            <div class="alert alert-danger"><?php echo $error; ?></div>
        <?php endif; ?>

        <?php if ($success): ?>
            <div class="alert alert-success"><?php echo $success; ?></div>
        <?php endif; ?>

        <form method="POST" class="form">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="<?php echo htmlspecialchars($student['name']); ?>" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<?php echo htmlspecialchars($student['email']); ?>" required>
            </div>

            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone" value="<?php echo htmlspecialchars($student['phone']); ?>" required>
            </div>

            <div class="form-group">
                <label for="course">Course:</label>
                <select id="course" name="course" required>
                    <option value="">Select Course</option>
                    <option value="B.Tech" <?php echo ($student['course'] === 'B.Tech') ? 'selected' : ''; ?>>B.Tech</option>
                    <option value="B.Sc" <?php echo ($student['course'] === 'B.Sc') ? 'selected' : ''; ?>>B.Sc</option>
                    <option value="BCA" <?php echo ($student['course'] === 'BCA') ? 'selected' : ''; ?>>BCA</option>
                    <option value="MBA" <?php echo ($student['course'] === 'MBA') ? 'selected' : ''; ?>>MBA</option>
                </select>
            </div>

            <div class="form-group">
                <label for="enrollment_date">Enrollment Date:</label>
                <input type="date" id="enrollment_date" name="enrollment_date" value="<?php echo $student['enrollment_date']; ?>" required>
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Update Student</button>
                <a href="index.php" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
<?php $conn->close(); ?>

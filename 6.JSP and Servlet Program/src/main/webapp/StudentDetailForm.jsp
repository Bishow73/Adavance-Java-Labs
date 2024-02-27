<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
</head>
<body>
<h2>Student Detail Form</h2>
<form action="PrintDetails.jsp" method="post">
<label for="name">Name:</label>
<input type="text" name="name" required><br><br>
<label for="Address">Address:</label>
<input type="text" name="Address" required><br><br>
<label for="rollNumber">Roll Number:</label>
<input type="text" name="rollNumber" required><br><br>
<label for="Faculty">Faculty:</label>
<input type="text" name="Faculty" required><br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>
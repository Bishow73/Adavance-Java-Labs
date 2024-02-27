<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Information</title>
</head>
<body>
<h2>Student Details</h2>
<%-- Retrieve values from the request object --%>
<% String name = request.getParameter("name"); %>
<% String Address = request.getParameter("Address"); %>
<% String rollNumber = request.getParameter("rollNumber"); %>
<% String faculty = request.getParameter("Faculty"); %>
<%-- Display the submitted information --%>
<p><strong>Name:</strong> <%= name %></p>
<p><strong>Address:</strong> <%= Address %></p>
<p><strong>Roll Number:</strong> <%= rollNumber %></p>
<p><strong>Faculty:</strong> <%= faculty %></p>
</body>
</html>
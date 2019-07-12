<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation Page</title>
</head>
<body>
<p>The student information is confirmed: ${student.firstName} ${student.lastName}</p>
<p>Student Country: ${student.country}</p>
<p>Student Favorite Language: ${student.favLanguage}</p>

<p>Student Used OS: ${student.operatingSystems}</p>
</body>
</html>
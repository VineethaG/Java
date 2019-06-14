<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body  {
 background-color: lightblue;
}
</style>
</head>
<body>
<p align="center" style= "color:green;">Please Register!</p>

<form name="form" action="courseRegistration" method="post">
<table align="center">
 <tr>
 <td>Email ID</td>
 <td><input type="text" name="email" /></td>
 </tr>
 <tr>
 <td>Full Name</td>
 <td><input type="text" name="studentname" /></td>
 </tr>
 <tr>
 <td>Course Name</td>
 <td><input type="text" name="coursename" /></td>
 </tr>
 
 
 
 <tr>
 <td></td>
 <td><input type="submit" value="Register"></input><input
 type="reset" value="Reset"></input></td>
 </tr>
</table>
</form>
</body>
</html>
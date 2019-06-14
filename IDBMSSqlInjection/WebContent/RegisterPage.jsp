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

<form name="form" action="Registration" method="post">
<table align="center">

<tr>
 <td>Student ID</td>
 <td><input type="text" name="studentid" /></td>
 </tr>
 
 <tr>
 <td>Full Name</td>
 <td><input type="text" name="fullname" /></td>
 </tr>
 <tr>
 <td>Email</td>
 <td><input type="text" name="email" /></td>
 </tr>
 <tr>
 <td>Username</td>
 <td><input type="text" name="username" /></td>
 </tr>
 <tr>
 <td>Password</td>
 <td><input type="password" name="password" /></td>
 </tr>
 
 <tr>
 <td>Address</td>
 <td><textarea cols="21" rows="4" maxlength="50" name="address" ></textarea></td>
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
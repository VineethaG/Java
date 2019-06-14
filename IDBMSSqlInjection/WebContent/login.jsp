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
<p align="center" style= "color:green;">Please Login!</p>
<form name="form" action="login" method="post">
<table align="center">
 <tr>
 <td>Username:</td>
 <td><input type="text" name="username" /></td>
 </tr>
 <tr>
 <td>Password</td>
 <td><input type="password" name="password" /></td>
 </tr>
 
 
 </tr>
 <tr>
 <td></td>
 <td><input type="submit" value="Login"></input><input
 type="reset" value="Reset"></input></td>
 </tr>
</table>
</form>
</body>
</html>
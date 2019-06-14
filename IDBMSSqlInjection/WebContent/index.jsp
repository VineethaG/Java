<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*, java.util.*, java.sql.*"%>
<%@ page import="oracle.jdbc.driver.OracleConnection" %>

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
<body> 

       
  <form name="form" action="HomePage" method="post">
<% String Full_Name = (String)request.getAttribute("username"); 
        String sql;
        out.println("Hi, " +Full_Name+"<br/><br/>" );
        
        %>
        <% request.setAttribute("username", Full_Name); %>
        
         <input maxlength="100" style="width: 500px;height:100px;" type="text" name="MailID" placeholder="Enter Your Student ID"><br/><br/>
        
 <input  type="submit" value="courses"></input>
 
</form>
  
          
    </body> 
</body>
</html>
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

       
  <form name="form" action="AdminPage" method="post">
<% String Full_Name = (String)request.getAttribute("username"); 
        String sql;
        out.println("Hi, Admin <br/><br/>" );
        
        %>
        <% request.setAttribute("username", Full_Name); %>
        
         <input maxlength="100" style="width: 500px;height:100px;" type="text" name="studentid"><br/><br/>
        
 <input  type="submit" value="Get the users details"></input>
 
</form>
  
          
    </body> 
</body>
</html>
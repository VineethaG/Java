package com.sqlinjection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");  
	 PrintWriter out = response.getWriter();  
	String StudentMailID =  request.getParameter("MailID");
	System.out.println(StudentMailID);
	 Connection con = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	 String userFullName = null;

	 try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");  
		 con=DriverManager.getConnection(  
				 "jdbc:oracle:thin:@localhost:1521:xe","learning","learning");  
		 stmt = con.createStatement();
		 ResultSet rset = stmt.executeQuery(
				 "select StudentFullName,CourseName from ENROLLMENT where StudentEmailID ='"+StudentMailID);
		 System.out.println(rset);
		 while (rset.next()) {
		      System.out.println(rset.getString("StudentFullName"));
		        out.print("<html> <span><strong>Student Name: </strong></span>"+
		      rset.getString("StudentFullName")+"<span> <strong> List of Courses:</strong></span>"+rset.getString("CourseName")+"<br/>");
		 }
		 
		    
		    
	 }
	 catch (Exception e) {
		 System.out.println(e);
	 }
		    
	 }
	 
}


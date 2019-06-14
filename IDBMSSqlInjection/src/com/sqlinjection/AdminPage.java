package com.sqlinjection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Properties;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class login
 */
@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminPage() {
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
	String studentid =  request.getParameter("studentid");
	System.out.println(studentid);
	 Connection con = null;
	 PreparedStatement stmt = null;
	 ResultSet rs = null;

	 String userFullName = null;

	 try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");  
		 Properties properties = new Properties();
		 properties.load(new FileInputStream(System.getProperty("prop")));
		 String username = properties.getProperty("oracle.username");
		String password = properties.getProperty("oracle.username");


		// Role Base sql injection
		 con=DriverManager.getConnection(  
//				 jdbc:orcale://localhost:1521/x?allowMultiQueries=true
				 "jdbc:oracle:thin:@localhost:1521:xe",username,password);  
	 
		 //Union SQL Injection
		   String sql = "select * from learning.USER_DETAILS where StudentID="+studentid;
		   stmt = con.prepareStatement(sql);
			boolean hasMoreResults = stmt.execute(sql);

		   while(hasMoreResults) {
				
				ResultSet rset = stmt.getResultSet();
				while (rset.next()) {
					   out.print("<html> <span><strong>Student Name: </strong></span>"+	rset.getString("Full_Name")
					   +",<span><strong>Student MailID: </strong></span>"+	rset.getString("Email_ID")+"<br/>");
					      userFullName = rset.getString("Full_Name");
					      out.println("</html>");   
				 }
				
				hasMoreResults = stmt.getMoreResults();
			}
		 
		 	//		 Stored Procedure
//		 CallableStatement cStmt = con.prepareCall("{call GETEMAILID(?,?)}");
//		    cStmt.setString(1, studentid);
//		    cStmt.registerOutParameter(2, Types.VARCHAR);
//
//		   cStmt.executeQuery();
//	        out.print("<html> <span><strong>Student Email ID: </strong></span>"+cStmt.getString(2)+"<br/>"); 
	 }
	 catch (Exception e) {
		 System.out.println(e);
	 }
		    
	 }
	 
}


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
 * Servlet implementation class Registration
 */
@WebServlet("/courseRegistration")
public class courseRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }
    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		 PrintWriter out = response.getWriter();  
		
		 String StudentMail = request.getParameter("email");
		 String StudentName = request.getParameter("studentname");
		 String CourseName = request.getParameter("coursename");
		 

		 Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");  
			 con=DriverManager.getConnection(  
					 "jdbc:oracle:thin:@localhost:1521:xe","learning","learning");  
			 stmt = con.createStatement();

			 PreparedStatement ps=con.prepareStatement(  
			 "insert into ENROLLMENT values(?,?,?)");  
			   
			 ps.setString(1,StudentMail);  
			 ps.setString(2,StudentName);  
			 ps.setString(3,CourseName);  
			  

			           
			 int i=ps.executeUpdate();  
			 System.out.println(i);
			 if(i>0)  {
	         response.sendRedirect("/IDBMSSqlInjection/login.jsp");
		}
		}
		 catch (Exception e) {
			 System.out.println(e);		
		}	 
	}

}

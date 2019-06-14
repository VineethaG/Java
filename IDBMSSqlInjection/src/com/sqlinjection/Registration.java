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
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }
    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		 PrintWriter out = response.getWriter();  
		 String studentid = request.getParameter("studentid");
		 String fullName = request.getParameter("fullname");
		 String email = request.getParameter("email");
		 String userName = request.getParameter("username");
		 String password = request.getParameter("password");
		 String address = request.getParameter("address");

		 Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");  
			 con=DriverManager.getConnection(  
			 "jdbc:oracle:thin:@localhost:1521:xe","sql","homework4");  
			 stmt = con.createStatement();

			 PreparedStatement ps=con.prepareStatement(  
			 "insert into USER_DETAILS values(?,?,?,?,?,?)");  
			 ps.setString(1,studentid);  
			 ps.setString(2,fullName);  
			 ps.setString(3,email);  
			 ps.setString(4,userName);  
			 ps.setString(5,password);  
			 ps.setString(6,address);  

			           
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

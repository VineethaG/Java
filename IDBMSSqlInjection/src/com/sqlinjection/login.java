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
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {
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
	 String userName = request.getParameter("username");
	 String password = request.getParameter("password");
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
				 "select Full_Name from USER_DETAILS where username ='"+userName+"' and password ='"+password+"'");
		 System.out.println(rset);
		 while (rset.next()) {
		      System.out.println(rset.getString("Full_Name"));
		      out.println("<html> <p>Hi,");
		      userFullName = rset.getString("Full_Name");
		      out.println(rset.getString("Full_Name")+"</p></html>");   
		 }
		 
		    request.setAttribute("username", userFullName);
		    if(userFullName != null && !userFullName.isEmpty()) {
	        RequestDispatcher rd =  request.getRequestDispatcher("/index.jsp");  
	        rd.forward(request, response);  

		    }
		    else response.sendRedirect("/IDBMSSqlInjection/login.jsp");  

		    
	 }
	 catch (Exception e) {
		 System.out.println(e);
	 }
}
}


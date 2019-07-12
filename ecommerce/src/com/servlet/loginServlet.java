package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Customer;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement ps;
    public loginServlet() {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "learning", "learning");
			if (conn != null)
				System.out.println("Connection Established");
			else
				System.out.println("connection not established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ps = conn.prepareStatement("select * from CUSTOMER where PHONE_NO=? and PASSWORD=?");
			ps.setString(1, request.getParameter("userId"));
			ps.setString(2, request.getParameter("password"));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("CUSTOMER_ID");
				String name = rs.getString("CUSTOMER_NAME");
				String phone_no = rs.getString("PHONE_NO");
				String password = rs.getString("PASSWORD");
				Customer customer = new Customer();
				customer.setId(id);
				customer.setName(name);
				customer.setPhoneNo(phone_no);
				customer.setPassword(password);
				HttpSession session = request.getSession();
				session.setAttribute("user", customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

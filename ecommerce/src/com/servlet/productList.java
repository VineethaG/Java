package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;

public class productList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	Statement statement;

	public productList() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "learning", "learning1");
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Product> productlist = new ArrayList<Product>();
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from product");
			while (rs.next()) {
				int id = rs.getInt("PRODUCT_ID");
				String name = rs.getString("PRODUCT_NAME");
				String desc = rs.getString("PRODUCT_DESC");
				String image_url = rs.getString("PRODUCT_URL");
				int price = rs.getInt("PRICE");
				Product product = new Product();
				product.setId(id);
				product.setName(name);
				product.setDesc(desc);
				product.setUrl(image_url);
				product.setPrice(price);
				productlist.add(product);
			}
			request.setAttribute("productlist", productlist);
			HttpSession session = request.getSession();
			
			session.setAttribute("productlist", productlist);
//				 RequestDispatcher dispatcher = request.getServletContext()
//			                .getRequestDispatcher("/index.jsp");
//			    dispatcher.forward(request, response);
//response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}

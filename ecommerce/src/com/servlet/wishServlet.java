package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;

@WebServlet("/wishServlet")
public class wishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public wishServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cartItemId = Integer.parseInt(request.getParameter("cartitem_id"));
		System.out.println("wishservlet " +cartItemId);
		HttpSession session = request.getSession(false);
		ArrayList<Product> productlist = (ArrayList<Product>) session.getAttribute("productlist");
		ArrayList<Product> wishList = (ArrayList<Product>) session.getAttribute("wishlist");
		ArrayList<Product> cartList = (ArrayList<Product>) session.getAttribute("cartlist");

		if (wishList == null) {
			wishList = new ArrayList<Product>();
		}
		
		ArrayList<Product> auxList = new ArrayList<Product>();

		for (Product list : productlist) {
			if (list.getId() == cartItemId)
				auxList.add(list);
		}
		
		wishList.addAll(auxList);

        ArrayList<Product> removeList =  (ArrayList<Product>) cartList.clone();

		for (Product clist : cartList) {
			if(clist.getId() == cartItemId) removeList.remove(clist);	
		}
		
		session.setAttribute("wishlist", wishList);
		session.setAttribute("cartlist", removeList);
		request.setAttribute("wishlist", wishList);
	}
}

package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;

/**
 * Servlet implementation class cartServlet
 */
@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("action"));
		System.out.println(request.getParameter("id"));

		if("fromProductList".equals(request.getParameter("action"))) {
			addToCartFormProductList(request,response);
		}
		if("fromWishList".equals(request.getParameter("action"))) 			
			addToCartFormWishList(request,response);
	
}

	private void addToCartFormWishList(HttpServletRequest request,HttpServletResponse response) {
		int wishitemid = Integer.parseInt(request.getParameter("id"));
		System.out.println("cart servlet "+wishitemid);
		HttpSession session = request.getSession(false);
		ArrayList<Product> productlist = (ArrayList<Product>) session.getAttribute("productlist");
		ArrayList<Product> wishList = (ArrayList<Product>) session.getAttribute("wishlist");
		ArrayList<Product> cartList = (ArrayList<Product>) session.getAttribute("cartlist");

		if(cartList == null) {
			cartList = new ArrayList<Product>();
		}
		ArrayList<Product> auxList = new ArrayList<>();
		
		for (Product list : productlist) {
			if (list.getId() == wishitemid)
				auxList.add(list);
		}
		cartList.addAll(auxList);
		
        ArrayList<Product> removeList =  (ArrayList<Product>) wishList.clone();
		for (Product wlist : wishList) {
			if(wlist.getId() == wishitemid) removeList.remove(wlist);	
		}
		
		session.setAttribute("cartlist", cartList);
		session.setAttribute("wishlist", removeList);
		request.setAttribute("cartlist", cartList);		

	}

	private void addToCartFormProductList(HttpServletRequest request, HttpServletResponse response) {
		int productid = Integer.parseInt(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		HttpSession session = request.getSession(false);
		ArrayList<Product> productlist = (ArrayList<Product>) session.getAttribute("productlist");
		ArrayList<Product> cartList = (ArrayList<Product>) session.getAttribute("cartlist");
		
		if (cartList == null) {
			cartList = new ArrayList<Product>();
		}
		System.out.println(productlist.get(0).getId());
		for (Product list : productlist) {
			if (list.getId() == productid) {
				cartList.add(list);
			}
		}
		session.setAttribute("cartlist", cartList);
		request.setAttribute("cartlist", cartList);		
}
}
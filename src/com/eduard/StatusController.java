package com.eduard;

import com.eduard.Product;
import com.eduard.Cart;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */

public class StatusController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Connect to mysql and verify username password
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", ""); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select curr_money,no_products from money");
 
		ResultSet rs = ps.executeQuery();
		rs.first();
		int curr_money=rs.getInt(1);
		int no_products=rs.getInt(2);
		
		
		request.setAttribute("curr_money" , curr_money);
		request.setAttribute("no_products" , no_products);
		
		request.getRequestDispatcher("status.jsp").forward(request, response);
		
		while (rs.next()) {
			
			response.sendRedirect("shop.html");
			return;
		}
		
		return;
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

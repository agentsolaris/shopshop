package com.eduard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyProductController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name2");
		
		// Connect to mysql and verify username password
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", ""); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select name, price, quantity from products where name=?");
		ps.setString(1, name);
 
		ResultSet rs = ps.executeQuery();
		rs.last();
		if (rs.getRow()==0) {
			request.setAttribute("result", "Product does not exist!");
	
			RequestDispatcher rss = request.getRequestDispatcher("RegisterFailure.jsp"); 
			rss.forward(request, response);
		}
		else
		{
			String price= rs.getString("price");
			String qty= rs.getString("quantity");
			request.setAttribute("price", price);
			request.setAttribute("qty", qty);
			request.setAttribute("name" , name);
			RequestDispatcher rss = request.getRequestDispatcher("modify-after.jsp"); 
			rss.forward(request, response);
		}
		return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

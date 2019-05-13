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

public class RemoveProductController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		// Connect to mysql and verify username password
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", ""); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select name from products where name=?");
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
			
			String removeSQL = "DELETE FROM products WHERE name = ?";
			ps = c.prepareStatement(removeSQL);
			ps.setString(1, name);
			ps.executeUpdate();
			request.setAttribute("result", "Product deleted succesfully!");
			ps=c.prepareStatement("update money set no_products = no_products  - 1");
			ps.executeUpdate();
			
			RequestDispatcher rss = request.getRequestDispatcher("RegisterFailure.jsp"); 
			rss.forward(request, response);
			ps.close();
		}
		return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

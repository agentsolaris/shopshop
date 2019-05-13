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

/**
 * Servlet implementation class LoginController
 */

public class ModifyProductAfterController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String quantity=request.getParameter("qty");
		String oldName=request.getParameter("oldname");
		// Connect to mysql and verify username password
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", ""); // gets a new connection
 
		PreparedStatement ps;

		
		ps=c.prepareStatement("update products set name= ?, price=?, quantity=? where name=?");
		ps.setString(4, oldName);
		ps.setString(3, quantity);
		ps.setString(2, price);
		ps.setString(1, name);
		ps.executeUpdate();
		request.setAttribute("result", "Product updated succesfully!");
		RequestDispatcher rss = request.getRequestDispatcher("RegisterFailure.jsp"); 
		rss.forward(request, response);
		ps.close();
			
		
		//response.sendRedirect("error.html");
		return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

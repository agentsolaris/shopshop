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

public class RegisterController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("name");
		String pw=request.getParameter("pwd");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", ""); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select username from users where username=?");
		ps.setString(1, un);
		//ps.setString(2, pw);
 
		ResultSet rs = ps.executeQuery();
		rs.last();
		if(rs.getRow()!=0)
		{
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Username already exists!");
			//return;
		}
		else
		{
			String insertTableSQL = "INSERT INTO users"
					+ "(USERNAME, PASSWORD, ENABLED) VALUES"
					+ "(?,?,?)";
			ps = c.prepareStatement(insertTableSQL);
			ps.setInt(3, 0);
			ps.setString(2, pw);
			ps.setString(1, un);
			ps.executeUpdate();
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Registration succesful!");
			//request.setAttribute("result", "Registration was a big succes!");
			//RequestDispatcher rss = request.getRequestDispatcher("RegisterFailure.jsp"); 
			//rss.forward(request, response);
			ps.close();
			return;
			//response.sendRedirect("index.html");
		}
		
		//response.sendRedirect("error.html");
		return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

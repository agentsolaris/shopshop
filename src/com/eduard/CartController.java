package com.eduard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eduard.Cart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */

public class CartController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html;charset=UTF-8");
	        //get sessio
	        
	        HttpSession session = request.getSession();
	       // String total= request.getParameter("totalOrder");
	       
	        ArrayList <Cart> cart=(ArrayList <Cart>) session.getAttribute("cart");
	        String total= request.getParameter("totalOrder");
	        int intTotal= Integer.parseInt(total);
	       // System.out.println(session.getAttribute("cart").get(0).getName());
	        PrintWriter out = response.getWriter();
	        //get current qty
	        if (session.getAttribute("cart") != null) {
	        
	        try {
	        Class.forName("com.mysql.jdbc.Driver");
			 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?allowMultiQueries=true", "root", ""); // gets a new connection

			PreparedStatement ps ; 
			
						ps=c.prepareStatement("update money set curr_money = curr_money + ?");
						ps.setInt(1, intTotal);
						ps.executeUpdate();
                
                for (int i = 0; i < cart.size(); i++) {
                	//check current qty
                	ps =c.prepareStatement("select quantity from products where name=?");
                	ps.setString(1, cart.get(i).getName());
                	ResultSet rs = ps.executeQuery();
          
                	rs.first();
                	ps=c.prepareStatement("update products set quantity=? where name=?");
        			int oldQty= Integer.parseInt(rs.getString("quantity"));
                	ps.setString(2, cart.get(i).getName());
        			ps.setString(1, Integer.toString(oldQty - cart.get(i).getQuantity()));
        			ps.executeUpdate();
        			ps.close();
     
                }
            } catch (ClassNotFoundException | SQLException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
            }
                //destroy session
                session.invalidate();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Thanks for the money!');");
                out.println("location='BuyController';");
                out.println("</script>");
        	}
	        else
	        {
	        	 out.println("<script type=\"text/javascript\">");
	             out.println("alert('Your shopping cart is empty');");
	             out.println("location='BuyController';");
	             out.println("</script>");
	        }
	  
	       
	        return;
	}

}

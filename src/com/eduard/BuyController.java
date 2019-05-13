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

public class BuyController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String productBoughtName = request.getParameter("name");
        HttpSession session = request.getSession();
        ArrayList<Cart> prdInCart = new ArrayList<Cart>();
        ArrayList<Product> prodList = new ArrayList<Product>();
        
        
       try {
        Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?allowMultiQueries=true", "root", ""); // gets a new connection

		PreparedStatement ps = c.prepareStatement("select name, price, quantity from products where name=?");
		ps.setString(1, productBoughtName);
		ResultSet rs = ps.executeQuery();
		rs.first();
		Product auxProd= new Product(rs.getString("name"),rs.getString("price"),rs.getString("quantity"));
		prodList.add(auxProd);
		
        if (session.getAttribute("cart") == null) {
            //if not exist session cart
            //add new product to cart
            prdInCart.add(new Cart(prodList.get(0).getName(),prodList.get(0).getPrice(),1));
            //System.out.println(prdInCart.get(0).getName());
        } else {
            prdInCart = (ArrayList<Cart>) session.getAttribute("cart");
            //if ID is exist
            //increase quantity
            boolean checkName=false;
            for (int i = 0; i < prdInCart.size(); i++) {
                if (prdInCart.get(i).getName().equals(productBoughtName)) {
                	
                    prdInCart.get(i).setQuantity(prdInCart.get(i).getQuantity() + 1);
                    checkName = true;
                    break;
                }
            }
            //if ID isn't exist
            if (checkName ==false) {
                 prdInCart.add(new Cart(prodList.get(0).getName(),prodList.get(0).getPrice(),1));
            }
            
            
            //for (Cart p: prdInCart)
            	
        }
        session.setAttribute("cart", prdInCart);
        response.sendRedirect("cart.jsp");
      
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	}
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Connect to mysql and verify username password
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", ""); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select * from products");
 
		ResultSet rs = ps.executeQuery();
		
		ArrayList <Product> productList= new ArrayList<Product>();
		//Product p=new Product();
		rs.beforeFirst();
		while (rs.next())
		{
			productList.add(new Product(rs.getString("name"),rs.getString("price"),rs.getString("quantity")));
		}
		request.setAttribute("products" , productList);
		
		request.getRequestDispatcher("buy.jsp").forward(request, response);
		
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

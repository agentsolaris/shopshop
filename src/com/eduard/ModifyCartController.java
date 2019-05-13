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

public class ModifyCartController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String productRemovedName = request.getParameter("name");
        int j=-1;
        HttpSession session = request.getSession();
        ArrayList<Cart> prdInCart = new ArrayList<Cart>();
        prdInCart = (ArrayList<Cart>) session.getAttribute("cart");
        for (int i=0;i<prdInCart.size();i++)
        	if (prdInCart.get(i).getName().equals(productRemovedName))
        	{
        		j=i;
        		break;
        	}
        if(j!=-1)
        {
        	if (prdInCart.get(j).getQuantity()-1 == 0)
        		prdInCart.remove(j);
        	else
        		prdInCart.get(j).setQuantity(prdInCart.get(j).getQuantity() - 1);
        }
        	
        session.setAttribute("cart", prdInCart);
        response.sendRedirect("cart.jsp");
      
	}
	
}

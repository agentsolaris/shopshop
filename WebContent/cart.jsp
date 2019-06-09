<%@page import="com.eduard.Product"%>
<%@page import="com.eduard.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping cart</title>
<link rel="stylesheet" href="style3.css">
</head>
<body>


 <table class="container">    
    
    <a href="BuyController"><input type="submit" value="View to product list" /></a>   
    
    <thead>
                <tr>
                    <th><h1>Product</h1></th>
                    <th><h1>Quantity</h1></th>
                    <th><h1>Price</h1></th>
                
                </tr>
            </thead>
            <tbody>
                  
                    <%
                    int totalOrder = 0;
                    HttpSession newSession = request.getSession();
                    if (newSession.getAttribute("cart") != null) {
                        ArrayList<Cart> arrC = (ArrayList<Cart>) newSession.getAttribute("cart");
                        for (int i = 0; i < arrC.size(); i++) {
                            totalOrder += (arrC.get(i).getQuantity() * Integer.parseInt(arrC.get(i).getPrice()));
                %>        
                <tr>
                    <td><%= arrC.get(i).getName()%></td>
                    <td><%= arrC.get(i).getQuantity()%> <a href="ModifyCartController?name=<%= arrC.get(i).getName()%>"><input type="button" value="-" /></a></td>
                    <td><%= arrC.get(i).getPrice()%></td>
                    <td><a href="RemoveCartController?name=<%= arrC.get(i).getName()%>"><input type="submit" value="remove" /></a> </td>
                    
                </tr>
                <%      }
                } else {
                %>
            <h1>YOU DIDN'T BUY ANYTHING YET</h1>
            <%
                }

            %>
        </tbody>
        
    </table>
    <h1>Total: <%= totalOrder%></h1>

   
       <form action="CartController?totalOrder=<%= totalOrder%>" method="post">
                
                <a href="CartController?totalOrder=<%= totalOrder%>"><input type="submit" value="BUY" /></a> 
       </form>
   
     
</body>
</html>
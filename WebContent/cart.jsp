<%@page import="com.eduard.Product"%>
<%@page import="com.eduard.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping cart</title>
    <style>
#cart {
  font-family: "Roboto", sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#cart td, #cart th {
  border: 1px solid #ddd;
  padding: 8px;
}

#cart tr:nth-child(even){background-color: #f2f2f2;}

#cart tr:hover {background-color: #ddd;}

#cart th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>

Shopping Cart<br>

 <br> <br>
  <div class="login-page">             
        <table id="cart">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Remove</th>
                
                </tr>
            </thead>
            <tbody>
                <%--
                    - Get all product that added to cart
                    - Caculate total cash
                --%>   
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
                    <td><%= arrC.get(i).getQuantity()%> <a href="ModifyCartController?name=<%= arrC.get(i).getName()%>"><input type="submit" value="-" /></a></td>
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

    <p>Total: <%= totalOrder%></p>
       <form action="CartController?totalOrder=<%= totalOrder%>" method="post">
                
                <a href="CartController?totalOrder=<%= totalOrder%>"><input type="submit" value="buy" /></a> 
       </form>
   
     <p><a href="BuyController"><input type="submit" value="Back to buy" /></a></p>
     </div>
</body>
</html>
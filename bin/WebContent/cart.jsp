<%@page import="com.eduard.Product"%>
<%@page import="com.eduard.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop</title>
</head>
<body>

Shopping Cart<br>

 <br> <br>
        <table border="1">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
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
                    <td><%= arrC.get(i).getQuantity()%></td>
                    <td><%= arrC.get(i).getPrice()%></td>
                </tr>
                <%      }
                } else {
                %>
            <h1>YOU DIDN'T BUY ANYTHING</h1>
            <%
                }

            %>
        </tbody>
    </table>

    <p>Total: <%= totalOrder%></p>
    <p><input type="submit" value="Confirm" value ="confirm" /></p>
    <form>
     <p><a href="BuyController">Back to buy</a></p>
</body>
</html>
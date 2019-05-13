
    <%@page import="com.eduard.Product"%>
    <%@page import="com.eduard.BuyController"%>
    <%@page import="java.util.ArrayList"%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List products</title>
</head>
<body>
 
 	    <table border="1">
        <thead>
            <tr>
     
                <th>Name</th>
                <th>Price</th>
                <th>Qty</th>
                <th>BUY</th>
            </tr>
        </thead>
        <tbody>
  
             <c:forEach items="${products}" var="product">
    <tr>      
        <td>${product.getName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getQuantity()}</td>
        <td>
                <form action="BuyController?name=${product.getName()}" method="post">
                
                <a href="BuyController?name=${product.getName()}"><input type="submit" value="buy"} /></a> 
                </form>

        </td>
    </tr>
            </c:forEach>
          
        </tbody>
    </table>
    <p><a href="cart.jsp">View Shopping Cart</a></p>
 	

</body>
</html>
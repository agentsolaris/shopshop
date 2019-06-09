
    <%@page import="com.eduard.Product"%>
    <%@page import="com.eduard.BuyController"%>
    <%@page import="java.util.ArrayList"%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<html>
<head>
    <title>List of products</title>
    <style>
#products {
  font-family: "Roboto", sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#products td, #products th {
  border: 1px solid #ddd;
  padding: 8px;
}

#products tr:nth-child(even){background-color: #f2f2f2;}

#products tr:hover {background-color: #ddd;}

#products th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
  margin: auto;
}
</style>
</head>
<body>
<div class="login-page">
 
 	    <table id="products">
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
                
                <a href="BuyController?name=${product.getName()}"><input type="submit" value="buy" /></a> 
                </form>

        </td>
    </tr>
            </c:forEach>
          
        </tbody>
    </table>
    <a href="cart.jsp"><input type="submit" value="View Shopping Cart (${fn:length(cart)})" /></a>
   
 	</div>

</body>
</html>
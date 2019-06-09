
    <%@page import="com.eduard.Product"%>
    <%@page import="com.eduard.BuyController"%>
    <%@page import="java.util.ArrayList"%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<html>
<head>
    <meta charset="utf-8">
    <title>Product list</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
  <table class="container">
    <thead>
      <tr>
        <th><h1>Name</h1></th>
        <th><h1>Price</h1></th>
        <th><h1>Quantity</h1></th>
  
      </tr>
    </thead>
    <c:forEach items="${products}" var="product">
      <tr>      
        <td>${product.getName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getQuantity()}</td>
        <td>
            <form action="BuyController?name=${product.getName()}" method="post">
            
            <a href="BuyController?name=${product.getName()}"><input type="submit" value="BUY" /></a> 
            </form>
    
        
      </tr>
          </c:forEach>
          
        </tbody>
        <a href="cart.jsp"><input type="submit" value="View Shopping Cart (${fn:length(cart)})" /></a>
  
  </table>

</body>
</html>
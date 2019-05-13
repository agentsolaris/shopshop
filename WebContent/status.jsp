
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
     
                <th>Money</th>
                <th>Number of products</th>
            </tr>
        </thead>
        <tbody>
  		<tr>
           <td> ${curr_money} </td>
           <td> ${no_products }</td>
         </tr>
        </tbody>
    </table>
    <script>
        function goBack() {
          window.history.back()
        }
     </script>
 	<button onclick="goBack()">Go Back</button>

</body>
</html>
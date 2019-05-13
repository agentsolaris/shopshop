<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop</title>
</head>
<body>

modify page<br>

 <br> <br>

 <form action="ModifyProductController" method="post">

    old product details: <br><br>
    name :<input type="text" name="name" placeholder="${name}" disabled> <br>
    price :<input type="text" name="price" placeholder="${price}" disabled><br>
    qty :<input type="text" name="qty"placeholder="${qty}" disabled><br>
    </form>

 <form action="ModifyProductAfterController" method="post">

         <input type="hidden" name="oldname" value="${name}" />
        enter new product details:<br><br>
        name :<input type="text" name="name" > <br>
        price :<input type="text" name="price"><br>
        qty :<input type="text" name="qty"><br>
        <input type="submit" value="modifiy">
        </form>
</body>
</html>

<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Online Shop - Eduard Barbulescu</title> 
<link rel="stylesheet" href="styleadmin.css">
</head>

<body>

  <div class="login-page">
  <div class="form">
        <form action="ModifyProductAfterController" method="post" class="login-form" onsubmit="return validateAddForm()">

                        <input type="hidden" name="oldname" value="${name}" />
                       Enter new details:<br><br>
                      <input type="text" name="name" placeholder="name(old : ${name})"> 
                       <input type="text" name="price" placeholder="price(old: ${price})">
                       <input type="text" name="qty" placeholder="quantity(old: ${qty})" >
                       <button  class = "yellowbutton">Modify</button>
                        
        </form>
        <!-- <form action="RemoveProductController?name=${name}" method="post" class="login-form">
        			   <input type="text" name="name" placeholder="${name}" hidden= true>
                       <button  class = "button redbutton">Delete product ${name}</button>
           </form> -->

    
  </div>
  <br>
  <div class="form2">
       
        <form action="RemoveProductController?name=${name}" method="post" class="login-form">
        			   <input type="text" name="name" placeholder="${name}" hidden= true>
                       <button>Delete product "${name}"</button>
           </form>

    
  </div>
  
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="admin.js"></script>

</body>

</html>

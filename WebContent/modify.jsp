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
   
    <form name ="modForm" action="ModifyProductController" method="post" class="login-form" onsubmit="return validateForm()">
            <h1>Enter product name:</h1>
            <input type="text" placeholder="name" name="name2"/>
            <button>Search</button>
            <p class="message">Want to add a product? <a href="admin.html">Add a product</a></p>
    </form>
    
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="admin.js"></script>

</body>

</html>

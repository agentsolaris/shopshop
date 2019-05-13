
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
   <script>
                function goBack() {
                  window.history.back()
                }
                </script>
<button onclick="goBack()">Go Back</button>
        <form action="ModifyProductAfterController" method="post" class="login-form" onsubmit="return validateAddForm()">   
                      <h1>Status of your shop:</h1><br><br>
                      How much money?<input type="text" name="name" placeholder="${curr_money}" disabled> 
                      How many products in shop?<input type="text" name="price" placeholder="${no_products}" disabled>
                       
		</form>
   
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="admin.js"></script>
</div>
</body>

</html>

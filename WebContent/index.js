$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

function validateForm() {
   var x = document.forms["loginForm"]["username"].value;
   var y = document.forms["loginForm"]["password"].value;
   if (x == "") {
     alert("Userame must be filled out");
     return false;
   }
   if (y == "") {
      alert("Password must be filled out");
      return false;
    }
 }

 function validateRegForm() {
   var x = document.forms["registerForm"]["name"].value;
   var y = document.forms["registerForm"]["pwd"].value;
   if (x == "") {
     alert("Userame must be filled out");
     return false;
   }
   if (y == "") {
      alert("Password must be filled out");
      return false;
    }
 }
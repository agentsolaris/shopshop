

function validateForm() {
   var x = document.forms["modForm"]["name2"].value;
   if (x == "") {
     alert("Name must be filled out");
     return false;
   }
 }

 function validateAddForm() {
   var x = document.forms["addForm"]["name"].value;
   var y = document.forms["addForm"]["price"].value;
   var z = document.forms["addForm"]["qty"].value;
   if (x == "") {
     alert("Name must be filled out");
     return false;
   }
   if (y == "") {
      alert("Price must be filled out");
      return false;
    }
    if (z == "") {
      alert("Quantity must be filled out");
      return false;
    }
    if (isNaN(y)) {
      alert("Price must be a number");
      return false;
    }
    if (isNaN(z)) {
      alert("Quantity must be a number");
      return false;
    }
 }
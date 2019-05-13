$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

function remove() {

	
}

function testRegister(form) {

   $.post('RegisterController', function(data) {
      var r=confirm(data);
      console.log(data);
      if (r==true)
       window.location = window.location.href;

  });
}
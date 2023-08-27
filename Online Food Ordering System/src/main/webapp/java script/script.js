/* favourites alert */
$('.heart').click(function () {
  if (this.style.fontWeight == 'normal') {
    this.style.color = 'red';
    this.style.fontWeight = 'bold';
  }
  else {
    this.style.color = 'red';
    this.style.fontWeight = 'normal';

    $('.alertfav').removeClass("hide");
    $('.alertfav').addClass("show");
    $('.alertfav').addClass("showalert");

    document.getElementById('overlay').style.display = "block";
    document.getElementById('overlay').style.opacity = "1";
  }
  
});


function heart(item_id){
	$.post("http://localhost:8080/Online_food_ordering_system/RemoveFavouriteServlet", {item_id : item_id}, function(response){
		
		var msg = document.getElementById('respMsg')
	msg.innerHTML = `<span class="fa-solid fa-heart-crack"></span> <span class="favmsg"> ${response} </span>`
	})
}


$('.alertclose, #overlay').click(function () {
  $('.alertfav').removeClass("show");
  $('.alertfav').addClass("hide");
  document.getElementById('overlay').style.display = "none";
  document.getElementById('overlay').style.opacity = "0";
  // setTimeout(function () {
  //   location.reload(true);
  // }, 300);
});

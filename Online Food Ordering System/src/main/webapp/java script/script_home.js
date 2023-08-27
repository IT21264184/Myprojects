let menu = document.querySelector('#menu-bars');
let navbar = document.querySelector('.navbar');

menu.onclick =() =>{
    menu.classList.toggle('fa-times');
    navbar.classList.toggle('active');
}

window.onscroll =() =>{
    menu.classList.remove('fa-times');
    navbar.classLlist.remove('active');
}

document.querySelector('#search').onclick =() => {
    document.querySelector('#search-form').classList.toggle('active');
}

document.querySelector('#close').onclick =() => {
    document.querySelector('#search-form').classList.remove('active');
}

var swiper = new Swiper(".home-slider", {
    spaceBetween: 30,
    centeredSlides: true,
    autoplay: {
      delay: 2500,
      disableOnInteraction: false,
    },
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
    loop:true,
  });

  var swiper = new Swiper(".review-slider", {
    spaceBetween: 20,
    centeredSlides: true,
    autoplay: {
      delay: 2500,
      disableOnInteraction: false,
    },
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
    loop:true,
    breakpoints:{
      0:{
        slidesPerView: 1,
      },
      640:{
        slidesPerView: 2,
      },
      768: {
        slidesPerView: 2,
      },
      1024: {
        slidesPerView: 3,
      },

    },
  });

/* cart */
/* function showCart(){
  document.getElementById('modal').style.transform = "translate(-50%, -50%) scale(1)";
  document.getElementById('overlay').style.opacity = "1";
  document.getElementById('overlay').style.display = "block";
}

function closeCart(){
  document.getElementById('modal').style.transform = "translate(-50%, -50%) scale(0)";
  document.getElementById('overlay').style.opacity = "0";
  document.getElementById('overlay').style.display = "none";
} */
/* cart open close */
function showCart() {
  $('.modal').removeClass("hide");
  $('.modal').addClass("show");
  $('.modal').addClass("show-cart");
  document.getElementById('overlay').style.display = "block";
  document.getElementById('overlay').style.opacity = "1";
};
$('.close-button').click(function () {
  $('.modal').removeClass("show");
  $('.modal').addClass("hide");
  document.getElementById('overlay').style.display = "none";
  document.getElementById('overlay').style.opacity = "0";
});
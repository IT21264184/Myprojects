<%@page import="model.Item, java.util.ArrayList, service.IIndexService, service.IndexServiceImpl, model.Rating"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> Feane </title>
  <link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Macondo&family=Quicksand:wght@500;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<script src="https://kit.fontawesome.com/339febfaad.js"
	crossorigin="anonymous"></script>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css"
    href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
  <!-- nice select  -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
    integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ=="
    crossorigin="anonymous" />
  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/item.css" rel="stylesheet" />
  <link href="css/style.css" rel="stylesheet" />
  <link href="css/header_footer.css" rel="stylesheet" />
  <link href="css/styles_3.css" rel="stylesheet" />
  
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>

<body class="sub_page">
  <div class="hero_area">
    <div class="bg-box">
      <img src="images/hero-bg1.jpg" alt="" style="padding:0;">
    </div>
    <!-- header section strats -->
    <header class="header_section">
      <div class="container">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index.html">
            <span>
              Feane
            </span>
          </a>

          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class=""> </span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav  mx-auto ">
              <li class="nav-item">
                <a class="nav-link" href="index.html">Home </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="menu.html">Menu</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="about.html">About</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="book.html">Book Table <span class="sr-only">(current)</span>
                </a>
              </li>
            </ul>
            <div class="user_option">
              <a href="" class="user_link">
                <i class="fa fa-user" aria-hidden="true"></i>
              </a>
              <a class="cart_link" href="#" id="cart" onclick="getCart('/GetProfileServlet')">
                <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg"
                  xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029"
                  style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                  <g>
                    <g>
                      <path d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                       c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z" />
                    </g>
                  </g>
                  <g>
                    <g>
                      <path d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                       C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                       c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                       C457.728,97.71,450.56,86.958,439.296,84.91z" />
                    </g>
                  </g>
                  <g>
                    <g>
                      <path d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                       c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z" />
                    </g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                  <g>
                  </g>
                </svg>
              </a>
              <form class="form-inline">
                <button class="btn  my-2 my-sm-0 nav_search-btn" type="button">
                  <i class="fa fa-search" aria-hidden="true" id="search"></i>
                </button>
              </form>
              <a href="" class="order_online">
                Order Online
              </a>
            </div>
          </div>
        </nav>
      </div>
    </header>
    <!-- end header section -->
  </div>

  <!--navigation bar-->

<%
	Item item = new Item();

	item =(Item) request.getAttribute("item");
%>

  <div class="container" style="margin-top: 50px; margin-bottom: 50px;">
    
      <div class="carousel-inner">
        <div class="carousel-item active">
          <div class="card">
            <div class="row">
              <div class="col-md-6 text-center align-self-center"> <img class="img-fluid"
                  src="<%=item.getItemImg()%>"> </div>
              <div class="col-md-6 info">
                <div class="row title">
                  <div class="col">
                    <h1 style="font-size: 4.5rem"><%=item.getItemName() %></h1>
                  </div>
                  <div class="col text-right"><a href="#"><i class="fa fa-heart-o"  style="color: red; font-size: 2rem;"  onclick="addToFavourites(<%=item.getItemID()%>)"></i></a></div>
                </div>
                <span class="fa fa-star checked"></span> <span
                  class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span
                  class="fa fa-star checked"></span> <span class="fa fa-star-half-full"></span> <span id="reviews">1590
                  Reviews</span>
                <p style="margin: 40px 0 10px 0"><%=item.getItemDes() %></p> 
                
                <div class="textarea">
	            	<textarea name="" id="review" cols="30" placeholder="Add any special instructions"></textarea>
	          	</div>
                
              </div>
            </div>
            <div class="row lower">
              
              <div class="col text-right align-self-center" style="display: flex; align-items: initial; justify-content: flex-end;"> 
                <select id="qty">
                  <script>
                    var i;
  
                    for (i = 1; i <= 10; i++) {
                      document.write("<option value='" + i + "' >" + i + "</option>");
                    }
                  </script>
                </select>
                <button class="btn" onclick="test(<%=item.getItemID()%>)">Add to cart</button> </div>
            </div>
            </div>
          </div>
        </div>
      </div>
    
    
	<section class="client_section layout_padding-bottom">
    <div class="container">
      <div class="heading_container heading_center psudo_white_primary mb_45">
        <h2>
          What Says Our Customers
        </h2>
      </div>
      <div class="carousel-wrap row ">
        <div class="owl-carousel client_owl-carousel">
        
        <%
    	ArrayList<Rating> ratings = new ArrayList<Rating>();
    
	    ratings =(ArrayList<Rating>) request.getAttribute("ratings");
	    
	    for(Rating r:ratings){
	    	
	    %>
        
          <div class="item">
            <div class="box">
              <div class="detail-box">
                <p>
                  <%=r.getReview() %>
                </p>
                <h6>
                  <%=r.getName() %>
                </h6>
                <p>
                  <%=r.getEmail() %>
                </p>
              </div>
              <div class="img-box">
                <img src="images/client1.jpg" alt="" class="box-img">
              </div>
            </div>
          </div>
          <%} %>
        </div>
      </div>
    </div>
  </section>



  <!-- footer section -->
  <footer class="footer_section">
    <div class="container">
      <div class="row">
        <div class="col-md-4 footer-col">
          <div class="footer_contact">
            <h4>
              Contact Us
            </h4>
            <div class="contact_link_box">
              <a href="">
                <i class="fa fa-map-marker" aria-hidden="true"></i>
                <span>
                  Location
                </span>
              </a>
              <a href="">
                <i class="fa fa-phone" aria-hidden="true"></i>
                <span>
                  Call +01 1234567890
                </span>
              </a>
              <a href="">
                <i class="fa fa-envelope" aria-hidden="true"></i>
                <span>
                  demo@gmail.com
                </span>
              </a>
            </div>
          </div>
        </div>
        <div class="col-md-4 footer-col">
          <div class="footer_detail">
            <a href="" class="footer-logo">
              Feane
            </a>
            <p>
              Necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin
              words, combined with
            </p>
            <div class="footer_social">
              <a href="">
                <i class="fa fa-facebook" aria-hidden="true"></i>
              </a>
              <a href="">
                <i class="fa fa-twitter" aria-hidden="true"></i>
              </a>
              <a href="">
                <i class="fa fa-linkedin" aria-hidden="true"></i>
              </a>
              <a href="">
                <i class="fa fa-instagram" aria-hidden="true"></i>
              </a>
              <a href="">
                <i class="fa fa-pinterest" aria-hidden="true"></i>
              </a>
            </div>
          </div>
        </div>
        <div class="col-md-4 footer-col">
          <h4>
            Opening Hours
          </h4>
          <p>
            Everyday
          </p>
          <p>
            10.00 Am -10.00 Pm
          </p>
        </div>
      </div>
      <div class="footer-info">
        <p>
          &copy; <span id="displayYear"></span> All Rights Reserved By
          <a href="https://html.design/">Free Html Templates</a><br><br>
          &copy; <span id="displayYear"></span> Distributed By
          <a href="https://themewagon.com/" target="_blank">ThemeWagon</a>
        </p>
      </div>
    </div>
  </footer>
  <!-- footer section -->



  <!-- search -->
  <form action="" id="search-form">
    <input type="search" placeholder="Type here.." name="" id="search-box">
    <label for="search-box" class="fas fa-search"></label>
    <i class="fas fa-times" id="close"></i>
  </form>

  <!--cart-->
  <div class="modalc hide" id="modalc">

    <!--header -->

    <div class="modalc-header">
      <div class="title">My Cart</div>
      <button class="close-button" onclick="closeCart()">&times;</button>
    </div><br>

    <!--add items button-->
    <div class="cart-addItem">
      <button class="abc"><i class="fa-solid fa-plus"></i>Add Items</button>
    </div>

    <!--item list-->
    <div class="cartscroll">
      <div class="modalc-body">
        <ul id="list">
          
         
<!--           <li class="flexbody" id="list"> -->
<!--             <div class="cartitem"> -->
<!--               <select> -->
<!--                 <script> -->
<!--                   var i;

                   for (i = 1; i <= 10; i++) {
                     document.write("<option value='" + i + "' >" + i + "</option>");
                   }
<!--                 </script> -->
<!--               </select> -->
<!--               BBQ Lorem, ipsum dolor sit amet consectetur adipisicing elit. Doloribus laborum ab atque quae eius quos -->
<!--               magni saepe eos temporibus veritatis. -->
<!--             </div> -->
<!--             <div class="cart-delete"> -->
<!--               <img src="images/Hamburger.jpg" alt=""> -->
<!--               <i class="fa-solid fa-trash"></i> -->
<!--             </div> -->
<!--           </li> -->
          
          
          
          
        </ul>

        <!--clear button-->
        <div class="cart-clear">
          <a href="#" onclick="clearCart('/GetProfileServlet')">Clear cart</a>
        </div>
      </div>
      <!--checkout button-->
      <div class="cart-foot">
      <form action="GetCheckoutServlet" class="checkout_btn"><button class="footbut" type="submit">Checkout</button></form>
      </div>
    </div>
  </div>

<!-- alert -->
	<div class="alertfav hide">
		<div id="respMsg">
<!-- 		<span class="fa-solid fa-heart-crack"></span> <span class="favmsg"></span> -->
		</div>
		 <span class="alertclose"> 
		<span
			class="fa-solid fa-xmark"></span>
		</span>
	</div>

  <!--overlay-->
  <div id="overlay"></div>

  <!-- jQery -->
  <script src="js/jquery-3.4.1.min.js"></script>
  <!-- popper js -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
    </script>
  <!-- bootstrap js -->
  <script src="js/bootstrap.js"></script>
  <!-- owl slider -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>
  <!-- isotope js -->
  <script src="https://unpkg.com/isotope-layout@3.0.4/dist/isotope.pkgd.min.js"></script>
  <!-- nice select -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
  <!-- custom js -->
  <script src="js/custom.js"></script>
  <!-- Google Map -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
  </script>
  <!-- End Google Map -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
</body>

</html>
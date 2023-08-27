<%@page import="model.Profile, model.Cart, java.util.ArrayList, service.CartServiceImpl, service.ICartService"%>
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
  <title>Profile</title>

  <script src="https://kit.fontawesome.com/339febfaad.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Macondo&family=Quicksand:wght@500;600&display=swap"
    rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link href="css/header_footer.css" rel="stylesheet" />
  <link href="css/styles_profile.css" rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">


  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
  <script defer src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
  <script defer src="https://code.jquery.com/jquery-3.4.1.js"></script>
  <script defer src="java script/script_3.js"></script>
</head>

<body class="sub_page">
  <div class="hero_area">
    <div class="bg-box">
      <img src="images/hero-bg1.jpg" alt="">
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
                <a class="nav-link" href="book.html">Book Table <span class="sr-only">(current)</span> </a>
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
  <div class="combo">
    <!--navigation bar-->
    <div class="navbar1">
      <ul>
        <li><a href="" class="active">Profile Settings</a></li>
        <li><a href="GetOrderServlet">Orders</a></li>
        <li><a href="GetFavouriteServlet">Favourites</a></li>
        <li><a href="">Help</a></li>
      </ul>
    </div>

    <!--right side panal-->
    <div class="settings">

	<%
		Profile profile = new Profile();
	
		profile =(Profile) request.getAttribute("profile");
	%>

      <!--settings header-->
	<div class="alert alert-danger alert-dismissable collapse" role="alert" id="alertDiv">
					  
		<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-exclamation-circle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
				<path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
		</svg>
					  
		<span id="errMsg"></span>
	</div>
      
      <div class="settings-head">
        <div class="photo">
          <img src="images/user.jpeg" alt="">
        </div>
        <label for="show" class="whole">
          <div class="details">
            <div class="namepen">
              <span><%=profile.getName() %> </span><i class="fa-solid fa-pen fa-2x"></i>
            </div>
            <span class="num"><%=profile.getPhone() %></span>
          </div>
        </label>
      </div>

      <!--settings body-->
      <form action="" method="">
        <div class="sett">
          <!--popup-->
          <div class="center">
            <input type="checkbox" name="" id="show">
            <div class="container1">
              <div class="data">
                <input type="text" placeholder="<%=profile.getName() %>" id="name">
              </div>
              <div class="data">
                <input type="text" placeholder="<%=profile.getPhone() %>" id="phone">
              </div>
            </div>
          </div>

          <ul class="checkout">
            <li>
              <label for=""><i class="fa-solid fa-location-dot"></i> Address</label>
              <div class="profbut" id="prof1">
                <p><%=profile.getAddress() %></p>

                <div id="cntrbtn">
                  <button type="button" onclick="checkuncheck()">Edit</button>
                </div>

              </div>
            </li>
            <!--popup address-->
            <div class="c">
              <input type="checkbox" name="" id="showcntr">
              <div class="cntr">
                  <div class="data">
                    <input type="text" placeholder="<%=profile.getAddress() %>" id="address">

                    <button type="button" onclick="checkuncheck(); showbtn();">&times;</button>
                  </div>
              </div>
            </div>

            <li>
              <label for=""><i class="fa-solid fa-envelope"></i> Email</label>
              <div class="profbut" id="prof2">
                <p> <%=profile.getEmail() %></p>
                <div id="cntrbtn2">
                  <button type="button" onclick="checkuncheck2()">edit</button>
                </div>

              </div>
            </li>
            <!--popup email-->
            <div class="c">
              <input type="checkbox" name="" id="showcntr2">
              <div class="cntr2">
                  <div class="data">
                    <input type="text" placeholder=" <%=profile.getEmail() %>" id="email">
                    <button type="button" onclick="checkuncheck2(); showbtn2();">&times;</button>
                    <a href=""><i class="fa-solid fa-envelope"></i></a>
                  </div>
              </div>
            </div>
          </ul>

          <button class="save" type="button" id="updateBtn" onclick="updateProfile()">Save</button><br>

			<div class="log_delete">
			<button>Logout</button>
          
	          <div class="text-center">
			<!-- Button HTML (to Trigger Modal) -->
			<a href="#myModal" data-toggle="modal">Delete Profile</a>
			</div>
		</div>
          
        </div>
      </form>
    </div>
  </div>

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

  <!--overlay-->
  <div id="overlay"></div>

	<!-- Modal HTML -->
	<div id="myModal" class="modal fade">
		<div class="modal-dialog modal-confirm">
			<div class="modal-content">
				<div class="modal-header flex-column">
					<div class="icon-box">
						<i class="material-icons">&#xE5CD;</i>
					</div>						
					<h4 class="modal-title w-100">Are you sure?</h4>	
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<p>Do you really want to delete the profile? This process cannot be undone.</p>
				</div>
				<div class="modal-footer justify-content-center">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					<form action="DeleteProfileServlet" method="post"><button type="submit" class="btn btn-danger">Delete</button></form>
					
				</div>
			</div>
		</div>
	</div> 

  <!-- jQery -->
  <script src="js/jquery-3.4.1.min.js"></script>

  <!-- bootstrap js -->
  <script src="js/bootstrap.js"></script>
  
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</body>

</html>
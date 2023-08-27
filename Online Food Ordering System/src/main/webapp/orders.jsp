<%@page import="java.util.ArrayList, model.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Basic -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Site Metas -->
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="shortcut icon" href="images/favicon.png" type="">

<title>Feane</title>

<!-- bootstrap core css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

<!--owl slider stylesheet -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
<!-- nice select  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
	integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ=="
	crossorigin="anonymous" />
<!-- font awesome style -->
<link href="css/font-awesome.min.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet" />
<link href="css/header_footer.css" rel="stylesheet" />
<link href="css/styles_profile.css" rel="stylesheet" />
<link href="css/styles_3.css" rel="stylesheet" />
<!-- responsive style -->
<link href="css/responsive.css" rel="stylesheet" />

 <script defer src="java script/script_4.js"></script>
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
              <a class="cart_link" href="#" id="cart" onclick="getCart('/GetOrderServlet')">
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
            </div>
          </div>
        </nav>
      </div>
    </header>
		<!-- end header section -->
	</div>
	<div class="combo">
		<div class="navbar1">
			<ul>
				<li><a href="GetProfileServlet">Profile Settings</a></li>
				<li><a href="" class="active">Orders</a></li>
				<li><a href="GetFavouriteServlet">Favourites</a></li>
				<li><a href="">Help</a></li>
			</ul>
		</div>

		<div class="settings">
			<div class="fav-header">
				<div class="title">My Orders</div>
			</div>

			<%
			ArrayList<Order> orderList = new ArrayList<Order>();
			
			int it_id, oid;
			
			it_id =(int)(request.getAttribute("it_id"));
			oid =(int)(request.getAttribute("oid"));

			orderList = (ArrayList<Order>) request.getAttribute("orderList");

			for (Order o : orderList) {
			%>

			<div class="container py-5 shadow" style="margin-bottom: 50px;">

				<!-- For demo purpose -->
				<div class="row text-center text-white mb-5"
					style="margin-bottom: 0px;">
					<div class="col-lg-7 mx-auto" style="text-align: left; margin-left:0px;">
						<h1 style="color: black;">
							OrderID #<%=o.getOrder_id()%></h1>
							
					</div>
				</div>
				<!-- End -->
				<div class="order_card">
				<div class="row" style="width: 100%; margin-right: 30px;">
					<div class="col-lg-8 mx-auto" style="margin-left:0px; flex: 0 0 100%; max-width: 100%;">

						<!-- List group-->
						<ul class="list-group">

							<%
								ArrayList<Integer> item_id = o.getItem_id();
								ArrayList<String> note = o.getNote();
								ArrayList<String> item_name = o.getItem_name();
								ArrayList<Double> item_price = o.getItem_price();
								ArrayList<String> img_path = o.getImg_path();
								ArrayList<Integer> quantity = o.getQuantity();
								
								Integer[] item_ids = new Integer[item_id.size()];
								item_ids = item_id.toArray(item_ids);
								
								String[] notes = new String[note.size()];
								notes = note.toArray(notes);
								
								String[] item_names = new String[item_name.size()];
								item_names = item_name.toArray(item_names);
								
								Double[] item_prices = new Double[item_price.size()];
								item_prices = item_price.toArray(item_prices);
								
								String[] img_paths = new String[img_path.size()];
								img_paths = img_path.toArray(img_paths);
								
								Integer[] quantities = new Integer[quantity.size()];
								item_ids = quantity.toArray(quantities);
							
								for (int i = 0; i < item_ids.length; i++) {
							%>

							<!-- list group item-->
							<li class="list-group-item">
								<!-- Custom content-->
								<div
									class="media align-items-lg-center flex-column flex-lg-row p-3">
									<div class="media-body order-2 order-lg-1">
										<h2 class="mt-0 font-weight-bold mb-2"><%=item_names[i]%></h2>
										<p class="font-italic text-muted mb-0 small">Special Notes : <%=notes[i] %></p>
										<div
											class="d-flex align-items-center justify-content-between mt-1">
											<h6 class="font-weight-bold my-2">Quantity <%=quantities[i] %></h6>
										</div>
										<div
											class="d-flex align-items-center justify-content-between mt-1">
											<h6 class="font-weight-bold my-2">RS<%=item_prices[i] * quantities[i] %></h6>
										</div>
										
									</div>
									<img
										src="<%=img_paths[i] %>"
										alt="Generic placeholder image" width="140"
										class="ml-lg-5 order-1 order-lg-2">
										
										
								</div> <!-- End -->
								
								<div class="btndiv">
								
								<%
								
								
									if(item_ids[i] == it_id && o.getOrder_id() == oid){
								%>
								
								<button type="button" class="btn btn-dark ratebtn" value="<%=item_ids[i]%>" data-value="<%=o.getOrder_id() %>"> Edit Rate</button>
								
								<%} %>
								
								<button type="button" class="btn btn-dark ratebtn" value="<%=item_ids[i]%>" data-value="<%=o.getOrder_id() %>">Rate</button>
								<button type="button" class="btn btn-dark">Reorder</button>
								</div>
							</li>
							<!-- End -->
							<%
							}
							%>

						</ul>
						<!-- End -->
					</div>
				</div>
				
				<!-- For demo purpose -->
				<div class="row text-center text-white mb-5"
					style="margin-bottom: 0px; width: 100%; margin-top: 30px; display: flex; flex-direction: column; border-right: 1px solid #dfdfdf;">
					<div class="col-lg-7 mx-auto" style="text-align: left; margin-left:0px;">
							<h1 style="color: black; font-size: x-large; font-weight: bold;">
							Address </h1>
							<h1 style="color: black; font-size: x-large; font-weight: bold;">
							Phone </h1>
							<h1 style="color: black; font-size: x-large; font-weight: bold;">
							Payment Type </h1>
							<%
								if(o.getPay_type().equals("Credit/Debit Card")){
							%>
							
							<h1 style="color: black; font-size: x-large; font-weight: bold;">
							Card No </h1>
							
							
							<%} %>
							<h1 style="color: black; font-size: x-large; font-weight: bold;">
							Date </h1>
							<h1 style="color: black; font-size: x-large; font-weight: bold;">
							Time </h1>
							<h1 style="color: black; font-size: x-large; font-weight: bold;">
							Total </h1>
					</div>
					<div class="col-lg-7 mx-auto" style="text-align: left; margin-left:0px;">
							<h1 style="color: black; font-size: larger; line-height: 29px;">
							<%=o.getAddress()%></h1>
							<h1 style="color: black; font-size: larger; line-height: 29px;">
							<%=o.getPhone()%></h1>
							<h1 style="color: black; font-size: larger; line-height: 29px;">
							<%=o.getPay_type()%></h1>
							<%
								if(o.getPay_type().equals("Credit/Debit Card")){
							%>
							
							<h1 style="color: black; font-size: larger; line-height: 29px;">
							<%=o.getCardNo()%></h1>
							
							
							<%} %>
							<h1 style="color: black; font-size: larger; line-height: 29px;">
							<%=o.getDate()%></h1>
							<h1 style="color: black; font-size: larger; line-height: 29px;">
							<%=o.getTime	()%></h1>
							<h1 style="color: black; font-size: larger; line-height: 29px;">
							<%=o.getOrder_total()%></h1>
					</div>
				</div>
				<!-- End -->
				</div>
			</div>

			<%
			}
			%>

		</div>

	</div>
	<!--navigation bar-->


	<!-- footer section -->
	<footer class="footer_section">
		<div class="container">
			<div class="row">
				<div class="col-md-4 footer-col">
					<div class="footer_contact">
						<h4>Contact Us</h4>
						<div class="contact_link_box">
							<a href=""> <i class="fa fa-map-marker" aria-hidden="true"></i>
								<span> Location </span>
							</a> <a href=""> <i class="fa fa-phone" aria-hidden="true"></i> <span>
									Call +01 1234567890 </span>
							</a> <a href=""> <i class="fa fa-envelope" aria-hidden="true"></i>
								<span> demo@gmail.com </span>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 footer-col">
					<div class="footer_detail">
						<a href="" class="footer-logo"> Feane </a>
						<p>Necessary, making this the first true generator on the
							Internet. It uses a dictionary of over 200 Latin words, combined
							with</p>
						<div class="footer_social">
							<a href=""> <i class="fa fa-facebook" aria-hidden="true"></i>
							</a> <a href=""> <i class="fa fa-twitter" aria-hidden="true"></i>
							</a> <a href=""> <i class="fa fa-linkedin" aria-hidden="true"></i>
							</a> <a href=""> <i class="fa fa-instagram" aria-hidden="true"></i>
							</a> <a href=""> <i class="fa fa-pinterest" aria-hidden="true"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 footer-col">
					<h4>Opening Hours</h4>
					<p>Everyday</p>
					<p>10.00 Am -10.00 Pm</p>
				</div>
			</div>
			<div class="footer-info">
				<p>
					&copy; <span id="displayYear"></span> All Rights Reserved By <a
						href="https://html.design/">Free Html Templates</a><br>
					<br> &copy; <span id="displayYear"></span> Distributed By <a
						href="https://themewagon.com/" target="_blank">ThemeWagon</a>
				</p>
			</div>
		</div>
	</footer>
	<!-- footer section -->
	
	<!-- rate -->
  <div class="bg-modal">

    <div class="container2">
      <div class="payhead">
        <div class="closelabel">
          &times;
        </div>
      </div>
      <div class="star-widget">
        <input type="radio" name="rate" id="rate-5" value="5" onclick="rateMsg()">
        <label for="rate-5" class="fas fa-star"></label>

        <input type="radio" name="rate" id="rate-4" value="4" onclick="rateMsg()">
        <label for="rate-4" class="fas fa-star"></label>

        <input type="radio" name="rate" id="rate-3" value="3" onclick="rateMsg()">
        <label for="rate-3" class="fas fa-star"></label>

        <input type="radio" name="rate" id="rate-2" value="2" onclick="rateMsg()">
        <label for="rate-2" class="fas fa-star"></label>

        <input type="radio" name="rate" id="rate-1" value="1" onclick="rateMsg()">
        <label for="rate-1" class="fas fa-star"></label>

        <form action="">
          <label for="" id="starlabel"></label>
          <div class="textarea">
            <textarea name="" id="review" cols="30" placeholder="Describe your experience"></textarea>
          </div>

          <div class="starbtn">
            <button onclick="rateSubmit()" type="button">Done</button>
          </div>
        </form>
      </div>
    </div>
  </div>
	
	
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
          <a href="">Clear cart</a>
        </div>
      </div>
      <!--checkout button-->
      <div class="cart-foot">
        <button class="footbut">Checkout</button>
      </div>
    </div>
  </div>
  

  <!--overlay-->
  <div id="overlay"></div>

	<!-- jQery -->
	<script src="js/jquery-3.4.1.min.js"></script>
	<!-- popper js -->
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous">
		
	</script>
	<!-- bootstrap js -->
	<script src="js/bootstrap.js"></script>
	<!-- owl slider -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
		
	</script>
	<!-- isotope js -->
	<script
		src="https://unpkg.com/isotope-layout@3.0.4/dist/isotope.pkgd.min.js"></script>
	<!-- nice select -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
	<!-- custom js -->
	<script src="js/custom.js"></script>
</body>

</html>
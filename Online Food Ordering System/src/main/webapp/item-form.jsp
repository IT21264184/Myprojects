

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Item Management  </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="item-list.jsp"
					class="nav-link">Item List</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<form action="AdminAddItemsServlet" method="post">
				<fieldset class="form-group">
					<label>Item ID</label> <input type="text"
						value="" class="form-control"
						name="item_id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Item Name</label> <input type="text"
						value="" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Item Description</label> <input type="text"
						value="" class="form-control"
						name="desc">
				</fieldset>

				<fieldset class="form-group">
					<label>Item Price</label> <input type="text"
						value="" class="form-control"
						name="price">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Item Image</label> <input type="text"
						value="" class="form-control"
						name="img">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
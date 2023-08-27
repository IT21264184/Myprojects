<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir"ltr">
 <head>
      <meta charset="utf-8">
      
      <link rel="stylesheet" type="text/css" href="css/styles_Nilusha.css"/>
      <link href="css/styles_checkout.css" rel="stylesheet">
      <title> Login Form </title>
 </head>
 <body>
 
 <input type="hidden" id="status" value= "<%= request.getAttribute("status") %>" >

   <div class="center">
       <h1>Login</h1>
          <form action="login" method="post">
            <div class="userl">
              <input type="text"  name="uid">
              <span></span>
              <labal>Email</labal>
            </div>
            <div class="userl">
              <input type="password" name="pass">
              <span></span>
              <labal>Password</labal>
            </div>
            <div class="fpass">
            <a href = "forgotpassword.jsp"> Forgot Password? </a>
            </div>
            <input type="submit" value="Login">
            <div class="sign"> 
             Do not have an account? <a href="registration.jsp">Signup</a>
            </div>
            
          </form>
    </div>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	 <link rel="stylesheet" href="alert/dist/sweetalert.css">
	 
	 <script type="text/javascript">
	  var status = document.getElementById("status").value;
	  if(status == "failed"){
		  swal("sorry","Wrong username or password","error");
	  }
	  else if(status == "resetSuccess"){
		  swal("congrats","password Reset Successful","success");
	  }
	  else if(status == "resetFailed"){
		  swal("sorry","password Reset Failed","error");
	  }
	 
	 </script>

 </body>
</html>
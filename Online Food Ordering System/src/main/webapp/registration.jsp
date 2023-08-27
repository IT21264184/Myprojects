<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir"ltr">
 <head>
      <meta charset="utf-8">
      <link rel="stylesheet" type="text/css" href="css/styles_Nilusha.css"/>
      <title> Registration Form </title>
 </head>
 <body>
 <input type="hidden" id="status" value= "<%= request.getAttribute("status") %>" >

   <div class="center">
       <h1>Registration Form</h1>
          <form method="post" action="register">
            <div class="userl">
              <input type="text" name="name" id="name" >
              <labal>Fullname</labal>
            </div>
            <div class="userl">
              <input type="email" name="email" id="email" >
              <labal>Email</labal>
            </div> 
            <div class="userl">
              <input type="text" name="address" id="address" >
              <labal>Address</labal>
            </div> 
            <div class="userl">
              <input type="text" name="contact" id="contact" >
              <labal>Phone Number</labal>
            </div>     
            <div class="userl">
              <input type="password" name="pass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,10}" id="pass" >
              <labal>Password</labal>
            </div>     
            <div class="userl">
              <input type="password" name="r_pass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,10}" id="re_pass" >
              <labal>Confirm Password</labal>
            </div>   

            <input type="submit" value="Register">
                
            <div class="sign"> 
             Already have an account? <a href="login.jsp">Login</a>
            </div> 

          </form>
      </div>
      <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	 <link rel="stylesheet" href="alert/dist/sweetalert.css">
	 
	 <script type="text/javascript">
	  var status = document.getElementById("status").value;
	  if(status == "success"){
		  swal("done","Account Created Successfully","success");
	  }
	 
	 </script>
 
 </body>
</html>
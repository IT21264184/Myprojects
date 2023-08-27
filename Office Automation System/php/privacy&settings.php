<?php
   require 'config.php';
?>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <title>ABC (pvt) Limited</title>

    <!--Link JS file-->
    <script src="Js/myscript.js"></script>

    <!-- Link CSS file -->
    <link rel="stylesheet" href="../css/nilCss.css">

    <script src="../js/myscript.js"> </script>

    <!-- Add icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css"
        integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <div class="header">
        <a href="user.php"><img src="../images/user.png" class=" user" alt="profile_pic"></a>
            <a href="../html/home.html"><img src="../images/logo.png" class="logo" alt="logo"></a>
            <ul>
                <li><a href="../html/home.html">Home</a></li>
                <li><a href="#about">About Us</a></li>
                <li><a href="../html/FAQ.html">Help</a></li>
                <li><a href="../html/Resources.html">Support Services</a></li>
                <li><a href="ContactUs.php">Contact Us</a></li>
            </ul>
        </div>

 <div class="vertical-menu"> 
 <a href="user.php">Your info</a>
  <a href="../html/security.html">Security</a>
  <a href="privacy&settings.php">Privacy & Settings</a>

   <div class="dropdown">
  <button onclick="myFunction()" class="dropbtn">Support Services</button>
  <div id="myDropdown" class="dropdown-content">
    <a href="#">Attendance</a>
    <a href="#">Request resource</a>
    <a href="salarysheet.php">Salary Sheet</a>
  </div>
</div>
</div>

<div class="bd">
    <h2>Privacy & Settings</h2>
    <p>Key privacy options to help you choose the data saved in your account</p>
<hr>
    <h3>Ad Settings</h3>
    <pre>You can choose whether to see ads or to block them</pre>
     <label>
      <input type="radio" name="ad"> On
      <input type="radio" name="ad"> Off
     </label>
     <button>Enter</button>
 <hr>
    <h4>Profile Settings</h4>
    <pre>select who can see your infomation</pre>
    <select id="con" onchange="profile()"> 
        <option>----select----</option>
        <option >private</option>
        <option >public</option>
        <option >Only friends</option>
    </select>
    <button>Select</button>
<hr>
    <h5>Notification Settings</h5>
     <pre>send notifications to All devices </pre>
     <input id="myInput" value="All Devices"  disabled>
     <button id="myBtn" onclick="javascript:alert('Successfully sent')">Confirm</button>
 <hr>
    <h6>Download or delete your data</h6>
    <pre>Your content and preferences related to your account</pre>
    <button>Download</button>
    <button>Delete</button>
 <hr>
     <h3>More options</h3>
     <pre>Other options to manage your data, like choosing what happens to it when your account becomes inactive or deleting your account</pre>
     <p>Enter Your Employee Id To Delete your Acconut</p>
       <form action="" method="POST">
        <input type="text" name="id"  placeholder="Enter id to delete"/>
        <input type="submit" name="Delete" value="Confirm Delete account">
      </form>

      <?php

        if(isset($_POST['Delete']))
        {
           $id = $_POST['id'];

            $sql = "DELETE FROM employee WHERE Emp_id='$id' ";
                      $sql_run = mysqli_query($conn, $sql);

            if($sql_run) 
            {
                 echo'<script type="text/javascript"> alert("Data Delete") </script>';
            }
            else
            {
                 echo'<script type="text/javascript"> alert("Data Not Delete") </script>';
            } 
        }


      ?>
 </div>



        <div class="footer">
        <a href="../html/Feedback.html"  style = "float : left;"><button>Feedback</button></a>
            <p style="margin-left:-50px;"> Copyright 2022 ©ABC (PVT) Limited. All Rights Reserved. </p>
            <a href="#">Terms</a>
            <a href="#">Privacy</a>
        </div>
    </div>
</body>

</html>

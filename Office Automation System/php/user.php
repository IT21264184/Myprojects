<?php

     require 'config.php' ;
?>

<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <title>ABC (pvt) Limited</title>

    <!--Link JS file-->
    <script src="../js/myscript.js"></script>

    <!-- Link CSS file -->
    <link rel="stylesheet" href="../css/nilCss.css">

    <!-- Add icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css"
        integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <div class="header">
            <a href="../html/home.html"><img src="../images/logo.png" class="logo"><br /><br /></a>
            <ul>
                <li><a href="../html/home.html">Home</a></li>
                <li><a href="#about">About Us</a></li>
                <li><a href="../html/FAQ.html">Help</a></li>
                <li><a href="../html/Resources.html">Support Services</a></li>
                <li><a href="ContactUs.php" >Contact Us</a></li>
            </ul>
        </div>

 <div class="vertical-menu"> 
  <a href="user.php">Your info</a>
  <a href="../html/security.html">Security</a>
  <a href="privacy&settings.php">Privacy & Settings</a>

  <div class="dropdown">
  <button onclick="myFunction()" class="dropbtn">Support Services</button>
  <div id="myDropdown" class="dropdown-content">
    <a href="attendance.php">Attendance</a>
    <a href="../html/Resources.html">Request resource</a>
    <a href="salarysheet.php">Salary Sheet</a>
  </div>
</div>

</div>
 
  <div class="bd">
<h2>Your Info</h2>
<p>You can see your infomation here</p>
     <form action="" method="post">
                    <?php

                          $sql = "SELECT NIC,gender,fname,lname,salary,emp_address,email,phone,d_number,designation,since
                                  FROM employee
                                  ORDER BY d_number ASC
                                  LIMIT 1";
                          $result = mysqli_query($conn, $sql); 
                          if (mysqli_num_rows($result) > 0) {
                          while ($row = mysqli_fetch_assoc($result)) {
                    ?>
                    <div class="inputBox">
                        <label for="NIC">NIC :&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</labal>
                        <input type="text" id="NIC" name="NIC" placeholder="NIC" value="<?php echo $row['NIC']; ?>" disabled required>
                    </div>
                    <div class="inputBox">
                        <label for="gender">Gender &emsp;:&emsp;&emsp;&emsp;&emsp;&emsp;</labal>
                        <input type="text" id="gender" name="gender" placeholder="Gender" value="<?php echo $row['gender']; ?>" disabled required>
                    </div>
                    <div class="inputBox">
                        <label for="fname">First name :&emsp;&emsp;&emsp;&emsp;</labal>
                        <input type="text" id="fname" name="fname" placeholder="First name" value="<?php echo $row['fname']; ?>" disabled required>
                    </div>
                    <div class="inputBox">
                        <label for="lname">Last Name :&emsp;&emsp;&emsp;&emsp;</labal>
                        <input type="text" id="lname" name="lname" placeholder="Last Name" value="<?php echo $row['lname']; ?>" disabled required>
                    </div>
                    <div class="inputBox">
                        <label for="salary">Salary :&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</labal>
                        <input type="data" id="salary" name="salary" placeholder="Salary" value="<?php echo $row['salary']; ?>" disabled required>
                    </div>
                    <div class="inputBox">
                        <label for="emp_address">Employee Address :&emsp;</labal>
                        <input type="txtaddress" id="emp_address" name="emp_address" placeholder="Employee Address" value="<?php echo $row['emp_address']; ?>" disabled required>
                    </div>
                    <div class="inputBox">
                        <label for="email">Email &emsp;:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</labal>
                        <input type="email" id="email" name="email" placeholder="Email" value="<?php echo $row['email']; ?>" disabled required>
                    </div>
                    <div class="inputBox">
                        <label for="phone">Phone :&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</labal>
                        <input type="data" id="phone" name="phone" placeholder="Phone" value="<?php echo $row['phone']; ?>" disabled required>
                    </div>
                    <div class="inputBox">
                        <label for="d_number">Dnumber :&emsp;&emsp;&emsp;&emsp;&emsp;</labal>
                        <input type="data" id="d_number" name="d_number" placeholder="Dnumber" value="<?php echo $row['d_number']; ?>" disabled required>
                    </div>
                     <div class="inputBox">
                        <label for="designation">Designation :&emsp;&emsp;&emsp;&emsp;</labal>
                        <input type="text" id="designation" name="designation" placeholder="Designation" value="<?php echo $row['designation']; ?>" disabled required>
                    </div>
                    <div class="inputBox">
                        <label for="since">Since :&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</labal>
                        <input type="data" id="since" name="since" placeholder="Since" value="<?php echo $row['since']; ?>" disabled required>
</div>
                   <?php
                   }
                    }

                   ?>                    

                    
                    <div class="inputBox">
                    <button><a href="update_prof.php">Edit Profile</a></button>
                    <!-- <button type="submit" class"btn">Edit Profile</button> -->
                    </div>
 </div>
<div class="logout">
<img src = "../images/user.png" class="logout" width="170" >
<Button style="font-size:43px"> <a href="logout.php">Log Out </a></button>
</div>

        <div class="footer">
        <button><a href="../html/Feedback.html"  style = "float : left;">Feedback</a></button>
            <p style="margin-left:-50px;"> Copyright 2022 ©ABC (PVT) Limited. All Rights Reserved. </p>
            <a href="#">Terms</a>
            <a href="#">Privacy</a>
        </div>
    </div>
</body>

</html>
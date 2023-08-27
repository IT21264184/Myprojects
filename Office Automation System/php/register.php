<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <title>ABC (pvt) Limited</title>

    <!--Link JS file-->
    <script src="../js/script.js"></script>

    <!-- Link CSS file -->
    <link rel="stylesheet" href="../css/style.css">

    <!-- Add icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css"
        integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <div class="header">
            <a href="naverr.php"><img src="../images/logo.png" class="logo" alt="logo"></a>
        </div>

        <div class="navigation">
            <ul>
                <li><a href="naverr.php">Home</a></li>
                <li><a href="naverr.php">About Us</a></li>
                <li><a href="naverr.php">Help</a></li>
                <li><a href="naverr.php">Support Services</a></li>
                <li><a href="naverr.php">Contact Us</a></li>
            </ul>
        </div>

        <div class="back">
            <div class="register">
                <h2>Registration</h2> <br>

                <form action="insert.php" method="post">

                    <?php 
                    if(isset($_GET['error']))
                    {
                    ?>
                    <p class="err_msg"><?php echo $_GET['error']; ?></p>
                    <?php 
                    }?>
                    <?php 
                    if(isset($_GET['success']))
                    {
                    ?>
                    <p class="succ_msg"><?php echo $_GET['success']; ?></p>
                    <?php 
                    }?>

                    <label>First Name</label>
                    <input type="text" name="fname"> <br>

                    <label>Last Name</label>
                    <input type="text" name="lname"> <br>

                    <label>Username</label>
                    <input type="text" name="uname"> <br>

                    <label>Email</label>
                    <input type="email" name="mail"> <br>

                    <label>NIC</label>
                    <input type="text" name="nic"> <br>

                    <label>Address</label>
                    <input type="text" name="address"> <br>

                    <label>Phone</label>
                    <input type="tel" name="phone"> <br>

                    <label>Password</label>
                    <input type="password" name="pass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,10}"> <br>

                    <label>Confirm Password</label>
                    <input type="password" name="r_pass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,10}"> <br>

                    <label>Department</label>
                    <select name="department">
                        <option value="Human Resource">Human Resource</option>
                        <option value="Marketing">Marketing</option>
                        <option value="Finance">Finance</option>
                        <option value="Sales">Sales</option>
                        <option value="Operations">Operations</option>
                    </select> <br><br><br>

                        <label>Gender</label> <br>
                        <div>
                        <label for="male">Male</label> <input type="radio" name="gender" value="male" id="male"><br><br>
                        <label for="female">Female</label> <input type="radio" name="gender" value="female" id="female"><br>
                    </div>

                    <div style="padding-left: 25%;">
                        <input type="checkbox" name="chk" id="chkbox" onclick ="enableRegister(this)">
                        <label>Agree to our Terms & Privacy.</label>
                    </div>
                    <input type="submit" value="SignUp" id="register" disabled ="disabled">

                    <div class="signup">
                        Already have a account? <a href="index.php">Login</a>
                    </div>
                </form>
            </div>
        </div>

        <div class="footer">
            <a href="naverr.php"  style = "float : left;"><button>Feedback</button></a>
            <p style="margin-left:-50px;"> Copyright 2022 ©ABC (PVT) Limited. All Rights Reserved. </p>
            <a href="#">Terms</a>
            <a href="#">Privacy</a>
        </div>
</body>

</html>
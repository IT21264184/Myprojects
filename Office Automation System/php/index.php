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
            <a href="#home"><img src="../images/logo.png" class="logo" alt="logo"></a>
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
            <div class="center">
                <h2>Login</h2>

                <form action="login.php" method="post">
                    <?php 
                    if(isset($_GET['error']))
                    {
                    ?>
                    <p class="err_msg"><?php echo $_GET['error']; ?></p>
                    <?php 
                    }?>
                    <label>User Name</label>
                    <input type="text" name="uname" > <br>
                    
                    <label>Password</label>
                    <input type="password" name="password" id="pass" >
                        
                    <div class="forgot_pass" style="margin-bottom: 0px;">
                        <a href="reset.php">Forgot password?</a>
                    </div>
                    <input type="submit" value="Login">
                    <div class="signup">
                        Don't have a account? <a href="register.php">SignUp</a>
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
    </div>
</body>

</html>
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
            <a href="user.php"><img src="../images/user.png" class=" user" alt="profile_pic"></a>
            <a href="../html/home.html"><img src="../images/logo.png" class="logo" alt="logo"></a>
        </div>

        <div class="navigation">
            <ul>
                <li><a href="../html/home.html">Home</a></li>
                <li><a href="#about">About Us</a></li>
                <li><a href="../html/FAQ.html">Help</a></li>
                <li><a href="../html/Resources.html">Support Services</a></li>
                <li><a href="#" class="active">Contact Us</a></li>
            </ul>
        </div>

        <div class="left">
            <h2>Send Us A Message</h2><br />
            
            <form action="contact_chk.php" method="post">
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
                
                <input type="text" name="name" placeholder="First Name" /><br /><br />
                <input type="email" name="mail" placeholder="Email" /><br /><br />
                <textarea name="msg" placeholder="Message"></textarea><br /><br />
                <input type="submit" value="Send Message" />
            </form>
        </div>

        <div class="right">
            <h2>Contact Us</h2><br />
            <p><i class="fa fa-phone" aria-hidden="true"></i> 011-7044800 <br><i class="fa fa-map-marker"
                    aria-hidden="true"></i> ABC (pvt) Limited <br> 524c, Kandy <br> Sri Lanka 20000 </p>
            <a href="#"><i class="fa fa-facebook-square" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-twitter-square" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-google-plus-square" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-linkedin-square" aria-hidden="true"></i></a>
        </div>

        <div class="footer">
            <a href="../html/Feedback.html"  style = "float : left;"><button>Feedback</button></a>
            <p> Copyright 2022 ©ABC (PVT) Limited. All Rights Reserved. </p>
            <a href="#">Terms</a>
            <a href="#">Privacy</a>
        </div>
    </div>
</body>

</html>
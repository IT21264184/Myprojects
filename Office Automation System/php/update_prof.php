<?php
session_start();

include "config.php";

if(isset($_SESSION['id']) && isset($_SESSION['uname']))
{
    $uname = $_SESSION['uname'];

    $sql8 = "SELECT e.fname, e.lname, e.email, e.emp_address, e.phone 
            FROM Employee e, Identification i 
            WHERE e.Emp_id = i.Emp_id AND i.username = '$uname'";

    $result8 = mysqli_query($conn, $sql8);

    if(mysqli_num_rows($result8) > 0)
    {
        $row2 = mysqli_fetch_assoc($result8);

        $_SESSION['fname'] = $row2['fname'];
        $_SESSION['lname'] = $row2['lname'];
        $_SESSION['mail'] = $row2['email'];
        $_SESSION['address'] = $row2['emp_address'];
        $_SESSION['phone'] = $row2['phone'];

    }

    if (!$result8) {
        echo "Could not successfully run query ($sql8) from DB: " . mysqli_error();
        exit();
    }
?>

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
                <li><a href="ContactUs.php">Contact Us</a></li>
            </ul>
        </div>

        <div class="back">
            <div class="register">
                <h2>Edit Profile</h2>

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

                <form action="update_chk.php" method="post">

                    <label>First Name</label>
                    <input type="text" name="fname" placeholder = "<?php echo $_SESSION['fname']; ?>"> <br>
                        
                    <label>Last Name</label>
                    <input type="text" name="lname" placeholder = "<?php echo $_SESSION['lname']; ?>"> <br>
                    
                    <label>Username</label>
                    <input type="text" name="uname" placeholder = "<?php echo $_SESSION['uname']; ?>"> <br>
                    
                    <label>Email</label>
                    <input type="email" name="mail" placeholder = "<?php echo $_SESSION['mail']; ?>"> <br>
                
                    <label>Address</label>
                    <input type="text" name="address" placeholder = "<?php echo $_SESSION['address']; ?>"> <br>
                
                    <label>Phone</label>
                    <input type="tel" name="phone" placeholder = "<?php echo $_SESSION['phone']; ?>"> <br>
                    
                    <input type="submit" value="Save Changes">

                    <div class="forgot_pass" style="margin-bottom: 0px;">
                        <a href="user.php">< Back</a>
                    </div>
                </form>
            </div>
        </div>

        <div class="footer">
            <a href="../html/Feedback.html"  style = "float : left;"><button>Feedback</button></a>
            <p style="margin-left:-50px;"> Copyright 2022 ©ABC (PVT) Limited. All Rights Reserved. </p>
            <a href="#">Terms</a>
            <a href="#">Privacy</a>
        </div>
</body>
</html>

<?php 
}
else
{
    header("Location: index.php?");
    exit();
}
?>
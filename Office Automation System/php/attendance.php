<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">


<head>
    <meta charset="utf-8" />
    <title>ABC (pvt) Limited</title>

    <!--Link JS file-->
    <script src="script.js"></script>

    <!-- Link CSS file -->
    <link rel="stylesheet" href="../css/styledevindi.css">

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
                <li><a href="#" style="margin-left:-70px;">Home</a></li>
                <li><a href="#about">About Us</a></li>
                <li><a href="#help">Help</a></li>
                <li><a href="ContactUs.html">Contact Us</a></li>
            </ul>
        </div>

        <?php include 'config.php'?>



        <div class="row">
        <div  class="col">
                <?php
                    // check if the subject get value exits Database Name attn
                    if(isset($_GET['attn']))
                    {
                        // remove single quotes from scp get value
                        $item_number = trim($_GET['attn'], "'");

                        // run sql command to select record based on get value
                        $record = $connection->query("select * from attn where Item_no='$Employee_No'") or die($connection->error());

                        // convert $record into an array for us to echo out on screen
                        $row = $record->fetch_assoc();
                        
                        

                        // create variables that hold data from db fields
                        $Employee_No= $row['Employee_No'];
                        $Employee_Name = $row['Employee_Name'];
                        $date = $row['date'];
                        $Punch_in = $row['Punch_in'];
                        $Punch_out = $row['Punch_out'];
                        $Production = $row['Production'];
                        $Break = $row['Break'];
                        $Overtime = $row['Overtime'];
                    


                        // strip out \n and replace with linebreaks
                        $Employee_No = str_replace('\n', '<br><br>',$Employee_No);
                        $Employee_Name = str_replace('\n', '<br><br>',$Employee_Name);
                        $date = str_replace('\n', '<br><br>', $date);
                        $Punch_in = str_replace('\n', '<br><br>',$Punch_in);
                        $Punch_out = str_replace('\n', '<br><br>',$Punch_out);
                        $Production = str_replace('\n', '<br><br>',$Production);
                        $Break = str_replace('\n', '<br><br>',$Break);
                        $Overtime = str_replace('\n', '<br><br>',$Overtime);
                      
                        // Display db subject record to screen

                        echo "<h3>Employee No</h3>
                              <p>{$Employee_No}</p>
                              <h3>Employee Name</h3>
                              <p><$Employee_Name</p>
                              <h3>Date</h3>
                              <p><$date</p>
                              <h3>Punch_in</h3>
                              <p>{$Punch_in}</p>
                              <h3>Punch_out</h3>
                              <p>{$Punch_out}</p>
                              <h3>Production</h3>
                              <p>{$Production}</p>
                              <h3>Break</h3>
                              <p>{$Break}</p>
                              <h3>Overtime</h3>
                              <p>{$Overtime}</p>";
   
                    }
                    

                ?>
        </div>
    </div>

    </section>
<section id="create" class="content-section text-center">
    <div class="col-lg-8 mx-auto">
        <h2>Attendance Form</h2>
    </div>
	<div class ="form-group">
    <form action="connection.php" method = "POST">

    <label>Employee No</label>
    <br>
    <input type ="text" name = "Employee_No" placeholder = "Employee No" class = "form-control">
    <br><br>
    <label>Employee Name</label>
    <br>
    <input type ="text" name = "Employee_Name" placeholder = "Employee Name" class = "form-control">
    <br><br>
    <label>Date</label>
    <br>
    <textarea type ="text" name = "Date" placeholder = "Date"  class = "form-control"></textarea>
    <br><br>
    <label>Punch in</label>
    <br>
    <input type ="text" name = "Punch_in"  placeholder = "Punch in" class = "form-control">
    <br><br>
    <label>Punch out</label>
    <br>
    <textarea type ="text" name = "Punch_out" placeholder = "Punch out"  class = "form-control"></textarea>
    <br><br>
    <label>Production</label>
    <br>
    <textarea type ="text" name = "Production" placeholder = "Production"  class = "form-control"></textarea>
    <br><br>
    <label>Break</label>
    <br>
    <input type ="text" name = "Break" placeholder = "Break"  class = "form-control">
    <br><br>
    <label>Overtime</label>
    <br>
    <input type ="text" name = "Overtime" placeholder = "Overtime"  class = "form-control">
    <br><br>
    <button type = "submit"  class = "btn-primary" style="width: 73px;color: rgb(255,255,255);" >submit</button>


    </form>
</section>

    
        <div class="footer">
            <button>Feedback</button>
            <p style="margin-left:-50px;"> Copyright 2022 ©ABC (PVT) Limited. All Rights Reserved. </p>
            <a href="#">Terms</a>
            <a href="#">Privacy</a>
        </div>
    </div>
</body>

</html>
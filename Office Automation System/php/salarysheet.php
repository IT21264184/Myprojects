<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <title>ABC (pvt) Limited</title>

    <!--Link JS file-->
    <script src="Js/myscript.js"></script>

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


<div class="ef">

<h2>Salary Sheet</h2>
<p>You can find your salary information here</p>
<hr>
<table>
      <tr>
         <th>Employee ID</th>
         <th>Salary</th>
      </tr>

<?php

require 'config.php' ;

echo "<br>";
$sql ="SELECT Emp_id,salary from Employee ";
$result = $conn-> query($sql);

if($result -> num_rows > 0){
  while($row = $result -> fetch_assoc()) {
     echo "<tr><td>" .$row["Emp_id"].  "</td><td>" .$row["salary"]. "</td></tr>";
 }
 echo "</table>";
 }
 else{
  echo "0 result";
}
$conn-> close();
?>

<hr>
</table>
<h4>Enter your salary accoding to your employee id</h4>
<form method="post">
<table border="0">
<tr>
<td> <input type="text" name="salary" value="" placeholder="Enter Salary"/>
</td>
</tr>
<tr>
<td> <input type="submit" name="submit" value="Submit"/>
</td>
</tr>
</table>
</form>
<hr>


<?php
if(isset($_POST['submit']))
{
$Total_salary = $_POST['salary'];
echo "Salary sheet";
echo "<h5>Earnings</h5>";
echo "<br>";
$Basic_salary = 0.5 * $Total_salary;
$OT = 0.4 * $Total_salary;
$Other = 0.6 * $Total_salary;

$gross_salary = $Basic_salary + $OT + $Other;

echo "Basic Salary : &emsp;&emsp;" .$Basic_salary."/-";
echo "<br>";
echo "Over Time : &emsp;&emsp;&emsp;" .$OT."/-";
echo "<br>";
echo "Other Earnings : &emsp;" .$Other ."/-";
echo "<br>";
echo "Gross Salary : &emsp;&emsp;" .$gross_salary ."/-";
echo"<br><br>";

echo "<h3>Deductions</h3>";
echo "<br><br>";
$Loan = 0.3 * $Total_salary;
$Medical = 0.1 * $Total_salary;
$Other_deduction = 0.1 * $Total_salary;

$Total_deduction = $Loan + $Medical + $Other_deduction;

echo "Loan : &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" .$Loan."/-";
echo "<br>";
echo "Medical : &emsp;&emsp;&emsp;&emsp;&emsp;" .$Medical."/-";
echo "<br>";
echo "Other Deduction : &emsp;&emsp;" .$Other_deduction."/-";
echo "<br>";
echo "Total Deductions : &emsp;" .$Total_deduction ."/-";
echo"<br><br>";

echo "<h6>Total Salary : &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;".$Total_salary."/-</h6>";
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
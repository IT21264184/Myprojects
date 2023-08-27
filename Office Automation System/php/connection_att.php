<?php

   // Create Database credential variables
   $user = "test";
   $password = "test";
   $db = "attn";


   // Create php db connection object
   $connection = new mysqli('localhost', $user, $password, $db) or die(mysqli_error($connection));

   // selcet data from db

   $result = $connection->query("select * from attn_table") or die($connection->error);

   // Insert Data to database

   if(isset($_POST['Employee_No']))
   {
       // save all $_POST values from form into separate variables
     
       $Employee_No= $_POST['Employee_No'];
       $Employee_Name = $_POST['Employee_Name'];
       $date = $_POST['date'];
       $Punch_in = $_POST['Punch_in'];
       $Punch_out = $_POST['Punch_out'];
       $Production = $_POST['Production'];
       $Break = $_POST['Break'];
       $Overtime = $_POST['Overtime'];

       $sql = "insert into attn_table (Employee_No, Employee_Name, date, Punch_in, Punch_out, Production, Break,Break,Overtime) values('$Employee_No','$Employee_Name','$date','$Punch_in','$Punch_out','$Production','$Break','$Overtime')";

       if ($connection->query($sql) === TRUE) 
       {
        
        echo "<h1>Record created successfully</h1>
              
              
       } 
       else 
       {
           
           echo "<h1>Error creating record: {$connection->error}</h1>
        
           
       }

       
       
   }


  


// delete data from db

if(isset($_GET['delete']))
{
    $Employee_No = $_GET['delete'];
    $mysqli->query("delete from attn_table where Item_no=$Employee_No") or die($mysqli->error);

}

// update data in db
if(isset($_PUT['put']))
{
       $Employee_No= $_POST['Employee_No'];
       $Employee_Name = $_POST['Employee_Name'];
       $date = $_POST['date'];
       $Punch_in = $_POST['Punch_in'];
       $Punch_out = $_POST['Punch_out'];
       $Production = $_POST['Production'];
       $Break = $_POST['Break'];
       $Overtime = $_POST['Overtime'];
       $mysqli->query("update attn_table set where Employee_Name=$Employee_Name, date=$date, Punch_in=$Punch_in, Punch_out=$Punch_out, Production=$Production, Break=$Break, Overtime=$Overtime where Employee_No=$Employee_No") or die($mysqli->error);
}


?>

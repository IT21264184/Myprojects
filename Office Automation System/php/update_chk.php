<?php
session_start();
include "config.php";

if (isset($_POST['fname']) || isset($_POST['lname']) || isset($_POST['uname']) || isset($_POST['mail'])
|| isset($_POST['address']) || isset($_POST['phone']))
{
    function validate($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);

        return $data;
    }

    $fname = validate($_POST['fname']);
    $lname = validate($_POST['lname']);
    $uname = validate($_POST['uname']);
    $mail = validate($_POST['mail']);
    $address = validate($_POST['address']);
    $phone = validate($_POST['phone']);

    $u_data = 'uname = ' . $_SESSION['uname'] . '&name = ' . $_SESSION['fname'];

    $id = $_SESSION['id'];

    if(!empty($fname))
    {
        $sql1 = "UPDATE Employee SET fname = '$fname'
                WHERE Emp_id = '$id'";

        $result1 = mysqli_query($conn, $sql1);
    }
    if(!empty($lname))
    {
        $sql2 = "UPDATE Employee SET lname = '$lname'
                WHERE Emp_id = '$id'";
        
        $result2 = mysqli_query($conn, $sql2);
    }
    if(!empty($uname))
    {
        $sql3 = "UPDATE Identification SET username = '$uname'
                 WHERE Emp_id = '$id'";

        $result3 = mysqli_query($conn, $sql3);
    }
    if(!empty($mail))
    {
        $sql4 = "UPDATE Employee SET email = '$mail'
                WHERE Emp_id = '$id'";

        $result4 = mysqli_query($conn, $sql4);
    }
    if(!empty($address))
    {
        $sql5 = "UPDATE Employee SET emp_address = '$address'
                WHERE Emp_id = '$id'";

        $result5 = mysqli_query($conn, $sql5);
    }
    if(!empty($phone))
    {
        $sql6 = "UPDATE Employee SET phone = '$phone'
                WHERE Emp_id = '$id'";

        $result6 = mysqli_query($conn, $sql6);
    }
    

    if($result1 || $result2 || $result3 || $result4 || $result5 || $result6)
    {
        header("Location: update_prof.php?success=Made changes successfully&$u_data");
        exit();
    }
    else
    {
        header("Location: update_prof.php?error=You haven't made any changes&$u_data");
        exit();
    }
    
}
else
{
    header("Location: update_prof.php");
    exit();
}

?>
<?php
session_start();

include "config.php";

if (isset($_POST['name']) && isset($_POST['mail']) && isset($_POST['msg']))
{

    function validate($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);

        return $data;
    }

    $name = validate($_POST['name']);
    $mail = validate($_POST['mail']);
    $msg = validate($_POST['msg']);

    if(empty($name))
    {
        header("Location: ContactUs.php?error=Name is required");
        exit();
    }
    else if(empty($mail))
    {
        header("Location: ContactUs.php?error=Email is required");
        exit();
    }
    else if(empty($msg))
    {
        header("Location: ContactUs.php?error=Message is required");
        exit();
    }
    else
    {
        $sql = "SELECT * FROM Memorandum WHERE email = '$mail' AND msg = '$msg'";
        $result = mysqli_query($conn, $sql);

        $u_data = 'name = ' . $name;

        if(mysqli_num_rows($result) > 0)
        {
            header("Location: ContactUs.php?error=You already have sent the message&$u_data");
            exit();
        }
        else
        {
            $sql2 = "SELECT Emp_id 
                    FROM Employee
                    WHERE fname = '$name'";
            
            $result2 = mysqli_query($conn, $sql2);

            if(mysqli_num_rows($result2) > 0)
            {
                $row2 = mysqli_fetch_assoc($result2);

                $emp_id = $row2['Emp_id'];
            }
            
            $sql5 = "INSERT INTO Memorandum (email, msg, emp_name, Emp_id)
                    VALUES ('$mail', '$msg', '$name', '$emp_id')";

            $result5 = mysqli_query($conn, $sql5);

            if($result5)
            {
                header("Location: ContactUs.php?success=Message Sent successfully&$u_data");
                exit();
            }
            else
            {
                header("Location: ContactUs.php?error=Unknown error occured&$u_data");
                exit();
            }
        }   
    }
}
else
{
    header("Location: ContactUs.php");
    exit();
}
?>
        
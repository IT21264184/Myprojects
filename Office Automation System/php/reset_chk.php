<?php
session_start();

include "config.php";

if (isset($_POST['uname']) && isset($_POST['pass']) && isset($_POST['re_pass']))
{

    function validate($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);

        return $data;
    }

    $uname = validate($_POST['uname']);
    $pass = validate($_POST['pass']);
    $re_pass = validate($_POST['re_pass']);

    $u_data = "uname = " . $uname;

    if(empty($uname))
    {
        header("Location: reset.php?error=User Name is required");
        exit();
    }
    else if(empty($pass))
    {
        header("Location: reset.php?error=Password is required");
        exit();
    }
    else if(empty($re_pass))
    {
        header("Location: reset.php?error=Confirm Password is required");
        exit();
    }
    else
    {
        $sql = "SELECT * FROM Identification WHERE username = '$uname'";
        $result = mysqli_query($conn, $sql);

        if(mysqli_num_rows($result) === 1)
        {
            $sql5 = "UPDATE Identification SET passwrd = '$pass' WHERE username = '$uname'";

            $result5 = mysqli_query($conn, $sql5);

            if($result5)
            {
                header("Location: reset.php?success=Password reset is successful&$u_data");
                exit();
            }
            else
            {
                header("Location: reset.php?error=Unknown error occured&$u_data");
                exit();
            }
        }
        else
        {
            header("Location: reset.php?error=Incorrect User Name");
            exit();
        }
    }
}
else
{
    header("Location: reset.php");
    exit();
}
?>
        
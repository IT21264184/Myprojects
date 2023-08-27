<?php
session_start();

include "config.php";

if (isset($_POST['uname']) && isset($_POST['password']))
{
    function validate($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);

        return $data;
    }

    $uname = validate($_POST['uname']);
    $pass = validate($_POST['password']);

    if(empty($uname))
    {
        header("Location: index.php?error=User Name is required");
        exit();
    }
    else if(empty($pass))
    {
        header("Location: index.php?error=Password is required");
        exit();
    }
    else
    {
        $sql = "SELECT * FROM Identification WHERE username = '$uname' AND passwrd = '$pass'";
        $result = mysqli_query($conn, $sql);

        if(mysqli_num_rows($result) === 1)
        {
            $row = mysqli_fetch_assoc($result);

            if($row['username'] == $uname && $row['passwrd'] == $pass)
            {
                $_SESSION['uname'] = $row['username'];
                $_SESSION['id'] = $row['Emp_id'];

                header("Location: ../html/home.html");
                exit();
            }
            else
            {
            header("Location: index.php?error=Incorrect User Name or Password");
            exit();
            }
        }
        else
        {
            header("Location: index.php?error=Incorrect User Name or Password");
            exit();
        }
    }
}

else
{
    header("Location: index.php");
    exit();
}
?>
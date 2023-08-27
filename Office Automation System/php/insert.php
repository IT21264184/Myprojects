<?php
session_start();
include "config.php";

if (isset($_POST['fname']) || isset($_POST['lname']) || isset($_POST['uname']) || isset($_POST['mail']) || isset($_POST['nic'])
|| isset($_POST['address']) || isset($_POST['phone']) || isset($_POST['pass']) 
|| isset($_POST['r_pass']) || isset($_POST['department']) || isset($_POST['gender']))
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
    $nic = validate($_POST['nic']);
    $address = validate($_POST['address']);
    $phone = validate($_POST['phone']);
    $pass = validate($_POST['pass']);
    $r_pass = validate($_POST['r_pass']);
    $department = validate($_POST['department']);
    $gender = validate($_POST['gender']);

    $u_data = 'uname = ' . $uname . '&name = ' . $fname;

    if(empty($fname))
    {
        header("Location: register.php?error=First Name is required");
        exit();
    }
    else if(empty($lname))
    {
        header("Location: register.php?error=Last Name is required");
        exit();
    }
    else if(empty($uname))
    {
        header("Location: register.php?error=User Name is required");
        exit();
    }
    else if(empty($mail))
    {
        header("Location: register.php?error=Email is required");
        exit();
    }
    else if(empty($nic))
    {
        header("Location: register.php?error=NIC is required");
        exit();
    }
    else if(empty($address))
    {
        header("Location: register.php?error=Address is required");
        exit();
    }
    else if(empty($phone))
    {
        header("Location: register.php?error=Phone Number is required");
        exit();
    }
    else if(empty($pass))
    {
        header("Location: register.php?error=Password is required");
        exit();
    }
    else if(empty($r_pass))
    {
        header("Location: register.php?error=Confirm password is required");
        exit();
    }
    else if(empty($department))
    {
        header("Location: register.php?error=Department is required");
        exit();
    }
    else if(empty($gender))
    {
        header("Location: register.php?error=Gender is required");
        exit();
    }
    
    else if($pass != $r_pass)
    {
        header("Location: register.php?error=Both passwords sould match");
        exit();
    }
    else
    {
        $sql = "SELECT * FROM Identification WHERE username = '$uname'";
        $result = mysqli_query($conn, $sql);

        if(mysqli_num_rows($result) > 0)
        {
            header("Location: register.php?error=User Name already exist try another&$u_data");
            exit();
        }
        else
        {
            $id_incre = "IE00";
            $i = rand(10, 99);
            
            $id_new = $id_incre . $i;

            $sql10 = "SELECT Emp_id FROM Identification WHERE Emp_id = '$id_new'";
            $result10 = mysqli_query($conn, $sql10);

            while(mysqli_num_rows($result10) > 0)
            {
                $i = rand(10, 99);

                $id_new = $id_incre . $i;

                $sql10 = "SELECT Emp_id FROM Identification WHERE Emp_id = '$id_new'";
                $result10 = mysqli_query($conn, $sql10);
            }
            $sql2 = "SELECT d_number 
                    FROM Department
                    WHERE dname = '$department'";
            
            $result2 = mysqli_query($conn, $sql2);
            
            if(mysqli_num_rows($result2) > 0)
            {
                $row3 = mysqli_fetch_assoc($result2);

                $d_number = $row3['d_number'];
            }

            if (!$result2) {
                echo "Could not successfully run query ($sql2) from DB: " . mysqli_error();
                exit();
            }

            $sql3 = "INSERT INTO Employee (Emp_id, NIC, gender, fname, lname, emp_address, email, phone, d_number)
                        VALUES ('$id_new', '$nic', '$gender', '$fname', '$lname', '$address', '$mail', '$phone', '$d_number')";

            $result3 = mysqli_query($conn, $sql3);

            $sql4 = "INSERT INTO Identification (username, passwrd, Emp_id)
                    VALUES ('$uname', '$pass', '$id_new')";

            $result4 = mysqli_query($conn, $sql4);

            if($result3 && $result4)
            {
                header("Location: register.php?success=Account created successfully&$u_data");
                exit();
            }
            else
            {
                header("Location: register.php?error=Unknown error occured&$u_data");
                exit();
            }

            $i += 1;
        }
    }
}
else
{
    header("Location: register.php");
    exit();
}

?>
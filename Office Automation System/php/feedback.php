
<?php

        $Name = $_post['name'];
        $Mail = $_post['mail'];
        $id = $_post['id'];
        $Phone = $_post['phone'];
        $Message = $_post['Message'];
       
        $conn = new mysqli('localhost','root', '', 'abc company');
        if($conn->connect_error){
            die('Connection Failed : '. $conn->connect_error);

        }
        else{
            echo "Connected";
            $stmt = $conn->prepare("insert into feedback(Name, Email, ID, Phone, Message)
                value(?,?,?,?,?)");
            $stmt->bind_param("sssis", $Name, $Mail,$id,$Phone, $Message);
            $stmt->execute();
            echo "Thank you for your feedback...!";
            $stmt->close();
            $stmt->close();
        }


?>
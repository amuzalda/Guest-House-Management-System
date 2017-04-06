<
<?php
$connect = mysqli_connect("localhost","rohan","rohansaraf","hostel");

include("mail/phpmailer.php");

if(isset($_POST['request']))
{

	  echo $URId="ID".str_pad(mt_rand(0, 9999), 4, '0', STR_PAD_LEFT);
	    echo $Name=mysqli_real_escape_string($connect, $_POST['Name']);
  echo $Surname=mysqli_real_escape_string($connect, $_POST['Surname']);
    echo $Mail = mysqli_real_escape_string($connect, $_POST['Mail']);	
     echo $Contact = mysqli_real_escape_string($connect,$_POST['Contact']);
        echo $Designation = mysqli_real_escape_string($connect,$_POST['Designation']);
  echo $Arrival = mysqli_real_escape_string($connect,$_POST['Arrival']);
  echo $Departure = mysqli_real_escape_string($connect,$_POST['Departure']);
   echo $Password=mysqli_real_escape_string($connect, $_POST['Password']);

  //$persons =mysqli_real_escape_string($connect, $_POST['persons']);
  //$rooms = mysqli_real_escape_string($connect,$_POST['rooms']);



  //$address = mysqli_real_escape_string($connect,$_POST['address']);
 


/*
  if (ctype_alpha(str_replace(' ', '', $name)) === false) {
  $errors[] = 'Name must contain letters and spaces only';
}*/

$query="INSERT into allguests(URId, Name, Surname, Mail,Contact,Designation,Arrival,Departure, Password) values('$URId','$Name','$Surname', '$Mail','$Contact','$Designation', '$Arrival','$Departure','$Password')";

  $query_run=mysqli_query($connect, $query);


  /* if($query_run)
	{
         $mail->AddAddress("$Mail");

         $mail->Subject = "Request for Room Booking";
				$mail->Body    = "Dear $Name $Surname,<br>You request is successfully registered.</b><br><br>Your details are as below:<br>User Id:<b> $URId</b><br>Your Password:<b> $Password </b> <br>Email Address: $Mail <br><br><b>Note: </b>Please note your User Id for checking your booking status.<br> Once your Booking get confirmed , You will get a mail.<br> Thanks.";
				$mail->AltBody = "Thanks for registering.Your request has been successfully registered.<br>Your details are as below:<br>User Id :<b> $URId</b>";
				 // Now sending the Mail
                  if(!$mail->Send()){
	                   header('Location: sorry.php');
                   }
                  else{
                     	header('Location: thanks.php');
			       }

	}
*/
}
?>

<?php session_start(); ?>
<?php
$connect = mysqli_connect("localhost","root","","hotel");
  if(isset($_POST['logout'])){
unset($_SESSION['userid']);
if(unset($_SESSION['userid'])){
	echo "You are logged out.";
	echo "Go to Homepage"
	
}
}
?>
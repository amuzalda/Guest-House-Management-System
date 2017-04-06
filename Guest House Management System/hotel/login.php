<?php session_start(); ?>
<?php
$connect = mysqli_connect("localhost","root","","hotel");
?>

<?php
// User Authentication section starts here
	     
	    $msg=' ';
		
        if(isset($_POST['pawa'])){
		   
          // Receive the data and filter it
		   
		  //include_once'functions.php';          //include function file

		    
		  $userid = filterdata($_POST['userid']); // get filtered form of email inserted by user at time of login
		  
		  $password =  filterdata($_POST['password']);  // get filtered form of password inserted by user at time of login
			
		  //Getting the userid from table
		  
		  $get_userid = "SELECT userid FROM user_tbl WHERE email = '$email'  LIMIT 1"; 
			
		  $run_userid = mysqli_query($connect,$get_userid); 
			
		  confirm_query($run_userid); 
			
		  $userid_row = mysqli_num_rows($run_userid);  // get number of rows from query_run
			
		  if($userid_row == 0){ 
		  
		        // if num_rows==0 user is not registered 
				
				$msg= 'You are not registered with us. You will be shortly redirected to register page';
				
				echo '<META HTTP-EQUIV="Refresh" Content="1; URL=index.html">';
				
		  }else{		
				
			    $userid_row=mysqli_fetch_assoc($run_userid);
				
				$userid = $userid_row['userid'];
			    
			    $pass_hash = sha1($password.$userid); //i.e. we need not to know password we just confirm in database
				
				$query= "SELECT * FROM userdetails WHERE userid='$userid' and pass_hash='$pass_hash' and userid = '$userid' LIMIT 1";
				
				$query_run = mysqli_query($connect, $query);
				
				confirm_query($query_run);
				
				$num_rows = mysqli_num_rows($query_run);
				
				if($num_rows == 0){
					
					$msg="You have entered a wrong password";
					
					echo '<META HTTP-EQUIV="Refresh" Content="1; URL=index.php">';
					
				}else{
					
					$msg= ' Welcome';
					
					$_SESSION['email'] = $email;
					
					//echo '<META HTTP-EQUIV="Refresh" Content="1; URL=index.php">';
					
					// header(location:customers/my_account.php);
					
					echo "<script>window.open('index.php','_self')</script>";
					
				}
				
		}
}
/////// user authentication ends here 


?>
<!DOCTYPE html >
<html>

        <head>
               <title>login</title>
               
               <link rel="stylesheet" media="all" type="text/css" href="css/style.css">
               
               <script type="text/javascript" src="js/script.js"> </script>
               
       </head>
       <body>
				
               <div class="main_wrap">
                       
                    <!--content starts here-->
                    
                    <div class="content">
                    
                     <?php echo "$msg"; ?>
                     
               </div>
                    
                    <!--content ends here-->
              
       </body>
</html>


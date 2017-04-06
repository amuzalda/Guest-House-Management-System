
<?php session_start(); ?>
<?php
$connect = mysqli_connect("localhost","root","","hotel");
?>

<?php
// User Authentication section starts here
	     
		
        if(isset($_POST['check'])){
		   
          // Receive the data and filter it
		   
		  //include_once'functions.php';          //include function file

		    
		  $userid =$_POST['userid']; // get filtered form of email inserted by user at time of login
		  
		  $password =$_POST['password'];  // get filtered form of password inserted by user at time of login
			
		  //Getting the userid from table
		  
		  $get_userid = "SELECT * FROM userdetails WHERE userid = '$userid'"; 
			
		  $run_userid = mysqli_query($connect,$get_userid); 
			
		  $userid_count= mysqli_num_rows($run_userid);  // get number of rows from query_run
			
		  if($userid_count == 0){ 
		  
		        // if num_rows==0 user is not registered 
				
				$msg= 'You are not registered with us. You will be shortly redirected to register page';
				
				
				
		  }else{		
				
			    $userid_row=mysqli_fetch_assoc($run_userid);
				
				$userid = $userid_row['userid'];
					$pass = $userid_row['password'];
			   
				
				if($password != $pass){
					
					$msg="You have entered a wrong password";
					
					
					
				}else{
					
					$msg= ' Welcome';
					
					$_SESSION['userid'] = $userid;
					
					//echo '<META HTTP-EQUIV="Refresh" Content="1; URL=index.php">';
					
					// header(location:customers/my_account.php);
					
					echo "<script>window.open('userlogin.php','_self')</script>";
					
				}
				
		}
}
/////// user authentication ends here 


?>
<!DOCTYPE html >
<html>

        <head>
               <title>login</title>
               
             <!--  <link rel="stylesheet" media="all" type="text/css" href="style.css"> -->
               
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




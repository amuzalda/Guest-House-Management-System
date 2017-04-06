<?php session_start();

$connect = mysqli_connect("localhost","root","","hotel");


$_SESSION['userid'] = isset($_SESSION['userid']) ? $_SESSION['userid'] : "";

if($_SESSION['userid']){

echo"<h2> you have logged in now </h2>";
}

?>

<!DOCTYPE html>
<html>
<head>
<title>IITJ GuestHouse</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">
  <div id="header">
    <div id="website_title">
      <div id="title"> IIT Jodhpur </div>
      <div id="slogan"> Online GuestHouse Booking</div>
    </div>
    <div id="menu">
      <ul>
        <li><a href="#" class="current">Home</a></li>
        <li><a href="#">Gallery</a></li>
        <li><a href="#" class="last">Contact</a></li>
      </ul>
    </div>
  </div>
  <!-- end of banner -->
  <div id="content">
    <div id="content_left">
      <div class="content_left_section">
        <div class="content_title_01">Request For Booking</div>
        <form action="request.php" method="post">
          <div class="form_row">
            <label>Arrival :</label>
            <input class="inputfield" name="arrival_date" type="date" placeholder="dd-mm-yyyy" style="width: 100px; margin-right: 20px; margin-left: 12px" required="text" /><br><br>
            <label>Departure :</label>
            <input class="inputfield" name="departure_date" type="date" placeholder="dd-mm-yyyy" style="width: 100px; margin-right: 20px;margin-left: 12px" required="text" /><br><br>
          <div class="form_row">
           <!-- <label>Persons:</label>
            <input class="inputfield" name="persons" type="text" style="width: 30px; margin-right: 20px;" required="text" />
            <label>Rooms:</label>
            <input class="inputfield" name="rooms" type="text" style="width: 30px;" required="text" /><br><br>-->
            <label>First Name :</label>
            <input class="inputfield" name="first_name" type="text" style="width: 100px;margin-left: 10px;" required="text" /><br><br>
            <label>Last Name :</label>
            <input class="inputfield" name="last_name" type="text" style="width: 100px; margin-right: 20px;margin-left: 12px;"required="text" /><br><br>
            <label>Designation :</label>
            <select name="designation" style="margin-left: 11px;">
              <option value="student" >Student</option>
              <option value="faculty">Faculty</option>
            </select><br><br>
            <label>Contact :</label>
             <input class="inputfield" name="contact" type="text" style="width: 100px; margin-right: 20px;margin-left: 11px;" required="text" /><br><br>
              <label>Email :</label>
             <input class="inputfield" name="email" type="email" style="width: 150px; margin-right: 20px;margin-left: 11px;" required="text" /><br><br>
            <label>Adress :</label>
             <textarea class="inputfield" rows="5" cols="50" name="address" type="text" style="width: 260px; height:100px; margin-right: 20px;margin-left: 11px;"required="text" ></textarea><br>
             <label>Password :</label>
             <input class="inputfield" name="password" type="password" style="width: 100px; margin-right: 20px;margin-left: 11px;" required="text" /><br><br>
             <label>Confirm Password :</label>
             <input class="inputfield" name="passwordconf" type="password" style="width: 100px; margin-right: 20px;margin-left: 11px;" required="text" /><br><br>
          </div>
          <div class="cleaner_h20">&nbsp;</div>
         <div class="rc_btn_01"><input type="submit" value="Request" name="request"></div>
        </form>
        <div class="cleaner">&nbsp;</div>
      </div>
      <!-- end of booking -->



      <div class="cleaner_h30">&nbsp;</div>
      <div class="cleaner_horizontal_divider_01">&nbsp;</div>
      <div class="cleaner_h30">&nbsp;</div>
    </div>
    <!-- end of content left -->
    <div id="content_right">
      <div class="content_right_section">
            <div class="content_right_2column_box">
        <div class="content_title_01">Check Booking Status</div>
        <form action="check.php" method="post">
         <div class="form_row">
            <label>UserID:</label>
            <input class="inputfield" name="userid" type="text" style="width: 80px; margin-right: 20px;" required="text" /><br><br>
            <label>Password:</label>
            <input class="inputfield" name="password" type="password" style="width: 80px;" required="text" />
          </div>
        <div class="cleaner_h10">&nbsp;</div>
        <div class="cleaner_h40">&nbsp;</div>
        <input type="submit" value="Check" name="check"/>
        
      </div>

      </form>
      <form action="logout.php" method="post">
        <input type="submit" value="Logout" name="logout" />
      </form>
      <div class="cleaner_h40">&nbsp;</div>
        <div class="content_title_01">About IIT Jodhpur</div>
        <p>This website is a software engineering project under the guidence of Dr. Chiranjoy Chattopadhyay.</p>
      </div>
      <div class="content_right_section">
        <div class="content_title_01">Gallery</div>
        <div class="gallery_box"> <img src="http://www.iitj.ac.in/slidertest/img/01.jpg" alt="" width=82px height=82px /></div>
        <div class="gallery_box"> <img src="http://www.iitj.ac.in/slidertest/img/02.jpg" alt=""  width=82px height=82px/></div>
        <div class="gallery_box"> <img src="http://www.iitj.ac.in/slidertest/img/03.jpg" alt=""  width=82px height=82px/> </div>
        <div class="gallery_box"> <img src="http://www.iitj.ac.in/slidertest/img/15th%20aug%20002.jpg" alt="" width=82px height=82px /></div>
        <div class="cleaner">&nbsp;</div>
      </div>
      <div class="cleaner_h20">&nbsp;</div>
    </div>
    <!-- end of content right -->
    <div class="cleaner">&nbsp;</div>
  </div>
  <div id="footer"> Copyright &copy; 2024 <a href="#"><strong>Your Company Name</strong></a> | Designed by <a target="_blank" rel="nofollow">templatemo</a>
    <div style="clear: both; margin-top: 10px;"> <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="" width="88" height="31" vspace="8" border="0" /></a> <a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="" vspace="8" border="0" /></a> </div>
  </div>
  <!-- end of footer -->
</div>
<!-- end of container -->
</body>
</html>

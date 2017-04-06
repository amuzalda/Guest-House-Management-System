<?php session_start(); ?>
<?php
$connect = mysqli_connect("localhost","root","","hotel");
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
      <div id="salgon"> Online GuestHouse Booking</div>
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
        <div class="content_title_01">Your Booking Details :</div>
        
          <div class="form_row">
            <label>Arrival :</label>
            <input class="inputfield" name="arrival_date" type="date" placeholder="dd-mm-yyyy" style="width: 100px; margin-right: 20px; margin-left: 12px" required="text" /><br><br>
            <label>Departure :</label>
            <input class="inputfield" name="departure_date" type="date" placeholder="dd-mm-yyyy" style="width: 100px; margin-right: 20px;margin-left: 12px" required="text" /><br><br>
          <div class="form_row">
            <label>Persons:</label>
            <input class="inputfield" name="persons" type="text" style="width: 30px; margin-right: 20px;" required="text" />
            <label>Rooms:</label>
            <input class="inputfield" name="rooms" type="text" style="width: 30px;" required="text" /><br><br>
            <label>First Name :</label>
            <input class="inputfield" name="first_name" type="text" style="width: 100px;margin-left: 10px;" required="text" /><br><br>
            <label>Last Name :</label>
            <input class="inputfield" name="last_name" type="text" style="width: 100px; margin-right: 20px;margin-left: 12px;"required="text" /><br><br>
            <label>Post :</label>
            <select name="pos" style="margin-left: 11px;">
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
          <input type="submit" value="Logout" name="logout">
        </form>
        <div class="cleaner">&nbsp;</div>
      </div>
      <!-- end of booking -->



      <div class="cleaner_h30">&nbsp;</div>
      <div class="cleaner_horizontal_divider_01">&nbsp;</div>
      <div class="cleaner_h30">&nbsp;</div>
    </div>
    <!-- end of content left -->

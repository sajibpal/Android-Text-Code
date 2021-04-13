<?php 
  include 'database.php';
  
  $email=filter_input(INPUT_POST,"email1",FILTER_VALIDATE_EMAIL);
  $password=filter_input(INPUT_POST,"password1");
 // $email=$_POST["email1"];
  //$password=$_POST["password1"];
  
  $q="SELECT *FROM android WHERE email='$email' AND password='$password'"; 
  
		$result=mysqli_query($conn, $q);
		
		if(mysqli_num_rows($result)==1){
			
		  echo "1";
		}
  
?>
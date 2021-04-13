<?php 

  $servername ="localhost";
   $username ="root";
   $password ="";
   $dbname="ok";

// Create connection
$conn = new mysqli($servername, $username, $password,$dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

 
	    $username=$_POST["uname"];
		$email=$_POST["email"];
		$password=$_POST["password"];
		$reponse=array();
	  	 
		$q="SELECT *FROM volley WHERE email='$email' AND password='$password'"; 
		$result=mysqli_query($conn, $q);
		
		if(mysqli_num_rows($result)>=1){ //if user before register  thake abar same informatio diya registration korte chay
			
		 $code="Login fails";
		 $message="User  already register";
		 array_push($reponse,array("code"=>$code,"message"=>$message));
		 echo json_encode($reponse);
		}
	   else{
		   
	      $sql="INSERT INTO volley(name,email,password) VALUES('$username','$email','$password')";
	      mysqli_query($conn, $sql);
		  $code="register sucessfull";
		  $message="Thanks you for registration with us.Now can Login";
		  array_push($reponse,array("code"=>$code,"message"=>$message));
		  echo json_encode($reponse);
		  
	   }
		
  
   mysqli_close($conn);
  
?>
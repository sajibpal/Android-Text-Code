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

 
		$name=$_POST["uname"];
		$password=$_POST["password"];
		$reponse=array();
	  	 
		$q="SELECT *FROM volley WHERE name='$name' AND password='$password' "; 
		$result=mysqli_query($conn, $q);
		
		if(mysqli_num_rows($result)>0){ 
			
		  while($row =mysqli_fetch_array($result)){
			
      
				$username=$row['name'];
				$email=$row['email'];

              $code="Login sucessfull";
		      array_push($reponse,array("code"=>$code,"name"=>$username,"email"=>$email));
		      echo json_encode($reponse);				
		    }
		 
		}
		
	   else{
		   
	      $code="Login Failed";
		  $message="User not found.Please try again.....";
		  array_push($reponse,array("code"=>$code,"message"=>$message));
		  echo json_encode($reponse);
		  
	   }
		
  
   mysqli_close($conn);
 
  
?>
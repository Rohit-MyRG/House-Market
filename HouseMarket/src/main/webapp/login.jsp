<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Login Page</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/navbar.css" />
	<style>
	@media (max-width: 986px){
		nav ul{
			background: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url("images/House3.jpg") no-repeat;
			background-size: cover;
		}
		section{
			background: linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),url('images/House2.jpg') no-repeat; 
			background-size: cover;
			height: calc(100vh - 45px);
		}
	}
	</style>
</head>
<body>
    <nav> <!-- Nav bar starts here-->
		<input type="checkbox" id="check">
		<label for="check" class="checkbtn">
			<i class="fas fa-bars"></i>
		</label>
		<label class="logo" >House Market</label>
		<ul>
			<li><a href="index.html">Home</a></li>
			<li><a href="AddProperty.html">For Property Owners</a></li>
			<li><a href="">Login | Sign up</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Feedback</a></li>
		</ul>
    </nav> <!--navbar ends here-->
    
	<section>	<!--Section starts here-->
	</section>

</body>
</html>
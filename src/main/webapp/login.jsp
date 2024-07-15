<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Login Page</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" type="text/css">
	
	<!-- <link rel="stylesheet" type="text/css" href="css/loginFormStyle.css"/> -->
	<link rel="stylesheet" type="text/css" href="css/navbar.css" />
	
</head>
<body> <!-- ############################################################################# -->

	<%
		if(session.getAttribute("username")!=null){
			getServletContext().getRequestDispatcher("/logout").forward(request, response);
		}
	%>

    <%@ include file="html/navigationBar.html" %>
    
    
    
	<section>	<!--Section starts here-->
	
		<!-- login and registration form-->
		<%@ include file="html/loginForm.html" %>
	
	</section>

</body> <!-- ############################################################################# -->

	<style>
		section{
			background-image: linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.6)),url("images/HomeHouse.jpg");
			background-position: 10% 50%;
			background-size: cover;
			height: calc(100vh - 45px);	
		}
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
	
	<script type="text/javascript">
		/* This function is helps to hide login form and show "nav ul" when "nav checkbtn" is checked
		else show login form and left:-100% "nav ul"*/
	
    	function ShowHideDiv(chkNav) {
			if(document.getElementById("nav1").offsetWidth<=986){
		        var sec1 = document.getElementById("loginForm");
		        var ans = chkNav.checked ? "none" : "block";
		        setTimeout(() => { sec1.style.display = ans }, 100);
			}
    	}
	</script>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Add Property</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" type="text/css">
	
	<link rel="stylesheet" type="text/css" href="css/navbar.css" />
	<link rel="stylesheet" href="css/addPropertyStyle.css">
	
	<script type="text/javascript" src="js/stateDist.js"> </script>
</head>
<body>

	<%
		if(session.getAttribute("username")==null){
			response.sendRedirect("login.jsp");
		}
	%>

	<!-- This is navigation bar HTML file. -->
    <%@ include file="html/navigationBar.html" %>
    
	<section>	<!--Section starts here-->
		
		<!-- This home.html file includes search bar for finding property. -->
		<%@ include file="html/addProperty.html" %>
		
	</section>










</body>

	<style>
		section{
			background-image: linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.6)),url("images/HomeHouse.jpg");
			background-repeat: repeat;
			background-position: 10% 50%;
			background-size: cover; 
			height: calc(180vh - 45px);	
			background-attachment: fixed;
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
				background-attachment: fixed;
			}
		}
	</style>
	<script type="text/javascript">
		
    	function ShowHideDiv(chkNav) {
			/* ignored: This function is defined for other pages but here it is for no occure error when checkbox checked*/
    	}
	</script>

</html>
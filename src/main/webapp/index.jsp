<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>House Market</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" type="text/css">
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
	<!-- <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places&key=AIzaSyCfPDOMlQ_bU56XJIuyMvgqgsUdk9PxxiA"></script> -->
	
	<link rel="stylesheet" type="text/css" href="css/navbar.css" />
	<link rel="stylesheet" type="text/css" href="css/section-style.css" />
    <script type="text/javascript" src="js/stateDist.js"> </script>
	<script>
		/* var searchInput = 'inputAddress';
		$(document).ready(function (){
			var autocomplete;
			autocomplete = new google.maps.places.Autocomplete((document.getElementById(searchInput)),{
				types:['geocode']
			});
		}); */

	/*this JS code shows the input fields table*/
		function show_search(){ 
			var table = document.getElementById("search-table");
			table.style.display = "inline-table";
			document.getElementById("search-btn").style.display="none";
		}
	</script>
	
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
		<%@ include file="html/home.html" %>
		
	</section>

</body>
<style>
	nav{
		/* position: fixed; */
  		top: 0;
	}
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
		
    	function ShowHideDiv(chkNav) {
			/* ignored: This function is defined for other pages but here it is for no occure error when checkbox checked*/
    	}
	</script>
</html>
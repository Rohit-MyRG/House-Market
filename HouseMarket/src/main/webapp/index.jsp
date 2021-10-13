<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>House Market</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
		 <h1>India's No.1 trustable and free property site</h1><br/>
		 
	<form>
		<!--Search properties design starts here-->
        <div class="border-div">
		<table id="search-table">
			<caption style="padding-bottom: 2px; color: aqua;"><h2>Search best & suitable house in your area</h2></caption>
			<tr>								<!--Select State starts here, here added all states of over india -->
				<td class="top-row in-field">
	  	<select class="top-form-control" id="inputState" onchange="changeState()" data-inline = "true">
			<option value="SelectState">---Select State---</option>
			<option value="Andra Pradesh">Andra Pradesh</option>
			<option value="Arunachal Pradesh">Arunachal Pradesh</option>
			<option value="Assam">Assam</option>
			<option value="Bihar">Bihar</option>
			<option value="Chhattisgarh">Chhattisgarh</option>
			<option value="Goa">Goa</option>
			<option value="Gujarat">Gujarat</option>
			<option value="Haryana">Haryana</option>
			<option value="Himachal Pradesh">Himachal Pradesh</option>
			<option value="Jammu and Kashmir">Jammu and Kashmir</option>
			<option value="Jharkhand">Jharkhand</option>
			<option value="Karnataka">Karnataka</option>
			<option value="Kerala">Kerala</option>
			<option value="Madya Pradesh">Madya Pradesh</option>
			<option value="Maharashtra">Maharashtra</option>
			<option value="Manipur">Manipur</option>
			<option value="Meghalaya">Meghalaya</option>
			<option value="Mizoram">Mizoram</option>
			<option value="Nagaland">Nagaland</option>
			<option value="Orissa">Orissa</option>
			<option value="Punjab">Punjab</option>
			<option value="Rajasthan">Rajasthan</option>
			<option value="Sikkim">Sikkim</option>
			<option value="Tamil Nadu">Tamil Nadu</option>
			<option value="Telangana">Telangana</option>
			<option value="Tripura">Tripura</option>
			<option value="Uttaranchal">Uttaranchal</option>
			<option value="Uttar Pradesh">Uttar Pradesh</option>
			<option value="West Bengal">West Bengal</option>
			<option disabled style="background-color:#aaa; color:#fff">UNION Territories</option>
			<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
			<option value="Chandigarh">Chandigarh</option>
			<option value="Dadar and Nagar Haveli">Dadar and Nagar Haveli</option>
			<option value="Daman and Diu">Daman and Diu</option>
			<option value="Delhi">Delhi</option>
			<option value="Lakshadeep">Lakshadeep</option>
			<option value="Pondicherry">Pondicherry</option>
		</select>		
			</td>
			<td class="top-row in-field"> <!-- these are the option for selecting proeperty type -->
				<input type="radio" name="what" id="House"><label for="House">House</label>
				<input type="radio" name="what" id="PG/Hostel"><label for="PG/Hostel">PG/Hostel</label>
				<input type="radio" name="what" id="Flatemates"><label for="Flatemates">Flatmates</label>
			<!--	<input type="radio" name="what" id="Shop"><label for="Shop">Shop</label> -->
			</td>
			<td class="top-row in-field">
				<select class="top-form-control" id="">
					<option value="Tenant Type">Tenant Type</option>
					<option value="Tenant Type">Male</option>
					<option value="Tenant Type">Female</option>
				</select>
			</td>
			<td class="top-row in-field">
				<select class="top-form-control" id="">
					<option value="Room Type">Room Type</option>
					<option value="Room Type">Single Sharing</option>
					<option value="Room Type">Double Sharing</option>
					<option value="Room Type">Triple Sharing</option>
					<option value="Room Type">Four Sharing</option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="district in-field"> <!--district or city selection option-->
				<select class="form-control" id="inputDistrict" data-inline = "true">
					<option value="">---select District/City---</option>
	  			</select>
		  	</td><td class="search in-search-field" colspan="2">
				  <!--icon of location-->
				  <img class="location-icon" src="https://1.bp.blogspot.com/-TgJlthlK1mo/YS0NTWr7HyI/AAAAAAAAAPU/IOt0YSnur3Mf1jeivn2J7sh4KsmG5fsrACLcBGAsYHQ/s0/location.png" alt="">
				 
				 <!--this is main input text field which read the address-->
				  <input type="text" id="inputAddress" class="form-control input-field in-search-field" placeholder="Search localities or landmark..">
			</td><td class="submit in-field">
				<!--this is search button behaves like submit-->
				<button type="submit" class="form-control">Search</button>
			</td>
		</tr>
	</table>
	<center>
	<!--this text field is just for showing all above input fields after clicked on the text field-->
	<input type="text" id="search-btn" onclick="show_search()" placeholder="Search property...">
	<!--this JS code is for blinking the placeholder value of search-btn text field-->
	<script type="text/javascript">
		var blink = document.getElementById('search-btn');
		setInterval(function() { blink.placeholder = (blink.placeholder == "" ? "Search Home/Flat/Room/Shop..." : ""); }, 450);
	  </script>
	  </center>
</div>
	 <!--Search properties design ends here-->
  </form>
  <!--Search form ends here-->
  <h4 class="hh4">Are you a property owner?</h4>
  <input type="text" name="search" placeholder="Search..">
</section>

</body>
</html>
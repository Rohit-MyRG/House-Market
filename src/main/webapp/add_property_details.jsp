<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
try{
	String form = request.getParameter("form");
	if(form.equals("property_details")){
		String apartment_type = request.getParameter("apartment_type");
		String BHK_type = request.getParameter("BHK_type");
		String floor = request.getParameter("floor");
		String total_floor = request.getParameter("total_floor");
		String property_age = request.getParameter("property_age");
		String facing = request.getParameter("facing");
		String property_size = request.getParameter("property_size");
		
		session.setAttribute("apartment_type", apartment_type);
		session.setAttribute("BHK_type", BHK_type);
		session.setAttribute("floor", floor);
		session.setAttribute("total_floor", total_floor);
		session.setAttribute("property_age", property_age);
		session.setAttribute("facing", facing);
		session.setAttribute("property_size", property_size);
		
		out.println("Ok");
	}else
		if(form.equals("locality_details")){
			String state = request.getParameter("state");
			String district = request.getParameter("district");
			String locality = request.getParameter("locality");
			String area = request.getParameter("area");
			
			session.setAttribute("state", state);
			session.setAttribute("district", district);
			session.setAttribute("locality", locality);
			session.setAttribute("area", area);

			out.println("Ok");
		}else
			if(form.equals("rental_details")){
				String look_for = request.getParameter("look_for");
				String rent = request.getParameter("rent");
				String deposit = request.getParameter("deposit");
				String monthly_maintainance = request.getParameter("monthly_maintainance");
				String prefered_tenants = request.getParameter("prefered_tenants");
				String furnishing = request.getParameter("furnishing");
				String parking = request.getParameter("parking");
				String available_from = request.getParameter("available_from");
				String description = request.getParameter("description");
				
				session.setAttribute("look_for", look_for);
				session.setAttribute("rent", rent);
				session.setAttribute("deposit", deposit);
				session.setAttribute("monthly_maintainance", monthly_maintainance);
				session.setAttribute("prefered_tenants", prefered_tenants);
				session.setAttribute("furnishing", furnishing);
				session.setAttribute("parking", parking);
				session.setAttribute("available_from", available_from);
				session.setAttribute("description", description);

				out.println(available_from);
			}else
				if(form.equals("additional_details")){
					String bathroom = request.getParameter("bathroom");
					String Balcony = request.getParameter("Balcony");
					String water_supply = request.getParameter("water_supply");
					String gym = request.getParameter("gym");
					String non_veg = request.getParameter("non_veg");
					String gated_security = request.getParameter("gated_security");
					String other_facility = request.getParameter("other_facility");
					
					session.setAttribute("bathroom", bathroom);
					session.setAttribute("Balcony", Balcony);
					session.setAttribute("water_supply", water_supply);
					session.setAttribute("gym", gym);
					session.setAttribute("non_veg", non_veg);
					session.setAttribute("gated_security", gated_security);
					session.setAttribute("other_facility", other_facility);
					
					out.println("Ok");
				}else
					if(form.equals("gallery")){
						String photo = request.getParameter("photo");
						
						session.setAttribute("photo", photo);
						
						out.println("Ok");
					}else
						if(form.equals("schedule")){
							String starttime = request.getParameter("starttime");
							String endtime = request.getParameter("endtime");
							String weekday = request.getParameter("weekday");
							
							session.setAttribute("starttime", starttime);
							session.setAttribute("endtime", endtime);
							session.setAttribute("weekday", weekday);
							
							out.println("Ok");
						}
}catch(Exception ex){
	System.out.println(ex);
	out.println("Error: "+ex.getMessage());
}
%> 



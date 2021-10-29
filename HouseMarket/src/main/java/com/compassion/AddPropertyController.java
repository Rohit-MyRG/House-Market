package com.compassion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.compassion.service.AddPropertyService;

@Controller
public class AddPropertyController {
	
	@RequestMapping
	public void addProperty(HttpServletRequest request, HttpServletResponse  response) {
		try {
			
			AddPropertyService propertyService = new AddPropertyService();
			HttpSession session = request.getSession();
			
			String apartment_type = session.getAttribute("apartment_type").toString();
			String BHK_type = session.getAttribute("BHK_type").toString();
			String floor = session.getAttribute("floor").toString();
			String total_floor = session.getAttribute("total_floor").toString();
			String property_age = session.getAttribute("property_age").toString();
			String facing = session.getAttribute("facing").toString();
			String property_size = session.getAttribute("property_size").toString();
			String user_Email_id = session.getAttribute("username").toString();
			
			boolean answer = propertyService.insertPropertyDetails(apartment_type,BHK_type,floor,total_floor,property_age,facing,property_size,user_Email_id);
			
			
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

}

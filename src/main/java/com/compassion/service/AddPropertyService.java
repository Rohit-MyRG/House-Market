package com.compassion.service;

import com.compassion.dao.AddPropertyDao;

public class AddPropertyService {
	AddPropertyDao apd;
	
	public boolean insertPropertyDetails(String apartment_type, String BHK_type, String floor, String total_floor, String property_age, String facing, String property_size, String user_Email_id) {
		
		 apd = new AddPropertyDao();
		 
		 boolean answer = apd.insertPropertyDetails(apartment_type,BHK_type,floor,total_floor,property_age,facing,property_size,user_Email_id);
		
		return answer;
	}

}

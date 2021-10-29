package com.compassion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddPropertyDao {
	public String pdid="";
	
	public boolean insertPropertyDetails(String apartment_type, String BHK_type, String floor, String total_floor, String property_age, String facing, String property_size,String user_Email_id) {
		try {
				/* Connect to the MySql database and get the reference of Connection interface. */
			Connection con = MySqlConnectionProvider.getConnection();
			
			PreparedStatement pst = con.prepareStatement("insert into property_details(pdid,apartment_type,BHK_type,floor,total_floor,property_age,facing,property_size,fk_user_emailid) values(NULL,?,?,?,?,?,?,?,?)");
			pst.setString(1, apartment_type);
			pst.setString(2, BHK_type);
			pst.setString(3, floor);
			pst.setString(4, total_floor);
			pst.setString(5, property_age);
			pst.setString(6, facing);
			pst.setString(7, property_size);
			pst.setString(8, user_Email_id);
			
			
			int hasInsert = pst.executeUpdate();
			
			pst = con.prepareStatement("SELECT last_insert_id() FROM rk_housemarket.property_details");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
				pdid=rs.getString(1);
			else
				pdid=null;
			
			if(hasInsert==1)
				return true;
			else
				return false;
			
		}catch(Exception ex) {
			System.out.println("\n\n Error: "+ex);
			return false;
		}
	}
}

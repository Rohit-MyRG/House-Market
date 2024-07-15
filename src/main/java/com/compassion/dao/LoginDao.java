package com.compassion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.compassion.bean.HouseMarketUser;

public class LoginDao {
					
						/* Add new user in the database*/
	public boolean insertUser(HouseMarketUser user) {
		try {
								/* Connect to the MySql database and get the reference of Connection interface. */
			Connection con = MySqlConnectionProvider.getConnection();
			
			if(isExistUser(user.getEmail_id())) {
				return false;   /*return false if user data(email id) already exists*/
			}
			
								/* Insert all data to the database. */
			PreparedStatement pst = con.prepareStatement("insert into HouseMarketUser(name,mobile,email,password) values(?,?,?,AES_ENCRYPT(?,?))");
			pst.setString(1, user.getName());
			pst.setString(2, user.getMobile());
			pst.setString(3, user.getEmail_id());
			pst.setString(4, user.getPassword());
			pst.setString(5, "rgrd98");			
								/* executeUpdate() method returns 1 if data has inserted else 0 */
			int hasInsert = pst.executeUpdate();
			if(hasInsert==1)
				return true;
			else
				return false;
			
		}catch(Exception exe) {
			System.out.println(exe);
		}
		return false;
	}
	
						/* To check does user exist or not*/
	public boolean isExistUser(String email) throws SQLException {
		
						/* Connect to the MySql database and get the reference of Connection interface. */
		Connection con = MySqlConnectionProvider.getConnection();
		
		PreparedStatement pst = con.prepareStatement("SELECT email FROM housemarketuser where email=?");
		pst.setString(1, email);
		
		ResultSet rs = pst.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
	}
	public ResultSet login(String email,String password) throws SQLException {
		
			/* Connect to the MySql database and get the reference of Connection interface. */
			Connection con = MySqlConnectionProvider.getConnection();
			
			PreparedStatement pst = con.prepareStatement("SELECT name,email,AES_DECRYPT(password,'rgrd98') as password FROM housemarketuser WHERE email=?");
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery();
			return rs;
			
	}
	
	
}
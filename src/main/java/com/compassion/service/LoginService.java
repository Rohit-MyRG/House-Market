package com.compassion.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import com.compassion.bean.HouseMarketUser;
import com.compassion.dao.LoginDao;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

public class LoginService {
	public boolean registerUser(String name, String mobile, String email_id, String password) {
		
						/* Using setters set all data members of HouseMarketUser bean*/
		HouseMarketUser user = new HouseMarketUser();
		user.setName(name);
		user.setMobile(mobile);
		user.setEmail_id(email_id);
		user.setPassword(password);
		
						/* return true if data of new user has inserted to the database*/
		return new LoginDao().insertUser(user);
	}
	
						/*Return random number like OTP*/
	public String randomNumber(int len) {
		String no="0123456789";
		Random r=new Random();
		char[] otp=new char[len];
		String s1="";
		for(int i=0;i<len;i++)
		{
			otp[i]=no.charAt(r.nextInt(no.length()));
			s1=s1+otp[i];
		}
		return s1;
	}
	
							/* This method send the OTP with descriptive message. */
	public boolean sendOtp(String to1,String from1,String pass1,String msgtext)
	{       
		try{
	            
			String host ="smtp.gmail.com";
			String user = from1;
			String pass = pass1;
			String to = to1;
			String from = from1;
			String subject = "Verification code for House Market";
			String messageText = msgtext;
			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");
			//java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	            
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject); 
			msg.setSentDate(new Date());
			msg.setText(messageText);

			Transport transport=mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
	           
			return true; 
		}catch(Exception ex)
		{    
			System.out.println("OTP Sending error,Please check 'internet Connection' or incurrect Email ID :\n"+ex); 
			 return false;
	    }
	}
	public boolean isExistUser(String email) throws SQLException {
		return new LoginDao().isExistUser(email);
	}
	
	public String login(String email, String password) throws SQLException {
		ResultSet rs = new LoginDao().login(email, password);
		try {
			if(rs.next()) 
			{
				if(email.equals(rs.getString("email"))) 
				{
					if(password.equals(rs.getString("password"))){
						return "True";
					}else {
						return "PasswordNotFound";
					}
				}else {
					return "EmailNotFound";
				}
			}else{
				return "EmailNotFound";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Error";
	}
	
}

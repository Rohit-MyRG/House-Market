package com.compassion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.compassion.service.LoginService;

@Controller
public class UserLogin {
	
	@RequestMapping("registration")
	public void loginRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
						/* Access all attributes from msgSender.jsp */
		String name = request.getAttribute("name").toString();
		String mobile = request.getAttribute("mobile").toString();
		String email_id = request.getAttribute("email_id").toString();
		String password = request.getAttribute("password").toString();
		
						/* LoginService class contains some services for login the user. */
		LoginService login = new LoginService();
		
						/* This method return true if all user data inserted in database*/
		boolean isInserted = login.registerUser(name, mobile, email_id, password);
		
						/* This out.prinln() method prints True, it means return True to login.jsp.   
						 * And in the login.jsp file checkOtp method of javaScript code
						 * will response to user over True or False.
						 */
		if(isInserted) {
			out.println("True");
		}else {
			out.println("Exist");
		}
		
	}
	
	@RequestMapping("sendOTP")
	public void sendOTP(HttpServletRequest request, HttpServletResponse response) {
		
		try {
						/* for printing the message on web page. */
		PrintWriter out = response.getWriter();
		
						/* Access the attributes from client/browser. */
		String name = request.getAttribute("name").toString();
		String mail = request.getAttribute("email").toString();
		
						/* LoginService class contains some services for login the user. */
		LoginService login = new LoginService();
		
						/* Check does user already exist or not using email id. */
		if(login.isExistUser(mail)){
			out.println("Sorry :( \nThis email-id is already exist,\n\nPlease use other email-id or \nForget the password if you have forgoted the password");
		}else
		{				
						/* Generate the OTP*/
			String otp = login.randomNumber(4);

						/* Generate the message with OTP for email*/
			String email_message="Dear "+name+",\n\nWelcome to the india's best and free Property rental site. \n\nYour (One Time Password)OTP for www.HouseMarket.com is: "+otp+"\n\nUse this Passcode to complete your transaction.\n\nThank you, \nTeam HouseMarket";
		
						/* Add the OTP in session attributes for later using. */
			HttpSession session = request.getSession();
			session.setAttribute("oneTime", otp);
		
						/* Send the email with OTP to the user. And return true or false to ans variable, true for sent and false for something wrong*/
			boolean ans = login.sendOtp(mail,"rk.housemarket@gmail.com","jqemgqpmxsmjfbdg",email_message);
						
			if(ans){
				out.println("Ok");
			}else{
				out.println("Sorry :( \nOTP Sending error,\nPlease check 'internet Connection' or incurrect Email ID. ");
			}
		}
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	@RequestMapping("loginUser")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String email = request.getParameter("email").toString();
			String password = request.getParameter("password").toString();
			
			LoginService login = new LoginService();
			String ans = login.login(email, password);
			
					/* for printing the message on web page. */
			PrintWriter out = response.getWriter();
			out.print("<script>");
			
			if(ans.equals("PasswordNotFound")) 
			{
				out.println("alert('Password Does Not Match');");
			}else 
			if(ans.equals("EmailNotFound")) 
			{
				out.println("alert('Email Does Not Match');");
			}else 
			if(ans.equals("Error")) 
			{
				out.println("alert('Sorry :(  Something went wrong, Please try again.');");
			}else 
			if(ans.equals("True")) 
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", email);
				out.println("alert('Congratulations :)  login successfully...');");
			}
			out.println("window.location.replace('http://localhost:8080/HouseMarket/'); ");
			out.println("</script>");
			
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

}

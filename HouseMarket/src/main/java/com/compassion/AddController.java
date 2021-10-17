package com.compassion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.compassion.service.AddService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage; 

@Controller
public class AddController {
	
	@RequestMapping("/log")
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * int a = Integer.parseInt(request.getParameter("t1"));
		 * 
		 * AddService as = new AddService(); a = as.add(a);
		 * 
		 * System.out.println("\n\n\nHello Rohit\n\n\n"+a); ModelAndView mv = new
		 * ModelAndView(); mv.setViewName("show.jsp"); mv.addObject("result", a); return
		 * mv;
		 */

		PrintWriter out = response.getWriter();
		
		
		try{
			
            
			String host ="smtp.gmail.com";
			String user = "rohit.myrg@gmail.com";
			String pass = "msrdpiqhxbonftim";
			String to = "rohit.myrg@gmail.com";
			String from = "rohit.myrg@gmail.com";
			String subject = "A.M. College Library System";
			String messageText = "746368";
			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");
			//Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	            
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
	           
			out.print("Done");
		}catch(Exception ex)
		{    
			//System.out.println("OTP Sending error,Please check 'internet Connection' or incurrect Email ID :\n"+ex); 
			out.print("Sorry");
		}
		
		
	}
}

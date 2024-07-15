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
	
	@RequestMapping("rohit")
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
		
		out.print("Hello Rohit");
		
	}
}

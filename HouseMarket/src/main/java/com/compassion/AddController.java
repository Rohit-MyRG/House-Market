package com.compassion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.compassion.service.AddService;

@Controller
public class AddController {
	
	@RequestMapping("/log")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * int a = Integer.parseInt(request.getParameter("t1"));
		 * 
		 * AddService as = new AddService(); a = as.add(a);
		 * 
		 * System.out.println("\n\n\nHello Rohit\n\n\n"+a); ModelAndView mv = new
		 * ModelAndView(); mv.setViewName("show.jsp"); mv.addObject("result", a); return
		 * mv;
		 */
		return "index.jsp";
	}
}

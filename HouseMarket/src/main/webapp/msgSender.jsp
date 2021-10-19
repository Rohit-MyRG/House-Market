<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" %>

<%
String form = request.getParameter("form");
if(form.equals("send")){
	String mail = request.getParameter("param1");
	String name = request.getParameter("name");
	
	request.setAttribute("name", name);
	request.setAttribute("email",mail);

	getServletContext().getRequestDispatcher("/sendOTP").forward(request, response);
		
}else 
if(form.equals("check")){
	String realOtp = session.getAttribute("oneTime").toString();
	String userOtp = request.getParameter("param1");
	if(realOtp.equals(userOtp)){
		session.removeAttribute("oneTime");
		
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email_id = request.getParameter("email_id");
		String password = request.getParameter("password");
		
		session.setAttribute("username", email_id);
		String s1="";
		for (int i = 0; i < name.length(); i++) {
			if(name.charAt(i)==' ')	break;
		    s1 = s1 + name.charAt(i);
		}
		session.setAttribute("name",s1);
		
		request.setAttribute("name", name);
		request.setAttribute("mobile", mobile);
		request.setAttribute("email_id", email_id);
		request.setAttribute("password", password);
		
		//out.println(name+"\n"+mobile+"\n"+email_id+"\n"+password+"\n");
		
		getServletContext().getRequestDispatcher("/registration").forward(request, response);
		out.println("True");
	}else{
		out.println("False");
	}
	
}

%>

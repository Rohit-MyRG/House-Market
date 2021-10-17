<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"
    import="java.util.*,javax.activation.*,javax.mail.internet.*,javax.mail.*" %>

<%!
private int sendOtp(String to1,String from1,String pass1,String msgtext)
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
           
		return 1; 
	}catch(Exception ex)
	{    
		System.out.println("OTP Sending error,Please check 'internet Connection' or incurrect Email ID :\n"+ex); 
		 return 0;
    }
}
%>


<%
String form = request.getParameter("form");
if(form.equals("send")){
	String mail = request.getParameter("param1");

	int len=4;
	String no="0123456789";
	Random r=new Random();
	char[] otp=new char[len];
	String s1="";
	for(int i=0;i<len;i++)
	{
		otp[i]=no.charAt(r.nextInt(no.length()));
		s1=s1+otp[i];
	}
	String txt="Dear Customer,\n\nWelcome to the india's best and free Property rental site. \n\nYour (One Time Password)OTP for www.HouseMarket.com is: "+s1+"\n\nUse this Passcode to complete your transaction.\n\nThank you, \nTeam HouseMarket";
	
	
	session.setAttribute("oneTime", s1);
	

	int ans = sendOtp(mail,"rohit.myrg@gmail.com","msrdpiqhxbonftim",txt);
	if(ans==1){
		session.setAttribute("mail", mail);
		out.println("OTP send successfully...");
	}else{
		out.println("Sorry :( \n Please enter valid email id.");
	}
}else 
if(form.equals("check")){
	String realOtp = session.getAttribute("oneTime").toString();
	String userOtp = request.getParameter("param1");
	if(realOtp.equals(userOtp)){
		session.removeAttribute("oneTime");
		String mail = session.getAttribute("mail").toString();
		session.setAttribute("username", mail);
		session.removeAttribute("mail");
		out.println("True");
	}else{
		out.println("False");
	}
	
}

%>

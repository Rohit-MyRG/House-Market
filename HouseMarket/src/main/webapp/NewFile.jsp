<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("login.jsp");
	}

%>
     
Welcome: <a href="">${username}</a>



</body>
</html>
<%@page import="com.rajesh.logging.Logger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>
<center>
<font face="Lucida sans Unicode" size="2">
	<%
			if(new com.rajesh.web.security.Session(request).isValidSession()){
	%>
					Hi, <%=new com.rajesh.web.security.Session(request).getUserName()%>
					Welcome Home !
					<a href='logout.do'>Logout</a>
	<%
			}
			else{
	%>			
					<jsp:forward page="index.jsp" >
					  <jsp:param name="message" value="Session Expired !" />
					</jsp:forward>
	<%
			}
	%>
</font>
</center>
</body>
</html>
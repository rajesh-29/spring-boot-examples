<%@page import="com.rajesh.logging.Logger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
	<body>
		<% Logger.log("ENTRY", "error.jsp"); %>
		ERROR<br/>
		Invalid session !<br/>
		or<br/>
		You are logged out ! <br/>
		<%  Logger.log("ENTRY", "error.jsp"); %>
	</body>
</html>
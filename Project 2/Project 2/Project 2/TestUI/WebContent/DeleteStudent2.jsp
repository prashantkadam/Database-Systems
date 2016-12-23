<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="table.css" rel="stylesheet" type="text/css">
<link href="stylesAdminMenu.css" rel="stylesheet" type="text/css">

<title>Welcome to Student Registration System</title>
</head>
<body background="images/online_banking.jpg">
<%
	String msg = "";
if(request.getAttribute("msg") != null){
	msg = request.getAttribute("msg").toString(); 	
}
	
	%>
<%@include file="menu.jsp"%>
<%
if(msg.equals("")){
	%>
	<p>Student deleted Successfully</p>
	<%
}else {
	%>
	<span style="border: 1px solid red"> ${msg} </span>
<%
}
%>
</body>
</html>
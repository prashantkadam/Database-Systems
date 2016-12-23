<%@page import="model.beans.ClassInformation"%>
<%@page import="model.beans.StudentClassInformation"%>
<%@page import="model.beans.StudentInformation"%>
<%@page import="model.beans.EnrollmentsTable"%>
<%@page import="model.beans.LogsTable"%>
<%@page import="model.beans.PrerequisitesTable"%>
<%@page import="model.beans.CourseCreditsTable"%>
<%@page import="model.beans.CoursesTable"%>
<%@page import="model.beans.ClassesTable"%>
<%@page import="model.beans.GradesTable"%>
<%@page import="model.beans.StudentsTable"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table Details</title>
<link href="stylesAdminMenu.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body background="images/online_banking.jpg">
	<%@include file="menu.jsp"%>
	<%
		ArrayList<ClassInformation> classInformationList = (ArrayList<ClassInformation>)request.getAttribute("classInformationList");
	String msg = "";
	if(request.getAttribute("msg") != null){
		msg = request.getAttribute("msg").toString(); 	
	}
	%>
	
	<div class="CSSTableGenerator">
	
	
	<%
if(msg.equals("")){
	%>
	<div>
	
	<table border="1" title="Class Information Details" cellspacing="20px">
			<tr>
				<th>BNumber</th>
				<th>firstName</th>
				<th>classId</th>
				<th>title</th>
			</tr>
			<s:forEach var="classInfo" items="${classInformationList }">
				<tr>
					<td>${classInfo.bNUmber }</td>
					<td>${classInfo.firstName }</td>
					<td>${classInfo.classId }</td>
					<td>${classInfo.title }</td>
				</tr>
			</s:forEach>
		</table>
	</div>
	<%
}else {
	%>
	<span style="border: 1px solid red"> ${msg} </span>
<%
}
%>
	
	
	
		
	</div>
</body>
</html>
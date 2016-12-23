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
		ArrayList<StudentClassInformation> studentClassList = (ArrayList<StudentClassInformation>)request.getAttribute("studentClassList");

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
	
	<table border="1" title="Student Details" cellspacing="20px">
			<tr>
				<th>classid</th>
				<th>deptCode</th>
				<th>courseNumber</th>
				<th>sectionNumber</th>
				<th>year</th>
				<th>semester</th>
				<th>lGrade</th>
				<th>nGrade</th>
			</tr>
			<s:forEach var="studentClass" items="${studentClassList }">
				<tr>
					<td>${studentClass.classid }</td>
					<td>${studentClass.deptCode }</td>
					<td>${studentClass.courseNumber }</td>
					<td>${studentClass.sectionNumber }</td>
					<td>${studentClass.year }</td>
					<td>${studentClass.semester }</td>
					<td>${studentClass.lGrade }</td>
					<td>${studentClass.nGrade }</td>
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
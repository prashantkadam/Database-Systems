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
		ArrayList<StudentsTable> studentList = (ArrayList<StudentsTable>)request.getAttribute("studentList");
		ArrayList<ClassesTable> classList = (ArrayList<ClassesTable>)request.getAttribute("classList");
		ArrayList<CoursesTable> courseList = (ArrayList<CoursesTable>)request.getAttribute("courseList");
		ArrayList<CourseCreditsTable> courseCreditList = (ArrayList<CourseCreditsTable>)request.getAttribute("courseCreditList");
		ArrayList<PrerequisitesTable> prerequisiteList = (ArrayList<PrerequisitesTable>)request.getAttribute("prerequisiteList");
		ArrayList<GradesTable> gradeList = (ArrayList<GradesTable>)request.getAttribute("gradeList");
		ArrayList<LogsTable> logList = (ArrayList<LogsTable>)request.getAttribute("logList");
		ArrayList<EnrollmentsTable> enrollmentList = (ArrayList<EnrollmentsTable>)request.getAttribute("enrollmentList");
	%>

	<div class="CSSTableGenerator">
		<table border="1" title="Student Details" cellspacing="20px">
		<caption> <br/>Students<br/><br/>
		</caption>
			<tr>
				<th>BNumber</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Status</th>
				<th>Gpa</th>
				<th>Email</th>
				<th>BDate</th>
				<th>DeptName</th>
			</tr>
			<s:forEach var="student" items="${studentList }">
				<tr>
					<td>${student.bNumber }</td>
					<td>${student.firstName }</td>
					<td>${student.lastName }</td>
					<td>${student.status }</td>
					<td>${student.gpa }</td>
					<td>${student.email }</td>
					<td>${student.bDate }</td>
					<td>${student.deptName }</td>

				</tr>
			</s:forEach>
		</table>
	</div>

	<div class="CSSTableGenerator">
		<table border="1" title="Enrollment Details" cellspacing="20px">
		<caption> <br/>Enrollments<br/><br/>
		</caption>
			<tr>
				<th>bNumber</th>
				<th>classId</th>
				<th>lGrade</th>
			</tr>
			<s:forEach var="enrollment" items="${enrollmentList }">
				<tr>
					<td>${enrollment.bNumber }</td>
					<td>${enrollment.classId }</td>
					<td>${enrollment.lGrade }</td>
				</tr>
			</s:forEach>
		</table>
	</div>

	<div class="CSSTableGenerator">
		<table border="1" title="Course Details" cellspacing="20px">
		<caption> <br/>Courses<br/><br/>
		</caption>
			<tr>
				<th>deptCode</th>
				<th>courserNumber</th>
				<th>title</th>
			</tr>
			<s:forEach var="course" items="${courseList }">
				<tr>
					<td>${course.deptCode }</td>
					<td>${course.courserNumber }</td>
					<td>${course.title }</td>
				</tr>
			</s:forEach>
		</table>
	</div>

	<div class="CSSTableGenerator">
		<table border="1" title="Course Credit Details" cellspacing="20px">
			<caption> <br/>Course Credits<br/><br/>
		</caption>
			<tr>
				<th>courseNumber</th>
				<th>credits</th>
			</tr>
			<s:forEach var="courseCredit" items="${courseCreditList }">
				<tr>
					<td>${courseCredit.courseNumber }</td>
					<td>${courseCredit.credits }</td>
				</tr>
			</s:forEach>
		</table>
	</div>

	<div class="CSSTableGenerator">
		<table border="1" title="Classes Details" cellspacing="20px">
		<caption> <br/>Classes<br/><br/>
		</caption>
			<tr>
				<th>classId</th>
				<th>deptCode</th>
				<th>courseNumber</th>
				<th>sectionNumber</th>
				<th>year</th>
				<th>semester</th>
				<th>limit</th>
				<th>classSize</th>
			</tr>
			<s:forEach var="class1" items="${classList }">
				<tr>
					<td>${class1.classId }</td>
					<td>${class1.deptCode }</td>
					<td>${class1.courseNumber }</td>
					<td>${class1.sectionNumber }</td>
					<td>${class1.year }</td>
					<td>${class1.semester }</td>
					<td>${class1.limit }</td>
					<td>${class1.classSize }</td>
				</tr>
			</s:forEach>
		</table>
	</div>


	<div class="CSSTableGenerator">
		<table border="1" title="Grade Details" cellspacing="20px">
		<caption> <br/>Grades<br/><br/>
		</caption>
			<tr>
				<th>lgrade</th>
				<th>ngrade</th>
			</tr>
			<s:forEach var="grade" items="${gradeList }">
				<tr>
					<td>${grade.lGrade }</td>
					<td>${grade.nGrade }</td>
				</tr>
			</s:forEach>
		</table>
	</div>

	<div class="CSSTableGenerator">
		<table border="1" title="Prerequisite Details" cellspacing="20px">
		<caption> <br/>Prerequisites<br/><br/>
		</caption>
			<tr>
				<th>deptCode</th>
				<th>courseNumber</th>
				<th>preDeptCode</th>
				<th>preCourseNumber</th>
			</tr>
			<s:forEach var="prerequisite" items="${prerequisiteList }">
				<tr>
					<td>${prerequisite.deptCode }</td>
					<td>${prerequisite.courseNumber }</td>
					<td>${prerequisite.preDeptCode }</td>
					<td>${prerequisite.preCourseNumber }</td>
				</tr>
			</s:forEach>
		</table>
	</div>

	<div class="CSSTableGenerator">
		<table border="1" title="Log Details" cellspacing="20px">
		<caption> <br/>Logs<br/><br/>
		</caption>
			<tr>
				 <th>LogId</th>
				<th>Who</th>
				<th>Time</th>
				<th>TableName</th>
				<th>Operation</th>
				<th>key-Value</th>
			</tr>
			<s:forEach var="log" items="${logList }">
				<tr>
					<td>${log.logId }</td>
					<td>${log.user }</td>
					<td>${log.time }</td>
					<td>${log.tableName }</td>
					<td>${log.operation }</td>
					<td>${log.keyValue }</td>
				</tr>
			</s:forEach>
		</table>
	</div>
</body>
</html>
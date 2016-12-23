<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="stylesAdminMenu.css" rel="stylesheet" type="text/css">
<link href="table.css" rel="stylesheet" type="text/css">

<title>Delete Student</title>
</head>
<body background="images/online_banking.jpg">
	<%@include file="menu.jsp"%>
	<form action="Controller">
		<div>
			<table>
				<tr>
					<td>Student BNumber to delete:</td>
					<td><input type="text" name="txtBNumber" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="Search" value="DELETE STUDENT" /></td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="action" value="deleteStudent2">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.coursemanagement.dto.StudentDetails"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<%@ include file="/Home/Header.jsp"%>
<style>
table {
	border: solid;
	padding: 10px
}

th {
	font-size: 19px;
	background-color: green;
	padding: 10px;
}

td {
	font-size: 18px;
	padding: 5px
}
</style>
</head>
<body
	style="background-image: url('Images/school.jpg'); background-repeat: no-repeat; background-size: cover;">
	<h1 style="text-align: center; color: #000066; text-decoration: blink;">Students
		List</h1>
	<%
	List<StudentDetails> studentDetails = (List<StudentDetails>) request.getAttribute("viewStudents");
	%>
	<div style="display: flex; justify-content: center;">
		<table>
			<tr>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Email Address</th>
				<th>Contact</th>
			</tr>

			<%
			for (StudentDetails students : studentDetails) {
			%>
			<tr>
				<td><%=students.getStudentId()%></td>
				<td><%=students.getStudentName()%></td>
				<td><%=students.getEmailAddress()%></td>
				<td><%=students.getMobileNumber()%></td>
			</tr>
			<%
			}
			%>

		</table>
	</div>
</body>
</html>
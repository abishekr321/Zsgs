<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.coursemanagement.dto.TeacherDetails"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher List</title>
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
<%
List<TeacherDetails> teacherDetails = (List<TeacherDetails>) request.getAttribute("viewTeachers");
%>
<body
	style="background-image: url('Images/school.jpg'); background-repeat: no-repeat; background-size: cover;">
	<h1 style="text-align: center; color: #000066; text-decoration: blink;">Teachers
		List</h1>
	<div style="display: flex; justify-content: center;">
		<table>
			<tr>
				<th>Teacher Id</th>
				<th>Teacher Name</th>
				<th>Email Address</th>
				<th>Contact</th>
				<th>Course Id</th>
				<th>Course Name</th>
				<th>Slot</th>

			</tr>

			<%
			for (TeacherDetails teachers : teacherDetails) {
			%>
			<tr>
				<td><%=teachers.getTeacherId()%></td>
				<td><%=teachers.getTeacherName()%></td>
				<td><%=teachers.getEmailAddress()%></td>
				<td><%=teachers.getMobileNumber()%></td>
				<td><%=teachers.getCourseId()%></td>
				<td><%=teachers.getCourseName()%></td>
				<td><%=teachers.getSlot()%></td>
			</tr>
			<%
			}
			%>

		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.coursemanagement.dto.TimeTable"%>
<%
if (session.getAttribute("studentId") == null) {
	response.sendRedirect("Student/StudentLogin.jsp");

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Timetable</title>
<%@ include file="/Home/Header.jsp"%>
<style>
table {
	border: solid;
	padding: 10px
}

th {
	font-size: 18px;
	background-color: green;
	padding: 10px;
}

td {
	font-size: 17px;
	padding: 5px
}
</style>
</head>
<body
	style="background-image: url('Images/school.jpg'); background-repeat: no-repeat; background-size: cover;">
	<%
	List<TimeTable> timeTable = (List<TimeTable>) request.getAttribute("viewTimeTable");
	%>
	<h1 style="text-align: center; color: #000066; text-decoration: blink;">Time
		Table</h1>
	<div style="display: flex; justify-content: center;">
		<table>
			<tr>
				<th>Course Id</th>
				<th>Course Name</th>
				<th>Duration</th>
				<th>Timing</th>
				<th>Teacher Name</th>
			</tr>

			<%
			for (TimeTable times : timeTable) {
			%>
			<tr>
				<td><%=times.getCourseId()%></td>
				<td><%=times.getCourseName()%></td>
				<td><%=times.getStartingDate()%> - <%=times.getEndingDate()%>
				</td>
				<td><%=times.getStartingTime()%> - <%=times.getEndingTime()%></td>
				<td><%=times.getTeacherName()%></td>
			</tr>
			<%
	}%>

		</table>
	</div>
</body>
</html>
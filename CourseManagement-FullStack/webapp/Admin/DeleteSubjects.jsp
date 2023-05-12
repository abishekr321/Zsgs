<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.coursemanagement.dto.CourseDetails"%>
<%
List<CourseDetails> courseDetails = (List<CourseDetails>) request.getAttribute("deleteCourses");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>subjectDeletion</title>
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
	<h1 style="text-align: center; color: #000066; text-decoration: blink;">Course
		List</h1>
	<div style="display: flex; justify-content: center;">
		<table>
			<tr>
				<th>course Id</th>
				<th>Course Name</th>
				<th>Duration</th>
				<th>Timing</th>

			</tr>

			<%
			for (CourseDetails courses : courseDetails) {
			%>
			<tr>
				<td><%=courses.getCourseId()%></td>
				<td><%=courses.getCourseName()%></td>
				<td><%=courses.getStartingDate()%> - <%=courses.getEndingDate()%>
				</td>
				<td><%=courses.getStartingTime()%> - <%=courses.getEndingTime()%></td>
				<td><a
					href="DeleteSubjects?courseId=<%=courses.getCourseId()%>"><img
						src="Images/delete.png" width="20px" height="20px"> </a></td>
			</tr>
			<%
}
	%>

		</table>
	</div>
</body>
</html>
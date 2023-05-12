<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.coursemanagement.dto.GradeSheet"%>
<%
if (session.getAttribute("teacherId") == null) {
	response.sendRedirect("TeacherLogin.jsp");

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<%@ include file="/Home/Header.jsp"%>
<style>
table {
	border: solid;
	padding: 10px;
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
	<%
	List<GradeSheet> gradeSheet = (List<GradeSheet>) request.getAttribute("teacherStudents");
	%>
	<h2 style="text-align: center; color: #000066; text-decoration: blink;">Student
		List</h2>
	<div style="display: flex; justify-content: center;">
		<table>
			<tr>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Grades</th>


			</tr>

			<%
			for (GradeSheet grades : gradeSheet) {
			%>
			<tr>
				<td><%=grades.getStudentId()%></td>
				<td><%=grades.getStudentName()%></td>
				<td><%=grades.getGrade()%></td>
			</tr>
			<%
			}
			%>

		</table>
	</div>
</body>
</html>
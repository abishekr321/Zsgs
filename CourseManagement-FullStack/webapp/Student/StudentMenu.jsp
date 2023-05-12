<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
if (session.getAttribute("studentId") == null) {
	response.sendRedirect("Student/StudentLogin.jsp");

}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>studentMenu</title>
<%@ include file="/Home/Header.jsp"%>
<style type="text/css">
.menu {
	margin-top: 100px;
	display: flex;
	justify-content: center;
	align-content: center;
}

.menu a {
	padding: 25px;
	margin: 25px;
	box-shadow: 10px 5px 5px grey;
}

.menu a:hover {
	box-shadow: 10px 5px 5px green;
}
</style>
</head>

<body
	style="background-image: url('Images/school.jpg'); background-size: 75%;">
	<div class="menu">

		<a href="/CourseManagement/ShowCourses"><img alt="" src="/CourseManagement/Images/enrollment.png"
			width="150px" height="150px">
		<h2 style="text-align: center;">Enrollment</h2></a> <a
			href="/CourseManagement/ViewTimeTable"><img alt="" src="/CourseManagement/Images/timetable.png"
			width="150px" height="150px">
		<h2 style="text-align: center;">Timetable</h2></a> <a
			href="/CourseManagement/ViewGradeSheet"><img alt=""
			src="/CourseManagement/Images/student gradesheet.png" width="150px" height="150px">
		<h2 style="text-align: center;">Gradesheet</h2></a>

	</div>
</html>
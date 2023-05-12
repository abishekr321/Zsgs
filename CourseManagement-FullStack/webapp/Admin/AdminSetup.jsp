<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminSetup</title>
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
	style="background-image: url('Images/school.jpg'); background-size: cover;">
	<%
			if (!(session.getAttribute("addSubjectSuccess") == null)) {
			%>
	<div
		style="color: green; text-align: center; font-weight: bold; padding-top: 30px; font-size: 24px;">
		<%=(String) session.getAttribute("addSubjectSuccess")%></div>

	<%
			session.removeAttribute("addSubjectSuccess");
			}
			%>
	<%
			if (!(session.getAttribute("addSubjectFailure") == null)) {
			%>
	<div
		style="color: red; text-align: center; font-weight: bold; padding-top: 30px; font-size: 24px;">
		<%=(String) session.getAttribute("addSubjectFailure")%></div>

	<%
			session.removeAttribute("addSubjectFailure");
			}
			%>
	<%
			if (!(session.getAttribute("deleteSubjectSuccess") == null)) {
			%>
	<div
		style="color: green; text-align: center; font-weight: bold; padding-top: 30px; font-size: 24px;">
		<%=(String) session.getAttribute("deleteSubjectSuccess")%></div>

	<%
			session.removeAttribute("deleteSubjectSuccess");
			}
			%>



	<div class="menu">
		<a href="AddSubjects.jsp"><img alt="admin"
			src="/CourseManagement/Images/addingsubject.png" width="150px" height="150px">
			<h2 style="text-align: center;">Add Subjects</h2></a> <a
			href="/CourseManagement/DeleteShowCourses"><img alt=""
			src="/CourseManagement/Images/deletesubjects.png" width="150px" height="150px">
			<h2 style="text-align: center;">Delete Subjects</h2></a> <a
			href="/CourseManagement/AdminViewStudents"><img alt=""
			src="/CourseManagement/Images/view Students.jpg" width="150px" height="150px">
			<h2 style="text-align: center;">View Students</h2></a> <a
			href="/CourseManagement/AdminViewTeachers"><img alt=""
			src="/CourseManagement/Images/view teachers.jpg" width="150px" height="150px">
			<h2 style="text-align: center;">View Teachers</h2></a>
	</div>
</body>
</html>
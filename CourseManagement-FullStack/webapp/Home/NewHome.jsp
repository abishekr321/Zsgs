<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@ include file="Header.jsp"%>
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

<body style="margin: 0px; background-image: url('BGimage/school.jpg'); background-repeat: no-repeat; background-size: cover;">
	<div class="menu">

		<a href="/CourseManagement/Admin/AdminLogin.jsp"><img alt="" src="/CourseManagement/Images/admin.png"
			width="150px" height="150px">
		<h2 style="text-align: center;">Admin</h2></a> 
		<a href="/CourseManagement/Teacher/TeacherLogin.jsp"><img alt="" src="/CourseManagement/Images/teachers.jpg" width="150px" height="150px">
		<h2 style="text-align: center;">Teacher</h2></a>
		 <a href="/CourseManagement/Student/StudentLogin.jsp"><img alt="" src="/CourseManagement/Images/student.png" width="150px" height="150px">
		<h2 style="text-align: center;">Student</h2></a>
	</div>
</body>
</html>
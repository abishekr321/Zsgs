<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.jsp" %>
<style type="text/css">
.menu{
margin-top:100px;
display:flex;
justify-content:center;
align-content: center;
}

.menu a{
padding: 25px;
margin: 25px;
box-shadow: 10px 5px 5px grey;
}

.menu a:hover {
	box-shadow: 10px 5px 5px green;
}
</style>
</head>

<body style="background-image:url('Images/largeHome.png');background-size: cover;">
<div class="menu">

<a href="adminLogin.jsp"><img alt="admin" src="Images/admin.png" width="150px" height="150px"><h2 style="text-align: center;">Admin</h2></a>
<a href="teacherLogin.jsp"><img alt="" src="Images/teachers.jpg" width="150px" height="150px"><h2 style="text-align: center;">Teacher</h2></a>
<a href="studentLogin.jsp"><img alt="" src="Images/studen.png" width="150px" height="150px"><h2 style="text-align: center;">Student</h2></a>
</div>
</body>
</html>
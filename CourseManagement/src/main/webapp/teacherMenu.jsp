<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <% if(session.getAttribute("teacherId")==null){
    	response.sendRedirect("teacherLogin.jsp");
    	
    }
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Menu</title>
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

<body style="background-image:url('Images/school.jpg');background-size:75%;">
<div class="menu">

<a href="TeacherViewStudents"><img alt="" src="Images/view Students.jpg" width="150px" height="150px"><h2 style="text-align: center;">view Students</h2></a>
<a href="TeacherViewGradeSheet"><img alt="" src="Images/teacher geadesheet.jpg" width="150px" height="150px"><h2 style="text-align: center;">Grade Sheet</h2></a>


</div>
</html>
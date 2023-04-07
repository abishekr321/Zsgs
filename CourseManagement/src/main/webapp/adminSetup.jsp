<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <% if(session.getAttribute("adminId")==null){
    	response.sendRedirect("adminLogin.jsp");
    	
    }
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminSetup</title>
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

<body style="background-image:url('Images/school.jpg');background-size: cover;">
<div class="menu">

<a href="addSubjects.jsp"><img alt="admin" src="Images/addingsubject.png" width="150px" height="150px"><h2 style="text-align: center;">Add Subjects</h2></a>
<a href="DeleteShowCourses"><img alt="" src="Images/deletesubjects.png" width="150px" height="150px"><h2 style="text-align: center;">Delete Subjects</h2></a>
<a href="AdminViewStudents"><img alt="" src="Images/view Students.jpg" width="150px" height="150px"><h2 style="text-align: center;">View Students</h2></a>
<a href="AdminViewTeachers"><img alt="" src="Images/view teachers.jpg" width="150px" height="150px"><h2 style="text-align: center;">View Teachers</h2></a>
</div>
</body>
</html>
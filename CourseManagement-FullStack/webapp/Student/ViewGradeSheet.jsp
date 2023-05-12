<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
       <%@page import ="com.coursemanagement.dto.GradeSheet"%>
     <% if(session.getAttribute("studentId")==null){
    	response.sendRedirect("Student/StudentLogin.jsp");
    	
    }
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GradeSheet</title>
<%@ include file="/Home/Header.jsp" %>
<style>
table{
border: solid;
padding:10px
}
th{
font-size:18px;
background-color: green;
padding:10px;
}
td{
font-size:17px;
padding: 5px
}

</style>
</head>
<body style="background-image:url('Images/school.jpg');background-repeat: no-repeat; background-size: cover;">
<% List<GradeSheet> gradeSheets = (List<GradeSheet>)request.getAttribute("viewGradesheet"); %>
<h1 style="text-align: center; color:#000066 ;text-decoration: blink;">Subject List</h1>
<div style="display: flex; justify-content: center;">
<table>
<tr>
<th>Course Id</th>
<th>Course Name</th>
<th>Grades</th>

</tr>

<%for(GradeSheet grades:gradeSheets) {
	%>
	<tr>
	<td><%=grades.getCourseId() %></td>
	<td><%=grades.getCourseName() %></td>
	<td><%=grades.getGrade() %></td>
	</tr>
	<%
}
	%>

</table>
</div>
</body>
</html>
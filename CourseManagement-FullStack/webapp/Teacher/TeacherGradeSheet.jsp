<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
 <%@page import ="com.coursemanagement.dto.GradeSheet" %>
      <% if(session.getAttribute("teacherId")==null){
    	response.sendRedirect("TeacherLogin.jsp");
    	
    }
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher GradeSheet</title>
<%@ include file="/Home/Header.jsp" %>
<style>
table{
border: solid;
padding:10px
}
th{
font-size:19px;
background-color: green;
padding:10px;
}
td{
font-size:18px;
padding: 5px;
text-align: center;
}
#but{
width: 100px;
height: 25px;
border-radius: 10px;
color:white;
background-color:navy;

}
#but:hover {
	background-color: green;
}

</style>
</head>
<body style="background-image:url('Images/school.jpg');background-repeat: no-repeat; background-size: cover;">
<% List<GradeSheet> gradeSheet =(List<GradeSheet>)request.getAttribute("teacherGradeSheet");  %>
<h2 style="text-align: center; color:#000066 ;text-decoration: blink;">Student Grade List</h2>
<div style="display: flex; justify-content: center;">
<form action="UpdateGradeSheet" method="post">
<table>
<tr>
<th>Student Id</th>
<th>Student Name</th>
<th>Grades</th>

</tr>

<%for(GradeSheet grades:gradeSheet){
	%>
	<tr>
	<td><%=grades.getStudentId() %></td>
	<td><%=grades.getStudentName() %></td>
	 <td><input type="text" name="<%=grades.getStudentId()%>" style="width: 40px; "></td> 
	</tr>
	<%
}
	%>
<tr>
<td> </td>
<td><input id="but" type="submit"></td>
<td> </td>
</tr>

</table>
</form>
</div>
</body>
</html>
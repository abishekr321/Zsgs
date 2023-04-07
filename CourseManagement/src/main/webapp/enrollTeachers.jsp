<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="java.sql.ResultSet" %>
   <% if(session.getAttribute("studentId")==null){
    	response.sendRedirect("studentLogin.jsp");
    	
    }
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.jsp" %>
<style>
table{
border: solid;
padding:10px
}
th{
background-color: green;
padding:10px;
}
td{
padding: 5px
}

</style>
</head>
<body style="background-image:url('Images/school.jpg');background-repeat: no-repeat; background-size: cover;">
<% ResultSet set =(ResultSet)request.getAttribute("courseTeachers");  %>
<div style="display: flex; justify-content: center;">
<table>
<tr>
<th>Teacher Id</th>
<th>Teacher Name</th>
<th>Course Id</th>
<th>Slot</th>
<th>  </th>
</tr>

<%while(set.next()){
	%>
	<tr>
	<td><%=set.getString(1) %></td>
	<td><%=set.getString(2) %></td>
	<td><%=set.getString(5) %></td>
	<td><%=set.getString(6) %></td>
	<td>
	
	<a href="EnrollStudents?courseId=<%= set.getString(5)%>&&teacherId=<%=set.getString(1) %>"><h4 style="text-align: center;">confirm--></h4> </a>
	</td>
	</tr>
	<%
}
	%>

</table>
</div>
</body>
</html>
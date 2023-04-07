<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
.topnav{
background:linear-gradient(45deg,#ff6666,#80ffaa,#80b3ff,#ffff80);
height: 80px;
margin: 0px
}
.topnav a{
float: right;
margin: 10px;
text-decoration: none;

}


</style>
</head>
<body style="margin: 0px;background-image:url('Images/school.jpg');background-repeat: no-repeat; background-size: cover;"  >

<div class="topnav" >
<div style="display: flex; justify-content:space-between;">
<h1 style="text-align: center; color:#003300 ; text-shadow: graytext;font-family:cursive;font-weight: bold;margin-left: 40%;"><i class="fa-solid fa-school fa-lg"></i> OHO Schools</h1>

<%
if(session.getAttribute("studentId")!=null||session.getAttribute("teacherId")!=null||session.getAttribute("adminId")!=null){
%>
<div style="display: flex;">
<% if(session.getAttribute("studentId")!=null){
	
	%>
	<a href="" style="font-size: 25px; color: #000099;"><i class="fa-solid fa-user"></i> <%=session.getAttribute("studentId") %></a>
	<% 
	
} else if(session.getAttribute("teacherId")!=null){
	
	%>
	<a href="" style="font-size: 25px; color: #000099;"><i class="fa-solid fa-user"></i> <%=session.getAttribute("teacherId") %> </a>
	<% 
	
} else if(session.getAttribute("adminId")!=null){
	
	%>
	<a href="" style="font-size: 25px; color: #000099;"><i class="fa-solid fa-user"></i><%=session.getAttribute("adminId") %> </a>
	<%
	
}
	%>


<a href="Logout"style="font-size: 25px; color: red;"><i class="fa-solid fa-right-from-bracket"></i> Logout</a>
<%} %>
</div>
</div>
</div>


</body>
</html>
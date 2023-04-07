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
<title>Insert title here</title>
<title>StudentRegistration</title>
<%@ include file="header.jsp" %>
<style type="text/css">
.in {
  border: 2px solid black;
  border-radius: 10px;
   color:"#cc99ff";
  width: 150px;
  height: 20px;
}
#but{
width: 100px;
height: 25px;
border-radius: 10px;
color:white;
background-color:navy;
text-align: center;

}
#but:hover {
	background-color: green;
}
</style>
</head>
<body style="background-image:url('Images/school.jpg');background-repeat: no-repeat; background-size: cover;">
<h1 style="text-align: center; color: #FE0D0D ;text-decoration: blink;">Subject Addition</h1>
<div style="text-align: center;margin-top: 30px ;border: 3px solid; width:20%;height:420px;margin-left: 40%; border-radius: 20px;padding-top: 30px ">
<form action="AddingSubject" method="post">
Subject Id:<br><input class="in"type ="text" name="subjectId"><br><br>
Subject Name:<br><input class="in" type="text" name="subjectName"><br><br>
Starting Date:<br><input class="in" type="date" name="startingDate"><br><br>
Ending Date:<br><input class="in" type="date" name="endingDate"><br><br>
Starting Time:<br><input class="in" type="text" name="startingTime"><br><br>
Ending Time:<br><input class="in" type="text" name="endingTime"><br><br>
<input id="but" type="submit"><br>
</form>
</div>
</body>
</html>
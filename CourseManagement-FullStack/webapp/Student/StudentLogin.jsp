<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StudentLogin</title>
<head><%@ include file="/Home/Header.jsp"%>
<style type="text/css">
.in {
	border: 2px solid black;
	color: "#cc99ff";
	width: 200px;
	height: 20px;
}

#but {
	width: 100px;
	height: 25px;
	border-radius: 10px;
	color: white;
	background-color: navy;
	margin-left: 28%;
}

#but:hover {
	background-color: green;
}

a {
	text-align: center;
	padding-left: 25%;
}

.error {
	color: red;
	font-family: sans-serif;
}
</style>
</head>
<body
	style="background-image: url('Images/school.jpg'); background-repeat: no-repeat; background-size: cover;">
	<h1 style="text-align: center; color: #008066; text-decoration: blink;">Student
		Login</h1>

	<div
		style="padding-left: 18px; margin-top: 50px; border: 3px solid; width: 19%; height: 250px; margin-left: 40%; border-radius: 20px; padding-top: 30px">
		<form action="/CourseManagement/StudentsLogin" method="post"
			onsubmit="return validateLogin()">
			<%
			if (!(session.getAttribute("newstudentId") == null)) {
			%>
			<div style="text-align: center; color: green; font-weight: bold;">
				User Id:
				<%=(String) session.getAttribute("newstudentId")%></div>

			<%
			session.removeAttribute("newstudentId");
			}
			%>


			Student Id<br>
			<input class="in" type="text" name="userName" required><br>
			<div class="error" id="nameError"></div>
			<br> Password<br>
			<input class="in" type="password" name="password" required><br>
			<div class="error" id="passwordError"></div>
			<br>
			<%
			if (!(session.getAttribute("failmsg") == null)) {
			%>
			<div style="text-align: center; color: red; font-weight: bold;"><%=(String) session.getAttribute("failmsg")%></div>
			<%
			session.removeAttribute("failmsg");
			}
			%><br> <input id="but" type="submit"><br>
			<br> <a href="RegisterStudents.jsp">Create an account</a><br>
		</form>
	</div>
</body>
<script>
	function validateLogin() {
		let name = document.forms[0]["userName"].value;
		let password = document.forms[0]["password"].value;
		var check = true;
		document.getElementById("nameError").innerHTML = "";
		document.getElementById("passwordError").innerHTML = "";
		const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$/;
		const nameRegex = /^[0-9]+$/;
		if (!passwordRegex.test(password)) {
			document.getElementById("passwordError").innerHTML = "Please Enter valid Password";
			check = false;
		}
		if (!nameRegex.test(name)) {
			document.getElementById("nameError").innerHTML = "Please Enter valid username";
			check = false;

		}
		return check;

	}
</script>
</html>
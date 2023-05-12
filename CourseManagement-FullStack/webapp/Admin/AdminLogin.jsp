<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><%@ include file="/Home/Header.jsp"%>
<meta charset="ISO-8859-1">
<title>adminLogin</title>
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
	text-align: center;
	margin-left: 26%;
}

#but:hover {
	background-color: green;
}

.error {
	color: red;
	font-family: sans-serif;
}
</style>
</head>
<body>

	<h1 style="text-align: center; color: #008066; text-decoration: blink;">Admin
		Login</h1>
	<div
		style="padding-left: 18px; font-size: 16pxfont-size:16px; margin-top: 10px; border: 3px solid; width: 19%; height: 8%; margin-left: 40%; border-radius: 20px; padding-top: 30px">
		<form action="/CourseManagement/AdminLogin" onsubmit="return validateLogin()"
			method="post">
			User Name<br>
			<input class="in" type="text" name="userName" required><br>
			<div class="error" id="nameError"></div>
			<br> Password<br>
			<input class="in" type="password" name="password" required><br>
			<div class="error" id="passwordError"></div>
			<br>
			<%
			if (!(session.getAttribute("failmsg") == null)) {
			%>
			<div style="color: red; font-weight: bold; text-align: center;"><%=(String) session.getAttribute("failmsg")%></div>
			<%
			session.removeAttribute("failmsg");
			}
			%><br> <input id="but" type="submit"><br>
			<br>
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
		const nameRegex = /^[a-zA-Z0-9]+$/;
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
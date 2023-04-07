<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.model.Model"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Registration</title>
<%@ include file="header.jsp"%>
<style type="text/css">
.in {
	border: 2px solid black;
	border-radius: 10px;
	color: "#cc99ff";
	width: 150px;
	height: 20px;
}

.error {
	color: red;
	font-family: sans-serif;
}

#but {
	width: 100px;
	height: 25px;
	border-radius: 10px;
	color: white;
	background-color: navy;
	text-align: center;
}

#but:hover {
	background-color: green;
}
</style>
</head>
<body
	style="background-image: url('Images/school.jpg'); background-repeat: no-repeat; background-size: cover;">
	<h1 style="text-align: center; color: #FE0D0D; text-decoration: blink;">Teacher
		Registration</h1>
	<div
		style="text-align: center; margin-top: 30px; border: 3px solid; width: 20%; height: 80%; margin-left: 40%; border-radius: 20px; padding-top: 30px">
		<form action="RegisterTeachers" onsubmit="return validateteacher()"
			method="post">
			First Name:<br>
			<input class="in" type="text" name="firstName" required><br>
			<div class="error" id="firstNameError"></div>
			<br> Last Name:<br>
			<input class="in" type="text" name="lastName" required><br>
			<div class="error" id="lastNameError"></div>
			<br> Email Address:<br>
			<input class="in" type="email" name="emailAddress" required><br>
			<div class="error" id="emailError"></div>
			<br> Mobile Number:<br>
			<input class="in" type="text" name="mobileNumber" required><br>
			<div class="error" id="numberError"></div>
			<br>
			<%
			Model model = new Model();
			ResultSet set = model.showCourses();
			%>
			Select Subject:<br>
			<select class="in" name="subject" required>
				<option value="" selected>choose</option>
				<%
				while (set.next()) {
				%>
				<option value="<%=set.getShort(1)%>">
					<%=set.getString(1)%> -
					<%=set.getString(2)%></option>
				<%
				}
				%>
			</select><br>
			<div class="error" id="selectError"></div>
			<br> Password:<br>
			<input class="in" type="password" name="password"><br>
			<div class="error" id="passwordError"></div>
			<br> Re-Enter Password:<br>
			<input class="in" type="password" name="rePassword"><br>
			<div class="error" id="passwordMatchError"></div>
			<br> <input id="but" type="submit"><br>
		</form>
	</div>
	<script>
		function validateteacher() {
			let firstName = document.forms[0]["firstName"].value;
			let lastName = document.forms[0]["lastName"].value;
			let email = document.forms[0]["emailAddress"].value;
			let mobileNumber = document.forms[0]["mobileNumber"].value;
			let subject = document.forms[0]["subject"].value;
			let password = document.forms[0]["password"].value;
			let rePassword = document.forms[0]["rePassword"].value;
			var check = true;
			document.getElementById("firstNameError").innerHTML = "";
			document.getElementById("lastNameError").innerHTML = "";
			document.getElementById("emailError").innerHTML = "";
			document.getElementById("numberError").innerHTML = "";
			document.getElementById("passwordError").innerHTML = "";
			document.getElementById("passwordMatchError").innerHTML = "";

			const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$/;
			const nameRegex = /^[a-zA-Z0-9]+$/;
			const numberRegex = /^[6789]\d{9}$/;
			const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
			if (!nameRegex.test(firstName)) {
				document.getElementById("firstNameError").innerHTML = "Please Enter Valid Name ";
				check = false;
			}
			if (!nameRegex.test(lastName)) {
				document.getElementById("lastNameError").innerHTML = "Please Enter valid Name";
				check = false;
			}
			if (!emailRegex.test(email)) {
				document.getElementById("emailError").innerHTML = "Please Enter valid E-mail address";
				check = false;
			}
			if (!numberRegex.test(mobileNumber)) {
				document.getElementById("numberError").innerHTML = "Please Enter valid number";
				check = false
			}
			if (subject == null) {
				document.getElementById("selectError").innerHTML = "Please Select one option";
				check = false
			}

			if (!passwordRegex.test(password)) {
				document.getElementById("passwordError").innerHTML = "Password must Contain minimum 1 uppercase, lowecase, digits and special Character";
				check = false;

			}
			if (password !== rePassword) {
				document.getElementById("passwordMatchError").innerHTML = "passwords doesn't match";
				check = false;
			}
			return check;

		}
	</script>

</body>
</html>
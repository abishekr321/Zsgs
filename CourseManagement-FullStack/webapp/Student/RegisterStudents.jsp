<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StudentRegistration</title>
<%@ include file="/Home/Header.jsp"%>
<style type="text/css">
.in {
	border: 2px solid black;
	color: "#cc99ff";
	width: 200px;
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
	margin-bottom: 10px;
	margin-left: 28%;
}

#but:hover {
	background-color: green;
}
</style>
</head>
<body
	style="background-image: url('Images/school.jpg'); background-repeat: no-repeat; background-size: cover;">
	<h1 style="text-align: center; color: #800080; text-decoration: blink;">Student
		Registration</h1>
	<div
		style="padding-left: 18px; margin-top: 30px; border: 3px solid; width: 19%; height: 80%; margin-left: 40%; border-radius: 20px; padding-top: 30px">
		<form action="/CourseManagement/RegistersStudents" method="post"
			onsubmit="return validateRegistration()">
			First Name<br> <input class="in" type="text" name="firstName"
				required><br>
			<div class="error" id="firstNameError"></div>
			<br> Last Name<br> <input class="in" type="text"
				name="lastName" required><br>
			<div class="error" id="lastNameError"></div>
			<br> Email Address<br> <input class="in" type="email"
				name="emailAddress" required><br>
			<div class="error" id="emailError"></div>
			<br> Mobile Number<br> <input class="in" type="text"
				name="mobileNumber" required><br>
			<div class="error" id="numberError"></div>
			<br> Password<br> <input class="in" type="password"
				name="password" required><br>
			<div class="error" id="passwordError"></div>
			<br> Re-Enter Password<br> <input class="in"
				type="password" name="rePassword" required><br>
			<div class="error" id="passwordMatchError"></div>
			<br> <input id="but" type="submit"><br>


		</form>
	</div>
	<script>
		function validateRegistration() {
			let firstName = document.forms[0]["firstName"].value;
			let lastName = document.forms[0]["lastName"].value;
			let email = document.forms[0]["emailAddress"].value;
			let mobileNumber = document.forms[0]["mobileNumber"].value;
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
				check = false;
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
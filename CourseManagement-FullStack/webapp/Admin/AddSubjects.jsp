<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>subjectAddition</title>
<%@ include file="/Home/Header.jsp"%>
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
	margin-left: 28%;
}

#but:hover {
	background-color: green;
}
</style>
</head>
<body>
	<h1 style="text-align: center; color: #339966; text-decoration: blink;">Subject
		Addition</h1>
	<div
		style="margin-top: 30px; padding-left: 13px; font-size: 16px; border: 3px solid; width: 18%; height: 420px; margin-left: 40%; border-radius: 20px; padding-top: 30px">
		<form action="/CourseManagement/AddingSubject" method="post">
			Subject Id<br>
			<input class="in" type="text" name="subjectId"><br>
			<br> Subject Name<br>
			<input class="in" type="text" name="subjectName"><br>
			<br> Starting Date<br>
			<input class="in" type="date" name="startingDate"><br>
			<br> Ending Date<br>
			<input class="in" type="date" name="endingDate"><br>
			<br> Starting Time<br>
			<input class="in" type="text" placeholder="00:00:00"
				name="startingTime"><br>
			<br> Ending Time<br>
			<input class="in" type="text" placeholder="00:00:00"
				name="endingTime"><br>
			<br> <input id="but" type="submit"><br>
		</form>
	</div>
</body>
</html>
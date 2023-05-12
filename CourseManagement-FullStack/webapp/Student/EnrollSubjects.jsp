<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.coursemanagement.dto.CourseDetails"%>
<%
if (session.getAttribute("studentId") == null) {
	response.sendRedirect("Student/StudentLogin.jsp");

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>subjectEnrollment</title>
<%@ include file="/Home/Header.jsp"%>
<style>
table {
	border: solid;
	padding: 10px
}

th {
	font-size: 18px;
	background-color: green;
	padding: 10px;
}

td {
	font-size: 17px;
	padding: 5px
}

#confirm {
	width: 75px;
	height: 25px;
	border-radius: 10px;
	color: white;
	background-color: navy;
}

#confirm:hover {
	background-color: green;
}
</style>

</head>
<body>
	<h1 id="head"
		style="text-align: center; color: #000066; text-decoration: blink;">Subject
		List</h1>
	<h1 id="tail"
		style="text-align: center; color: #000066; text-decoration: blink;">Teacher
		List</h1>
	<%
	List<CourseDetails> courseDetails = (List<CourseDetails>) request.getAttribute("showCourses");
	%>
	<div id="course" style="display: flex; justify-content: center;">
		<table>
			<tr>
				<th>course Id</th>
				<th>Course Name</th>
				<th>Duration</th>
				<th>Timing</th>
				<th></th>
			</tr>

			<%
			for (CourseDetails courses : courseDetails) {
			%>
			<tr>
				<td><%=courses.getCourseId()%></td>
				<td><%=courses.getCourseName()%></td>
				<td><%=courses.getStartingDate()%> - <%=courses.getEndingDate()%>
				</td>
				<td><%=courses.getStartingTime()%> - <%=courses.getEndingTime()%></td>
				<td>
					<button id="confirm"
						onclick="getTeacher(<%=courses.getCourseId()%>)">select</button>

				</td>
			</tr>
			<%
			}
			%>

		</table>
	</div>
	<div id="teachers" style="display: flex; justify-content: center;">
		<table>
			<thead>
				<tr>
					<th>Teacher Id</th>
					<th>Teacher Name</th>
					<th>Course Id</th>
					<th>Slot</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="tableBody">

			</tbody>

		</table>
		<template>
			<tr>
				<td id="teacherId"></td>
				<td id="teacherName"></td>
				<td id="courseId"></td>
				<td id="slot"></td>
				<td>
					<button id="confirm">confirm</button>
				</td>

			</tr>

		</template>
	</div>
	<script type="text/javascript">
document.getElementById("tail").style.display="none";
document.getElementById("teachers").style.display="none";


</script>
	<script type="text/javascript">
function enrollSubject(teacherId,courseId){
     const xhr = new XMLHttpRequest();
     xhr.onreadystatechange=function(){
    	 if(xhr.readyState==4){
    		 var result = xhr.responseText;
    		 window.location="Student/StudentMenu.jsp";
    	 }
     }
     xhr.open("GET","/CourseManagement/EnrollStudents?teacherId="+teacherId+"&courseId="+courseId);
     xhr.send();
}
	function getTeacher(courseid){
		document.getElementById("head").style.display="none";
		document.getElementById("course").style.display="none";
		document.getElementById("tail").style.display="block";
		document.getElementById("teachers").style.display="flex";
		let httpRequestObject = new XMLHttpRequest();
		httpRequestObject.onreadystatechange = function() {
			if (httpRequestObject.readyState == 4) {
				document.getElementById('tableBody').innerHTML="";
				let response = JSON.parse(httpRequestObject.responseText);
	
				
				for (var i = 0; i < response.length; i++) {
				var eachObject = response[i];
				var templateTag = document.getElementsByTagName("template")[0];
				var eachItemDiv = templateTag.content;
				var copiedDiv = eachItemDiv.cloneNode(true);
		
				copiedDiv.querySelector("#teacherId").innerText= eachObject.teacherId;
			    copiedDiv.querySelector("#teacherName").innerText= eachObject.teacherName;
			    copiedDiv.querySelector("#courseId").innerText= eachObject.courseId;
			    copiedDiv.querySelector("#slot").innerText= eachObject.slot;
			    copiedDiv.querySelector("#confirm").setAttribute('onclick',"enrollSubject("+eachObject.teacherId+","+eachObject.courseId+")");
			    document.getElementById('tableBody').append(copiedDiv);
			}
			}
		};
		httpRequestObject.open("GET", "/CourseManagement/StudentViewTeachers?courseId="+courseid);
		// httpRequestObject.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		httpRequestObject.send();
	}
	
</script>
</body>
</html>
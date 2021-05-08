<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.bharath.web.jdbc.Authentication"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href=" css/style.css" />
</head>



<body>
	<c:set var="data" value="${welcomeNote}" />
	<h2><b>${data}</b></h2>

	<hr>
<h2>Subscriber</h2>

	<input type="button" value="Add Subscriber"
		onclick="window.location.href='AddStudent.jsp'; return false;"
		class="add-student-button btn"/>

	<input type="button" value="List All Subscriber"
		onclick="window.location.href='DisplayAuth.jsp'; return false;"
		class="add-student-button btn" />

	
<h2>Subject</h2>

	<input type="button" value="Add Subject"
		onclick="window.location.href='AddSubject.jsp'; return false;"
		class="add-student-button btn" />

	<input type="button" value="Dispaly Subject"
		onclick="window.location.href='DisplaySubjects.jsp'; return false;"
		class="add-student-button btn" />



	
<h2>Student</h2>

	<input type="button" value="Add Student Details"
		onclick="window.location.href='AddStudentDetails.jsp'; return false;"
		class="add-student-button btn" />

	<input type="button" value="View Student Details"
		onclick="window.location.href='ViewStudentDetails.jsp'; return false;"
		class="add-student-button btn" />
	
	<h2>Staff</h2>
	
	<input type="button" value="Add Staff Details"
		onclick="window.location.href='AddStaffDetails.jsp'; return false;"
		class="add-student-button btn" />
	<input type="button" value="View Staff Details"
		onclick="window.location.href='ViewStaffDetails.jsp'; return false;"
		class="add-student-button btn"/>
	
<br><br>
	<footer>
		<input type="button" value="LogOut"
			onclick="window.location.href='Login.jsp'; return false;"
			class="add-student-button btn"/>
	</footer>

</body>
</html>
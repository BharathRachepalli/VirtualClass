<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<h2>Add Staff Details</h2>

<!-- <form action="SubjectConterllerServlet">
		<input type="hidden" name="command" value="PrintSubjects1" />
		<input type="submit" value="show Subject list">
	</form> -->
	<br>
	<form action="AuthenticationControllerServlet">
		<input type="hidden" name="command" value="PrintList2" />
		<input type="submit" value="show Email List" class="btn">
	</form>
	<br>
<form action="StaffControllerServlet">
<input type="hidden" name="command" value="AddStaffDetails"/>

<label>Student First Name:</label><br>
<input type="text" name="sfname"><br><br>
<label>Student Last Name:</label><br>
<input type="text" name="slname"><br><br>
<label>Student Subject:</label><br>
<input type="text" name="ssname"><br><br>


<%-- <select name="ssname">
<c:forEach var="i" items="${sub_List}">
<option>${i.sName }</option>
</c:forEach>
</select> --%>



<label>Staff Email:</label>
<select name="semail"><br>
<c:forEach var="i" items="${auth_List}">
<option>${i.email}</option>
</c:forEach>
</select><br><br>

<input type="submit" value="Save" class="btn"><br><br>
</form>

<button onclick="goBack()" class="btn">Go Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>
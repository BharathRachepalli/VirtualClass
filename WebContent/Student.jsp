<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
	<h2>Display Students</h2>
	<input type="button" value="Display Students"
		onclick="window.location.href='DisplayStudentsForStudents.jsp'; return false;"
		class="add-student-button btn" />
		
		
<h2>Display Staff</h2>
	 <input type="button" value="Dispaly Staff"
		onclick="window.location.href='DisplayStaffForStaff.jsp'; return false;"
		class="add-student-button btn" />

	
	<h2>UploadAssignment</h2>

	 <input type="button" value="Upload Assignment"
		onclick="window.location.href='StudentAssig.jsp'; return false;"
		class="add-student-button btn" />
	
	<h2>Display Video's</h2>
	<input type="button" value="Video PlayList"
		onclick="window.location.href='Video.jsp'; return false;"
		class="add-student-button btn" />
	
	<br><br>
	<footer>
		<input type="button" value="LogOut"
			onclick="window.location.href='Login.jsp'; return false;"
			class="add-student-button btn" />
	</footer>
</body>
</html>
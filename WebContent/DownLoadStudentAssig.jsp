<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<h1>Student Assignment Download</h1><br><br>
<form action="AssigServlet">

		
		<input type="hidden" name="command" value="assigdown" />
		Enter Subject ID:<br> <input type="text" name="subName"/><br><br>
		Enter Student Email:<br> <input type="text" name="email"/><br><br>
		
		<input type="submit" value="Download Assignment" class="btn"><br><br>
	</form>
	<button onclick="goBack()" class="btn">Go Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>
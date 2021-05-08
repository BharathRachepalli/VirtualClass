<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href=" css/style.css" />
</head>
<body><h2>Student Assignment Upload</h2><br>
<form action="AssigServlet">

		
		<input type="hidden" name="command" value="assig" />
		Enter Subject ID for Staff:<br> <input type="text" name="subName"/><br><br>
		Enter Student Email:<br> <input type="text" name="email" /><br><br>
		Upload File:<br><input type="file" name="stuAssig"><br><br>
		<input type="submit" value="Upload Assignment" class="btn"><br><br>
	</form>
	<button onclick="goBack()" class="btn">Go Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>
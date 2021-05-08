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

<h2>Add Subject</h2>

<form action="SubjectConterllerServlet">
<input type="hidden" name="command" value="AddSubject"/><br><br>

<label>Name:</label><br>
<input type="text" name="sname"><br><br>
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
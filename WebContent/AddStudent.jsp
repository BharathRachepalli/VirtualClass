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

<h2>Add Authentication</h2>

<form action="AuthenticationControllerServlet">
<input type="hidden" name="command" value="AddStudent"/><br><br>

<label>Email:</label><br>
<input type="text" name="email"><br><br>
<label>Password:</label><br>
<input type="text" name="pwd"><br><br>
<label>Logintype:</label><br>
<select name="logintype">

<option>employee</option>
<option>businesspartner</option>
<option>customer</option>
<option>staff</option>
</select><br><br><br><br>
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
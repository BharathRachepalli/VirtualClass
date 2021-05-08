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
<h2>Update Student Authentication</h2>
<form action="AuthenticationControllerServlet">
<input type="hidden" name="command" value="Update"/>

<input type="hidden" name="aEmail" value="${auth_load.email}"/>
<label>Email:</label>
${auth_load.email}
<br><label>Password:<br></label>
<input type="text" name="pwd" value="${auth_load.pwd}"><br><br>
<label>Logintype:<br></label>
<select name="logintype" >

<option>employee</option>
<option>businesspartner</option>
<option>customer</option>
<option>staff</option> 
</select><br><br>
<input type="submit" value="Save" class="btn">
<br>
<button onclick="goBack()" class="btn">Go Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</form>
</body>
</html>
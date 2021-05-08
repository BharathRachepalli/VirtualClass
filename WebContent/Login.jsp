<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href=" css/style.css" />
</head>
<body>
<h1 style="text-align:center;color:#66bfbf;font-size: 50px;">Home Page</h1>
<div style="border:2px solid black;padding:20px;margin:7% 12% 5% 12%;text-align:center;">
<form action="AuthenticationControllerServlet" >


Email<br><input type="text" name="email">
<br><br>

Password<br><input type="password" name="pwd">
<br><br>
LoginType<br><select name="logintype">
<option>Admin</option>
<option>employee</option>
<option>businesspartner</option>
<option>customer</option>
<option>staff</option>
</select>

<input type="hidden" name="command" value="Login"/>



 <br><br>
<input type="submit" value="submit" class="btn"><br><br>
<a href="index.html">Contact Me</a>
</form>
</div>
</body>
</html>
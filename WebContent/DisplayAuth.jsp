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
<h2>List Of All Subscribed Users</h2> <hr>
<form action="AuthenticationControllerServlet">
		<input type="hidden" name="command" value="PrintList" />
		<input type="submit" value="show list" class="btn">
	</form>

	
	<table border=1>
		<tr>
			<th>Email</th>
			<th>password</th>
			<th>Login Type</th>
			<th>Action</th>
		</tr>

		<%-- <%for(Authentication i : authList) {%> --%>

		<c:forEach var="i" items="${auth_List}">
		
		<c:url var="tempLink" value="AuthenticationControllerServlet">
						<c:param name="command" value="Load" />
						<c:param name="email" value="${i.email}" />
					</c:url>
					
					
					
			<tr>
				<td>${i.email }</td>
				<td>${i.pwd }</td>
				<td>${i.logintype }</td>
				<td><a href="${tempLink}">Update</a></td>
			</tr>
		</c:forEach>
		<%-- <%} %> --%>

	</table><br><br>
	<button onclick="goBack()" class="btn">Go Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>
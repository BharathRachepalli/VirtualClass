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
<body><h2>List Of Subjects</h2>
<form action="SubjectConterllerServlet">
		<input type="hidden" name="command" value="PrintSubjects" /><br><br>
		<input type="submit" value="show list" class="btn"><br><br>
	</form>

	
	<table border=1>
		<tr>
			<th>ID</th>
			<th>Name</th>
			
		</tr>

		<%-- <%for(Authentication i : authList) {%> --%>

		<c:forEach var="i" items="${sub_List}">
					
					
			<tr>
				<td>${i.sId }</td>
				<td>${i.sName }</td>
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
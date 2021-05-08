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
<body><h2>List Of All Staff Users</h2>
<form action="StaffControllerServlet">
		<input type="hidden" name="command" value="StaffPrintList" />
		<input type="submit" value="show Staff" class="btn"><br><br>
	</form>
	
	

	<table border=1>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>subject</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="i" items="${stu_List}">
		<tr>
		
		<c:url var="tempLink" value="StaffControllerServlet">
						<c:param name="command" value="Load" />
						<c:param name="id" value="${i.staffId}" />
					</c:url>
					<c:url var="tempLink1" value="StaffControllerServlet">
						<c:param name="command" value="Delete" />
						<c:param name="id" value="${i.staffId}" />
					</c:url>
					
				<td>${i.staffId}</td>
				<td>${i.staffFName }</td>
				<td>${i.staffLName }</td>
				<td>${i.staffSubject }</td>
				<td>${i.staffEmail }</td>
				<td><a href="${tempLink}">Update</a> | <a href="${tempLink1}" onclick="if (!(confirm('Are you sure you want to delete this Staff?'))) return false">Delete</a></td>
			</tr> 
		
		
		</c:forEach>
		</table>
		<button onclick="goBack()" class="btn">Go Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>
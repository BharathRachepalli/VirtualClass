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
<h2>List Of Staff</h2>
<hr><br><br>
<form action="StaffServlet">
		<input type="hidden" name="command" value="PrintStaff" />
		Enter Subject ID for Staff: <br><input type="text" name="subName"/><br><br>
		<input type="submit" value="show Staff" class="btn">
	</form>
	<br><br>
	
	
	<table border=1>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>subject</th>
			<th>Email</th>
		</tr>
		
		<c:forEach var="i" items="${stu_List}">
		<tr>
		
					
				<td>${i.staffId}</td>
				<td>${i.staffFName }</td>
				<td>${i.staffLName }</td>
				<td>${i.staffSubject }</td>
				<td>${i.staffEmail }</td>
				
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
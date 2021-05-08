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
<h2>Update Student Details</h2>
<form action="StaffControllerServlet">
<input type="hidden" name="command" value="Update"/>

<input type="hidden" name="id" value="${stu_load.staffId}"/>

<label>ID :</label><br><br>
${stu_load.staffId}

<label>Email :</label><br><br>
${stu_load.staffEmail}

<label>First Name:<br></label>
<input type="text" name="fname" value="${stu_load.staffFName}">
<br><br>
<label>Last Name:<br></label>
<input type="text" name="lname" value="${stu_load.staffLName}">
<br><br>
<input type="submit" value="Save" class="btn">
</form>

<button onclick="goBack()" class="btn">Go Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>
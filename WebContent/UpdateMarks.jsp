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
<h2>Update Student Marks For Respective Subject</h2>
<form action="StaffServlet">
<input type="hidden" name="command" value="Update"/>

<input type="hidden" name="id" value="${stu_load.studentId}"/><br><br>

<label>ID :</label>
${stu_load.studentId}
<br><br>
<label>Subject :</label>
${stu_load.studentSubject}
<br><br>
<label>Enter New Marks:<br></label>
<input type="text" name="marks" value="${stu_load.studentMarks}">
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
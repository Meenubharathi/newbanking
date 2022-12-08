<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="css/Design.css">
</head>
<body>
<h1>REQUEST PAGE</h1>
<table>
<tr><td>Account_No </td><td><select><c:forEach var="details" items="${map}">
<option value="${details.value.getAccountNo()}">${details.value.getAccountNo()}</option></c:forEach></select></td></tr>
<tr><td>Amount </td><td><input type="text" name="amount"></td></tr>
<tr><td><input type="submit" value="submit"></td></tr>
</table>
</body>
</html>
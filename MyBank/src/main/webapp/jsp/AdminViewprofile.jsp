<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminViewProfile</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<style>
table.right{
  margin-left: auto; 
  margin-right: auto;
}
</style>
<link rel="stylesheet" href="css/ADesign.css">
</head>
<body>
<form action="BankingServlet" method="post">
<h1>All Details</h1>
<table class="center">
<tr>
<th>Customer Id</th>
<th>Name</th>
<th>Mobile</th>
<th>Email</th>
<th>DOB</th>
<th>Adhar Number</th>
<th>Pan Number</th>
<th>Address</th>
</tr>
<c:forEach var="detail" items="${map1}">
<tr>
<td>${detail.value.getUserId()}</td>
<td>${detail.value.getName()}</td>
<td>${detail.value.getPhoneNo()}</td>
<td>${detail.value.getEmail()}</td>
<td>${detail.value.getDob()}</td>
<td>${detail.value.getAdharNo()}</td>
<td>${detail.value.getPanNo()}</td>
<td>${detail.value.getAddress()}</td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>
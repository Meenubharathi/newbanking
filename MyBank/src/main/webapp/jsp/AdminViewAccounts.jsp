<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="css/ADesign.css">
</head>
<body>
<form action="BankingServlet" method="post">
<h1>Account Details</h1>
<table class="center">
<tr>
<th>Customer Id</th>
<th>Account Number</th>
<th>Account Type</th>
<th>Balance</th>
<th>IFSC Code</th>
<th>Branch</th>
<th>Status</th>
</tr>
<c:forEach var="details" items="${map}">
<tr>
<td>${details.value.getCustomerID()}</td>
<td>${details.value.getAccountNo()}</td>
<td>${details.value.getAccountType()}</td>
<td style="text-align:right">${details.value.getBalance()}</td>
<td>${details.value.getIFSCcode()} </td>
<td>${details.value.getBranch()}</td>
<td>${details.value.getStatus()}</td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewAccounts</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="css/CDesign.css">
</head>
<body>
<h1>Accounts Details</h1>
<h2><%
int id=(int) session.getAttribute("customerId");
out.print("Customer Id:"+id);
%></h2>
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
<td>${details.value.getIFSCcode()}</td>
<td>${details.value.getBranch()}</td>
<td>${details.value.getStatus()}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
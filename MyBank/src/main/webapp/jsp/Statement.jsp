<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statement page</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="css/Design.css">
</head>
<body>
<h1>STATEMENT</h1>
<TABLE>
<tr>
<th>Transaction_id</th>
<th>Time</th>
<th>Account_No</th>
<th>Transaction_Account</th>
<th>Amount</th>
<th>Mode</th>
<th>CurrentBalance</th>
</tr>
<c:forEach var="details" items="${map}">
<c:forEach var="detail" items="${details.value}">
<tr>
<td>${detail.getTransactionId()}</td>
<td>${detail.getTime()}</td>
<td>${detail.getAccountNumber()}</td>
<td>${detail.getTransaction_Account()}</td>
<td>${detail.getAmount()}</td>
<td>${detail.getModeOfTransaction()}</td>
<td>${detail.getCurrent_Balance()}</td>
</tr></c:forEach>
</c:forEach>
</TABLE>
</body>
</html>
<button class="button" type="submit" name="button" value="WithDraw">WithDraw</button>
<button class="button" type="submit" name="button" value="Deposit">Deposit</button>

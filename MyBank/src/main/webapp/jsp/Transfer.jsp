<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>transaction</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="css/CDesign.css">
</head>
<h1>Do Transaction</h1>
<body>
<form action="BankingServlet" method="post">
<table class="center">
<tr><td>Account  </td><td><select class="selectBox" name="accountNo"><c:forEach var="details" items="${map}">
<option value="${details.value.getAccountNo()}">${details.value.getAccountNo()}</option></c:forEach></select></td></tr>
<tr><td>Debit </td><td>Debit</td></tr>
<tr><td>Amount</td><td><input type="text" name="amount" pattern="[0-9]{1,10}" title="should contain numbers only" required></td></tr>
<tr><td>Transaction Account</td><td><input type="text" name="transAcc" pattern="[0-9]{10,15}" title="should contain numbers only" required></td></tr>
</table>
<div style="text-align:center;margin-top:20px;"><button class="button" type="submit" name="button" value="process">Transfer</button></div>
</form>
<h1 style="color:green;text-align:center;">${transfer}</h1>
<h1 style="color:red;text-align:center;">${nottransfer}</h1>
<h1 style="color:red;text-align:center;">${error}</h1>
</body>
</html>
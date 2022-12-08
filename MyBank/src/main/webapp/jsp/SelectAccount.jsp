<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="css/CDesign.css">
</head>
<body>
<h1>Statement</h1>
<form action="BankingServlet" method="post">
<table class="center">
<tr><td>Account Number </td><td>
<select class="selectBox" name="accNo"><c:forEach var="details" items="${map1}">
<option value="${details.value.getAccountNo()}">${details.value.getAccountNo()}</option></c:forEach></select></td>
<td><button class="button" type="submit" name="button" value="next">Get Statement</button></td>
</tr>
</table>
<div style="margin-top:20px;"></div>
<c:forEach var="values" items="${map}">
<table class="center">
<tr>
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
<td>${detail.getTime()}</td>
<td>${detail.getAccountNumber()}</td>
<td>${detail.getTransaction_Account()}</td>
<td style="text-align:right">${detail.getAmount()}</td>
<td>${detail.getModeOfTransaction()}</td>
<td style="text-align:right">${detail.getCurrent_Balance()}</td>
</tr>
</c:forEach>
</c:forEach>
</table>
</c:forEach>

</form>
</body>
</html>
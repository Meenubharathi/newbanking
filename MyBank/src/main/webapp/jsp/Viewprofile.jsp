<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="css/CDesign.css">
</head>
<body>
<form action="BankingServlet" method="post">
<h1>Personal Details</h1>
<h2><%
int id=(int) session.getAttribute("customerId");
out.print("Customer Id:"+id);
%>
</h2>
<h1 style="color:green;text-align:center;">${update}</h1>
<table class="center">
<c:forEach var="details" items="${map}">
<c:forEach var="detail" items="${map1}">
<tr><td>Name</td><td>${details.value.getName()}</td></tr>
<tr><td>DOB</td><td>${detail.value.getDob()}</td></tr>
<tr><td>Phone Number</td><td><input type="text" maxlength="10" value="${details.value.getPhoneNo()}" name="mobile" 
                        pattern ="[7-9]{1}[0-9]{9}" title="phone number should contain 10 numbers" required></td></tr>
<tr><td>Email id</td><td><input type="email" value="${details.value.getEmail()}" name="email" required></td></tr>
<tr><td>Adhar Number</td><td>${detail.value.getAdharNo()} </td></tr>
<tr><td>Pan Number</td><td>${detail.value.getPanNo() }</td></tr>
<tr><td>ADDRESS</td><td><input type="text" name="address" value="${detail.value.getAddress()}" required></td></tr>
</c:forEach>
</c:forEach>
</table>
<div style="text-align:center;margin-top:20px;"><button class="button" type="submit" name="button" value="update">Update</button></div>
</form>
</body>
</html>
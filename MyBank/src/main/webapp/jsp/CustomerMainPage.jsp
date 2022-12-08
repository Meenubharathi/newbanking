<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<style>
body
{   
    height:500px;
    background:#A1C3D1;
}
table.center 
{
  margin-left: auto; 
  margin-right: auto;
}

table 
{
  font-family: arial, sans-serif;
   border: 1px solid black;
  border-radius: 20px;
  width: 40%;
}
td
{
    text-align: left;
    padding: 8px;
}
th
{
    text-align: center;
    padding: 8px;
}
tr:nth-child(odd){background-color: #ded8db;}
tr:nth-child(even){background-color: MistyRose;}

tr:first-child th:first-child { border-top-left-radius: 20px; }
tr:first-child th:last-child { border-top-right-radius: 20px; }

tr:first-child td:first-child { border-top-left-radius: 30px; }
tr:first-child td:last-child { border-top-right-radius: 30px; }

tr:last-child td:first-child { border-bottom-left-radius: 20px; }
tr:last-child td:last-child { border-bottom-right-radius: 20px; }

</style>
</head>
<body>
<h2><%
int id=(int) session.getAttribute("customerId");
out.print("Customer Id:"+id);
%></h2>
<table class="center">
<tr>
<th>Account Number</th>
<th>Account Type</th>
<th>Balance</th>
</tr>
<c:forEach var="details" items="${map}">
<tr>
<td>${details.value.getAccountNo()}</td>
<td>${details.value.getAccountType()}</td>
<td style="text-align:right">${details.value.getBalance()}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
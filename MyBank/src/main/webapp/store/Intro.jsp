<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Page</title>
<style >
body
{
	background-color:OldLace;
}
table.center {
  margin-left: auto; 
  margin-right: auto;
}
table 
{
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 40%;
}
td
{
    border: 3px solid Black;
    text-align: left;
    padding: 8px;
}
</style>
</head>
<body>
<h1 align="center">Welcome</h1>
<form action="../BankingServlet" method="post">
<table class="center">
<tr>
<td><input type="submit" name="button" value="AdminLogin"></td><td><input type="submit" name="button" value="CustomerLogin"></td>
</tr>
</table>
</form>
</body>
</html>
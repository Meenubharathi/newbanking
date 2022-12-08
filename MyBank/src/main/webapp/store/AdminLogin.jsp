<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
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
<h1 align="center">Login</h1>
<form action="BankingServlet" method="post">
<table class="center">
<tr>
<td>USER-ID </td>
<td><input type="text" name="userid"></td>
</tr>
<tr>
<td >PASSWORD </td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="reset" value="Reset"></td>
<td><input type="submit" name="button" value="Admin" ></td>
</tr>
</table>
</form>
<form action="BankingServlet" method="post">
<input type="submit" name="button" value="LogOut">
</form>

</body>
</html>
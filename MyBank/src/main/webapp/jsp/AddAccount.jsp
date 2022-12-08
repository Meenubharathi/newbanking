<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/ADesign.css">
</head>
<body>
<h1 style="color:green">${add}</h1>
<h1 style="color:red">${error}</h1>
<form action="BankingServlet" method="post">
<h1>Adding Account Details</h1>
<table class="center">
<tr><td>Customer Id </td><td><input type="text" name="customerid" required></td></tr>
<tr><td>Account Number </td><td><input type="text" maxlength="15" name="accNo" required></td></tr>
<tr><td>Account Type </td><td><select class="selectBox" name="accType"><option value="Savings Account">savings account</option>
<option value="NRI Account">NRI Account</option><option value="Salary Account">Salary Account</option>
<option value="Current Account">Current Account</option></select></td></tr>
<tr><td>IFSC code </td><td><input type="text" maxlength="11" name="ifscCode" required></td></tr>
<tr><td>Balance </td><td><input type="text" name="balance" required></td></tr>
<tr><td>Branch </td><td><input type="text" name="branch" required></td></tr>
<tr><td>Status </td><td>ACTIVE</td></tr>
</table>
<div style="text-align:center;margin-top:20px"><button class="button" type="submit" name="button" value="Add account">Add Account</button></div>
</form>
</body>
</html>
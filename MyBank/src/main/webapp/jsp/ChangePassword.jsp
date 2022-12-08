<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChangePassword</title>
<link rel="stylesheet" href="css/CDesign.css">
</head>
<h1>Change Password</h1>
<body>
<form action="BankingServlet" method="post">
<table class="center">
<tr>
<td>Enter Password</td>
<td><input type="password" name="oldPW" required></td>
</tr>
<tr>
<td>New Password</td>
<td><input type="password" name="newPW" required></td>
</tr>
<tr>
<td> Re-Enter New Password</td>
<td><input type="password" name="RenewPW" required></td>
</tr>
</table>
<div style="text-align:center;margin-top:20px;"><button class="button" type="submit" name="button" value="Change password">Change Password</button></div>
</form>
<h1 style="color:green;text-align:center;">${update1}</h1>
<h1 style="color:red;text-align:center;">${update2}</h1>
</body>
</html>
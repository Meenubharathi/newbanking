<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddUser</title>
<link rel="stylesheet" href="css/ADesign.css">
</head>
<body>
<h1 style="color:green">${add}</h1>
<h1 style="color:red;text-align:center;">${error}</h1>

<form action="BankingServlet" method="post">
<h1>Add User</h1>
<table class="center">
<tr><td>Customer Id </td><td><input type="text" maxlength="3" name="customerid" required></td></tr>
<tr><td>Name </td><td><input type="text" name="name" required></td></tr>
<tr><td>DOB </td><td><input type="date" maxlength="10" name="dob" required></td></tr>
<tr><td>Mobile </td><td><input type="text" maxlength="10" name="mobile" required></td></tr>
<tr><td>Email </td><td><input type="email" name="email" required></td></tr>
<tr><td>Adhar Number </td><td><input type="text" maxlength="12" name="adhar" required></td></tr>
<tr><td>Pan Number </td><td><input type="text" maxlength="10" name="pan" required></td></tr>
<tr><td>Address </td><td><input type="text" name="address" required></td></tr>
<tr><td>Password </td><td><input type="text" name="password" required></td></tr>
<tr><td>Role </td><td><input type="text" name="role" required></td></tr>
<tr><td>Status </td><td>ACTIVE</td></tr>
</table>
<div style="text-align:center;margin-top:20px"><button class="button" type="submit" name="button" value="Add user">Add User</button></div>
</form>

</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminPage</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="css/AButtonDesign1.css">
<body>
<h1 align="center" style="color:white;">Welcome</h1>
<iframe  src="jsp/AdminMainPage.jsp" name="adminmenu" height="600" width="1200" align="right"></iframe>
<form action="BankingServlet" method="post" target="adminmenu">
<button class="button" type="submit" name="button" value="Home">Home</button>
<button class="button" type="submit" name="button" value="View Accounts">View Accounts</button>
<button class="button"type="submit" name="button" value="View Details">View Details</button>
<button class="button" type="submit" name="button" value="Add User">Add User</button>
<button class="button" type="submit" name="button" value="Add Account">Add Account</button>
</form>
<div class="fixed" >
<div class="dropdown">
<button class="dropbutton"><i class="material-icons">menu</i></button>
<div class="content">
<form action="BankingServlet" method="post" target="adminmenu">
<button class="button1" type="submit" name="button" value="Change Password">Change Password</button>
</form>
<form action="BankingServlet" method="post">
<button class="button1" type="submit" name="button" value="LogOut">LogOut</button>
</form>
</div>
</div>
</div>
</body>
</html>
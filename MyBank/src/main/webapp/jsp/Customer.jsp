<!DOCTYPE html>
<html>
<head>
<title>Customer page</title>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="css/ButtonDesign.css">
</head>
<body>
<h1 align="center">Happy Bank Welcome's You</h1>
<iframe  style="border: none;" src="jsp/CustomerMainPage.jsp" name="customermenu" height="650" width="1200" align="right"></iframe>
<form action="BankingServlet" method="post" target="customermenu">
<div style="margin-top:20px;">
<button class="button" type="submit" name="button" value="home"><i class="fas fa-home">
home</i></button>
<button class="button" type="submit" name="button" value="View Account">View Account</button>
<button class="button" type="submit" name="button" value="Transfer">Transfer</button>
<button class="button" type="submit" name="button" value="Statement">Statement</button>
</div>
</form>
<div class="fixed" >
<div class="dropdown">
<button class="dropbutton"><i class="fas fa-user-plus"></i></button>
<div class="content">
<form action="BankingServlet" method="post" target="customermenu">
<button class="button1" type="submit" name="button" value="View detail">View detail</button>
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





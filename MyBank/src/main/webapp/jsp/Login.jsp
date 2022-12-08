<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<style >
body
{
    height:725px;
    background: linear-gradient(to bottom, #ff66cc 0%, #ccff99 100%);
}
table {
  font-family: arial, sans-serif;
  border:none;border-radius: 20px;
  position: absolute;
  top:200px;
  left:500px;
  padding: 30px 50px;
  background: #ffe6e6;
}
input[type=text], input[type=password]
{
  border:none;border-radius: 15px;
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  border: 2px solid #ccc;
  box-sizing: border-box;
}
.button
{
border:none;border-radius: 20px;
border: 2px solid #ccc;
text-align: center;
background-color:White;
color:  solid Black;
font-weight: bold; 
cursor: pointer;
padding: 16px 32px;
width:200px; 
}
.button:hover
{
   background-color:#D3D3D3;
   color:  white;
}
</style>
</head>
<body>
<h1 align="center">Happy Bank</h1>
<h1 align="center">Login</h1>
<form action="../BankingServlet" method="post">
<h1 align="center">${message}</h1>
<c:remove var="message" scope="session" /> 
<table>
<tr>
<td>USER-ID </td></tr>
<tr><td><input type="text" name="userid" placeholder="Enter UserId" pattern="[0-9]{3}" title="please enter correct customer id" required></td></tr>
<tr>
<td >PASSWORD </td></tr>
<tr><td><input type="password" name="password" placeholder="Enter Password"  required></td>
</tr>
<tr></tr><tr></tr>
<tr>
<td><button class="button" type="submit" name="button" value="Login" >Login</button>
<button class="button" type="reset" value="Reset">Reset</button>
</td></tr>
</table>
</form>
</body>
</html>
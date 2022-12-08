<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin detail page</title>
<style type="text/css">
body
{
	 height:575px;
    background:linear-gradient(to bottom, #ffcccc 30%, #ccffff 70%);
}
table.center 
{
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
    text-align: left;
    padding: 8px;
}
th
{
   
    text-align: center;
    padding: 8px;
}
tr:nth-child(odd){background-color: #ccffff ;}
tr:nth-child(even){background-color: #ffcccc ;}

tr:first-child th:first-child { border-top-left-radius: 20px; }
tr:first-child th:last-child { border-top-right-radius: 20px; }

tr:first-child td:first-child { border-top-left-radius: 30px; }
tr:first-child td:last-child { border-top-right-radius: 30px; }

tr:last-child td:first-child { border-bottom-left-radius: 20px; }
tr:last-child td:last-child { border-bottom-right-radius: 20px; }

</style>

</head>
<body>
<form>
<h1>All Request</h1>
<table class="center">
<tr>
<th>Account No</th>
<th>Request</th>
<th>Amount</th>
<th>Approve</th>
<th>DisApprove</th>
</tr>
<tr>
<td>35789512365</td>
<td>withdraw</td>
<td>100000</td>
<td><input type="button" value="approve"></td>
<td><input type="button" value="disapprove"></td>

</table>
</form>
</body>
</html>
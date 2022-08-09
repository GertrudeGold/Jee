<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Account</title>

</head>
<body>

<h1>Modify account</h1>
<form action="ModifyAccount" method="POST">
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td>Lastname</td>
		<td><input type="text" name="lastname" value="<%= %>" size="20" required></td>
	</tr>
	<tr>
		<td>Firstname</td>
		<td><input type="text" name="firstname" value="<%= %>" size="20" required></td>
	</tr>	
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" value="<%= %>" size="20" required></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="Modify"></td>
	</tr>
	</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
</head>
<body>
<h1>Modify vehicle</h1>
<form action="ModifyVehicle" method="POST">
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td> Vehicle type </td>
		<td><input type="text" name="type" value="" size="20" required></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="Modify"></td>
	</tr>
	</table>
</form>
</body>
</html>
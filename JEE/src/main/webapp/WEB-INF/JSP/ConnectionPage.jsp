<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/Views/exceptionError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connection page</title>
</head>
<body>
<h1>Connection</h1>
<form action="Authentication" method="POST">
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td> Matricule : </td>
		<td><input type="text" name="matricule" value=""size="20" required></td>
	<tr>
		<td> Password : </td>
		<td><input type="password" name="password" value="" size="20" required></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="Submit"></td>
	</tr>
	</table>
</form>
</body>
</html>

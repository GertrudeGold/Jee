<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
</head>
<body>
<h1>Create account</h1>
<form action="AddAccount" method="POST">
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td>Account type</td>
		<td>
		<select name="type">
			<option value="Administrator">Administrator</option>
			<option value="BrigadeChief">Brigade chief</option>
			<option value="Collector">Collector</option>
			<option value="Policeman">Policeman</option>
		</select>
		<% 
		String type = request.getParameter("type");
		if(type != null && type == "Policeman")
		{%>
			<tr>
			<td>Chief Id</td>
			<td><input type="text" name="ChiefId" value="" size="20"></td>
			</tr>
		<%}
		%>
	<tr>
		<td>Lastname</td>
		<td><input type="text" name="lastname" value="" size="20" required></td>
	</tr>
	<tr>
		<td>Firstname</td>
		<td><input type="text" name="firstname"  value="" size="20" required></td>
	</tr>	
	<tr>
		<td>Password</td>
		<td><input type="password" name="password"  value="" size="20" required></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="Create"></td>
	</tr>
	</table>
</form>
</body>
</html>
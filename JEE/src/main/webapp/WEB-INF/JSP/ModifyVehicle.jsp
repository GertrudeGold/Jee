<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="appli.Javabeans.Vehicle" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
</head>
<body>
<% Vehicle vehicle = (Vehicle)request.getAttribute("vehicle"); %>

<h1>Modify vehicle</h1>
<form action="ModifyVehicle" method="POST">
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td> Vehicle type </td>
		<td><input type="text" name="type" value="<%= vehicle.getType() %>" size="20" required></td>
	</tr>
	<tr>
		<input style ="display : none "type="text" name="oldType" value="<%= vehicle.getType() %>" size="20">
		<td colspan="2" align="center"><input type="submit" name="submit" value="Modify"></td>
	</tr>
	</table>
</form>
</body>
</html>
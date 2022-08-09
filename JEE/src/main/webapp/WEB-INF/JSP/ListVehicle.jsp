<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="appli.Javabeans.Vehicle" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of account</title>
</head>
<body>
<% ArrayList<Vehicle> vehicles=(ArrayList<Vehicle>) request.getAttribute("vehicles");%>

<table cellspacing="1" cellpadding="4" border="3">
	<thead>
		<tr>
			<th>Id</<th>
			<th>Type</<th>
			<th>Modify</<th>
			<th>Delete</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<vehicles.size();i++){
		Vehicle vehicle=vehicles.get(i);%>
		<tr>
			<td><%= vehicle.getId() %></td>
			<td><%= vehicle.getType() %></td>
			<form action="??" method="post">
			<td><input type="submit" name="Modify" value="Modify"></td>
			<td><input type="submit" name="Delete" value="Delete"></td>
			</form>
		</tr>
	<%} 
	%>
	</tbody>
</table>
<br>
<form action="??" method="post">
	<td><input type="submit" name="Create" value="Create"></td>
</form>
</body>
</html>
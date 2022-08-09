<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="Javabeans.Vehicle" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of vehicle</title>
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
			<form action="RedirectAdministrator" method="post">
			<td><button type="submit" name="ModifyVehicle" value="<% request.setAttribute("vehicle", vehicle); %>">Modify</button></td>
			<td><button type="submit" name="DeleteVehicle" value="<% request.setAttribute("vehicle", vehicle); %>">Delete</button></td>
			</form>
		</tr>
	<%} 
	%>
	</tbody>
</table>
<br>
<form action="RedirectAdministrator" method="post">
	<td><input type="submit" name="Create" value="Create"></td>
</form>
</body>
</html>
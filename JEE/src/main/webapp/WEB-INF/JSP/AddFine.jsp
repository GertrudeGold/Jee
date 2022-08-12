<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="appli.Javabeans.Violation" %>
<%@page import="appli.Javabeans.Vehicle" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Fine</title>
</head>
<body>
<% ArrayList<Violation> violations=(ArrayList<Violation>) request.getAttribute("violations");%>
<% ArrayList<Vehicle> vehicles=(ArrayList<Vehicle>) request.getAttribute("vehicles");%>

<form action="AddFine" method="POST">
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td>Violation type</td>
		<td>
		<select name="violationType">
		<% for(int i=0;i<violations.size();i++){
		Violation violation =violations.get(i);%>
		<option value="<%= violation.getId() %>"><%= violation.getType() %></option>
	<%} 
	%>
		</select>
	</tr>
	<tr>
		<td>Vehicle type</td>
		<td>
		<select name="vehicleType">
		<% for(int i=0;i<vehicles.size();i++){
		Vehicle vehicle =vehicles.get(i);%>
		<option value="<%=vehicle.getId() %>"><%= vehicle.getType() %></option>
	<%} 
	%>
		</select>
	</tr>
	<tr>
		<td>Plate number</td>
		<td><input type="text" name="plateNumber"  value="" size="20" required></td>
	</tr>
	<tr>
		<td>Date</td>
		<td><input type="datetime-local" name="date"  value="" required></td>
	</tr>	
	<tr>
		<td>Lastname</td>
		<td><input type="text" name="lastname" value="" size="20" required></td>
	</tr>
	<tr>
		<td>Firstname</td>
		<td><input type="text" name="firstname" value="" size="20" required></td>
	</tr>
	<tr>
		<td>Commentary</td>
		<td><input type="text" name="commentary" value="" size="100" required></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="Create"></td>
	</tr>
	</table>
</form>
</body>
</html>
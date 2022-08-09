<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="Javabeans.Fine" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of validated fine</title>
</head>
<body>
<% ArrayList<Fine> fines=(ArrayList<Fine>) request.getAttribute("fines");%>

<table cellspacing="1" cellpadding="4" border="3">
	<thead>
		<tr>
			<th>Id</<th>
			<th>Policeman id</<th>
			<th>Vehicle</<th>
			<th>Plate</<th>
			<th>Date</<th>
			<th>Lastname</<th>
			<th>Firstname</<th>
			<th>Comment</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<fines.size();i++){
		Fine fine=fines.get(i);%>
		<tr>
			<td><%= fine.getId() %></td>
			<td><%= fine.getPoliceman().getId() %></td>
			<td><%= fine.getTypeVehicle().getType() %></td>
			<td><%= fine.getPlate().getPlateinformation() %></td>
			<td><%= fine.getDate() %></td>
			<td><%= fine.getGultyLastName() %></td>
			<td><%= fine.getGultyFirstName() %></td>
			<td><%= fine.getComment() %></td>		
		</tr>
	<%} 
	%>
	</tbody>
</table>
</body>
</html>
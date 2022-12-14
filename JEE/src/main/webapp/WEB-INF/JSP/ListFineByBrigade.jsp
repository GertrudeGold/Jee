<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="appli.Javabeans.Fine" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of fine by brigade</title>
</head>
<body>
<% ArrayList<Fine> fines=(ArrayList<Fine>) request.getAttribute("fines");%>

<form action="RedirectBrigadeChief" method="post">
	<td><button type="submit" name="Home" value="Home">Home</button></td>
</form>
<br>

<table cellspacing="1" cellpadding="4" border="3">
	<thead>
		<tr>
			<th>Id</<th>
			<th>Policeman</<th>
			<th>Vehicle</<th>
			<th>Plate</<th>
			<th>Date</<th>
			<th>Lastname</<th>
			<th>Firstname</<th>
			<th>Comment</<th>
			<th>Validate</<th>
			<th>Unvalidate</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<fines.size();i++){
		Fine fine=fines.get(i);%>
		<tr>
			<td><%= fine.getId() %></td>
			<td><%= fine.getPoliceman().getLastname() %></td>
			<td><%= fine.getTypeVehicle().getType() %></td>
			<td><%= fine.getPlate().getPlateinformation() %></td>
			<td><%= fine.getDate() %></td>
			<td><%= fine.getGultyLastName() %></td>
			<td><%= fine.getGultyFirstName() %></td>
			<td><%= fine.getComment() %></td>		
			<form action="RedirectBrigadeChief" method="post">
			<input type="hidden" name="idFine" value="<%= fine.getId() %>"/>
			<td><button type="submit" name="Validate" value="Validate">Validate</button></td>
			<td><button type="submit" name="Unvalidate" value="Unvalidate">Unvalidate</button></td>
			</form>
		</tr>
	<%} 
	%>
	</tbody>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="appli.Javabeans.Fine" %>
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
			<th>Policeman</<th>
			<th>Vehicle</<th>
			<th>Plate</<th>
			<th>Date</<th>
			<th>Lastname</<th>
			<th>Firstname</<th>
			<th>Comment</<th>
			<th>Send mail</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<fines.size();i++){
		Fine fine=fines.get(i);%>
		<tr>
			<td><%= fine.getId() %></td>
			<td><%= fine.getPoliceman().getFirstname() %></td>
			<td><%= fine.getTypeVehicle().getType() %></td>
			<td><%= fine.getPlate().getPlateinformation() %></td>
			<td><%= fine.getDate() %></td>
			<td><%= fine.getGultyLastName() %></td>
			<td><%= fine.getGultyFirstName() %></td>
			<td><%= fine.getComment() %></td>		
			<form action="RedirectCollector" method="post">
			<td><button type="submit" name="sendMail" value="sendMail">Send mail</button></td>
			</form>
		</tr>
	<%} 
	%>
	</tbody>
</table>
</body>
</html>
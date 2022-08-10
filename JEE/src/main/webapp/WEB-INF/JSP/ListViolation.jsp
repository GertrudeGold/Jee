<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="appli.Javabeans.Violation" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of violation</title>
</head>
<body>
<% ArrayList<Violation> violations=(ArrayList<Violation>) request.getAttribute("violations");%>

<table cellspacing="1" cellpadding="4" border="3">
	<thead>
		<tr>
			<th>Id</<th>
			<th>Type</<th>
			<th>Amount</<th>
			<th>Modify</<th>
			<th>Delete</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<violations.size();i++){
		Violation violation=violations.get(i);%>
		<tr>
			<td><%= violation.getId() %></td>
			<td><%= violation.getType() %></td>
			<td><%= violation.getPrice() %></td>
			<form action="RedirectAdministrator" method="post">
			<td><button type="submit" name="ModifyViolation" value="<%= request.setAttribute("violation", violation) %>">Modify</button></td>
			<td><button type="submit" name="DeleteViolation" value="<%= request.setAttribute("violation", violation) %>">Delete</button></td>
			</form>
		</tr>
	<%} 
	%>
	</tbody>
</table>
<br>
<form action="RedirectAdministrator" method="post">
	<td><input type="submit" name="CreateViolation" value="Create"></td>
</form>
</body>
</html>
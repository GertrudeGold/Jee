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

<form action="RedirectCollector" method="post">
	<td><button type="submit" name="Home" value="Home">Home</button></td>
</form>
<br>

<table cellspacing="1" cellpadding="4" border="3">
	<thead>
		<tr>
			<th>Id</<th>
			<th>Type</<th>
			<th>Amount</<th>
			<th>Modify</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<violations.size();i++){
		Violation violation=violations.get(i);%>
		<tr>
			<td><%= violation.getId() %></td>
			<td><%= violation.getType() %></td>
			<td><%= violation.getPrice() %></td>
			<form action="RedirectCollector" method="post">
			<input type="hidden" name="typeViolation" value="<%= violation.getType() %>"/>
			<td><button type="submit" name="ModifyViolation" value="Modify">Modify</button></td>
			</form>
		</tr>
	<%} 
	%>
	</tbody>
</table>
<br>
</body>
</html>
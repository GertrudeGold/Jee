<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="Javabeans.Staff" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of account</title>
</head>
<body>
<% ArrayList<Staff> accounts=(ArrayList<Staff>) request.getAttribute("Accounts");%>

<table cellspacing="1" cellpadding="4" border="3">
	<thead>
		<tr>
			<th>Id</<th>
			<th>Lastname</<th>
			<th>Firstname</<th>
			<th>Matricule</<th>
			<th>Password</<th>
			<th>Modify</<th>
			<th>Delete</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<accounts.size();i++){
		Staff account=accounts.get(i);%>
		<tr>
			<td><%= account.getId() %></td>
			<td><%= account.getLastname() %></td>
			<td><%= account.getFirstname() %></td>
			<td><%= account.getMatricule() %></td>
			<td><%= account.getPassword() %></td>
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
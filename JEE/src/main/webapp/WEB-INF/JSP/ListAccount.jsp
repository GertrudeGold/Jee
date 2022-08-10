<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="appli.Javabeans.Administrator" %>
<%@page import="appli.Javabeans.BrigadeChief" %>
<%@page import="appli.Javabeans.Collector" %>
<%@page import="appli.Javabeans.Policeman" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of account</title>
</head>
<body>
<% ArrayList<Administrator> adAccounts=(ArrayList<Administrator>)request.getAttribute("adAccounts");%>
<% ArrayList<Collector> coAccounts=(ArrayList<Collector>) request.getAttribute("coAccounts");%>
<% ArrayList<Policeman> pmAccounts=(ArrayList<Policeman>) request.getAttribute("pmAccounts");%>
<% ArrayList<BrigadeChief> bcAccounts=(ArrayList<BrigadeChief>) request.getAttribute("bcAccounts");%>

<form action="RedirectAdministrator" method="post">
	<td><input type="submit" name="CreateAccount" value="Create"></td>
</form>
<h2>Administrator</h2>
<table cellspacing="1" cellpadding="4" border="3">
	<thead>
		<tr>
			<th>Id</<th>
			<th>Lastname</<th>
			<th>Firstname</<th>
			<th>Matricule</<th>
			<th>Modify</<th>
			<th>Delete</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<adAccounts.size();i++){
		Administrator account=adAccounts.get(i);%>
		<tr>
			<td><%= account.getId() %></td>
			<td><%= account.getLastname() %></td>
			<td><%= account.getFirstname() %></td>
			<td><%= account.getMatricule() %></td>
			<form action="RedirectAdministrator" method="post">
			<td><button type="submit" name="ModifyAccount" value="<% request.setAttribute("account", account); %>">Modify</button></td>
			<td><button type="submit" name="DeleteAccount" value="<% request.setAttribute("account", account); %>">Delete</button></td>
			</form>
		</tr>
	<%} 
	%>
	</tbody>
</table>
<br>
<h2>BrigadeChief</h2>
<table cellspacing="1" cellpadding="4" border="3">
	<thead>
		<tr>
			<th>Id</<th>
			<th>Lastname</<th>
			<th>Firstname</<th>
			<th>Matricule</<th>
			<th>Modify</<th>
			<th>Delete</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<bcAccounts.size();i++){
		BrigadeChief account=bcAccounts.get(i);%>
		<tr>
			<td><%= account.getId() %></td>
			<td><%= account.getLastname() %></td>
			<td><%= account.getFirstname() %></td>
			<td><%= account.getMatricule() %></td>
			<form action="RedirectAdministrator" method="post">
			<td><button type="submit" name="ModifyAccount" value="<% request.setAttribute("account", account); %>">Modify</button></td>
			<td><button type="submit" name="DeleteAccount" value="<% request.setAttribute("account", account); %>">Delete</button></td>
			</form>
		</tr>
	<%} 
	%>
	</tbody>
</table>
<br>
<h2>Collector</h2>
<table cellspacing="1" cellpadding="4" border="3">
	<thead>
		<tr>
			<th>Id</<th>
			<th>Lastname</<th>
			<th>Firstname</<th>
			<th>Matricule</<th>
			<th>Modify</<th>
			<th>Delete</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<coAccounts.size();i++){
		Collector account=coAccounts.get(i);%>
		<tr>
			<td><%= account.getId() %></td>
			<td><%= account.getLastname() %></td>
			<td><%= account.getFirstname() %></td>
			<td><%= account.getMatricule() %></td>
			<form action="RedirectAdministrator" method="post">
			<td><button type="submit" name="ModifyAccount" value="<% request.setAttribute("account", account); %>">Modify</button></td>
			<td><button type="submit" name="DeleteAccount" value="<% request.setAttribute("account", account); %>">Delete</button></td>
			</form>
		</tr>
	<%} 
	%>
	</tbody>
</table>
<br>
<h2>Policeman</h2>
<table cellspacing="1" cellpadding="4" border="3">
	<thead>
		<tr>
			<th>Id</<th>
			<th>Lastname</<th>
			<th>Firstname</<th>
			<th>Matricule</<th>
			<th>Modify</<th>
			<th>Delete</<th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<pmAccounts.size();i++){
		Policeman account=pmAccounts.get(i);%>
		<tr>
			<td><%= account.getId() %></td>
			<td><%= account.getLastname() %></td>
			<td><%= account.getFirstname() %></td>
			<td><%= account.getMatricule() %></td>
			<form action="RedirectAdministrator" method="post">
			<td><button type="submit" name="ModifyAccount" value="<% request.setAttribute("account", account); %>">Modify</button></td>
			<td><button type="submit" name="DeleteAccount" value="<% request.setAttribute("account", account); %>">Delete</button></td>
			</form>
		</tr>
	<%} 
	%>
	</tbody>
</table>
<br>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="appli.Javabeans.Staff" %>
<%@page import="appli.Javabeans.Administrator" %>
<%@page import="appli.Javabeans.Collector" %>
<%@page import="appli.Javabeans.BrigadeChief" %>
<%@page import="appli.Javabeans.Policeman" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Account</title>

</head>
<body>
<% Staff staff = (Staff)request.getAttribute("account"); %>
<h1>Modify account</h1>
<form action="ModifyAccount" method="POST">
	<table border="1" cellspacing="0" cellpadding="5">
	
	<tr>
		<td>Lastname</td>
		<td><input type="text" name="lastname" value="<%= staff.getLastname()  %>" size="20" required></td>
	</tr>
	<tr>
		<td>Firstname</td>
		<td><input type="text" name="firstname" value="<%= staff.getFirstname() %>" size="20" required></td>
	</tr>	
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" value="<%= staff.getPassword() %>" size="20" required></td>
	</tr>
	<tr>
		<input style ="display : none "type="text" name="matricule" value="<%= staff.getMatricule() %>" size="20">
		<td colspan="2" align="center"><input type="submit" name="submit" value="Modify"></td>
		
	</tr>
	</table>
</form>
</body>
</html>
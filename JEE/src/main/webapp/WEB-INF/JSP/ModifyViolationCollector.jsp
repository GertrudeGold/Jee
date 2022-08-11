<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="appli.Javabeans.Violation" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify violation</title>
</head>
<body>
<% Violation violation = (Violation)request.getAttribute("violation"); %>

<h1>Modify Violation</h1>
<form action="ModifyViolationCollector" method="POST">
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td>Violation type : </td>
		<td><label><%= violation.getType() %></label></td>
	</tr>
	<tr>
		<td>Amount</td>
		<td><input type="text" name="amount" value="<%= violation.getPrice() %>" size="20" required></td>
	</tr>	
	<tr>
		<input style ="display : none "type="text" name="oldType" value="<%= violation.getType() %>" size="20">
		<td colspan="2" align="center"><input type="submit" name="submit" value="Modify"></td>
	</tr>
	</table>
</form>
</body>
</html>
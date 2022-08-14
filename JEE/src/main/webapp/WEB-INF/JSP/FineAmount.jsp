<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fine amount</title>
</head>
<body>
<h1> <%= request.getAttribute("lastname") %> <%= request.getAttribute("firstname") %> have to pay <%= request.getAttribute("Total") %> euros</h1>
<br>
<h1> <%= request.getAttribute("lackInsurance") %></h1>
<form action="RedirectPoliceman" method="post">
	<td><button type="submit" name="Home" value="Home">Home</button></td>
</form>
</body>
</html>
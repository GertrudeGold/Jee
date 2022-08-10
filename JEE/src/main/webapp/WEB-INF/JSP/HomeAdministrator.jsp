<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page - Administrator</title>
</head>
<body>
<h1>Bienvenue ${ConnectedStaff.firstname} ${ConnectedStaff.lastname}</h1>
<form action="RedirectAdministrator" method="post">
    <input type="submit" name="ManageAccount" value="Manage account" />
    <input type="submit" name="ManageVehicle" value="Manage vehicle" />
    <input type="submit" name="ManageViolation" value="Manage violation" />
</form>
</body>
</html>
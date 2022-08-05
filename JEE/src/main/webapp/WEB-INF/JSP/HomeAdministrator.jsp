<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page - Administrator</title>
</head>
<body>
<h1>>Bienvenue ${ConnectedStaff.firstname} ${ConnectedStaff.lastname}</h1>

<form action="RedirectAdministrator" method="post">
    <input type="submit" name="button1" value="Manage account" />
    <input type="submit" name="button2" value="Manage vehicle" />
    <input type="submit" name="button3" value="Manage violation" />
</form>

</body>
</html>
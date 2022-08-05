<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page - Collector</title>
</head>
<body>
<h1>>Bienvenue ${ConnectedStaff.firstname} ${ConnectedStaff.lastname}</h1>

<form action="RedirectCollector" method="post">
    <input type="submit" name="button1" value="Manage violation amount" />
    <input type="submit" name="button2" value="See validated fine" />
</form>

</body>
</html>
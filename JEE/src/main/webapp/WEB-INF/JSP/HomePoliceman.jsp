<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page - Policeman</title>
</head>
<body>
<h1>Welcome ${ConnectedStaff.firstname} ${ConnectedStaff.lastname}</h1>

<form action="RedirectPoliceman" method="post">
    <input type="submit" name="CreateFine" value="Create a new fine" />
</form>

</body>
</html>
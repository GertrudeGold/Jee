<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page - Brigade chief</title>
</head>
<body>
<h1>Welcome ${ConnectedStaff.firstname} ${ConnectedStaff.lastname}</h1>

<form action="RedirectBrigadeChief" method="post">
    <input type="submit" name="brigadeFine" value="Manage brigade's fine" />
</form>

</body>
</html>
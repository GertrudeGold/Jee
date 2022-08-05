<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
<<<<<<< HEAD
<script type="text/javascript" src="main.js"></script>
=======
>>>>>>> branch 'master' of https://github.com/GertrudeGold/Jee.git
</head>
<body>
<script type="text/javascript">
  function AddAccountSelected() 
{
  if(document.getElementById("Selectedvalue") == "Policeman")
  {
      document.getElementById("ChiefIdInput").style.display = "compact";
  }
}
</script>
<h1>Create account</h1>
<form action="AddAccount" method="POST">
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td>Account type</td>
		<td>
<<<<<<< HEAD
		<select name="type" id="Selectedvalue" onChange="AddAccountSelected();" >
=======
		<select name="type" id="Selectedvalue" onChange="AddAccountSelected()" >
>>>>>>> branch 'master' of https://github.com/GertrudeGold/Jee.git
			<option value="Administrator">Administrator</option>
			<option value="BrigadeChief">Brigade chief</option>
			<option value="Collector">Collector</option>
			<option value="Policeman">Policeman</option>
		</select>
		
			<tr style="display: none" id="ChiefIdInput">
			<td>Chief Id</td>
			<td><input type="text" name="ChiefId" value="" size="20"></td>
			</tr>
	<tr>
		<td>Lastname</td>
		<td><input type="text" name="lastname" value="" size="20" required></td>
	</tr>
	<tr>
		<td>Firstname</td>
		<td><input type="text" name="firstname"  value="" size="20" required></td>
	</tr>	
	<tr>
		<td>Password</td>
		<td><input type="password" name="password"  value="" size="20" required></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="Create"></td>
	</tr>
	</table>
</form>
</body>
</html>
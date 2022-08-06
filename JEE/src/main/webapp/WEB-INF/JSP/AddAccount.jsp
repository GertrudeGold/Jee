<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
<script type="text/javascript">
	function showDiv(divId, element)
    {
    	document.getElementById(divId).style.display = element.value == 4 ? 'table-row' : 'none';
    }
</script>
</head>
<body>
<h1>Create account</h1>
<form action="AddAccount" method="POST">
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td>Account type</td>
		<td>
		<select id="test" name="SelectedType" onchange="showDiv('hidden_div', this)">
           <option value=1>Administrator</option>
           <option value=2>Collector</option>
           <option value=3>BrigadeChief</option>
           <option value=4>Policeman</option>
        </select>
        </td>
        	<tr style="display: none" id="hidden_div">
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<script type="text/javascript" src="js/convalida.js">
</script>
</head>
<body>
<h3>Inserire i dati per login</h3>
<form action="controllo.jsp" method="post" onsubmit="javascript:return checkLogin();">
<table>
	<tr> 
		<td>Username</td>
		<td><input type="text" name="username" id="username"></td>
		<td style="width:500px;"><span id="infoUsername"></span></td>
	</tr>
	<tr> 
		<td>Password</td>
		<td><input type="password" name="password" id="password"></td>
		<td style="width:500px;"><span id="infoPassword"></span></td>
	</tr>
	<tr> 
		<td colspan="2"><input type="submit" value="login"></td>
	</tr>
</table>
</form>
</body>
</html>
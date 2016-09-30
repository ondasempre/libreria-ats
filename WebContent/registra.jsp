<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Registrazione</title>
<script type="text/javascript" src="js/convalida.js">
</script>
</head>
<body>
<h3>Inserire i dati per la registrazione</h3>
<form action="salvadati.jsp" method="post" onsubmit="javascript:return checkRegistrazione();">
<table>
	<tr> 
		<td style="width:150px;">Nome</td>
		<td style="width:300px;"><input type="text" name="nome" id="nome"></td>
		<td style="width:500px;"><span id="infoNome"></span></td>
	</tr>
	<tr> 
		<td>Cognome</td>
		<td><input type="text" name="cognome" id="cognome"></td>
		<td style="width:500px;"><span id="infoCognome"></span></td>
	</tr>
	<tr> 
		<td>Indirizzo</td>
		<td><textarea cols="30" rows="3" name="indirizzo" id="indirizzo"></textarea></td>
		<td style="width:500px;"><span id="infoIndirizzo"></span></td>
	</tr>
	<tr> 
		<td>Cap</td>
		<td><input type="text" name="cap" maxlength="5" id="cap"></td>
		<td style="width:500px;"><span id="infoCap"></span></td>
	</tr>
	<tr> 
		<td>Nascita</td>
		<td><input type="text" name="nascita" placeholder="dd/MM/yyyy" id="nascita"></td>
		<td style="width:500px;"><span id="infoNascita"></span></td>
	</tr>
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
		<td>Email</td>
		<td><input type="text" name="email" id="email"></td>
		<td style="width:500px;"><span id="infoEmail"></span></td>
	</tr>
	<tr> 
		<td><input type="reset" value="Cancella modulo"></td>
		<td colspan="2"><input type="submit" value="Registrati"></td>
	</tr>
</table>
</form>
</body>
</html>
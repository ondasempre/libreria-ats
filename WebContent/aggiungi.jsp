<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>

<%@page import="com.ats.beans.Articolo" %>
<!DOCTYPE html>
<html>
<head>
<title>Inserisci</title>
<script type="text/javascript" src="js/convalida.js">
</script>
</head>
<body>
<h3>Inserire i dati libro</h3>

<form action="/libreriaprova/salvalibro" method="post">

<table>
	
	<tr> 
		<td style="width:150px;">Titolo</td>
		<td style="width:300px;"><input type="text" name="titolo" id="titolo"></td>
	</tr>
	<tr> 
		<td>Autore</td>
		<td><input type="text" name="autore" id="autore"></td>
	</tr>
	<tr> 
		<td>Prezzo</td>
		<td><input type="text" name="prezzo" id="prezzo"></td>
	</tr>
	<tr> 
		<td ><input type="submit" value="inserisci"></td>
	</tr>
</table>
	<a href="visualizzacatalogo.jsp">torna al catalogo</a>
</form>
</body>
</html>
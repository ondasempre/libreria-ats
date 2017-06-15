<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>
<%@page import="com.ats.beans.Articolo" %>
<!DOCTYPE html>
<html>
<head>
<title>Modifica</title>
<script type="text/javascript" src="js/convalida.js">
</script>
</head>
<body>
<h3>Inserire i dati da modificare</h3>

<form action="/libreriaprova/modificalibro" method="post">

<table>
	
	<tr> 
		<td style="width:150px;">Titolo</td>
		<td style="width:300px;"><input type="text"name="titolo" value="<%=request.getParameter("titolo") %>"></td>
	</tr>
	<tr> 
		<td>Autore</td>
		<td><input type="text" name="autore" value="<%=request.getParameter("autore") %>"></td>
	</tr>
	<tr> 
		<td>Prezzo</td>
		<td><input type="text" name="prezzo" value="<%=request.getParameter("prezzo") %>"></td>
	</tr>
	<tr> 
		<td></td>
		<td><input type="hidden" name="id" value="<%=request.getParameter("id") %>"></td>
	</tr>
	<tr> 
		<td ><input type="submit" value="modifica"></td>
		<td ><input type="reset" value="annulla"></td>
	</tr>
</table>
	<a href="visualizzacatalogo.jsp">torna al catalogo</a>
</form>
</body>
</html>
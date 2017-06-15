<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="data" scope="request" class="com.ats.beans.DataConnect" />
<%@page import="com.ats.beans.Articolo" %>
<!-- qui possono accedere solo gli utenti registrati che hanno fatto il log in -->
<%
	String username = (String)session.getAttribute("username");
	if(username == null){
%>
<%@include file="accessonegato.html" %>
<%
	} else {
%>

<!DOCTYPE html>
<html>
<head>
<title>visualizza catalogo</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<form action="aggiungi.jsp" method="post">
<input type="submit" value="aggiungi">
</form>
	<h3>Lista Articoli</h3>
	
	<table style="width:100%">
	<tr>
		<td style="width:20%">Titolo</td>
		<td style="width:20%">Autore</td>
		<td style="width:20%">Prezzo</td>
	</tr>
<%
	Articolo[] articoli=data.getArticoli();
	for(int i=0;i<articoli.length;i++)
	{
	%>
	<tr>
		<td><%=articoli[i].getTitolo() %></td>
		<td><%=articoli[i].getAutore() %></td>
		<td><%=String.format("%.2f",articoli[i].getPrezzo()) %></td>
		<td><form action="modifica.jsp" method="post">
		<input type="hidden" name="id" value="<%=articoli[i].getId_articolo() %>">
		<input type="hidden" name="titolo" value="<%=articoli[i].getTitolo() %>">
		<input type="hidden" name="autore" value="<%=articoli[i].getAutore() %>">
		<input type="hidden" name="prezzo" value="<%=articoli[i].getPrezzo() %>">
		<input type="submit" value="modifica">
		</form>
		</td>
		</tr>
		<%
		}
		%>
		
	</table>
	<br>
	<a href="report.jsp">indietro alla pagina principale</a>
</body>
</html>
<%
}
%>
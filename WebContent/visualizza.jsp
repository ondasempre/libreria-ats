<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="carrello" scope="session" class="com.ats.beans.Carrello"/>

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
<title>Riepilogo carrello</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>Lista articoli carrello</h3>
Quantit&agrave;<%=carrello.numeroArticoli() %>
<table style="width:100%">
	<tr>
		<td style="width=20%">Titolo</td>
		<td style="width=20%">Autore</td>
		<td style="width=20%">Totale Parziale</td>
		<td style="width=20%">Quantit&agrave;</td>
		<td style="width=20%">Elimina articolo</td>
	</tr>
<%
	Enumeration<String[]> enumerazione = carrello.enumerazione();
	String dati[];
	while(enumerazione.hasMoreElements()){
		dati = enumerazione.nextElement();
%>
	<tr>
		<td><%=dati[0] %></td>
		<td><%=dati[1] %></td>
		<td><%=String.format("%.2f", carrello.totaleParziale(dati[4])) %></td>
		<td><%=dati[3] %></td>
		<td><form action="/libreriaprova/rimuovi"method="post">
			<input type="submit" value="togli dal carrello">
			<input type="hidden" name="id" value="<%= dati[4] %>">
		</form></td>
	</tr>
<%
	}
%>
	<tr>
		<td colspan="5">Totale complessivo carrello: <%=String.format("%.2f",carrello.totaleComplessivo()) %></td>
	</tr>
</table>
<br>
<%
	if(carrello.totaleComplessivo() != 0){
%>
<h3>Conferma ordine</h3>
<form action="conferma.jsp">
<input type="submit" value="Ordina">
<input type="hidden" name="totale" value="<%=carrello.totaleComplessivo() %>">
<input type="hidden" name="username" value="<%=username %>">
</form>
<%
	}
%>
<br>
<a href="acquisti.jsp">Torna agli acquisti</a>
</body>
</html>
<%
	}
%>
<%
	String username = (String)session.getAttribute("username");
	if(username == null){
%>
<%@include file="accessonegato.html" %>
<%
	} else {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>
<%@ page import="com.ats.beans.Articolo" %>
<jsp:useBean id="carrello" scope="session" class="com.ats.beans.Carrello"/>
<jsp:useBean id="data" scope="request" class="com.ats.beans.DataConnect"/>
    
<!DOCTYPE html>
<html>
<head>
<title>Acquisti On-line</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>Lista articoli</h3>
<p>Totale carrello:&nbsp;<%=String.format("%.2f",carrello.totaleComplessivo())%>&#8364;</p>
<table style="width:100%">
	<tr>
		<td style="width=20%">id</td>
		<td style="width=20%">Titolo</td>
		<td style="width=20%">Autore</td>
		<td style="width=20%">Prezzo</td>
		<td style="width=20%">Ordine</td>
	</tr>
<%
	Articolo[] articoli = data.getArticoli();
	for(int i = 0; i<articoli.length; i++){
%>
	<tr>
		<td><%=articoli[i].getId_articolo()%></td>
		<td><%=articoli[i].getTitolo()%></td>
		<td><%=articoli[i].getAutore()%></td>
		<td><%=String.format("%.2f",articoli[i].getPrezzo())%></td>
	<!-- 	<td><form action="aggiungi.jsp" method="post">   -->
	<td><form action="/Libreria/aggiungi" method="post">
			<input type="submit" value="Aggiungi al carrello">
			<input type="hidden" name="id" value="<%=articoli[i].getId_articolo()%>">
			<input type="hidden" name="titolo" value="<%=articoli[i].getTitolo()%>">
			<input type="hidden" name="autore" value="<%=articoli[i].getAutore()%>">
			<input type="hidden" name="prezzo" value="<%=articoli[i].getPrezzo()%>">
		</form></td>
	</tr>
<%
	}
%>
</table>
<br><a href="visualizza.jsp">Prodotti ordinati attualmente sul carrello</a>
</body>
</html>
<%
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="data" scope="request" class="com.ats.beans.DataConnect"/>

<!-- qui possono accedere solo gli utenti admin -->
<%
	String username = (String)session.getAttribute("username");
	if(username == null || !username.equals("admin")){
%>
<%@include file="accessonegato.html" %>
<%
	} else {
%>

<!DOCTYPE html>
<html>
<head>
<title>Report</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>Riepilogo ordini</h3>
<table style="width:100%">
	<tr>
		<td style="width=20%">Username</td>
		<td style="width=20%">Email</td>
		<td style="width=20%">Id ordine</td>
		<td style="width=20%">Totale</td>
		<td style="width=20%">Quantit&agrave;</td>
	</tr>
<%
	Vector<String[]> dati = data.getReport();
	for(int i = 0; i<dati.size(); i++){
%>
	<tr>
<%
	String[] riga = dati.get(i);
		for(int j = 0; j<riga.length; j++){
%>
		<td><%=riga[j] %></td>
<%
		}
%>
	</tr>
<%
	}
%>
</table>


</body>
</html>
<%
	}
%>
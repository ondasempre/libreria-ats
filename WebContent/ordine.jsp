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
<title>Ordine confermato</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>Dati ordine</h3>
<p>Il tuo codice dell'ordine <%= session.getAttribute("idordine") %> </p>
<%
	session.removeAttribute("carrello"); //svuolo il carrello
	}
%>
	</body>
</html>

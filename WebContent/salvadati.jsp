<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="com.ats.businesscomponent.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="utente" scope="page" class="com.ats.beans.Utente"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<title>Registrazione</title>
</head>
<body>

<%
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	utente.setNome(request.getParameter("nome"));
	utente.setCognome(request.getParameter("cognome"));
	utente.setIndirizzo(request.getParameter("indirizzo"));
	utente.setCap(request.getParameter("cap"));
	utente.setNascita(formato.parse(request.getParameter("nascita")));
	utente.setUsername(request.getParameter("username"));
	utente.setPassword(request.getParameter("password"));
	utente.setEmail(request.getParameter("email"));
	
	String username = request.getParameter("username");
	
	UtenteBC utenteBC = new UtenteBC();
	utenteBC.create(utente);
	
	if(username == null) username = ""; //sql injection
	session.setAttribute("username", username);
%>
<h3>Registrazione completata con successo</h3>
<p><a href="acquisti.jsp">Procedi agli acquisti</a></p>
<%
	
%>
</body>
</html>
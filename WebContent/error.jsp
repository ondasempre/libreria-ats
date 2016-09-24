<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="com.ats.architecture.dao.*" %>

<!DOCTYPE html>
<html>
<head>
<title>Eccezione!</title>
</head>
<body>

<%
	if(exception instanceof ClassNotFoundException){
%>
<h3>Driver non trovato</h3>
<p>Stringa del driver sbagliata</p>
<p>Driver non presente in lib</p>
<%
	}else if(exception instanceof DAOException){
%>
<h3>DAOException</h3>
<p>Motivo: <%= exception.getMessage()%></p>
<p>Codice errore: <%= ((DAOException)exception).getMessaggio()%></p>
<%
	}else{
%>
<h3>Eccezione non prevista</h3>
<p>Motivo: <%= exception.getMessage()%></p>
<p>
<%
	exception.printStackTrace(new PrintWriter(out)); //così scrivo sulla pagina jsp
	}
%>
</body>
</html>
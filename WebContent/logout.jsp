<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>


<%
		session.invalidate(); //elimina tutti i dati della sessione
%>

<!DOCTYPE html>
<html>
<head>
<title>Logout</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>Hai appena effettuato il logout</h3>
<p>Se vuoi rientrare effettua il login</p>
</body>
</html>

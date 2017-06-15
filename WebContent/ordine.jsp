<%
	String username =(String)session.getAttribute("username");
		if(username==null){
%>
<%@include file="accessonegato.html" %>
<%
		}
		else{
%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Ordine confermato</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>Dati ordine</h3>
<p>Codice ordine:<%= session.getAttribute("idordine") %></p>
<%
	session.removeAttribute("carrello");
%>
<br>
<a href="acquisti.jsp">Compra ancora</a>
</body>
</html>
<%
	}
%>
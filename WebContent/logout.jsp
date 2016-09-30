
    <%@page errorPage="error.jsp" %>
    <%
    	
    String username=(String)session.getAttribute("username");
    if(username==null)
    {
  
    %>
    <%@include file="accessonegato.html" %>
    <%
    }
    else
    {
    session.invalidate();
    %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>logout</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h3>hai appena efettuato il logout</h3>
	<p>se voui rientrare effettua il login</p>
</body>
</html>
<%
}
%>
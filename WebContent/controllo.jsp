<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>
<%
	String user = request.getParameter("username");
	String pass = request.getParameter("password");
	
	if(user == null ) user = "";
	if(pass == null) pass = "";
	
	if(!user.equals("") && !pass.equals(""))
	{
%>
<jsp:useBean id="data" scope="session" class="com.ats.beans.DataConnect"/>
<%
	String[] userpass = data.getUsernamePassword(user);
	if(userpass != null)
	{
		if(userpass[1].equals(pass))
		{
			session.setAttribute("username", user);
			if(user.equals("admin")){
				response.sendRedirect("report.jsp");
			} else {
				response.sendRedirect("acquisti.jsp");
			}
		} else {
%>
<html>
<head>
<title>Errore!</title>
</head>
<body>

<h3>Password errata!</h3><br>
<a href="login.jsp">Ritenta</a>

</body>
</html>
<%
	}
		}else{
%>

<html>
<head>
<title>Errore</title>
</head>
<body>
<h3>Utente inesistente</h3>
<br>
<a href="login.jsp">Riprova il login se sei registrato</a>
<br>
<p>oppure</p>
<a href="registra.jsp">registrati</a>

</body>
</html>
<%
	}}
%>
<%@page errorPage="error.jsp" %>
<%
	String user=request.getParameter("username");
	String pass=request.getParameter("password");
	if(user== null)
		user="";
	if(pass==null)
		pass="";
	if(!user.equals("") && !pass.equals(""))
	{
		
%>
<jsp:useBean id="data" scope="request" class="com.ats.beans.DataConnect"/>
<%
	String[]userpass = data.getUsernamePassword(user);
	if(userpass != null)
	{
		if(userpass[1].equals(pass))
		{
			session.setAttribute("username", user);
			if(user.equals("admin"))
				response.sendRedirect("report.jsp");
			else
				response.sendRedirect("acquisti.jsp");
			
		}
		else
		{
%>

<html>
<head>
<title>Errore</title>
</head>
<body>
	<h3>Password Errata</h3>
	<br>
	<a href="login.jsp">ritenta!</a>
</body>
</html>
<%
		}
	}
	else
	{
	%>
<html>
<head>
<title>errore!</title>
</head>
<body>
<h3>utente inesistente!</h3>
<br>
<a href="login.jsp">riprova il login se sei registrato</a>
<br>
<p> oppure:</p>
<a href="registra.jsp">oppure registrati</a>
</body>
</html>
<%
	}
	}
%>
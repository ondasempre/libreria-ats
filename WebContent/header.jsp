<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<title>Header</title>
</head>
<body>

<table style="width:20%; height:5%">
	<tr>
		<td><h2>Negozio On-line</h2></td>
	</tr>
<%
	String username = (String)session.getAttribute("username");
	if(username == null){
%>
	<tr>
		<td><a href="login.jsp">Login</a></td>
	</tr>
<%
	} else{
%>
	<tr>
		<td><%=username %>&nbsp;&nbsp;&nbsp;<a href="logout.jsp">Logout</a></td>
	</tr>
<%
	}
%>
</table>

</body>
</html>
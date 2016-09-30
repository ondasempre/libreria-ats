<%
	String username=(String)session.getAttribute("username");
	

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page errorPage="error.jsp"%>
<jsp:useBean id="data"scope="request"class="com.ats.beans.DataConnect"/>





<!DOCTYPE html>
<html>
<head>
<title>Report</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<br>
	<a href="visualizzacatalogo.jsp">visualizza catalogo</a>
<h3>riepilogo ordini</h3>
<table style="width:100%">
<tr>
	<td style="width:20%">Username</td>
	<td style="width:20%">email</td>
	<td style="width:20%">idordine</td>
	<td style="width:20%">totale</td>
	<td style="width:20%">quantit&agrave;</td>
	</tr>
	<%
	Vector<String[]>dati=data.getReport();
	for(int i=0;i<dati.size();i++)
	{
	
	%>
	<tr>
		<%
		String[] riga=dati.get(i);
		for(int j=0;j<riga.length;j++)
		{
		%>
		<td><%=riga[j] %></td>
		
		<%
		}
		%>
		<td><form action="elimina.jsp">
		<input type="submit" value="elimina ordine">
		<input type="hidden" name="id_ordine" value="<%=riga[2]%>">
		<input type="hidden" name="username" value="<%=riga[0]%>">
		<input type="hidden" name="totale" value="<%=riga[3]%>">
		</form></td>
		
		</tr>
		<%
		}
		%>
	</table>
	

</body>
</html>

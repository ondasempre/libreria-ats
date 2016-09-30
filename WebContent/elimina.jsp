<%@page import="com.ats.beans.Ordine"%>
<%
	String username=(String)session.getAttribute("username");
	if(username==null || !username.equals("admin"))
	{


%>
<%@include file="accessonegato.html" %>
<%
	}
	else
	{

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page errorPage="error.jsp"%>
<jsp:useBean id="data"scope="request"class="com.ats.beans.DataConnect"/>
<%@page import="com.ats.businesscomponent.OrdineBC"%> 
<!DOCTYPE html>
<html>
<head>
<title>Elimina ordine</title>
</head>
<body>
	<%

	java.util.Date dat=data.getData(Integer.parseInt(request.getParameter("id_ordine")));
	Ordine ordine=new Ordine();
	ordine.setData(dat);
	ordine.setId_ordine(Integer.parseInt(request.getParameter("id_ordine")));
	ordine.setTotale(Double.parseDouble(request.getParameter("totale")));
	ordine.setUsername(request.getParameter("username"));
	OrdineBC ordineBC=new OrdineBC();
	ordineBC.elimina(ordine, Integer.parseInt(request.getParameter("id_ordine")));
	response.sendRedirect("report.jsp");
	%>

</body>
</html>
<%
}
%>
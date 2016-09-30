<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>
<%@page import="java.util.*" %>
<%@page import="com.ats.businesscomponent.*" %>
<jsp:useBean id="carrello" scope="session" class="com.ats.beans.Carrello"/>
<jsp:useBean id="ordine" scope="page" class="com.ats.beans.Ordine"/>
<jsp:useBean id="oa" scope="page" class="com.ats.beans.OrdineArticolo"/>
<jsp:setProperty name="ordine" property="*"/>
<%
	OrdineBC ordineBC = new OrdineBC();
	ordineBC.create(ordine);
	OrdineArticoloBC oaBC = new OrdineArticoloBC();
	Enumeration<String[]> enumerazione = carrello.enumerazione();
	String dati[];
	while(enumerazione.hasMoreElements()){
		dati = enumerazione.nextElement();
		oa.setId_articolo(Integer.parseInt(dati[4]));
		oa.setId_ordine(ordine.getId_ordine());
		oa.setQuantita(Integer.parseInt(dati[3]));
		oaBC.create(oa);
	}
	
	session.setAttribute("idordine", ordine.getId_ordine());
	response.sendRedirect("ordine.jsp");
%>
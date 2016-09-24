<%@page errorPage="error.jsp" %>
<jsp:useBean id="carrello" scope="session" class="com.ats.beans.Carrello"/>
<%
	String id = request.getParameter("id");
	
	if(id != null)
	{
		String titolo = request.getParameter("titolo");
		String autore = request.getParameter("autore");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		carrello.aggiungiLibro(id, titolo, autore, prezzo);
	}
	response.sendRedirect("acquisti.jsp");
	//con response torno alla pagina acquisti e basta
	//se mettevo forward rimandavo alla pagina acquisti con i parametri
%>
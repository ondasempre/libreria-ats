package com.ats.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.beans.Carrello;


public class AggiungiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aggiungi(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aggiungi(request, response);
	}
	
	protected void aggiungi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			HttpSession session= request.getSession();
			Carrello c= (Carrello) session.getAttribute("carrello");
			String id=request.getParameter("id");
			if(id!=null)
			
			{
				String titolo=request.getParameter("titolo");
				String autore=request.getParameter("autore");
				Double prezzo=Double.parseDouble(request.getParameter("prezzo"));
				c.aggiungiLibroAlCarrello(id, titolo, autore, prezzo);
			}
			response.sendRedirect("acquisti.jsp");
		}

}
}

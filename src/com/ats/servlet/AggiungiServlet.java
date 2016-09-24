package com.ats.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.beans.Carrello;

/**
 * Servlet implementation class Aggiungi
 */
public class AggiungiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AggiungiServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		addLibro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		addLibro(request, response);
	}

	protected void addLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//System.out.println("CIAOOOOOOOOO");
		/**
		 * Recupero tarmite la sessione i dati del carrello
		 */
		 HttpSession session = request.getSession(true);
		 
		 /**
		  * Con l'oggetto Carrello recupero i dati dell'ordine
		  */
		 
		 Carrello carrello = (Carrello) session.getAttribute("carrello");
		 		 
		 String id = request.getParameter("id");
		 if(id != null)
		 {
				String titolo = request.getParameter("titolo");
				String autore = request.getParameter("autore");
				double prezzo = Double.parseDouble(request.getParameter("prezzo"));
				carrello.aggiungiLibro(id, titolo, autore, prezzo);
		}
		response.sendRedirect("acquisti.jsp");
		 
		 
	}
	
}

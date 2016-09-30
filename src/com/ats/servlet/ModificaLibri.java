package com.ats.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.architecture.dao.DAOException;
import com.ats.beans.Articolo;
import com.ats.businesscomponent.ArticoloBC;

/**
 * Servlet implementation class ModificaLibri
 */
public class ModificaLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		Articolo articolo=new Articolo();
		articolo.setTitolo(request.getParameter("titolo"));
		articolo.setAutore(request.getParameter("autore"));
		articolo.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
		articolo.setId_articolo(Integer.parseInt(request.getParameter("id")));
		ArticoloBC articoloBC=new ArticoloBC();
		articoloBC.aggiorna(articolo);
			
		} catch (ClassNotFoundException | DAOException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("visualizzacatalogo.jsp");
	}
	
}

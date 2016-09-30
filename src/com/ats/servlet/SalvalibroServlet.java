package com.ats.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.architecture.dao.DAOException;
import com.ats.beans.Articolo;
import com.ats.businesscomponent.ArticoloBC;


public class SalvalibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Articolo articolo=new Articolo();
		articolo.setTitolo(request.getParameter("titolo"));
		System.out.println(articolo.getTitolo());
		articolo.setAutore(request.getParameter("autore"));
		articolo.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
		ArticoloBC articoloBC=new ArticoloBC();
		articoloBC.create(articolo);
			
		} catch (ClassNotFoundException | DAOException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("aggiungi.jsp");
	}

}

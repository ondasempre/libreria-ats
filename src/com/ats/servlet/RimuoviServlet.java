package com.ats.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.beans.Carrello;

public class RimuoviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rimuovi(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rimuovi(request, response);
	}
	
	public void rimuovi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id != null){
			HttpSession session = request.getSession();
			Carrello carrello = (Carrello) session.getAttribute("carrello");
			carrello.rimuoviLibro(id);
		}
		response.sendRedirect("visualizza.jsp");
	}

}

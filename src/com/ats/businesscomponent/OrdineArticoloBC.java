package com.ats.businesscomponent;

import java.sql.Connection;
import java.sql.SQLException;

import com.ats.architecture.dao.DAOException;
import com.ats.architecture.dao.OrdineArticoloDAO;
import com.ats.architecture.dao.OrdineDAO;
import com.ats.architecture.dbaccess.DBAccess;
import com.ats.beans.Ordine;
import com.ats.beans.OrdineArticolo;

public class OrdineArticoloBC {
	private Connection conn;

	public OrdineArticoloBC() throws ClassNotFoundException, DAOException{
		conn = DBAccess.getConnection();	//restituisce connessione sincronizzata
	}

	//versione business del metodo create
	//l'ordine arriva dal Presentation Layer (dalla pagina jsp)
	public void create(OrdineArticolo oa) throws DAOException, ClassNotFoundException{
		try{
			OrdineArticoloDAO oaDAO = new OrdineArticoloDAO();
			oaDAO.create(conn, oa);
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	
	
	public void delete(OrdineArticolo oa) throws DAOException, ClassNotFoundException
	{
		try{
			// Recuperiamo l'id dell'Ordine
			long id_ordine = oa.getId_ordine();
			
			long id_articolo = oa.getId_articolo();
			
			// Richiamo il metodo delete relativo all'ordine
			new OrdineArticoloDAO().delete(conn, id_ordine, id_articolo, oa);
			
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	
}

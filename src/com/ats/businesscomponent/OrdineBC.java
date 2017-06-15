package com.ats.businesscomponent;

import java.sql.*;

import com.ats.architecture.dao.DAOException;
import com.ats.architecture.dao.OrdineArticoloDAO;
import com.ats.architecture.dao.OrdineDAO;
import com.ats.architecture.dbaccess.DBAccess;
import com.ats.beans.Ordine;
import com.ats.idgenerator.OrdineIdGenerator;

/*
 * in questa classe devo aprire la connessione con il DB per mandare i dati al DAO
 */
public class OrdineBC {
	private Connection conn;
	
	public OrdineBC() throws ClassNotFoundException, DAOException{
		conn = DBAccess.getConnection();	//restituisce connessione sincronizzata
	}
	
	//versione business del metodo create
	//l'ordine arriva dal Presentation Layer (dalla pagina jsp)
	public void create(Ordine ordine) throws DAOException, ClassNotFoundException{
		try{
			OrdineIdGenerator idGen = OrdineIdGenerator.getInstance();
			long id = idGen.getNextId();
			ordine.setId_ordine(id);
			OrdineDAO ordineDAO = new OrdineDAO();
			ordineDAO.create(conn, ordine);
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	public void elimina(Ordine ordine, int id_ordine) throws DAOException, ClassNotFoundException{
		try{
			OrdineArticoloDAO oaDAO = new OrdineArticoloDAO();
			oaDAO.elimina(conn, ordine);
			OrdineDAO ordineDAO = new OrdineDAO();
			ordineDAO.elimina(conn, ordine, id_ordine);
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
}

package com.ats.businesscomponent;

import java.sql.Connection;
import java.sql.SQLException;
import com.ats.architecture.dao.DAOException;
import com.ats.architecture.dao.OrdineArticoloDAO;
import com.ats.architecture.dbaccess.DBAccess;
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


}

package com.ats.businesscomponent;

import java.sql.Connection;
import java.sql.SQLException;

import com.ats.architecture.dao.ArticoloDAO;
import com.ats.architecture.dao.DAOException;
import com.ats.architecture.dbaccess.DBAccess;
import com.ats.beans.Articolo;
import com.ats.idgenerator.ArticoloIdGenerator;

public class ArticoloBC {
	private Connection conn;

	public ArticoloBC() throws ClassNotFoundException, DAOException{
		conn = DBAccess.getConnection();	//restituisce connessione sincronizzata
	}

	/*
	 * prima di inserire i dati dell'utente dovrei controllare se i dati inseriti vanno bene
	 * pacchetto utilities dentro architecture
	 * qui metto le classi di validazione
	 * una per stringhe una per data...
	 * metodo validate ritorna true o false
	 * nel business component richiamo i metodi di validazione
	 * 
	 * per questo progetto facciamo validazioni lato client javascript
	 */
	public void create(Articolo articolo) throws DAOException, ClassNotFoundException{
		try{
			ArticoloIdGenerator idGen2 = ArticoloIdGenerator.getInstance();
			int id2 = (int)idGen2.getNextId();
			articolo.setId_articolo(id2);
			ArticoloDAO articoloDAO = new ArticoloDAO();
			articoloDAO.create(conn, articolo);
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	public void aggiorna(Articolo articolo) throws DAOException, ClassNotFoundException{
		try{
			ArticoloDAO articoloDAO = new ArticoloDAO();
			
			articoloDAO.aggiorna1(conn, articolo);
			
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
}

package com.ats.businesscomponent;

import java.sql.Connection;
import java.sql.SQLException;

import com.ats.architecture.dao.DAOException;
import com.ats.architecture.dao.UtenteDAO;
import com.ats.architecture.dbaccess.DBAccess;
import com.ats.beans.Utente;

public class UtenteBC {
	private Connection conn;

	public UtenteBC() throws ClassNotFoundException, DAOException{
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
	public void create(Utente utente) throws DAOException, ClassNotFoundException{
		try{
			UtenteDAO utenteDAO = new UtenteDAO();
			utenteDAO.create(conn, utente);
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
}

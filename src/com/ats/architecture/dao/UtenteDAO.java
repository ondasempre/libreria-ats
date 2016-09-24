package com.ats.architecture.dao;

import java.sql.*;

import javax.sql.rowset.CachedRowSet;

import com.ats.beans.Utente;
import com.sun.rowset.CachedRowSetImpl;

/*
 * Classe per scrivere e leggere i dati dalla tabella utente
 */
public class UtenteDAO implements DAOconstants{
	private CachedRowSet rowSet;	//mantiene la sincronizzazione con il DB
									//con connection hai più controllo sulla conn
	public UtenteDAO() throws SQLException{
		rowSet = new CachedRowSetImpl();
	}
	
	public void create(Connection conn, Utente utente) throws DAOException{
		try{
			rowSet.setCommand(SELECT_UTENTI);
			rowSet.execute(conn);	//quando apriamo la connessione con il DBAccess
									//dobbiamo passare la connessione come parametro
			
			rowSet.moveToInsertRow();
			
			rowSet.updateString(1, utente.getNome());
			rowSet.updateString(2, utente.getCognome());
			rowSet.updateString(3, utente.getIndirizzo());
			rowSet.updateString(4, utente.getCap());
			rowSet.updateDate(5, new java.sql.Date(utente.getNascita().getTime()));
			rowSet.updateString(6, utente.getUsername());
			rowSet.updateString(7, utente.getPassword());
			rowSet.updateString(8, utente.getEmail());
			
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
			
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
		
		
		
		
	}
}
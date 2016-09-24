package com.ats.architecture.dao;

import java.sql.*;

import javax.sql.rowset.CachedRowSet;

import com.ats.beans.Ordine;
import com.sun.rowset.CachedRowSetImpl;

/*
 * Classe per scrivere e leggere i dati dalla tabella utente
 */
public class OrdineDAO implements DAOconstants{
	private CachedRowSet rowSet;	//mantiene la sincronizzazione con il DB
									//con connection hai più controllo sulla conn
	public OrdineDAO() throws SQLException{
		rowSet = new CachedRowSetImpl();
	}
	
	public void create(Connection conn, Ordine ordine) throws DAOException{
		try{
			rowSet.setCommand(SELECT_ORDINI);
			rowSet.execute(conn);	//quando apriamo la connessione con il DBAccess
									//dobbiamo passare la connessione come parametro
			
			rowSet.moveToInsertRow();
			
			rowSet.updateLong(1, ordine.getId_ordine());
			rowSet.updateDouble(2, ordine.getTotale());
			rowSet.updateDate(3, new java.sql.Date(System.currentTimeMillis()));
			rowSet.updateString(4, ordine.getUsername());
						
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
			
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	

	public void delete(Connection conn, long id, Ordine ordine) throws DAOException 
	{
		try
		{	
			// Eseguo il comando per eliminare l'odine nel database con SQL
			rowSet.setCommand(DELETE_ORDINE);
			rowSet.setLong(1, id);
			rowSet.execute(conn);	
			
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		
	}
	
}
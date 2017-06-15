package com.ats.architecture.dao;

import java.sql.*;

import javax.sql.rowset.CachedRowSet;

import com.ats.beans.Ordine;
import com.ats.beans.OrdineArticolo;
import com.sun.rowset.CachedRowSetImpl;

/*
 * Classe per scrivere e leggere i dati dalla tabella utente
 */
public class OrdineArticoloDAO implements DAOconstants{
	private CachedRowSet rowSet;	//mantiene la sincronizzazione con il DB
									//con connection hai più controllo sulla conn
	public OrdineArticoloDAO() throws SQLException{
		rowSet = new CachedRowSetImpl();
	}
	
	public void create(Connection conn, OrdineArticolo oa) throws DAOException{
		try{
			rowSet.setCommand(SELECT_ORDINEARTICOLO);
			rowSet.execute(conn);	//quando apriamo la connessione con il DBAccess
									//dobbiamo passare la connessione come parametro
			
			rowSet.moveToInsertRow();
			
			rowSet.updateLong(1, oa.getId_ordine());
			rowSet.updateInt(2, oa.getId_articolo());
			rowSet.updateInt(3, oa.getQuantita());
						
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
			
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	public void elimina(Connection conn, Ordine ordine) throws DAOException{
		try{
			
			rowSet.setCommand(DELETE_ORDINE_ARTICOLO);
	        rowSet.setLong(1, ordine.getId_ordine());  
	        rowSet.execute(conn);
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
}
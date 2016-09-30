package com.ats.architecture.dao;

import java.sql.*;

import javax.sql.rowset.CachedRowSet;

import com.ats.beans.Articolo;
import com.sun.rowset.CachedRowSetImpl;

/*
 * Classe per scrivere e leggere i dati dalla tabella utente
 */
public class ArticoloDAO implements DAOconstants{
	private CachedRowSet rowSet;	//mantiene la sincronizzazione con il DB
									//con connection hai più controllo sulla conn
	public ArticoloDAO() throws SQLException{
		rowSet = new CachedRowSetImpl();
	}
	
	public void create(Connection conn, Articolo articolo) throws DAOException{ 
		try{
			
			rowSet.setCommand(SELECT_ARTICOLO);
			rowSet.execute(conn);	//quando apriamo la connessione con il DBAccess
									//dobbiamo passare la connessione come parametro
			
			rowSet.moveToInsertRow();
			
			rowSet.updateLong(1, articolo.getId_articolo());
			rowSet.updateString(2, articolo.getTitolo());
			rowSet.updateString(3, articolo.getAutore());
			rowSet.updateDouble(4, articolo.getPrezzo());
						
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
			
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	
	public void aggiorna1(Connection conn, Articolo articolo) throws DAOException{ 
		try{
	        rowSet.setCommand(UPDATE_ARTICOLO);
	       
	        rowSet.setLong(4, articolo.getId_articolo());
	        
	        rowSet.setString(1, articolo.getTitolo());
	        
	       
	        rowSet.setString(2, articolo.getAutore());
	    
	        rowSet.setDouble(3, articolo.getPrezzo());
	       
	        rowSet.execute(conn);
	       
			
		}catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
}
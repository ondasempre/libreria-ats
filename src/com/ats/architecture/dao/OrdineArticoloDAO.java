package com.ats.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.ats.beans.Articolo;
import com.ats.beans.Ordine;
import com.ats.beans.OrdineArticolo;
import com.sun.rowset.CachedRowSetImpl;

/*
 * Classe per scrivere e leggere i dati dalla tabella utente
 */
public class OrdineArticoloDAO implements DAOconstants{
	private CachedRowSet rowSet;	//mantiene la sincronizzazione con il DB
									//con connection hai pi� controllo sulla conn
	public OrdineArticoloDAO() throws SQLException{
		rowSet = new CachedRowSetImpl();
	}
	
	public void create(Connection conn, OrdineArticolo oa) throws DAOException
	{
		try
		{
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
	
	public void delete(Connection conn, OrdineArticolo oa) throws DAOException 
	{

		try
		{	
			// Cancella la relationship Ordine_Articolo
			rowSet.setCommand(DELETE_ORDINEARTICOLO);
	
			rowSet.setLong(1, oa.getId_ordine());
			rowSet.setLong(2, oa.getId_articolo());
			
			rowSet.execute(conn);	
			
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(Connection conn, long id_ordine, long id_articolo, OrdineArticolo oa) throws DAOException {
		try
		{	
			// Cancella la relationship Ordine_Articolo
			rowSet.setCommand(DELETE_ORDINEARTICOLO);
	
			rowSet.setLong(1, oa.getId_ordine());
			rowSet.setLong(2, oa.getId_articolo());
			
			rowSet.execute(conn);	
			
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		
	}
	
}
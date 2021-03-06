package com.ats.idgenerator;

import com.ats.architecture.dao.DAOException;
import com.ats.architecture.dao.DAOconstants;
import com.ats.architecture.dbaccess.DBAccess;

import java.sql.*;


/*
 * qui implementiamo Singleton
 */
public class ArticoloIdGenerator implements IdGeneratorInterface, DAOconstants{
	private static ArticoloIdGenerator idGen; //riferimento all'istanza corrente
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	
	private ArticoloIdGenerator(){
		
	}
	
	public static ArticoloIdGenerator getInstance(){
		if(idGen == null){
			idGen = new ArticoloIdGenerator();
		}
		return idGen;
	}
	
	@Override //pu� servire solo per la javadoc
	public long getNextId() throws DAOException, ClassNotFoundException {
		//genera l'id e lo ritorna come valore
		long id;
		try{
			conn = DBAccess.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(ARTICOLONEXT);
			rs.next();	//ATTENZIONE ALLA POSIZIONE DEL CURSORE
			id = rs.getLong(1);
			return id;
		}catch(SQLException sql){
			throw new DAOException(sql);
		}finally{
			DBAccess.closeConnection(conn);
		}
	}
}

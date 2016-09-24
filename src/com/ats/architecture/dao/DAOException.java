package com.ats.architecture.dao;

import java.sql.SQLException;

/*
 * classe che gestisce le eccezioni SQL
 * DEVE seguire le regole del design pattern DAO
 */
public class DAOException extends Exception implements DAOconstants{
	private static final long serialVersionUID = 3335619211046387024L;
	
	//invalid username e password
	private final static int ORA1017 = 1017;
	private final static int ORA17002 = 17002;
	
	private String messaggio;
	
	public DAOException(SQLException sql){
		String chiave = messaggio;
		if (sql != null){
			switch(sql.getErrorCode()){
			case ORA1017:
				chiave = "invalid username/password";
				log(sql);
				break;
			case ORA17002:
				chiave = "IO exception di Oracle";
				log(sql);
				break;
			default:
				chiave = "Eccezione SQL "+sql.getMessage();
			}
		}
		messaggio = chiave;
	}
	
	public String getMessaggio(){
		return messaggio;
	}
	
	private void log(SQLException sql) {
		sql.printStackTrace(System.err);
		System.err.println("SQLState: "+sql.getSQLState());
		System.err.println("Motivo: "+sql.getMessage());
		System.err.println("Codice: "+sql.getErrorCode());
	}
}

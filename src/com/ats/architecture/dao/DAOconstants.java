package com.ats.architecture.dao;

public interface DAOconstants 
{

	String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	String JDBC_URL = "jdbc:oracle:thin:@10.0.1.18:1521:orcl";
	
	String USERNAME = "flavio";
	String PASSWORD = "flavio";
	
	//recupero il prossimo valore dalla sequenza per usare la sequenza per incrementare l'id_ordine
	String SEQNEXTVAL = "SELECT ordine_seq.nextval FROM dual";
	
	//si mettono sempre delle query per recuperare il contenuto delle tabelle
	// e per le viste
	String SELECT_UTENTI = "SELECT * FROM utente";
	String SELECT_ORDINI = "SELECT * FROM ordine";
	String SELECT_ARTICOLO = "SELECT * FROM articolo";
	String SELECT_ORDINEARTICOLO = "SELECT * FROM ordine_articolo";
	String SELECT_ROPORT = "SELECT * FROM report";
	String DELETE_ORDINE = "DELETE FROM Ordine where id_ordine = ?";
	String DELETE_ORDINEARTICOLO = "DELETE FROM OrdineArticolo where id_ordine = ? AND id_articolo = ?";
	
	
	String SELECT_USERPASS = "SELECT username, password FROM utente WHERE username = ?";
}

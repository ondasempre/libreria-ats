package com.ats.architecture.dao;

public interface DAOconstants {

	String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	String JDBC_URL = "jdbc:oracle:thin:@10.0.2.15:1521:orcl";
	
	String USERNAME = "salvatore";
	String PASSWORD = "pass";
	
	//recupero il prossimo valore dalla sequenza per usare la sequenza per incrementare l'id_ordine
	String SEQNEXTVAL = "SELECT ordine_seq.nextval FROM dual";
	String ARTICOLONEXT = "SELECT libro_seq.nextval FROM dual";
	//si mettono sempre delle query per recuperare il contenuto delle tabelle
	// e per le viste
	String SELECT_UTENTI = "SELECT * FROM utente";
	String SELECT_ORDINI = "SELECT * FROM ordine";
	
	String SELECT_ARTICOLO = "SELECT * FROM articolo";
	String SELECT_ARTICOLO_DESC = "SELECT * FROM articolo oredr by desc";
	String SELECT_ORDINEARTICOLO = "SELECT * FROM ordine_articolo";
	String SELECT_REPORT = "SELECT * FROM report";
	String SELECT_DATA="select data from ordine where id_ordine=?";
	
	
	String SELECT_USERPASS = "SELECT username, password FROM utente WHERE username = ?";
	String DELETE_ORDINE="delete from ordine where id_ordine=?";
	String DELETE_ORDINE_ARTICOLO="delete from ordine_articolo where id_ordine=?";
	String UPDATE_ARTICOLO="update articolo set titolo=?,autore=?, prezzo=? where id_articolo=?";
}

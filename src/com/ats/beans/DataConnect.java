package com.ats.beans;

import java.sql.*;
import java.util.Vector;

import com.ats.architecture.dao.DAOException;
import com.ats.architecture.dao.DAOconstants;
import com.ats.architecture.dbaccess.DBAccess;

/*
 * funzionalità di business per recuperare i libri del catalogo da mostrare
 */
public class DataConnect implements DAOconstants{
	private Connection conn;
	
	public DataConnect() throws DAOException, ClassNotFoundException{
		conn = DBAccess.getConnection();
	}
	
	public Articolo[] getArticoli() throws SQLException{
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		//mi raccomando mettere quei parametri altrimenti il cursore di rs non può andare indietro
		
		ResultSet rs = stmt.executeQuery(SELECT_ARTICOLO);
		rs.last();
		int righe = rs.getRow();
		Articolo[] articoli = new Articolo[righe];
		rs.beforeFirst();
		for(int i = 0; rs.next(); i++){
			articoli[i] = new Articolo();
			articoli[i].setId_articolo(rs.getInt(1));
			articoli[i].setTitolo(rs.getString(2));
			articoli[i].setAutore(rs.getString(3));
			articoli[i].setPrezzo(rs.getDouble(4));
		}
		return articoli;
	}
	
	/*
	 * verifico username e password per l'accesso
	 */
	public String[] getUsernamePassword(String username) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement(SELECT_USERPASS);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		if(!rs.next())
			return null;
		//array anonimo:
		return new String[] {rs.getString(1), rs.getString(2)};
	}
	
	public Vector<String[]> getReport() throws SQLException{
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_ROPORT);
		ResultSetMetaData meta = rs.getMetaData();
		int colonne = meta.getColumnCount();
		Vector<String[]> dati = new Vector<String[]>();
		rs.beforeFirst();
		while(rs.next()){
			String[] riga = new String[colonne];
			for(int i = 0; i<colonne; i++){
				riga[i] = rs.getString(i+1);
				//qui sto usando una componente java con ResultSet
				//ricorda che java parte da 0 e SQL parte da 1!!!
			}
			dati.add(riga);
		}
		return dati;
	}
}

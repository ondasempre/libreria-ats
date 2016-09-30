package com.ats.beans;
import java.sql.*;
import java.util.Date;
import java.util.Vector;

import com.ats.architecture.dao.DAOException;
import com.ats.architecture.dao.DAOconstants;
import com.ats.architecture.dbaccess.DBAccess;

public class DataConnect implements DAOconstants{
	private Connection conn;
	
	public DataConnect()throws DAOException, ClassNotFoundException
	{
		conn=DBAccess.getConnection();
	}
	public Articolo[] getArticoli() throws SQLException
	{
		//ci dobbiamo dire il result set come lo vogliamo
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=stmt.executeQuery(SELECT_ARTICOLO);
		rs.last();
		int righe= rs.getRow();
		Articolo[] articoli=new Articolo[righe];
		//sto all'ultimo e devo riposizionarmi alla prima
		rs.beforeFirst();
		for(int i=0; rs.next();i++)
		{
			articoli[i]=new Articolo();
			articoli[i].setId_articolo(rs.getInt(1));
			articoli[i].setTitolo(rs.getString(2));
			articoli[i].setAutore(rs.getString(3));
			articoli[i].setPrezzo(rs.getDouble(4));
			
		}
		return articoli;
		
	}
	
	public String[] getUsernamePassword(String username)throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement(SELECT_USERPASS);
		stmt.setString(1,username);
		ResultSet rs = stmt.executeQuery();
		if(!rs.next())
			return null;
		return new String[]{rs.getString(1), rs.getString(2)};
	}

	public Vector<String[]> getReport() throws SQLException
	{
		Statement stmt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=stmt.executeQuery(SELECT_REPORT);
		ResultSetMetaData meta= rs.getMetaData();
		int colonne= meta.getColumnCount();
		Vector<String[]>dati=new Vector<String[]>();
		rs.beforeFirst();
		while(rs.next())
		{
			String[] riga = new String[colonne];
			for(int i=0; i<colonne;i++)
			{
				//indice di colonna diverso da result set perche i =0 CRISTO
				riga[i]=rs.getString(i+1);
			}
			dati.add(riga);
		}
		return dati;
	}
	public Date getData(int id)
	{
		java.sql.Date data=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SELECT_DATA);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			data=rs.getDate(1);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
}

package com.ats.architecture.dbaccess;

import java.sql.*;
import com.ats.architecture.dao.DAOException;
import com.ats.architecture.dao.DAOconstants;

/*
 * Classe che si occupa di aprire e chiudere la connessione con il DB
 */
public class DBAccess implements DAOconstants
{
	private static Connection conn;
	
	//statico perch� deve essere richiamato direttamente sulla classe e non
	//su una sua istanza
	public static synchronized Connection getConnection() throws ClassNotFoundException, DAOException
	{
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return conn;
	}

	public static void closeConnection(Connection conn) throws DAOException
	{
		try
		{
			if(conn != null)
			{
				conn.close();
			}
			
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
}

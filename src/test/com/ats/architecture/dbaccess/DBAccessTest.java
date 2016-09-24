package test.com.ats.architecture.dbaccess;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.ats.architecture.dao.DAOException;
import com.ats.architecture.dbaccess.DBAccess;

public class DBAccessTest {

	@Test
	public void testConnection() {
		//creo l'istanza dell'elemento da sottoporre al test
		Connection conn = null;
		try{
			DBAccess.getConnection();
		}catch(ClassNotFoundException | DAOException exc){
			//se finisce dentro qui vuol dire che c'è un problema
			exc.printStackTrace();
			fail("Connessione fallita");	//messaggio facoltativo
		}finally{
			try{
				DBAccess.closeConnection(conn);
			}catch(DAOException exc){
				exc.printStackTrace();
				fail("Disconnessione fallita");
			}
		}
	}

}

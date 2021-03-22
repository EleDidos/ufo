package it.poliyo.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) {
		
		/** ? introduce serie di parametri
		*   & concatenazione di info
		*/
		
		String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=240899SQL";

		
		//METODO STATICO di Driver Manager --> creo CONNESSIONE
		// tutte le operazioni colm DB possono sempre generare ECCEZIONI
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			
			
			
			// CHIUSURA connessione --> numero limitato di connessioni aperte contemporanee
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}

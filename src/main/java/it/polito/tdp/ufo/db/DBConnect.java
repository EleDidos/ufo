package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Mi da solo la CONNESSIONE all'URL
 * Lui crea CONNESSIONE che viene chiesta da DAO
 * Così se ho più classi DAO, tutte possono condividere la CONNECTION
 * @author elena
 *
 */

public class DBConnect {
	
	static String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=240899SQL";
	
	public static Connection getConnestion() throws SQLException {
		return DriverManager.getConnection(jdbcURL);
	}
}

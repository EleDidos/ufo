package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Possibile INTERFACCIA in modo che CHIAMANTE non sappia nulla di JDBC
 */

import java.util.List;

public class SightingDAO {
	
	
	public 	List <String> readShapes(){
		

		try {
			//CHIEDE CONNECT a DB Connect
			Connection conn= DBConnect.getConnestion();
		
			String sql = "SELECT DISTINCT shape"

				+ "FROM sighting"
				+ "WHERE shape <> ' ' "
				+"ORDER BY shape ASC";
		
			PreparedStatement st = conn.prepareStatement(sql);
		
			ResultSet res = st.executeQuery(sql);
		
			List<String> formeUFO = new ArrayList <>();
			while (res.next()) {
				String forma = res.getString("shape");
				formeUFO.add(forma);
			}
			
			st.close();
			return formeUFO;
		}catch(SQLException e) {
			throw new RuntimeException(e);
			//meglio PROPAGARE ECCEZIONE --> non deve succedere
		}
	}
	
	
	
	public int countByShape(String shape) {

			
		try{
			//CHIEDE CONNECT a DB Connect
			Connection conn= DBConnect.getConnestion();
			
			String sql2 = "SELECT COUNT(*) AS cnt FROM sighting WHERE shape= ?";
			String shapeScelta = "circle"; //cerco forma decisa qui
		
		//PREPARO LO STATEMENT
			PreparedStatement st2 = conn.prepareStatement(sql2);
		
		//SOSTITUISCO AL ? della query il valore di SHAPESCELTA
			st2.setString(1, shapeScelta);
			ResultSet res2 = st2.executeQuery();
			res2.first();
		
		//estraggo colonna chiamata cnt
			int count = res2.getInt("cnt");
			st2.close();
		
			conn.close();
			
			return count;
		}catch(SQLException e) {
			throw new RuntimeException("DATABASE ERRORE: " +e);
			//meglio PROPAGARE ECCEZIONE --> non deve succedere
		}
		
	}
	

}

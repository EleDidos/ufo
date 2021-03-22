
package it.polito.tdp.ufo.model;

import java.util.List;

import it.polito.tdp.ufo.db.SightingDAO;

public class Model {

	private List<String> formeUFO = null ;
	
	public List<String> getFormeUFO() {
		// IL MODELLO SI SALVA LE FORME --> DAO le legge soltanto
		// se non c'è ancora nulla di salvato, le salva
		// se ce ne sono di già salvate, ritorna quelle
		if (this.formeUFO==null) {
			SightingDAO dao = new SightingDAO() ;
			this.formeUFO = dao.readShapes() ;
		}
		return this.formeUFO;
	}
	
	public int getCountByForma(String forma) {
		// i metodi JDBC non vengono gestiti da lui
		// ma dalla classe DAO
		SightingDAO dao = new SightingDAO();
		return dao.countByShape(forma) ;
	}
}
package com.german_martinez.p3.modelo;

import java.util.HashMap;
import java.util.Map;

public enum CocheDao {
	INSTANCE;

	private Map<String, Coche> coches = new HashMap<String, Coche>();

	private CocheDao() {
		Coche coche = new Coche("1", "Seat", "Ibiza", 2015, 3, 192, 235,
				Coche.GASOLEO, 5, 21400);
		coches.put("1", coche);
		coche = new Coche("2", "Volkswagen", "Golf", 2015, 3, 300, 250,
				Coche.GASOLEO, 5, 43050);
		coches.put("2", coche);
		coche = new Coche("3", "BMW", "Serie 1", 2015, 3, 326, 250,
				Coche.GASOLEO, 5, 44750);
		coches.put("3", coche);
	}

	public Map<String, Coche> getCoches() {
		return this.coches;
	}

}

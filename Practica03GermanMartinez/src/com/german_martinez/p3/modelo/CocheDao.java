package com.german_martinez.p3.modelo;

import java.util.HashMap;
import java.util.Map;

public enum CocheDao {
	INSTANCE;

	private Map<String, Coche> coches = new HashMap<String, Coche>();

	private CocheDao() {
		Coche coche = new Coche("1", "Seat", "Leon", 2013, 3, 110, 194,
				Coche.DIESEL, 5, 24620);
		coches.put("1", coche);
		coche = new Coche("2", "Volkswagen", "Golf", 2012, 3, 300, 250,
				Coche.GASOLINA, 5, 40885);
		coches.put("2", coche);
		coche = new Coche("3", "BMW", "Serie 3", 2012, 3, 431, 250,
				Coche.GASOLINA, 5, 89900);
		coches.put("3", coche);
	}

	public Map<String, Coche> getCoches() {
		return this.coches;
	}

}

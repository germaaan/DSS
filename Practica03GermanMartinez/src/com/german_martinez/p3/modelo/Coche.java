package com.german_martinez.p3.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coche {
	public final static int GASOLEO = 1;
	public final static int GASOIL = 2;
	public final static int HIBRIDO = 3;
	public final static int ELECTRICO = 4;
	private String id;
	private String marca;
	private String modelo;
	private int anio;
	private int numPuertas;
	private int potencia;
	private int maxVelocidad;
	private int combustible;
	private int numPlazas;
	private float precio;

	public Coche() {
	}

	public Coche(String id, String marca, String modelo, int anio,
			int numPuertas, int potencia, int maxVelocidad, int combustible,
			int numPlazas, float precio) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.numPuertas = numPuertas;
		this.potencia = potencia;
		this.maxVelocidad = maxVelocidad;
		this.combustible = combustible;
		this.numPlazas = numPlazas;
		this.precio = precio;
	}

	public String getId() {
		return this.id;
	}

	public String getMarca() {
		return this.marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public int getAnio() {
		return this.anio;
	}

	public int getNumPuertas() {
		return this.numPuertas;
	}

	public int getPotencia() {
		return this.potencia;
	}

	public int getMaxVelocidad() {
		return this.maxVelocidad;
	}

	public int getCombustible() {
		return this.combustible;
	}

	public int getNumPlazas() {
		return this.numPlazas;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public void setMaxVelocidad(int maxVelocidad) {
		this.maxVelocidad = maxVelocidad;
	}

	public void setCombustible(int combustible) {
		this.combustible = combustible;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
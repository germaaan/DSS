package com.german_martinez.p3.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coche {
	public final static int GASOLINA = 1;
	public final static int DIESEL = 2;
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

	public String toHTML() {
		String values = "<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body>"
				+ "<h3>Características:</h3><ul>"
				+ "<li><strong>ID: </strong>"
				+ this.id
				+ "</li><li><strong>Marca: </strong>"
				+ this.marca
				+ "</li><li><strong>Modelo: </strong>"
				+ this.modelo
				+ "</li><li><strong>Año: </strong>"
				+ this.anio
				+ "</li><li><strong>Número de puertas: </strong>"
				+ this.numPuertas
				+ "</li><li><strong>Potencia: </strong>"
				+ this.potencia
				+ "</li><li><strong>Velocidad máxima: </strong>"
				+ this.maxVelocidad + "</li>";

		switch (this.combustible) {
		case Coche.GASOLINA:
			values += "<li><strong>Combustible: </strong>Gasolina</li>";
			break;
		case Coche.DIESEL:
			values += "<li><strong>Combustible: </strong>Diésel</li>";
			break;
		case Coche.HIBRIDO:
			values += "<li><strong>Combustible: </strong>Híbrido</li>";
			break;
		case Coche.ELECTRICO:
			values += "<li><strong>Combustible: </strong>Eléctrico</li>";
			break;
		}

		values += "<li><strong>Número de plazas: </strong>" + this.numPlazas
				+ "</li><li><strong>Precio: </strong>" + this.precio
				+ "</li></ul>";

		return values;
	}
}
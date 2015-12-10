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
		String values = "<!DOCTYPE html><html><head><meta charset='utf-8' /><meta name='viewport' content='width=device-width, initial-scale=1' /><meta name='description' content='DSS: Práctica 3' /><meta name='author' content='Germán Martínez Maldonado' /><title>Características</title><link rel='stylesheet'href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'></head><body><nav class='navbar navbar-inverse navbar-fixed-top'><div class='container'><div class='navbar-header'><button type='button' data-toggle='collapse' data-target='#navbar'aria-expanded='false' aria-controls='navbar'class='navbar-toggle collapsed'><span class='sr-only'>Toggle navigation</span><spanclass='icon-bar'> </span> <span class='icon-bar'></span><spanclass='icon-bar'> </span> <span class='icon-bar'></span><spanclass='icon-bar'> </span></button></div><div id='navbar' class='collapse navbar-collapse'><ul class='nav navbar-nav'><li><a href='../../index.html'>Inicio</a></li><li><a href='../../rest/coches'>Mapa de elementos</a></li><li><a href='../../rest/coches/count'>Contador elementos</a></li><li><a href='../../catalogo.html'>Catálogo de coches</a></li></ul></div></div></nav><div class='container'><div class='starter-template'><h2 style='padding-top: 50px; text-align: center'>Características</h2><table id='tareas' class='table table-hover text-center'><thead><tr><th class='col-sm-1 text-center'>Propiedad</th><th class='col-sm-1 text-center'>Valor</th></tr></thead><tbody><tr><td>ID</td><td>"
				+ this.id
				+ "</td></tr><tr><td>Marca</td><td>"
				+ this.marca
				+ "</td></tr><tr><td>Modelo</td><td>"
				+ this.modelo
				+ "</td></tr><tr><td>Año</td><td>"
				+ this.anio
				+ "</td></tr><tr><td>Número de puertas</td><td>"
				+ this.numPuertas
				+ "</td></tr><tr><td>Potencia</td><td>"
				+ this.potencia
				+ "</td></tr><tr><td>Velocidad máxima</td><td>"
				+ this.maxVelocidad + "</td></tr><tr><td>Combustible</td><td>";

		switch (this.combustible) {
		case Coche.GASOLINA:
			values += "Gasolina";
			break;
		case Coche.DIESEL:
			values += "Diésel";
			break;
		case Coche.HIBRIDO:
			values += "Híbrido";
			break;
		case Coche.ELECTRICO:
			values += "Eléctrico";
			break;
		}

		values += "</td></tr><tr><td>Número de plazas</td><td>"
				+ this.numPlazas + "</td></tr><tr><td>Precio</td><td>"
				+ this.precio + "</td></tr><tr><td></td><td></td></tr>";

		return values;
	}
}
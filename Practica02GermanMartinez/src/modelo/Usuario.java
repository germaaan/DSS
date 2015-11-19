package modelo;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	// Variables de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	private String nombre;
	private String apellido;
	private String email;

	// Constructor por defecto
	public Usuario() {
		this.nombre = "";
		this.apellido = "";
		this.email = "";
	}

	// Constructor mediante el paso como parámetro de otro usuario
	public Usuario(Usuario us) {
		this.nombre = us.getNombre();
		this.apellido = us.getApellido();
		this.email = us.getEmail();
	}

	// Métodos para obtener y modificar las variables
	public long getId() {
		return this.getId();
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Método para obtener una cadena con la información del usuario
	@Override
	public String toString() {
		return this.nombre + " " + this.apellido + "" + this.email;
	}
}

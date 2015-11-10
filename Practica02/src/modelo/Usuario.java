package modelo;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// JAVADOC

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id; // Identificador numérico del usuario
	private String nombre; // Nombre del usuario
	private String apellido; // Apellidos del usuario
	private String email; // Su dirección de correo electrónico

	// Para construir un usuario vacío
	public Usuario() {
		this.nombre = "";
		this.apellido = "";
		this.email = "";
	}

	public Usuario(Usuario us) {
		this.nombre = us.getNombre();
		this.apellido = us.getApellido();
		this.email = us.getEmail();
	}

	public long getId() {
		return this.getId();
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return null;
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

	@Override
	public String toString() {
		return this.nombre + " " + this.apellido + "" + this.email;
	}
}

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

	}

	public Usuario(Usuario us) {

	}

	public long getId() {
		return 1;
	}

	public void setId(long id) {

	}

	public String getNombre() {
		return null;
	}

	public void setNombre(String nombre) {

	}

	public String getApellido() {
		return null;
	}

	public void setApellido(String apellido) {

	}

	public String getEmail() {
		return null;
	}

	public void setEmail(String email) {

	}

	@Override
	public String toString() {
		return this.nombre + " " + this.apellido + "" + this.email;
	}
}

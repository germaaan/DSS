package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.Persistence;

import java.util.List;

import modelo.Usuario; // Quitar

public class BDUsuario {
	private static final String PERSISTENCE_UNIT_NAME = "usuario";
	private static EntityManagerFactory factoria = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	// Insertar un usuario; si ya existe, no tiene efecto.
	public static void insertar(Usuario usuario) {

	}

	// Actualizar los datos de un usuario en la base de datos
	public static void actualizar(Usuario usuario) {

	}

	// Eliminar un usuario de la base de datos
	public static void eliminar(Usuario usuario) {

	}

	// Recuperar un usuario desde la base de datos
	public static Usuario seleccionarUsuario(String email) {
		return null;
	}

	// Comprobar que existe el usuario cuyo email pasamos como argumento
	public static boolean existeEmail(String email) {
		return false;
	}

	// Listar los usuarios de la base de datos
	public static List<Usuario> seleccionarTodosUsuarios() {
		return null;
	}
}

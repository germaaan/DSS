package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.Persistence;

import java.util.List;

public class BDUsuario {
	// Unidad de persistencia definida
	private static final String PERSISTENCE_UNIT_NAME = "usuario";
	// Interfaz para gestionar las entidades
	private static EntityManagerFactory factoria = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	// Método de inserción de usuarios
	// - Si existe el usuario: no hace nada
	// - Si no existe el usuario: almacena el usuario en la base de datos de
	// forma persistente
	public static void insertar(Usuario usuario) {
		EntityManager em = factoria.createEntityManager();

		if (!existeEmail(usuario.getEmail())) {
			em.getTransaction().begin();

			em.persist(usuario);

			em.getTransaction().commit();
			em.close();
		}
	}

	// Método de actualización de usuarios
	// - Si existe el usuario: obtiene el usuario mediante una consulta,
	// modifica su nombre y sus apellidos y guarda los cambios en la base de
	// datos
	// - Si no existe el usuario: no hace nada
	public static void actualizar(Usuario usuario) {
		EntityManager em = factoria.createEntityManager();

		if (existeEmail(usuario.getEmail())) {
			Query q = em.createQuery(
					"SELECT u from Usuario u WHERE u.email LIKE :email")
					.setParameter("email", usuario.getEmail());

			Usuario anterior = new Usuario((Usuario) q.getSingleResult());

			em.getTransaction().begin();

			anterior.setNombre(usuario.getNombre());
			anterior.setApellido(usuario.getApellido());

			em.getTransaction().commit();
			em.close();
		}
	}

	// Método de eliminación de usuarios
	// - Si existe el usuario: obtiene el usuario mediante una consulta,
	// lo elimina y guarda los cambios en la base de datos
	// - Si no existe el usuario: no hace nada
	public static void eliminar(Usuario usuario) {
		EntityManager em = factoria.createEntityManager();

		if (existeEmail(usuario.getEmail())) {
			em.getTransaction().begin();
			Query q = em.createQuery(
					"SELECT u from Usuario u WHERE u.email LIKE :email")
					.setParameter("email", usuario.getEmail());

			Usuario borrado = new Usuario((Usuario) q.getSingleResult());

			em.remove(borrado);
			em.getTransaction().commit();
			em.close();
		}
	}

	// Método de selección de usuarios
	// - Si existe el usuario: obtiene el usuario mediante una consulta,
	// crea un nuevo usuario a partir del usuario obtenido y lo devuelve.
	// - Si no existe el usuario: devuelve un usuario nulo
	public static Usuario seleccionarUsuario(String email) {
		EntityManager em = factoria.createEntityManager();
		Usuario usuario = null;

		if (existeEmail(email)) {
			Query q = em.createQuery(
					"SELECT u from Usuario u WHERE u.email LIKE :email")
					.setParameter("email", email);

			usuario = new Usuario((Usuario) q.getSingleResult());

			em.close();
		}

		return usuario;
	}

	// Método de búsqueda de emails
	// - No se produce ninguna excepción: existe el usuario, se devuelve un valor verdadero
	// - Se produce una excepción por no resultados: se devuelve un valor falso
	public static boolean existeEmail(String email) {
		EntityManager em = factoria.createEntityManager();
		Query q = em.createQuery(
				"SELECT u from Usuario u WHERE u.email LIKE :email")
				.setParameter("email", email);

		try {
			q.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		} finally {
			em.close();
		}
	}

	// Método para listar usuario:
	// - Devuelve una lista con todos los usuarios contenidos en la base de datos
	public static List<Usuario> listarUsuarios() {
		EntityManager em = factoria.createEntityManager();
		Query q = em.createQuery("SELECT u from Usuario u");

		@SuppressWarnings("unchecked")
		List<Usuario> listaUsuarios = q.getResultList();

		em.close();

		return listaUsuarios;
	}

}
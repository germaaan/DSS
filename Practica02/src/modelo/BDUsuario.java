package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
//import javax.persistence.TypedQuery;
import javax.persistence.Persistence;

import java.util.List;

//import modelo.Usuario;

public class BDUsuario {
	private static final String PERSISTENCE_UNIT_NAME = "usuario";
	private static EntityManagerFactory factoria = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	public static void insertar(Usuario usuario) {
		EntityManager em = factoria.createEntityManager();

		if (!existeEmail(usuario.getEmail())) {
			em.getTransaction().begin();

			em.persist(usuario);

			em.getTransaction().commit();
			em.close();
		}
	}

	public static void actualizar(Usuario usuario) {
		EntityManager em = factoria.createEntityManager();

		if (existeEmail(usuario.getEmail())) {
			Query q = em.createQuery(
					"SELECT u from Usuario u WHERE u.email LIKE :email")
					.setParameter("email", usuario.getEmail());

			Usuario anterior = (Usuario) q.getSingleResult();

			em.getTransaction().begin();

			anterior.setNombre(usuario.getNombre());
			anterior.setApellido(usuario.getApellido());

			em.getTransaction().commit();
			em.close();
		}
	}

	public static void eliminar(Usuario usuario) {
		EntityManager em = factoria.createEntityManager();

		if (existeEmail(usuario.getEmail())) {
			em.getTransaction().begin();
			Query q = em.createQuery(
					"SELECT u from Usuario u WHERE u.email LIKE :email")
					.setParameter("email", usuario.getEmail());

			Usuario borrado = (Usuario) q.getSingleResult();

			em.remove(borrado);
			em.getTransaction().commit();
			em.close();
		}
	}

	public static Usuario seleccionarUsuario(String email) {
		EntityManager em = factoria.createEntityManager();
		Usuario usuario = null;

		if (existeEmail(email)) {
			Query q = em.createQuery(
					"SELECT u from Usuario u WHERE u.email LIKE :email")
					.setParameter("email", email);

			usuario = (Usuario) q.getSingleResult();

			em.close();
		}

		return usuario;
	}

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

	public static List<Usuario> listarUsuarios() {
		EntityManager em = factoria.createEntityManager();
		Query q = em.createQuery("SELECT u from Usuario u");

		@SuppressWarnings("unchecked")
		List<Usuario> listaUsuarios = q.getResultList();

		em.close();

		return listaUsuarios;
	}

}
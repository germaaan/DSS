package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.BDUsuario;
import modelo.Usuario;

import org.junit.Before;
import org.junit.Test;

public class JPATest {
	private static final String PERSISTENCE_UNIT_NAME = "usuario";
	private EntityManagerFactory factoria;
	private String nombre = "German";
	private String apellido = "Martinez";
	private String email = "germaaan@gmail.com";
	private String email2 = "germaaan@hotmail.com";

	// Inicialización con un usuario de prueba
	@Before
	public void setUp() throws Exception {
		factoria = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factoria.createEntityManager();

		Query q = em.createQuery(
				"SELECT u from Usuario u WHERE u.email LIKE :email")
				.setParameter("email", this.email);

		if (q.getResultList().size() == 0) {
			em.getTransaction().begin();

			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setEmail(email);

			em.persist(usuario);

			em.getTransaction().commit();
			em.close();
		}
	}

	// Selección de usuario mediante su email
	@Test
	public void seleccionarUsuario() {
		Usuario usuario = BDUsuario.seleccionarUsuario(email);
		assertNotNull(usuario);
	}

	// Inserción de usuario mediante su nombre, apellido y email
	@Test
	public void insertar() {
		Usuario usuario = new Usuario();
		usuario.setNombre(this.nombre + " 2");
		usuario.setApellido(this.apellido + " 2");
		usuario.setEmail(email2);

		BDUsuario.insertar(usuario);

		assertTrue(BDUsuario.existeEmail(email2));
	}

	// Comprobación de existencia de usuario mediante su email
	@Test
	public void existeEmail() {
		assertTrue(BDUsuario.existeEmail(email2));
	}

	// Actualización de usuario mediante su nombre, apellido y email
	@Test
	public void actualizar() {
		Usuario usuario = new Usuario();
		usuario.setNombre(this.nombre + " 3");
		usuario.setApellido(this.apellido + " 3");
		usuario.setEmail(email);

		BDUsuario.actualizar(usuario);

		usuario = BDUsuario.seleccionarUsuario(email);
		assertEquals(usuario.getNombre(), this.nombre + " 3");
		assertEquals(usuario.getApellido(), this.apellido + " 3");
	}

	// Eliminación de usuario mediante su email
	@Test
	public void eliminar() {
		Usuario usuario = new Usuario();
		usuario.setEmail(email2);

		BDUsuario.eliminar(usuario);

		assertFalse(BDUsuario.existeEmail(email2));
	}
}

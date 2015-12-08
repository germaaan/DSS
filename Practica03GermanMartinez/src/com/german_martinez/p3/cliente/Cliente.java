package com.german_martinez.p3.cliente;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.german_martinez.p3.modelo.Coche;
import com.german_martinez.p3.modelo.CocheDao;

/*
 * Cliente para comprobar las funcionalidades CRUD del cliente RESTful
 */
public class Cliente {
	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());

		// Listamos los coches
		System.out.println("Texto con el listado de todos los coches:");
		System.out.println(service.path("rest").path("coches").request()
				.accept(MediaType.TEXT_XML).get(String.class));

		// Obtenemos el XML para la aplicación
		System.out
				.println("\nXML para la aplicación con el listado de todos los coches:");
		System.out.println(service.path("rest").path("coches").request()
				.accept(MediaType.APPLICATION_XML).get(String.class));

		// Crear un coche (CREATE)
		Form form = new Form();
		form.param("id", "4");
		form.param("marca", "Porsche");
		form.param("modelo", "Cayenne");
		form.param("anio", "2011");
		form.param("numPuertas", "5");
		form.param("potencia", "570");
		form.param("maxVelocidad", "284");
		form.param("combustible", "1");
		form.param("numPlazas", "5");
		form.param("precio", "192590");
		Response response = service
				.path("rest")
				.path("coches")
				.request()
				.post(Entity
						.entity(form, MediaType.APPLICATION_FORM_URLENCODED),
						Response.class);

		// El código de la respuesta debería ser 200 (Operación correcta)
		if (response.getStatus() == 200) {
			System.out.println("\nCoche creado (CREATE).");
		}

		// Obtenemos listado de todos los coches para comprobar que se ha creado
		System.out.println("Comprueba que se ha creado un coche con ID=4:");
		System.out.println(service.path("rest").path("coches").request()
				.accept(MediaType.APPLICATION_XML).get(String.class));

		// Leer un coche (READ)
		// Obtenemos el coche con el ID igual a 4
		System.out.println("\nCoche leido (READ).");
		System.out.println("Información del coche con ID=4:");
		System.out.println(service.path("rest").path("coches/4").request()
				.accept(MediaType.APPLICATION_XML).get(String.class));

		// Actualizar un coche (UPDATE)
		// Cambiamos los valores del coche que acabamos de crear
		Coche coche = new Coche("4", "Ferrari", "458", 2010, 2, 605, 325,
				Coche.GASOLINA, 2, 269022);
		response = service
				.path("rest")
				.path("coches")
				.path(coche.getId())
				.request(MediaType.APPLICATION_XML)
				.put(Entity.entity(coche, MediaType.APPLICATION_XML),
						Response.class);

		// El código de la respuesta debería ser 204 (recurso inexistente)
		if (response.getStatus() == 204) {
			System.out.println("\nCoche actualizado (UPDATE).");
		}

		// Volvemos a listar todos los coches para comprobar que se ha
		// actualizado
		System.out
				.println("Comprueba que se el coche con ID=4 ahora es un Ferrari:");
		System.out.println(service.path("rest").path("coches").request()
				.accept(MediaType.APPLICATION_XML).get(String.class));

		// Borrar un coche (DELETE)
		// Borramos el coche con el ID=4
		response = service.path("rest").path("coches/4").request().delete();

		// El código de la respuesta debería ser 204 (recurso inexistente)
		if (response.getStatus() == 204) {
			System.out.println("\nCoche borrado (DELETE).");
		}

		// Volvemos a listar todos los coches para comprobar que se ha borrado
		System.out.println("Comprueba que no existe un coche con ID=4:");
		System.out.println(service.path("rest").path("coches").request()
				.accept(MediaType.APPLICATION_XML).get(String.class));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/Practica03GermanMartinez").build();
	}
}

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

public class Tester {
	public static void main(String[] args) {

		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());

		// Crea el coche de prueba
		Coche coche = new Coche("4", "Ferrari", "458", 2010, 2, 605,
				325, Coche.GASOLINA, 2, 269022);
		Response response = service
				.path("rest")
				.path("coches")
				.path(coche.getId())
				.request(MediaType.APPLICATION_XML)
				.put(Entity.entity(coche, MediaType.APPLICATION_XML),
						Response.class);

		// El código de la respuesta debería ser 201 (recurso creado)
		System.out.println(response.getStatus());

		// Listamos los coches
		System.out.println(service.path("rest").path("coches").request()
				.accept(MediaType.TEXT_XML).get(String.class));

		// Obtenemos el XML para la aplicación
		System.out.println(service.path("rest").path("coches").request()
				.accept(MediaType.APPLICATION_XML).get(String.class));

		// Obtenemos el coche con el ID igual a 1
		Response checkDelete = service.path("rest").path("coches/1").request()
				.accept(MediaType.APPLICATION_XML).get();

		// Borramos el coche con el ID igual a 1
		service.path("rest").path("coches/1").request().delete();

		// Volvemos a listar todos los coches para comprobar que se ha borrado
		System.out.println(service.path("rest").path("coches").request()
				.accept(MediaType.APPLICATION_XML).get(String.class));

		// Crear un coche
		Form form = new Form();
		form.param("id", "5");
		form.param("marca", "Porsche");
		form.param("modelo", "Cayenne");
		form.param("anio", "2011");
		form.param("numPuertas", "5");
		form.param("potencia", "570");
		form.param("maxVelocidad", "284");
		form.param("combustible", "1");
		form.param("numPlazas", "5");
		form.param("precio", "192590");
		response = service
				.path("rest")
				.path("coches")
				.request()
				.post(Entity
						.entity(form, MediaType.APPLICATION_FORM_URLENCODED),
						Response.class);
		System.out.println("Form response " + response.getStatus());

		// Obtenemos listado de todos los coches para comprobar que se ha creado
		System.out.println(service.path("rest").path("coches").request()
				.accept(MediaType.APPLICATION_XML).get(String.class));

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/Practica03GermanMartinez").build();
	}
}

package recurso;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import modelo.Coche;
import modelo.CocheDao;

public class CocheRecurso {

	@Context
	UriInfo uriInfo;
	@Context
	Request peticion;
	String id;

	public CocheRecurso(UriInfo uriInfo, Request peticion, String id) {
		this.uriInfo = uriInfo;
		this.peticion = peticion;
		this.id = id;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Coche getCoche() {
		Coche coche = CocheDao.INSTANCE.getCoches().get(id);

		if (coche == null) {
			throw new RuntimeException(
					"GET: No se ha encontrado un coche con el id \"" + id
							+ "\".");
		}

		return coche;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public Coche getCocheHTML() {
		Coche coche = CocheDao.INSTANCE.getCoches().get(id);

		if (coche == null) {
			throw new RuntimeException(
					"GET: No se ha encontrado un coche con el id \"" + id
							+ "\".");
		}

		return coche;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putCoche(JAXBElement<Coche> elementoCoche) {
		Coche coche = elementoCoche.getValue();
		Response respuesta;

		if (CocheDao.INSTANCE.getCoches().containsKey(coche.getId())) {
			respuesta = Response.noContent().build();
		} else {
			respuesta = Response.created(uriInfo.getAbsolutePath()).build();
		}

		CocheDao.INSTANCE.getCoches().put(coche.getId(), coche);

		return respuesta;
	}

	@DELETE
	public void deleteCoche() {
		Coche coche = CocheDao.INSTANCE.getCoches().remove(id);

		if (coche == null) {
			throw new RuntimeException(
					"DELETE: No se ha encontrado un coche con el id \"" + id
							+ "\".");
		}
	}

}
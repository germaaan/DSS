package com.german_martinez.p3.recurso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import com.german_martinez.p3.cliente.Cliente;
import com.german_martinez.p3.modelo.Coche;
import com.german_martinez.p3.modelo.CocheDao;

@Path("/coches")
public class CochesRecurso {

	@Context
	UriInfo uriInfo;
	@Context
	Request peticion;
	@Context
	ServletContext contexto;

	public CochesRecurso() {
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Coche> getCoches() {
		List<Coche> listaCoches = new ArrayList<Coche>();
		listaCoches.addAll(CocheDao.INSTANCE.getCoches().values());

		return listaCoches;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Coche> getCochesAsHtml() {
		List<Coche> listaCoches = new ArrayList<Coche>();
		listaCoches.addAll(CocheDao.INSTANCE.getCoches().values());

		return listaCoches;
	}

	@GET
	@Path("/count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return Integer.toString(CocheDao.INSTANCE.getCoches().size());
	}

	@GET
	@Path("/imagen")
	@Produces("image/jpg")
	public Response getImage() {
		File file = new File(
				"/home/germaaan/proyectos/DSS/Practica03GermanMartinez/WebContent/img/bmw_serie3.jpg");

		ResponseBuilder responseBuilder = Response.ok((Object) file);
		responseBuilder.header("Content-Disposition",
				"attachment; filename=\"bmw_serie3.jpg\"");
		return responseBuilder.build();
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createCoche(@FormParam("id") String id,
			@FormParam("marca") String marca,
			@FormParam("modelo") String modelo, @FormParam("anio") int anio,
			@FormParam("numPuertas") int numPuertas,
			@FormParam("potencia") int potencia,
			@FormParam("maxVelocidad") int maxVelocidad,
			@FormParam("combustible") int combustible,
			@FormParam("numPlazas") int numPlazas,
			@FormParam("precio") float precio,
			@Context HttpServletResponse servletResponse) throws IOException {

		Coche coche = new Coche(id, marca, modelo, anio, numPuertas, potencia,
				maxVelocidad, combustible, numPlazas, precio);

		CocheDao.INSTANCE.getCoches().put(coche.getId(), coche);

		servletResponse.sendRedirect("./coches/");
	}

	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateCoche(@FormParam("id") String id,
			@FormParam("marca") String marca,
			@FormParam("modelo") String modelo, @FormParam("anio") int anio,
			@FormParam("numPuertas") int numPuertas,
			@FormParam("potencia") int potencia,
			@FormParam("maxVelocidad") int maxVelocidad,
			@FormParam("combustible") int combustible,
			@FormParam("numPlazas") int numPlazas,
			@FormParam("precio") float precio,
			@Context HttpServletResponse servletResponse) throws IOException {

		Coche coche = new Coche(id, marca, modelo, anio, numPuertas, potencia,
				maxVelocidad, combustible, numPlazas, precio);

		CocheDao.INSTANCE.getCoches().put(coche.getId(), coche);

		servletResponse.sendRedirect("../../index.html");
	}

	@Path("{coche}")
	public CocheRecurso getCoche(@PathParam("coche") String id) {
		return new CocheRecurso(uriInfo, peticion, id);
	}

}
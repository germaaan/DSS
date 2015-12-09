package com.german_martinez.p3.recurso;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
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

	private String pathSeat = "/home/germaaan/proyectos/DSS/Practica03GermanMartinez/WebContent/img/seat_leon.jpg";
	private String pathVW = "/home/germaaan/proyectos/DSS/Practica03GermanMartinez/WebContent/img/vw_golf.jpg";
	private String pathBMW = "/home/germaaan/proyectos/DSS/Practica03GermanMartinez/WebContent/img/bmw_serie3.jpg";

	public CochesRecurso() {
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Coche> getXML() {
		List<Coche> listaCoches = new ArrayList<Coche>();
		listaCoches.addAll(CocheDao.INSTANCE.getCoches().values());

		return listaCoches;
	}

	@GET
	@Produces({ MediaType.TEXT_XML })
	public List<Coche> getHTML() {
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
	@Path("/carseat")
	@Produces({ MediaType.TEXT_HTML })
	public String getCarSeat() {
		return CocheDao.INSTANCE.getCoches().get("1").toHTML()
				+ "<tr><td><strong>SONIDO</strong></td><td><audio controls><source src='/Practica03GermanMartinez/sound/sonidoSeat.mp3'type='audio/mpeg'>Este navegador no soporta elementos de audio.</audio></td></tr><tr><td></td><td></td></tr><tr><td><strong>IMAGEN</strong></td><td><img src='/Practica03GermanMartinez/img/seat_leon.jpg'width=600 height=333 alt='Seat Leon'></td></tr></tbody></table></div></div></body>";
	}

	@GET
	@Path("/carvw")
	@Produces({ MediaType.TEXT_HTML })
	public String getCarVW() {
		return CocheDao.INSTANCE.getCoches().get("2").toHTML()
				+ "<tr><td><strong>SONIDO</strong></td><td><audio controls><source src='/Practica03GermanMartinez/sound/sonidoVW.mp3'type='audio/mpeg'>Este navegador no soporta elementos de audio.</audio></td></tr><tr><td></td><td></td></tr><tr><td><strong>IMAGEN</strong></td><td><img src='/Practica03GermanMartinez/img/vw_golf.jpg'width=600 height=333 alt='Volkswagen Golf'></td></tr></tbody></table></div></div></body>";
	}

	@GET
	@Path("/carbmw")
	@Produces({ MediaType.TEXT_HTML })
	public String getCarBMW() {
		return CocheDao.INSTANCE.getCoches().get("3").toHTML()
				+ "<tr><td><strong>SONIDO</strong></td><td><audio controls><source src='/Practica03GermanMartinez/sound/sonidoBMW.mp3'type='audio/mpeg'>Este navegador no soporta elementos de audio.</audio></td></tr><tr><td></td><td></td></tr><tr><td><strong>IMAGEN</strong></td><td><img src='/Practica03GermanMartinez/img/bmw_serie3.jpg'width=600 height=333 alt='BMW Serie 3'></td></tr></tbody></table></div></div></body>";
	}

	@GET
	@Path("/imgseat")
	@Produces("image/jpg")
	public Response getSeat() {
		File imgSeat = new File(pathSeat);
		BufferedImage image = null;
		ByteArrayOutputStream baos = null;
		byte[] imageData = null;

		try {
			image = ImageIO.read(imgSeat);

			baos = new ByteArrayOutputStream();

			ImageIO.write(image, "jpg", baos);
			imageData = baos.toByteArray();
		} catch (IOException e) {
			System.err.println(e.getMessage());

			ResponseBuilder responseBuilder = Response.ok((Object) imgSeat);
			responseBuilder.header("Content-Disposition",
					"attachment; filename=\"seat_leon.jpg\"");
			return responseBuilder.build();
		}

		return Response.ok(new ByteArrayInputStream(imageData)).build();
	}

	@GET
	@Path("/imgvw")
	@Produces("image/jpg")
	public Response getVW() {
		File imgVW = new File(pathVW);
		BufferedImage image = null;
		ByteArrayOutputStream baos = null;
		byte[] imageData = null;

		try {
			image = ImageIO.read(imgVW);

			baos = new ByteArrayOutputStream();

			ImageIO.write(image, "jpg", baos);
			imageData = baos.toByteArray();
		} catch (IOException e) {
			System.err.println(e.getMessage());

			ResponseBuilder responseBuilder = Response.ok((Object) imgVW);
			responseBuilder.header("Content-Disposition",
					"attachment; filename=\"vw-golf.jpg\"");
			return responseBuilder.build();
		}

		return Response.ok(new ByteArrayInputStream(imageData)).build();
	}

	@GET
	@Path("/imgbmw")
	@Produces("image/jpg")
	public Response getBMW() {
		File imgBMW = new File(pathBMW);
		BufferedImage image = null;
		ByteArrayOutputStream baos = null;
		byte[] imageData = null;

		try {
			image = ImageIO.read(imgBMW);

			baos = new ByteArrayOutputStream();

			ImageIO.write(image, "jpg", baos);
			imageData = baos.toByteArray();
		} catch (IOException e) {
			System.err.println(e.getMessage());

			ResponseBuilder responseBuilder = Response.ok((Object) imgBMW);
			responseBuilder.header("Content-Disposition",
					"attachment; filename=\"bmw_serie3.jpg\"");
			return responseBuilder.build();
		}

		return Response.ok(new ByteArrayInputStream(imageData)).build();
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
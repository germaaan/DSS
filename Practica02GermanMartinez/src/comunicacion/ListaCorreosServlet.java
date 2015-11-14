package comunicacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.BDUsuario;
import modelo.Usuario;

@WebServlet("/ListaCorreosServlet")
public class ListaCorreosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaCorreosServlet() {
		super();

		Usuario usuario = new Usuario();
		usuario.setNombre("German");
		usuario.setApellido("Martinez");
		usuario.setEmail("germaaan@gmail.com");
		BDUsuario.insertar(usuario);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("action");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");

		if (accion == null) {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<h1>" + "Lista de usuarios" + "</h1>");

			writer.println("<table>");
			writer.println("<tr><th>Nombre</th><th>Apellido</th><th>Email</th>");
			for (Usuario u : BDUsuario.listarUsuarios()) {
				writer.println("<tr><td>" + u.getNombre() + "</td>");
				writer.println("<td>" + u.getApellido() + "</td>");
				writer.println("<td>" + u.getEmail() + "</td></tr>");
			}
			writer.println("</table>");
		} else {
			ObjectOutputStream oos = new ObjectOutputStream(
					response.getOutputStream());

			switch (accion) {
			case "listarUsuarios":
				List<Usuario> listaUsuarios = BDUsuario.listarUsuarios();

				oos.writeObject(listaUsuarios);

				break;
			case "aniadirUsuario":
				if (BDUsuario.existeEmail(email)) {
					oos.writeInt(1);
					oos.writeObject("Ya existe un usuario con el email \""
							+ email + "\".");
				} else {
					Usuario usuario = new Usuario();
					usuario.setNombre(nombre);
					usuario.setApellido(apellido);
					usuario.setEmail(email);

					BDUsuario.insertar(usuario);

					oos.writeInt(0);
					oos.writeObject("Usuario insertado correctamente.");
				}

				break;
			case "actualizarUsuario":
				if (BDUsuario.existeEmail(email)) {
					Usuario usuario = new Usuario();
					usuario.setNombre(nombre);
					usuario.setApellido(apellido);
					usuario.setEmail(email);

					BDUsuario.actualizar(usuario);

					oos.writeInt(0);
					oos.writeObject("Usuario actualizado correctamente.");
				} else {
					oos.writeInt(1);
					oos.writeObject("No existe un usuario con el email \""
							+ email + "\".");
				}

				break;
			case "eliminarUsuario":
				if (BDUsuario.existeEmail(email)) {
					Usuario usuario = BDUsuario.seleccionarUsuario(email);
					BDUsuario.eliminar(usuario);

					oos.writeInt(0);
					oos.writeObject("Usuario eliminado correctamente.");
				} else {
					oos.writeInt(1);
					oos.writeObject("No existe un usuario con el email \""
							+ email + "\".");
				}

				break;
			}

			oos.flush();
			oos.close();
		}
	}
}

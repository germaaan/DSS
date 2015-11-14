package comunicacion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.BDUsuario;
import modelo.Usuario;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ListaCorreosServlet")
public class ListaCorreosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("action");
		if (accion.equals("listarUsuarios")) {
			List<Usuario> lista = BDUsuario.listarUsuarios();

			ObjectOutputStream oos = new ObjectOutputStream(
					response.getOutputStream());
			oos.writeObject(lista);
			oos.flush();
			oos.close();
		} else if (accion.equals("aniadirUsuario")) {
			ObjectOutputStream oos = new ObjectOutputStream(
					response.getOutputStream());
			try {
				String nombre = request.getParameter("nombre"), apellido = request
						.getParameter("apellido"), email = request
						.getParameter("email");

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
			} catch (Exception e) {
				oos.writeInt(-1);
				oos.writeObject("Error al insertar el usuario.");
			} finally {
				oos.flush();
				oos.close();
			}
		} else if (accion.equals("actualizarUsuario")) {
			ObjectOutputStream oos = new ObjectOutputStream(
					response.getOutputStream());
			try {
				String nombre = request.getParameter("nombre"), apellido = request
						.getParameter("apellido"), email = request
						.getParameter("email");

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
			} catch (Exception e) {
				oos.writeInt(-1);
				oos.writeObject("Error al actualizar el usuario.");
			} finally {
				oos.flush();
				oos.close();
			}
		} else if (accion.equals("eliminarUsuario")) {
			ObjectOutputStream oos = new ObjectOutputStream(
					response.getOutputStream());
			try {
				String email = request.getParameter("email");

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
			} catch (Exception e) {
				oos.writeInt(-1);
				oos.writeObject("Error al eliminar el usuario.");
			} finally {
				oos.flush();
				oos.close();
			}
		} else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1>" + "Lista de usuarios" + "</h1>");

			out.println("<table>");
			out.println("<tr><th>Nombre</th><th>Apellido</th><th>Email</th>");
			for (Usuario u : BDUsuario.listarUsuarios()) {
				out.println("<tr><td>" + u.getNombre() + "</td>");
				out.println("<td>" + u.getApellido() + "</td>");
				out.println("<td>" + u.getEmail() + "</td></tr>");
			}
			out.println("</table>");
		}
	}

}

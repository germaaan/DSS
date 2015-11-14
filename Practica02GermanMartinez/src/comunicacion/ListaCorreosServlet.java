package comunicacion;

import java.io.IOException;
import java.io.PrintWriter;

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
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Usuario usuario = new Usuario();
		usuario.setNombre("German");
		usuario.setApellido("Martinez");
		usuario.setEmail("germaaan@gmail.com");
		BDUsuario.insertar(usuario);

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

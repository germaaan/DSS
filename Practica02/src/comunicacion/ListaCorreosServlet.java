package comunicacion;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.BDUsuario;
import modelo.Usuario;

import java.awt.List;
import java.io.IOException;

public class ListaCorreosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("usuarios", BDUsuario.listarUsuarios());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	};

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");

		if (!nombre.isEmpty() && !apellido.isEmpty() && !email.isEmpty()) {
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setEmail(email);
			
			System.out.println(usuario.toString());

			BDUsuario.insertar(usuario);
		}

		request.setAttribute("usuarios", BDUsuario.listarUsuarios());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}

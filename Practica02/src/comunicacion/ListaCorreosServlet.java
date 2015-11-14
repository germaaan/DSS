package comunicacion;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.BDUsuario;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "ListaCorreosServlet", urlPatterns = { "/ListaCorreosServlet" }, initParams = { @WebInitParam(name = "accion", value = "listar") })
public class ListaCorreosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		System.out.println("Servlet inicializado...");
	}

	// @Override
	// public void doGet(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// // request.getRequestDispatcher("index.jsp").forward(request, response);
	// response.setContentType("text/html");
	// PrintWriter out = response.getWriter();
	// out.println("<h1>" + "Lista de usuarios" + "</h1>");
	//
	// out.println("<table>");
	// out.println("<tr><th>Nombre</th><th>Apellido</th><th>Email</th>");
	// // for(Usuario u : BDUsuario.listarUsuarios()) {
	// // out.println("<tr><td>" + u.getNombre() + "</td>");
	// // out.println("<td>" + u.getApellido() + "</td>");
	// // out.println("<td>" + u.getEmail() + "</td></tr>");
	// // }
	// out.println("</table>");
	// }

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");

		 response.sendRedirect("index.jsp");
//		RequestDispatcher rd = getServletContext().getRequestDispatcher(
//				"/login.html");
//		PrintWriter out = response.getWriter();
//		out.println("<font color=red>Either user name or password is wrong.</font>");
//		rd.include(request, response);

	}

}

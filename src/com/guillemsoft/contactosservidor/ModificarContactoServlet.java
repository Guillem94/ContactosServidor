package com.guillemsoft.contactosservidor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificarContactoServlet
 */
@WebServlet("/ModificarContactoServlet")
public class ModificarContactoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarContactoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ContactosDAO contactosDAO = new ContactosDAO();
		Contacto contacto = contactosDAO
				.recuperarContacto(Integer.parseInt(id));
		String nombre = contacto.getNombre();
		String apellidos=contacto.getApellidos();
		String direccion=contacto.getDireccion();
		String telefono=contacto.getTelefono();
		String email=contacto.getEmail();
		ServletOutputStream out = response.getOutputStream();
		out.println("<html><head><title>Lista de contactos</title></head><body>");
		out.println("<form method=\"post\" action=\"NuevoContactoServlet\">");
		
		out.println("nombre:<input type=\"text\" name=\"nombre\" value=\""+nombre+"\" /><br />apellidos:<input type=\"text\" name=\"apellidos\" value=\""+apellidos+"\"/><br />");
		out.println("direccion:<input type=\"text\" name=\"direccion\" value=\""+direccion+"\" /><br />");
		out.println("telefono:<input type=\"text\" name=\"telefono\" value=\""+telefono+"\"/><br />");
		out.println("email:<input type=\"text\" name=\"email\" value=\""+email+"\" /><br />");
		out.println("<input type=\"submit\" value=\"Guardar\"></input><br />");
		out.println("<input type=\"reset\" value=\"Borrar todo\"></input></form>");
		out.println("<a href=\"index.html\">Volver</a>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

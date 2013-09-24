package com.guillemsoft.contactosservidor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActualizarContactoServlet
 */
@WebServlet("/ActualizarContactoServlet")
public class ActualizarContactoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarContactoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		String direccion=request.getParameter("direccion");
		String email=request.getParameter("email");
		String telefono=request.getParameter("telefono");
		String id=request.getParameter("id");
		Contacto contacto=new Contacto();
		contacto.setId(Integer.parseInt(id));
		contacto.setNombre(nombre);
		contacto.setApellidos(apellidos);
		contacto.setDireccion(direccion);
		contacto.setEmail(email);
		contacto.setTelefono(telefono);
		ContactosDAO contactosDAO=new ContactosDAO();
		contactosDAO.actualizarContacto(contacto);
		ServletOutputStream out = response.getOutputStream();
		out.println("<html><head><title>Contacto actualizado</title></head><body>");
		out.println("Contacto acrualizado correctamente <br />");
		out.println("<a href=\"index.html\">Volver</a>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

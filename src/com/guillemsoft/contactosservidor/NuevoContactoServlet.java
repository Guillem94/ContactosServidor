package com.guillemsoft.contactosservidor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NuevoContactoServlet
 */
@WebServlet("/NuevoContactoServlet")
public class NuevoContactoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoContactoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("llega petición get");
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request,	HttpServletResponse response) {
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		String direccion=request.getParameter("direccion");
		String email=request.getParameter("email");
		String telefono=request.getParameter("telefono");
		Contacto contacto=new Contacto();
		contacto.setNombre(nombre);
		contacto.setApellidos(apellidos);
		contacto.setDireccion(direccion);
		contacto.setEmail(email);
		contacto.setTelefono(telefono);
		ContactosDAO contactosDAO=new ContactosDAO();
		contactosDAO.guardarContacto(contacto);
		try {
			ServletOutputStream out = response.getOutputStream();
			out.println("<html><head><title>Contacto guardado</title></head><body>");
			out.println("Contacto guardado con éxito<br />");
			out.println("<a href=\"index.html\">Volver</a>");
			
			out.println("</body></html>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("llega petición post");
	processRequest(request,response);

	}

}

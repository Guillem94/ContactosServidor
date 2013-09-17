package com.guillemsoft.contactosservidor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListarContactosServlet
 */
@WebServlet("/ListarContactosServlet")
public class ListarContactosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarContactosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContactosDAO contactosDAO=new ContactosDAO();
		List<Contacto> contactos =contactosDAO.recuperarContactos();
		ServletOutputStream out = response.getOutputStream();
		out.println("<html><head><title>Lista de contactos</title></head><body><ul>");
		for(int i=0;i<contactos.size();i++){
			Contacto contacto=contactos.get(i);
		out.println("<li><a href=\"ModificarContactoServlet?id="+contacto.getId()+"\">"+contacto.getNombre()+"</a></li>");
		}
		out.println("</ul>");
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

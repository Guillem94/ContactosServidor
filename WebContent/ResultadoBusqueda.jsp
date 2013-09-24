<%@page import="com.guillemsoft.contactosservidor.Contacto"%>
<%@page import="java.util.List"%>
<%@page import="com.guillemsoft.contactosservidor.ContactosDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultados busqueda</title>
</head>
<body>
	<%
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		ContactosDAO contactosDAO = new ContactosDAO();
		List<Contacto> contactos = contactosDAO.buscarContactos(nombre,
				apellidos);
		if (contactos.size() == 0) {
	%>
	<h1>No existen contactos</h1>
	<%
		} else {
	%>
	<table>
		<thead>
			<td>Nombre</td>
			<td>Apellidos</td>
			<td>Direccion</td>
			<td>Telefono</td>
			<td>Email</td>

		</thead>
		<%
			for (Contacto contacto : contactos) {
				String nombre2 = contacto.getNombre();
				String apellidos2=contacto.getApellidos();
				String direccion=contacto.getDireccion();
				String telefono=contacto.getTelefono();
				String email=contacto.getEmail();
		%>
		<tr>
			<td><%out.print(nombre2);%></td>
			<td><%out.print(apellidos2);%></td>
			<td><%out.print(direccion);%></td>
			<td><%out.print(telefono);%></td>
			<td><%out.print(email);%></td>

		</tr>

		<%
			}
		%>
	</table>


	<%
		}
	%>


</body>
</html>
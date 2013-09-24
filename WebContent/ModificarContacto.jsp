<%@page import="com.guillemsoft.contactosservidor.ContactosDAO"%>
<%@ page import="com.guillemsoft.contactosservidor.Contacto" %>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	ContactosDAO contactosDAO = new ContactosDAO();
	Contacto contacto = contactosDAO.recuperarContacto(Integer.parseInt(id));
	
	String nombre = contacto.getNombre();
	String apellidos=contacto.getApellidos();
	String direccion=contacto.getDireccion();
	String telefono=contacto.getTelefono();
	String email=contacto.getEmail();
%>

<form method="get" action="ActualizarContactoServlet">
<input type="hidden" name="id" value="<%out.print(id);%>"/> 
nombre:<input type="text" name="nombre" value="<%out.print(nombre);%>"/>
<br />
apellidos:<input type="text" name="apellidos"  value="<%out.print(apellidos);%>"/>
<br />
direccion:<input type="text" name="direccion"  value="<%out.print(direccion);%>"/>
<br />
telefono:<input type="text" name="telefono"  value="<%out.print(telefono);%>"/>
<br />
email:<input type="text" name="email"  value="<%out.print(email);%>"/>
<br />

<a href="BorrarContactoServlet?id=<%out.print(id);%>" >Eliminar contacto</a>

<input type="submit" value="Guardar"></input><input type="reset" value="Borrar todo"></input>
</form>
<a href="index.html">Volver</a>

</body>
</html>
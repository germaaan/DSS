<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,modelo.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Práctica 2 - Germán Martínez Maldonado</title>
</head>
<body>
	<h1>Insertar usuario</h1>
	<form method="post" action="ListaCorreosServlet">
		<label for="nombre">Nombre</label> <input type="text" id="nombre"
			name="nombre" placeholder="Introduzca nombre" /> <label
			for="apellido">Apellido</label> <input type="text" id="apellido"
			name="apellido" placeholder="Introduzca apellido" /> <label
			for="email">Email</label> <input type="text" id="email" name="email"
			placeholder="Introduzca email" /> <input type="submit"
			value="Añadir" />
	</form>
	<hr>
	<hr>
</body>
</html>
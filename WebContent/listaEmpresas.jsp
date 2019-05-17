<%@page import="java.util.ArrayList"%>
<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%
	ArrayList<Empresa> empresas = (ArrayList<Empresa>)request.getAttribute("empresas");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>
	<ul>
		<% 	for (Empresa empresa : empresas){ %>
		<li>
			<%= empresa.getNome() %>
		</li>
		<% }%>
	</ul>
</body>
</html>
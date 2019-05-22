<%@page import="java.util.ArrayList"%>
<%@page import="br.com.alura.gerenciador.modelo.Empresa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standart Taglib</title>
</head>
<body>
	<h3>Lista de empresas:</h3>

	<ul>	
		<c:forEach items="${empresas}" var="empresa">
			
			<li>
				${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" /> 
				<a href="/gerenciador/entrada?acao=removeEmpresa&id=${empresa.id}">remove</a>
				<a href="/gerenciador/entrada?acao=mostraEmpresa&id=${empresa.id}">editar</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>
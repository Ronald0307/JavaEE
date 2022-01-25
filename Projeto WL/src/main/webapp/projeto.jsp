<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("projeto");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Café da manhã</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Lista de café da manhã</h1>
	<a href="novo.html" class="Botao1">Adicionar</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Item</th>
				<th>Opções</th>
			</tr>
			</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td><%=lista.get(i).getItem()%></td>
				<td>
					<a href="select?idcon=<%=lista.get(i).getIdcon()%>"
					class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)"
					class="Botao2">Excluir</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>
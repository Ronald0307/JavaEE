<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Café da manhã</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Contato</h1>
	<form name="frmpessoas" action="update">
		<table>
			<tr>
				<td><input type="text" name="idcon" id="Caixa3" readonly
					value="<%out.print(request.getAttribute("idcon"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1"
					value="<%out.print(request.getAttribute("nome"));%>">></td>
			</tr>
			<tr>
				<td><input type="text" name="cpf" class="Caixa2"
					value="<%out.print(request.getAttribute("cpf"));%>">></td>
			</tr>
			<tr>
				<td><input type="text" name="item" class="Caixa1"
					value="<%out.print(request.getAttribute("item"));%>">></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>
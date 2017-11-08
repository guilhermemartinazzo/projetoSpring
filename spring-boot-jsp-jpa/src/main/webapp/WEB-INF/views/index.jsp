<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projetos</title>
<%-- <link rel="stylesheet" href="<c:url value="/static/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"> --%>
<link rel="stylesheet" href="<c:url value="/static/bootstrap-4/css/bootstrap.min.css"/>">
<script src="<c:url value="/static/lib/jquery-1.11.1.min.js"/>"></script>
<script src="<c:url value="/static/js/funcoes.js"/>"></script>
</head>
<body>
<div class="container">
	
		<h2 class="form-sigin-heading" style="text-align:center;">Projetos</h2>
		<input type="text" id="nome" class="form-control" placeholder="Nome do projeto">
		<input type="text" id="descricao" class="form-control" placeholder="Descrição do projeto">
		<input type="date" id="dtIni" class="form-control" placeholder="Data de início" style="width: 20%;">
		<input type="date" id="dtPrevTerm" class="form-control" placeholder="Previsão de término" style="width: 20%;">
		<input type="number" id="orcamento" class="form-control" placeholder="Orçamento total (Em Reais)" style="width: 20%;">
		<table>
			<tr>
				<td>Gerente:</td>
				<td><select name="idgerente" id="gerente">
				<option value = "">Selecione</option>
				<c:forEach var="lista" items="${listaPessoas}">
					<option value="${lista.id}">${lista.nome}</option>
				</c:forEach>
				</select>
				</td>
			</tr>
		</table>
		<button class="btn btn-primary btn-block btn-lg" onclick="salvarProjeto()">Salvar Projeto</button>
		
		
		<c:if test="${!listaVazia}">
			<table class="table-striped" style="width:100%;">
			<tr style="font-weight: bold;text-align:center;">
				<td>Código</td>
				<td>Nome </td>
				<td>Data de Início </td>
				<td>Previsão Fim </td>
				<td>Data de Fim </td>
				<td>Descrição</td>
				<td>Status</td>
				<td>Orçamento</td>
				<td>Risco</td>
				<td>Id Gerente</td>
			</tr>
			<c:forEach var="projeto" items="#{listaProjetos}">
			<tr>
				<td> <c:out value="${projeto.id}"/> </td>
				<td><c:out value="${projeto.nome}"/> </td>
				<td><fmt:formatDate value="${projeto.dataInicio}" type="date" pattern="dd/MM/yyyy"/> </td>
				<td><fmt:formatDate value="${projeto.dataPrevisaoFim}" type="date" pattern="dd/MM/yyyy"/></td>
				<td><fmt:formatDate value="${projeto.dataFim}" type="date" pattern="dd/MM/yyyy"/></td>
				<td><c:out value="${projeto.descricao}"/> </td>
				<td><c:out value="${projeto.status}"/> </td>
				<td><fmt:formatNumber currencySymbol="R$" type="currency" value="${projeto.orcamento}"/></td>
				<td><c:out value="${projeto.risco}"/> </td>
				<td><c:out value="${projeto.idGerente}"/> </td>
			</tr>
			</c:forEach>
			</table>
		</c:if>
	
</div>
</body>
</html>
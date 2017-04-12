<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- cria o DAO -->
<html>
<body>
	<c:import url="cabecalho.jsp" />
	<h2><a href="mvc?logica=CarregaContatoLogic"> + Novo Contato</a></h2>
	<table>
		<!-- percorre contatos montando as linhas da tabela -->
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
		</tr>
		<c:forEach var="contato" items="${contatos}">
			<tr>
				<td>${contato.nome}</td>
				<td><c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if> <c:if test="${empty contato.email}">
E-mail não informado
</c:if></td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
				<td><a href="mvc?logica=CarregaContatoLogic&id=${contato.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>
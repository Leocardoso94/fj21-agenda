<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- cria o DAO -->
<html>
<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao" />
<table>
	<!-- percorre contatos montando as linhas da tabela -->
	<tr>
		<th>Nome</th>
		<th>Email</th>
		<th>Endere�o</th>
		<th>Data de Nascimento</th>
	</tr>
	<c:forEach var="contato" items="${dao.lista}">
		<tr>
			<td>${contato.nome}</td>
			<td><c:if test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
				</c:if> <c:if test="${empty contato.email}">
E-mail n�o informado
</c:if></td>
			<td>${contato.endereco}</td>
			<td>${contato.dataNascimento.time}</td>
			<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
			</td>
		</tr>
	</c:forEach>
</table>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<h3>Alterar Contato</h3>
	<form action="mvc">
		<input value="${id}" name="id" type="hidden" readonly>
		<input value="AlteraContatoLogic" name="logica" readonly type="hidden">
		Nome: <input type="text" name="nome" value="${nome}" /> <br />
		E-mail: <input type="text" name="email" value="${email}" /><br />
		Endereço: <input type="text" name="endereco" value="${endereco}" /><br />
		Data Nascimento: <input type="text" name="dataNascimento"
			value="${dataNascimento}"> <br /> <input type="submit"
			value="Alterar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>
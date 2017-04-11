<%@page import="java.text.SimpleDateFormat"%>
<%@ page
	import="java.util.*,
br.com.caelum.agenda.dao.*,
br.com.caelum.agenda.modelo.*"%>
<html>
<body>
	<table>
		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			for (Contato contato : contatos) {
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=sdf.format(contato.getDataNascimento().getTime())%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>

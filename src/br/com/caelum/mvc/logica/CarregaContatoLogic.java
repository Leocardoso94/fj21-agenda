package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class CarregaContatoLogic implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = 0;
		String email = "";
		String endereco = "";
		String dataNascimento = "";
		String nome = "";
		if (req.getParameter("id") != null) {
			Connection connection = (Connection) req.getAttribute("conexao");

			ContatoDao dao = new ContatoDao(connection);
			Contato contato = dao.pesquisar(Integer.parseInt(req.getParameter("id")));
			id = contato.getId();
			email = contato.getEmail();
			nome = contato.getNome();
			endereco = contato.getEndereco();
			dataNascimento = new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime());
		}
		req.setAttribute("id", id);
		req.setAttribute("email", email);
		req.setAttribute("dataNascimento", dataNascimento);
		req.setAttribute("nome", nome);
		req.setAttribute("endereco", endereco);
		System.out.println("Carregando contato... " + nome);

		return "/WEB-INF/jsp/add-contato.jsp";
	}

}

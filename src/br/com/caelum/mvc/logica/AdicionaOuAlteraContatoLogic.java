package br.com.caelum.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AdicionaOuAlteraContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Contato contato = new Contato();
		
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		Calendar dataNascimento = null;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("dataNascimento"));
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			System.out.println("Erro de convers�o da data");			 
		}
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao contatoDao = new ContatoDao();
		
		System.out.println(req.getParameter("id"));
		
		if(!req.getParameter("id").equals("0")){
			contato.setId(Long.parseLong(req.getParameter("id")));
			System.out.println("Alterando Contato "+ contato.getNome());
			contatoDao.altera(contato);
		}
		else{		
			System.out.println("Adicionando Contato "+ contato.getNome());
		contatoDao.adiciona(contato);
		}
		return "mvc?logica=ListaContatosLogic";
	}

}

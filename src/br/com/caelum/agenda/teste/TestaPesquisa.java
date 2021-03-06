package br.com.caelum.agenda.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class TestaPesquisa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = new ConnectionFactory().getConnection();
		ContatoDao dao = new ContatoDao(con);
		Contato contato = dao.pesquisar(2);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Endere�o: " + contato.getEndereco());
		System.out.println("Data de Nascimento: " + sdf.format(contato.getDataNascimento().getTime()) + "\n");
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

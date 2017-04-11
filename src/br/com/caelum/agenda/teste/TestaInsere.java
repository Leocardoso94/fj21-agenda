package br.com.caelum.agenda.teste;

import br.com.caelum.agenda.dao.FuncionarioDao;
import br.com.caelum.agenda.modelo.Funcionario;

public class TestaInsere {

	public static void main(String[] args) {
		Funcionario f = new Funcionario();
		f.setNome("Joao");
		f.setSenha("1234");
		f.setUsuario("jaozika");

		FuncionarioDao dao = new FuncionarioDao();
		dao.adiciona(f);
	}

}

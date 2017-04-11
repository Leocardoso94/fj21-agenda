package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.modelo.Funcionario;

public class FuncionarioDao {
	private Connection conn;

	public FuncionarioDao() {
		this.conn = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario funcionario) {
		String sql = "insert into funcionarios " + "(nome,usuario,senha)" + " values (?,?,?)";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, funcionario.getNome());
			st.setString(2, funcionario.getUsuario());
			st.setString(3, funcionario.getSenha());

			st.execute();
			st.close();

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}

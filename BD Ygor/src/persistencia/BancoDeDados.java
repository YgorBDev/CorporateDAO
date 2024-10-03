package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import model.Pessoa;

public class BancoDeDados {
	private Connection db;
	
	public BancoDeDados() {
		try {
			this.db = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd_cadastro",
					"root",
					"root"
				);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void armazenarPessoa(Pessoa p) throws SQLException {
		String query = "INSERT INTO pessoa VALUES(null, ?, ?, ?)";
		PreparedStatement st = db.prepareStatement(query);
		st.setString(1, p.getNome());
		st.setString(2, p.getCpf());
		st.setString(3, p.getDataNascimento());
		st.executeUpdate();
	}
	
	public ArrayList<Pessoa> getPessoas() throws SQLException {
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		String query = "SELECT nome, cpf, data_nasc FROM pessoa";
		PreparedStatement st = db.prepareStatement(query);
		ResultSet res = st.executeQuery();
		while (res.next()) {
			String nome = res.getString("nome");
			String cpf = res.getString("cpf");
			String dataNasc = res.getString("data_nasc");
			Pessoa p = new Pessoa(nome, cpf, dataNasc);
			lista.add(p);
		}
		return lista;
	}
}
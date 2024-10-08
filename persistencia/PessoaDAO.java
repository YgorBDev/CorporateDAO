package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pessoa;

public class PessoaDAO {
	private Connection bd;
	
	public PessoaDAO() {
		this.bd = BancoDeDados.getBd();
	}
	
	public void create(Pessoa p) throws SQLException {
		String query = "INSERT INTO pessoa VALUES(null, ?, ?, ?)";
		PreparedStatement st = this.bd.prepareStatement(query);
		st.setString(1, p.getNome());
		st.setString(2, p.getCpf());
		st.setString(3, p.getDataNascimento());
		st.executeUpdate();
	}
	
	public ArrayList<Pessoa> getAll() throws SQLException {
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		String query = "SELECT nome, cpf, data_nasc FROM pessoa";
		PreparedStatement st = this.bd.prepareStatement(query);
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
	
	public void update(Pessoa p) throws SQLException {
		String query = """
				UPDATE pessoa
				SET nome = ?, data_nasc = ?
				WHERE cpf = ?
		""";
		PreparedStatement st = this.bd.prepareStatement(query);
		st.setString(1, p.getNome());
		st.setString(2, p.getDataNascimento());
		st.setString(3, p.getCpf());
		st.executeUpdate();
	}
	
	public void delete(Pessoa p) throws SQLException {
		String query = """
				DELETE FROM pessoa
				WHERE cpf = ?
		""";
		PreparedStatement st = this.bd.prepareStatement(query);
		st.setString(1, p.getCpf());
		st.executeUpdate();
	}
	
	public ArrayList<Pessoa> findByNomeLike(String s) throws SQLException {
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		String query = """
				SELECT nome, cpf, data_nasc
				FROM pessoa
				WHERE nome LIKE ?
		""";
		PreparedStatement st = this.bd.prepareStatement(query);
		st.setString(1, "%" + s + "%");
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

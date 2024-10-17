package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Empresa;
import model.Status;

public class EmpresaDAO {
    private Connection bd;

    public EmpresaDAO() {
        this.bd = BancoDeDados.getBd();
    }

    public void create(Empresa e) throws SQLException {
        String query = "INSERT INTO empresa VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement st = this.bd.prepareStatement(query)) {
            st.setString(1, e.getNomeEmpresa());
            st.setString(2, e.getCnpj());
            st.setString(3, e.getDataCriacao());
            st.setString(4, e.getLugar());
            st.setDouble(5, e.getLucroBruto());
            st.setDouble(6, e.getLucroLiquido());
            st.setDouble(7, e.getImposto());
            st.setInt(8, e.getQtdeFuncionario());
            st.executeUpdate();
        }
    }

    public ArrayList<Empresa> getAll() throws SQLException {
        ArrayList<Empresa> lista = new ArrayList<>();
        String query = "SELECT * FROM empresa"; // Adjust columns as necessary
        try (PreparedStatement st = this.bd.prepareStatement(query);
             ResultSet res = st.executeQuery()) {
            while (res.next()) {
                String nomeEmpresa = res.getString("nome");
                String cnpj = res.getString("cnpj");
                String dataCriacao = res.getString("dataCriacao");
                String lugar = res.getString("lugar");
                double lucroBruto = res.getDouble("lucroBruto");
                double lucroLiquido = res.getDouble("lucroLiquido");
                double imposto = res.getDouble("imposto");
                int qtdeFuncionario = res.getInt("qtdeFuncionario");
                Status status = Status.valueOf(res.getString("status")); // Ensure Status is an enum

                Empresa e = new Empresa(nomeEmpresa, cnpj, dataCriacao, lugar, lucroBruto, lucroLiquido, imposto, qtdeFuncionario, status);
                lista.add(e);
            }
        }
        return lista;
    }

    public void update(Empresa e) throws SQLException {
        String query = "UPDATE empresa SET nome = ?, lugar = ?, dataCriacao = ?, lucroBruto = ?, lucroLiquido = ?, imposto = ?, qtdeFuncionario = ? WHERE cnpj = ?";
        try (PreparedStatement st = this.bd.prepareStatement(query)) {
            st.setString(1, e.getNomeEmpresa());
            st.setString(2, e.getLugar());
            st.setString(3, e.getDataCriacao());
            st.setDouble(4, e.getLucroBruto());
            st.setDouble(5, e.getLucroLiquido());
            st.setDouble(6, e.getImposto());
            st.setInt(7, e.getQtdeFuncionario());
            st.setString(8, e.getCnpj());
            st.executeUpdate();
        }
    }

    public void delete(Empresa e) throws SQLException {
        String query = "DELETE FROM empresa WHERE cnpj = ?";
        try (PreparedStatement st = this.bd.prepareStatement(query)) {
            st.setString(1, e.getCnpj());
            st.executeUpdate();
        }
    }

    public ArrayList<Empresa> findByNomeLike(String s) throws SQLException {
        ArrayList<Empresa> lista = new ArrayList<>();
        String query = "SELECT * FROM empresa WHERE nome LIKE ?";
        try (PreparedStatement st = this.bd.prepareStatement(query)) {
            st.setString(1, "%" + s + "%");
            try (ResultSet res = st.executeQuery()) {
                while (res.next()) {
                    String nomeEmpresa = res.getString("nome");
                    String cnpj = res.getString("cnpj");
                    String dataCriacao = res.getString("dataCriacao");
                    String lugar = res.getString("lugar");
                    double lucroBruto = res.getDouble("lucroBruto");
                    double lucroLiquido = res.getDouble("lucroLiquido");
                    double imposto = res.getDouble("imposto");
                    int qtdeFuncionario = res.getInt("qtdeFuncionario");
                    Status status = Status.valueOf(res.getString("status")); // Ensure Status is an enum

                    Empresa e = new Empresa(nomeEmpresa, cnpj, dataCriacao, lugar, lucroBruto, lucroLiquido, imposto, qtdeFuncionario, status);
                    lista.add(e);
                }
            }
        }
        return lista;
    }
}

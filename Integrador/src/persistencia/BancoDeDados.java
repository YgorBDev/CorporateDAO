package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDeDados {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_integrador";
    private static final String USER = "root"; 
    private static final String PASSWORD = "root"; 


    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexão estabelecida com sucesso!");
            
            adicionarEmpresas(conn, "Tech Solutions", "123.456/0001-95", "São Paulo", "2015-04-01", 200000.00, 150000.00, 20000.00, "ativa");
            
            listarEmpresas(conn);
            
            adicionarFuncionario(conn, "Roberta Costa", "454.563.908.22", "2005-05-15", "Estagiaria", 2000.00, "66611112222", "2024-01-10", "ativo");
            
            listarFuncionarios(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void adicionarEmpresas(Connection conn, String nome, String cnpj, String lugar, String data_criacao, double lucro_bruto, double lucro_liquido, double imposto, String status) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, cpf, data_nasc, cargo, salario, celular, data_admissao, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, cnpj);
            pstmt.setString(3, lugar);
            pstmt.setString(4, data_criacao);
            pstmt.setDouble(5, lucro_bruto);
            pstmt.setDouble(6, lucro_liquido);
            pstmt.setDouble(7, imposto);
            pstmt.setString(8, status);
            pstmt.executeUpdate();
            System.out.println("Funcionário adicionado com sucesso!");
        }
    }
    
    private static void listarEmpresas(Connection conn) throws SQLException {
        String sql = "SELECT * FROM empresa";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Empresa: " + rs.getString("nome") + ", CNPJ: " + rs.getString("cnpj"));
            }
        }
    }

    private static void adicionarFuncionario(Connection conn, String nome, String cpf, String dataNasc, String cargo, double salario, String celular, String dataAdmissao, String status) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, cpf, data_nasc, cargo, salario, celular, data_admissao, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, cpf);
            pstmt.setString(3, dataNasc);
            pstmt.setString(4, cargo);
            pstmt.setDouble(5, salario);
            pstmt.setString(6, celular);
            pstmt.setString(7, dataAdmissao);
            pstmt.setString(8, status);
            pstmt.executeUpdate();
            System.out.println("Funcionário adicionado com sucesso!");
        }
    }

    private static void listarFuncionarios(Connection conn) throws SQLException {
        String sql = "SELECT * FROM funcionario";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Funcionário: " + rs.getString("nome") + ", CPF: " + rs.getString("cpf"));
            }
        }
    }
}

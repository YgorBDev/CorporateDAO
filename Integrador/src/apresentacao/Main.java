package apresentacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Scanner;
import persistencia/BancoDeDados;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner teclado = new Scanner(System.in);
			
			BancoDeDados bd = new BancoDeDados();

			while (true) {
				
				System.out.println("\n== Cadastro Empresarial ==");
				System.out.println("1) Cadastrar uma Empresa");
				System.out.println("2) Mostrar Empresas Cadastradas");
				System.out.println("3) Contratar Funcionarios");
				System.out.println("4) Mostrar Contratos ");
				System.out.println("5) Declarar Impostos");
				System.out.println("6) Mostrar Declaraçoes");
				System.out.println("7) Opção Secret");
				
				System.out.print("Escolha uma opção: ");
				int opcao = teclado.nextInt();
				teclado.nextLine();

				if (opcao == 1) {
					System.out.print("\nDigite o nome da empresa: ");
					String nome_empresa = teclado.nextLine();
					System.out.print("\nDigite o lugar da empresa: ");
					String lugar = teclado.nextLine();
					System.out.print("Digite o CNPJ da empresa: ");
					String CNPJ = teclado.nextLine();
					System.out.print("Digite a data de criação da empresa (YYYY-MM-DD): ");
					String data_criacao = teclado.nextLine();
					System.out.print("\nDigite o lucro bruto da empresa: ");
					String lucro_bruto = teclado.nextLine();
					System.out.print("\nDigite o lucro liquido da empresa: ");
					String lucro_liquido = teclado.nextLine();
					System.out.print("\nDigite o imposto pago pela empresa: ");
					String imposto = teclado.nextLine();
			
					empresa e = new empresa(nome_empresa, lugar, CNPJ, data_criacao);
					try {
						bd.armazenarEmpresa(e);
					} catch (SQLIntegrityConstraintViolationException e) {
					
						System.out.println("\n*** Esse CNPJ já foi cadastrado!");
						continue;
					}
					System.out.println("\nUsuário cadastrado com sucesso!");
				}
				
				else if (opcao == 2) {
					ArrayList<Pessoa> lista = bd.getPessoas();
					if (lista.size() == 0) {
						System.out.println("\nO cadastro está vazio.");
					} else {
						System.out.println("\nPessoas cadastradas:");
						for (Pessoa p: lista) {
							System.out.println(p);
						}
					}
				}
				
				
        adicionarEmpresas(conn, "Tech Solutions", "123.456/0001-95", "São Paulo", "2015-04-01", 200000.00, 150000.00, 20000.00, "ativa");
        
        listarEmpresas(conn);
        
        adicionarFuncionario(conn, "Roberta Costa", "454.563.908.22", "2005-05-15", "Estagiaria", 2000.00, "66611112222", "2024-01-10", "ativo");
        
        listarFuncionarios(conn);
    } catch (SQLException e) {
        e.printStackTrace();
    	}
    }
}
package apresentacao;

import java.util.ArrayList;
import java.util.Scanner;
import model.Empresa;
import persistencia.EmpresaDAO;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Main {


	public static void main(String[] args) {
		try {
			Scanner teclado = new Scanner(System.in);

			while (true) {
				System.out.println("\n== Sistema Empresarial ==");
				System.out.println("1) Cadastrar uma pessoa");
				System.out.println("2) Mostrar o cadastro");
				System.out.println("3) Encerrar");
				
				System.out.print("Escolha uma opção: ");
				int opcao = teclado.nextInt();
				teclado.nextLine();

				if (opcao == 1) {
					try {
						System.out.print("\nDigite o nome da Empresa: ");
						String nomeEmpresa = teclado.nextLine();
						System.out.print("Digite o CNPJ da Empresa: ");
						String cnpj = teclado.nextLine();
						System.out.print("Digite a data de criação da empresa: ");
						String dataCriacao = teclado.nextLine();
						System.out.print("Informe o local da empresa: ");
						String lugar = teclado.nextLine();
						System.out.print("Digite o lucro bruto da sua empresa: ");
						Double lucroBruto = teclado.nextDouble();
						System.out.print("Digite o número de funcionários da sua empresa: ");
						Double qtdeFuncionario = teclado.nextDouble();
						
						Empresa e = new Empresa(nomeEmpresa, cnpj, dataCriacao, dataCriacao, lucroBruto, qtdeFuncionario, null);
						EmpresaDAO ed = new EmpresaDAO();
						ed.create(e);
					} catch (SQLIntegrityConstraintViolationException e) {
				
						System.out.println("\n*** Esse CNPJ já foi cadastrado!");
						continue;
					}
					System.out.println("\nEmpresa cadastrada com sucesso!");
				}
				else if (opcao == 2) {
					EmpresaDAO ed = new EmpresaDAO();
					ArrayList<Empresa> lista = ed.getAll();
					if (lista.size() == 0) {
						System.out.println("\nO cadastro está vazio.");
					} else {
						System.out.println("\nPessoas cadastradas:");
						for (Empresa e: lista) {
							System.out.println(e);
						}
					}
				}
				
				else if (opcao == 3) {
					break;
				}
				else {
					System.out.println("Opção inválida!");
				}
			}
			teclado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("\nTenha um bom dia!");
		}
	}

}
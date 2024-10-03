package apresentacao;

import java.util.ArrayList;
import java.util.Scanner;
import model.Pessoa;
import persistencia.BancoDeDados;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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
					System.out.print("\nDigite o nome da pessoa: ");
					String nome = teclado.nextLine();
					System.out.print("Digite o CPF da pessoa: ");
					String cpf = teclado.nextLine();
					System.out.print("Digite a data de nascimento da pessoa (YYYY-MM-DD): ");
					String DataNascimento = teclado.nextLine();
					Pessoa p = new Pessoa(nome, cpf, DataNascimento);
					try {
						bd.armazenarPessoa(p);
					} catch (SQLIntegrityConstraintViolationException e) {
					
						System.out.println("\n*** Esse CPF já foi cadastrado!");
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
				
				else if (opcao == 3) {
					break;
				}
				
				else {
					System.out.println("Opção inválida!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("\nTenha um bom dia!");
		}
	}

}
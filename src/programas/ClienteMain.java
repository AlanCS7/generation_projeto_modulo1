package programas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import classes.Cliente;
import classes.ClientePf;
import classes.ClientePj;

public class ClienteMain {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		
		try {
		ClientePf clientePf = new ClientePf();
		ClientePj clientePj = new ClientePj();

		List<Cliente> clientes = new ArrayList<>();

		System.out.print("------------------BEM VINDO AO GBANK!------------------\n");
		System.out.println();
		System.out.print("Informe quantos clientes deseja cadastrar: ");
		int nCli = sc.nextInt();

		System.out.println();
		for (int i = 0; i < nCli; i++) {

			System.out.print("------------------CRIAR NOVO CLIENTE------------------\n");
			System.out.println();
			System.out.print("Qual tipo de Cliente (F ou J)? ");
			char cli = sc.next().charAt(0);

			if (cli == 'F' || cli == 'f') {

				System.out.print("Digite o número da conta pessoa fisica: ");
				int num = sc.nextInt();
				sc.nextLine();

				System.out.print("Digite o nome da conta: ");
				String nome = sc.nextLine();

				System.out.print("Digite o endereço: ");
				String end = sc.nextLine();

				System.out.print("Digite o CPF: ");
				String cpf = sc.nextLine();

				double deposito = 0.0;

				System.out.print("------------------------------------------------------\n\n");
				clientePf = new ClientePf(num, nome, end, deposito, cpf);

				int n;

				do {

					System.out.println("Digite uma das opções abaixo: " + "\n1 - DEPOSITO" + "\n2 - SAQUE"
							+ "\nO - SAIR DO MENU");
					System.out.println();
					System.out.print("OPÇÃO: ");
					n = sc.nextInt();

					if (n == 1) {
						System.out.print("\nDigite o valor do depósito: ");
						deposito = sc.nextDouble();
						clientePf.deposito(deposito);
						System.out.print("Novo Saldo: " + clientePf.getSaldo() + "\n\n");
					} else if (n == 2) {
						System.out.print("\nDigite o valor do Saque com taxa de 5 reais: ");
						double saque = sc.nextDouble();
						clientePf.saque(saque);
						System.out.print("Novo Saldo: " + clientePf.getSaldo() + "\n\n");
					}

				} while (n != 0);

				System.out.print("\n------------------------------------------------------\n");
				clientes.add(clientePf);

			} else if (cli == 'J' || cli == 'j') {

				System.out.print("Digite o número da conta pessoa juridica: ");
				int num = sc.nextInt();
				sc.nextLine();

				System.out.print("Digite o nome da conta: ");
				String nome = sc.nextLine();

				System.out.print("Digite o endereço: ");
				String end = sc.nextLine();

				System.out.print("Digite o CNPJ: ");
				String cnpj = sc.nextLine();

				double deposito = 0.0;

				System.out.print("------------------------------------------------------\n\n");
				clientePj = new ClientePj(num, nome, end, deposito, cnpj);

				int n;
				do {

					System.out.println("Digite uma das opções abaixo: " + "\n1 - DEPOSITO" + "\n2 - SAQUE"
							+ "\nO - SAIR DO MENU");
					System.out.println();
					System.out.print("OPÇÃO: ");
					n = sc.nextInt();

					if (n == 1) {
						System.out.print("\nDigite o valor do depósito: ");
						deposito = sc.nextDouble();
						clientePj.deposito(deposito);
						System.out.print("Novo Saldo: " + clientePj.getSaldo() + "\n\n");
					} else if (n == 2) {
						System.out.print("\nDigite o valor do Saque com taxa de 7 reais: ");
						double saque = sc.nextDouble();
						clientePj.saque(saque);
						System.out.print("Novo Saldo: " + clientePj.getSaldo() + "\n\n");
					}

				} while (n != 0);

				System.out.print("\n------------------------------------------------------\n");
				clientes.add(clientePj);

			} else {
				System.out.println("Digite uma das opções (F ou J)");
			}

		}

		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}

		int na = 0;
		int np = 0;

		do {
			System.out.println("\n-------------------MENU DE OPÇÕES-------------------");
			System.out.println("\n1 - REMOVER CLIENTE" + "\n2 - ATUALIZAR CLIENTE" + "\nO - SAIR DO PROGRAMA");
			System.out.println();
			System.out.print("OPÇÃO: ");
			na = sc.nextInt();

			if (na == 1) {

				System.out.print("\nDigite número da conta do cliente que vai ser removido: ");
				int nConta = sc.nextInt();

				clientes.removeIf(x -> x.getNumConta() == nConta);

			} else if (na == 2) {

				System.out.print("\nDigite número da conta do cliente que vai ser atualizado: ");
				int nConta = sc.nextInt();
				do {
					if (nConta == clientePf.getNumConta()) {
						System.out.println("\nDigite uma das opções que deseja atualizar:" + "\n1 - NOME"
								+ "\n2 - ENDEREÇO" + "\nO - SAIR DO MENU");
						System.out.println();
						System.out.print("OPÇÃO: ");
						int op = sc.nextInt();
						sc.nextLine();
						if (op == 1) {
							System.out.print("Digite o novo nome: ");
							String nome = sc.nextLine();
							clientePf.setNome(nome);
						} else if (op == 2) {
							System.out.print("Digite o novo endereço: ");
							String endereco = sc.nextLine();
							clientePf.setEndereco(endereco);
						}

					} else if (nConta == clientePj.getNumConta()) {
						System.out.println("\nDigite uma das opções que deseja atualizar: " + "\n1 - NOME"
								+ "\n2 - ENDEREÇO" + "\nO - SAIR DO MENU");
						System.out.println();
						System.out.print("OPÇÃO: ");
						int op = sc.nextInt();
						sc.nextLine();
						if (op == 1) {
							System.out.print("Digite o novo nome: ");
							String nome = sc.nextLine();
							clientePj.setNome(nome);
						} else if (op == 2) {
							System.out.print("Digite o novo endereço: ");
							String endereco = sc.nextLine();
							clientePj.setEndereco(endereco);
						}
					}
				} while (np != 0);

			}

		} while (na != 0);

		System.out.println("\n-------------------LISTA ATUALIZADA-------------------");
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
		} catch(Exception e) {
			System.out.println("DIGITE COM LETRAS MAIUSCULAS OU NÚMEROS CONFORME SOLICITADO.");
		}
		
		sc.close();

	}

}

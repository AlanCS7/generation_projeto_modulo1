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

			if (cli == 'F') {

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
							+ "\nO - SAIR DO PROGRAMA");
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

			} else if (cli == 'J') {

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
							+ "\nO - SAIR DO PROGRAMA");
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

		sc.close();

	}

}

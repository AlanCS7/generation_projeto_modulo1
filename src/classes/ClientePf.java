package classes;

public class ClientePf extends Cliente {

	private String cpf;

	public ClientePf() {

	}

	public ClientePf(int numConta, String nome, String endereco, String cpf) {
		super(numConta, nome, endereco);
		this.cpf = cpf;
	}

	public ClientePf(int numConta, String nome, String endereco, double saldo, String cpf) {
		super(numConta, nome, endereco, saldo);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public void saque(double saque) {
		saldo -= saque + 5;

	}
	
}

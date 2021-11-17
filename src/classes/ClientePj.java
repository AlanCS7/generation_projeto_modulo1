package classes;

public class ClientePj extends Cliente {

	private String cnpj;

	public ClientePj() {

	}

	public ClientePj(int numConta, String nome, String endereco, String cnpj) {
		super(numConta, nome, endereco);
		this.cnpj = cnpj;
	}

	public ClientePj(int numConta, String nome, String endereco, double saldo, String cnpj) {
		super(numConta, nome, endereco, saldo);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public void saque(double saque) {
		saldo -= saque + 7;

	}

}

package classes;

public abstract class Cliente {

	private int numConta;
	private String nome;
	private String endereco;
	protected double saldo;
	
	public Cliente() {
		
	}

	public Cliente(int numConta, String nome, String endereco) {
		this.numConta = numConta;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Cliente(int numConta, String nome, String endereco, double saldo) {
		this.numConta = numConta;
		this.nome = nome;
		this.endereco = endereco;
		this.saldo = saldo;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getSaldo() {
		return saldo;
	}

	public void deposito(double deposito) {
		saldo += deposito;
	}
	
	public void saque(double saque) {
		saldo -= saque;
	}
	
}

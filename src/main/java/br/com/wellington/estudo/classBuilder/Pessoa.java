package br.com.wellington.estudo.classBuilder;

public class Pessoa {

	private final long cpf;
	private String nome;
	private int idade;

	private Pessoa(long cpf, String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}

	public static class PessoaBuilder {

		private final long cpf;
		private String nome;
		private int idade;

		public PessoaBuilder(long cpf) {
			this.cpf = cpf;
		}

		public PessoaBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public PessoaBuilder idade(int idade) {
			this.idade = idade;
			return this;
		}

		public Pessoa builder() {
			return new Pessoa(cpf, nome, idade);
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public long getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + "]";
	}

}

package br.com.wellington.estudo.classBuilder;

public class Main {

	public static void main(String[] args) {
		Pessoa p = new Pessoa.PessoaBuilder(34772872825l)
				.nome("NOME")
				.idade(18)
				.builder(); 
		System.out.println(p);
	}

}

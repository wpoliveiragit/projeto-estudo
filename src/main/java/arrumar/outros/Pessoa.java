package arrumar.outros;

/**
 * Definição do que a classe representa ou administra sobre uma pessoa.
 *
 * @author Wellington Pires de Oliveira.
 * @date 05/04/2019
 */
public class Pessoa {

	/**
	 * Representação masculina.
	 */
	static final char MASCULINO = 'M';
	/**
	 * Representação feminima.
	 */
	static final char FEMININO = 'F';

	/**
	 * O nome da pessoa.
	 */
	private final String nome;
	/**
	 * O sexo da pessoa.
	 */
	private final char sexo;
	/**
	 * A idade da pessoa.
	 */
	private final int idade;

	/**
	 * Cria uma nova pessoa.
	 *
	 * @param nome  O nome da pessoa.
	 * @param idade A idade da pessoa.
	 * @param sexo  O sexo da pessoa (Usar os valores estáticos contido na classe).
	 */
	public Pessoa(String nome, int idade, char sexo) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}

	/**
	 * Retorna a idade da pessoa
	 *
	 * @return A idade da pessoa.
	 */
	public int getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		return "NOME: " + nome + " IDADE: " + idade + " SEXO: " + sexo;
	}

}

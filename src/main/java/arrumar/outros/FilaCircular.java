package arrumar.outros;
/**
 * Representação de uma fila ao estilo circular onde devemos definir
 * previamente a capacidade máxima dela.
 *
 * @author Wellington Pires de Oliveira.
 * @date 05/04/2019
 * @path Estudo.BrunaExercicioFacu.Fila
 */
public class FilaCircular {

	/** Define onde começa a idade que se refere aos idosos. */
	private static final int IDADE_UTIL = 59;

	/** Ponto onde se inicia a fila. */
	private int inicio;

	/** Ponto onde termina o fim da fila. */
	private int fim;

	/**
	 * Quantidade de pessoas existentes na fila.
	 */
	private int acervo;

	/**
	 * O acervo de pessoas da fila
	 */
	private final Pessoa pessoas[];

	/**
	 * Cria um controle de fila.
	 *
	 * @param max O tamanho máximo da fila.
	 */
	public FilaCircular(int max) {
		inicio = 0;
		fim = 0;
		acervo = 0;
		pessoas = new Pessoa[max];
	}

	/**
	 * Informa se a fila esta cheia.
	 *
	 * @return true para fila cheia.
	 */
	public boolean isCheia() {
		return acervo == pessoas.length;

	}

	/**
	 * Informa se a fila esta vazia.
	 *
	 * @return true para fila vazia.
	 */
	public boolean isVazia() {
		return acervo == 0;
	}

	/**
	 * Adiciona uma nova pessoa ao final da fila.
	 *
	 * @param pessoa a pessoa a ser adicionada.
	 * @return true em caso de sucesso na adição
	 */
	public boolean add(Pessoa pessoa) {
		if (isCheia()) {
			return false;
		}
		pessoas[fim++] = pessoa;
		if (fim > pessoas.length) {
			fim = 0;
		}
		acervo++;
		return true;
	}

	/**
	 * Remove o primeiro elemento da fila
	 *
	 * @return A pessoa removida ou null caso a fila esteja vazia.
	 */
	public Pessoa remove() {
		if (isVazia()) {
			return null;
		}
		Pessoa p = pessoas[inicio];
		pessoas[inicio++] = null;
		if (inicio == pessoas.length) {
			inicio = 0;
		}
		acervo--;
		return p;
	}

	/**
	 * Armazena na fila do parâmetro a relação de idosos contidos na fila.
	 *
	 * @param idosos A fila para armaznar a relação de idosos contidos na fila.
	 */
	public void relacaoIdosos(FilaCircular idosos) {
		for (int i = inicio; i < fim; i++) {
			if (pessoas[i].getIdade() > IDADE_UTIL) {
				idosos.add(pessoas[i]);
			}
		}
	}

	@Override
	public String toString() {
		String s = "";
		if (isVazia()) {
			return s;
		}
		if (inicio < fim) {
			for (int i = inicio; i < fim; i++) {
				s += pessoas[i].toString() + '\n';
			}
			return s.substring(0, s.length() - 1);
		}
		int i = inicio;

		while (i != fim) {
			s += pessoas[i++].toString() + '\n';
			if (i > pessoas.length) {
				i = 0;
			}
		}
		return s.substring(0, s.length() - 1);
	}

	/**
	 * Retorna a quantidade de elementos contidos na fila.
	 *
	 * @return A quantidade de elementos contidos na fila.
	 */
	public int getTamanho() {
		return acervo;
	}
}

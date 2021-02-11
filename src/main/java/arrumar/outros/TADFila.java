package outros;

public class TADFila {

	// Atributos da Fila
	private int capacidade;
	private int inicio, fim;
	private String pessoa[];

	// Método Construtor (Cruidado ao entender que método é um construtor)
	public TADFila(int tam) {
		capacidade = tam;
		inicio = -1;
		fim = -1;
		pessoa = new String[capacidade];
	}

	public boolean filaCheia() {
		return (fim == capacidade - 1);
	}

	public boolean filaVazia() {
		return (fim == inicio);
	}

	public boolean enfileira(String vPessoa) {
		if (filaCheia()) {
			return false;
		}
		fim++;
		pessoa[fim] = vPessoa;
		return true;
	}

	public void imprimeFila() {
		for (int i = inicio + 1; i <= fim; i++) {
			System.out.println("Nome: " + pessoa[i]);
		}
	}

	public boolean desenFileira() {
		if (filaVazia()) {
			return false;
		}
		inicio++;
		return true;
	}

}

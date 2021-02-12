package arrumar.grapho;

public class Grapho {

	/**
	 * Quantidade de nodos do grapho.
	 */
	protected final int qtdNodos;

	/**
	 * Matriz do grapho.
	 */
	protected Integer[][] matrizDePesos;

	/**
	 * CONSTRUTOR do grapho.
	 * 
	 * @param numeroNodos
	 * @throws RuntimeException
	 */
	public Grapho(int numeroNodos) throws RuntimeException {
		if (numeroNodos < 1) {
			throw new RuntimeException("O numero de nodos deve ser maior que 0");
		}
		this.qtdNodos = numeroNodos;

		try {
			setMatrizDePesos(criaMatrizInt(numeroNodos, 0));
		} catch (Exception ex) {
			if (ex.getMessage() == null) {
				System.out.println("Ocorreu um erro de " + ex + " no construtor");
			} else {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static Integer[][] criaMatrizInt(int tamanho, Integer valorPadrao) throws RuntimeException {

		if (tamanho < 2) {
			throw new RuntimeException("o tamanho deve ser maior que 1");
		}
		// como o grapho vai considerar valores de 1-n
		Integer matriz[][] = new Integer[tamanho + 1][];
		try {
			for (int i = 0; i < tamanho; i++) {
				matriz[i] = new Integer[tamanho + 1];
				System.out.println("Tamanho: " + new Integer[tamanho + 1].length);
				for (int j = 0; j < tamanho; j++) {
					matriz[i][j] = valorPadrao;
					System.out.println("i: " + i + "-[" + j + "]");
				}
			}
		} catch (Exception ex) {
			if (ex.getMessage() == null) {
				System.out.println("Ocorreu um erro de " + ex + " em criaMatrizInt");
			} else {
				System.out.println("Erro ao criar a matriz");
			}
		}
		return matriz;
	}

	public void printMatriz(Integer matriz[][]) throws Exception {

		if (matriz == null) {
			throw new Exception("a matriz e nula");
		}
		if (matriz[0] == null) {
			throw new Exception("a matriz nao foi inicializada");
		}
		int tamanho = getnumeroNodos();

		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++)
				System.out.printf("[" + matriz[i][j] + "] ");
			System.out.printf("\n");
		}
	}

	public void insertArc(int A, int B, int peso) throws Exception {
		try {
			if (A < 0 || B < 0 || A > getnumeroNodos() || B > getnumeroNodos()) {
				throw new Exception("um dos vertices sao invalidos");
			}
			if (peso == 0) {
				throw new Exception("nao eh permitido peso negativo");
			}
			matrizDePesos[A][B] = peso;
		} catch (Exception ex) {
			if (ex.getMessage() == null) {
				System.out.println("Ocorreu um erro de " + ex + " insertArc");
			} else {
				System.out.println("Erro na insecao de arco");
			}
		}
	}

	public Integer[][] getMatrizDePesos() {
		return this.matrizDePesos;
	}

	public void setMatrizDePesos(Integer[][] pesos) {
		this.matrizDePesos = pesos;
	}

	public int getnumeroNodos() {
		return qtdNodos;
	}

	public static void main(String args[]) {
		try {
			Grapho teste = new Grapho(5);
			teste.printMatriz(teste.getMatrizDePesos());
		} catch (Exception ex) {
			if (ex.getMessage() == null) {
				System.out.println("Ocorreu um erro de " + ex + " no main");
			} else {
				System.out.println(ex.getMessage());
			}
		}
	}

}
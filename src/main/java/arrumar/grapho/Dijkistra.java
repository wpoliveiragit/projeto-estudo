package arrumar.grapho;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Dijkistra extends Grapho {

	private static final long INFINITO = Long.MAX_VALUE;

	private boolean nodosVisitados[];
	private long distancias[];
	private long predecessor[];
	private List<Integer> filaDePrioridade = new ArrayList<>();
	private int origem;

	/*
	 * Construtor : recebe o numero de nodos do grafo
	 */
	public Dijkistra(int numeroDeNodos) throws Exception {
		super(numeroDeNodos);
		// como sera considerado de 1- n entao e acrescentado + 1
		nodosVisitados = new boolean[numeroDeNodos];
		// como sera considerado de 1- n entao e acrescentado + 1
		distancias = new long[numeroDeNodos];
		// antecesor do vertice
		predecessor = new long[numeroDeNodos];
	}

	private long dijkistra(int origem, int destino) throws RuntimeException {

		if (origem < 0 || origem > getnumeroNodos()) {
			throw new RuntimeException("origem e menor que 0 ou destino nao existe");
		}

		try {
			iniciaMenorCaminho(origem);
		} catch (Exception ex) {
			System.out.println("Erro ao iniciar os dados " + ex);
		}

		while (!filaDePrioridade.isEmpty()) {
			Integer verticeMenorPeso = extraiMenor();

			for (int i = 0; i < getnumeroNodos(); i++) {

				if (getMatrizDePesos()[verticeMenorPeso][i] > 0) {
					relaxa(verticeMenorPeso, i);
				}
			}

		}
		printDistancias();
		return distancias[destino];
	}

	/*
	 * Inicia dados do algoritmo
	 */
	private void iniciaMenorCaminho(int origem) {
		for (int i = 0; i < getnumeroNodos(); i++) {
			distancias[i] = INFINITO;
			nodosVisitados[i] = false;
			predecessor[i] = INFINITO;
			filaDePrioridade.add(new Integer(i));// adiciona a aresta na fila
		}
		distancias[origem] = 0;// inicia o vetor de distancias

	}

	/*
	 * Relaxa arestas no grafo
	 */
	private void relaxa(int u, int v) {
		if (distancias[v] > distancias[u] + getMatrizDePesos()[u][v]) {
			distancias[v] = distancias[u] + getMatrizDePesos()[u][v];
			predecessor[v] = u;
		}
	}

	private int extraiMenor() {
		long menorValor = INFINITO;
		int verticeDeMenorPeso = 0;

		Iterator<Integer> it = filaDePrioridade.iterator();
		while (it.hasNext()) {
			int verticeAtual = it.next();
			if (distancias[verticeAtual] < menorValor) {
				menorValor = distancias[verticeAtual];
				verticeDeMenorPeso = verticeAtual;
			}
		}

		System.out.println("Remove o vertice " + verticeDeMenorPeso + " da fila " + " de peso " + menorValor);
		// remove o vertice com menor distancia do grafo
		filaDePrioridade.remove(new Integer(verticeDeMenorPeso));
		System.out.println("-------------------------------------------------");

		return verticeDeMenorPeso;
	}

	public int getOrigem() {
		return origem;
	}

	public void setOrigem(int origem) {
		this.origem = origem;
	}

	public List<Integer> getFilaDePrioridade() {
		return filaDePrioridade;
	}

	public void setFilaDePrioridade(List<Integer> filaDePrioridade) {
		this.filaDePrioridade = filaDePrioridade;
	}

	private void printDistancias() {
		for (int i = 0; i < getnumeroNodos(); i++)
			System.out.print("[" + distancias[i] + "] ");
		System.out.println();
	}

	public static void main(String args[]) {

		try {
			Dijkistra dij = new Dijkistra(5);
			
			dij.insertArc(0, 1, 10);
			dij.insertArc(0, 2, 5);
			
			dij.insertArc(1, 2, 2);
			dij.insertArc(1, 3, 1);
			
			dij.insertArc(2, 1, 3);
			dij.insertArc(2, 3, 9);
			dij.insertArc(2, 4, 2);
			
			dij.insertArc(3, 4, 4);
			
			dij.insertArc(4, 3, 6);
			dij.insertArc(4, 0, 7);
			
			System.out.println("Menor caminho entre 0 e 4 " + dij.dijkistra(0, 4));
			// dij.printMatriz(dij.getMatrizDePesos());
		} catch (Exception ex) {
			if (ex.getMessage() == null)
				System.out.println("Ocorreu um erro de " + ex + " no main");
			else
				System.out.println(ex.getMessage() + "XXX");
		}

	}
}
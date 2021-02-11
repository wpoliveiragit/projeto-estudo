package enumeration;

/**
 * Enumeração é um conjunto fixo de constantes pré-definidas.
 *
 * CARACTER�?STICA
 * 
 * - Ao em vez de 'class' use 'enum';
 * 
 * - O construtor asseita dois modificadores, private e friendly (sem
 * modificador);
 * 
 * - As constantes de um enum devem ficar antes dos atributos e métodos;
 *
 * - Não é permitido criar um objeto de um enum;
 *
 * - O construtos é declarado com o modificador private, embora não precise
 * estar explícito;
 *
 * - Seguindo a convenção, por serem objetos constantes e imutáveis (static
 * final), os nomes declarados de atributos recebem todas as letras em
 * MAIÚSCULAS;
 *
 * - As instâncias do tipo enum devem obrigatoriamente ter apenas um nome;
 *
 * USO Entre muitos outros aspectos, um enum é criado para padronização de
 * informações, deixando assim o código mais consistente, centralizado e
 * elegante.
 *
 * Na declaração deverá ser substituido a palavra chave class por enum.
 * 
 * No corpo de um enum pode ser incluir métodos e atributos.
 * 
 * O compilador automaticamente adiciona alguns métodos específicos quando se
 * cria um enum, pois todo enum se estende implicitamente da classe
 * Java.labg.TabelaPeriodica, não podendo ter uma estenção de outra classe.
 *
 * @author Wellington Pires de Oliveira
 * 
 * @date 26/05/2017.
 */

// Troque 'class' por 'enum'
public enum Turno {
	/**
	 * Cada constante usará o construtor de uma maneira implicita para se auto
	 * instanciar usando apenas parametrização para definir o construtor usando.
	 */

	/**
	 * CONJUNTO FIXO DE CONSTANTES
	 * 
	 * Deverá sempre estar no início do corpo do enum.
	 * 
	 * A ordem que aqui estiver, será a ordem que aparecerá na classe quando for
	 * envocada.
	 * 
	 * Para criar o Conjunto cada constante deve ser separada uma da outra com uma
	 * ',' e na ultima deverá adicionar ';'
	 * 
	 */
	MANHA(6, 14), 
	TARDE(14, 22), 
	NOITE(22, 6);

	/* Atributos */
	/**
	 * Como esses dados são constantes imutaveis, o ideal é deixar o atributo com o
	 * status final ou apenas deixar o acesso ao atributo por meio de um método,
	 * evitando assim uma possivel alteração.
	 */
	public final int entrada;// Horario de entrada na empresa
	public final int saida;// Horário de saida na empresa
	/* Construtores */

	/**
	 * um construtor de enum, sempre estará como o modificador private, pois apenas
	 * será usado apenas por ele mesmo.
	 */

	private Turno(int entrada, int saida) {
		this.entrada = entrada;
		this.saida = saida;
	}

	/* Métodos */
	/**
	 * Os métodos em enum, seguem o padrão de uma classe convencional. sendo criado
	 * de acordo com a necessidade.
	 */

}

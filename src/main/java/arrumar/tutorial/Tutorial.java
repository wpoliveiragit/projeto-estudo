package arrumar.tutorial;

/**
 * Os modificadores de acesso definem a proteção do seu codigo e a
 * confiabilidade usual da sua classe deixando assim menos passivo a erros.
 * Existem quatro tipos de 'modificadores de acesso' public, private, protected
 * e default (sem a palavra reservada de um modificador de acesso). Toda classe
 * tem acesso a seus atributos e método livremente.
 *
 * -----------------------------------------------------------------------------
 * public (na CLASSE): Permite que classes de outros pacotes criem objetos desta
 * classe.
 *
 * public (no ATRIBUITO e METODO): Permite o acesso pelo objeto.
 * -----------------------------------------------------------------------------
 * private (na CLASSE): Uma classe não pode ser private (Classes internas
 * podem).
 *
 * private (no ATRIBUTO e METODO): Permite o acesso apenas no corpo desta
 * classe.
 * -----------------------------------------------------------------------------
 * protected (na CLASSE): Uma classe não pode ser protected (Classes internas
 * podem).
 *
 * protected (no ATRIBUTO e METODO): Permite o acesso no corpo desta classe e
 * ganha o status da herança.
 * -----------------------------------------------------------------------------
 * default (na CLASSE): Permite que apenas as classes do mesmo pacote criem
 * objetos desta classe.
 *
 * default (no ATRIBUTO e METODO): Permite o acesso pelo objeto, se a classe que
 * o criar pertença ao mesmo pacote desta classe
 * -----------------------------------------------------------------------------
 *
 * @author Wellington Pires de Oliveira.
 * @date 09/11/2017.
 */
public class Tutorial {

	/**
	 * Variáveis primitivas são áreas da memória onde o desenvolvedor solicita ao
	 * compilador para manipular números (inteiros, reais e caracteres).
	 *
	 * HELP
	 *
	 * = Literal lógico=
	 *
	 * boolean(1 bit): Guarda apenas os valores true ou false.
	 *
	 * = Inteiros =
	 *
	 * byte(8 bits): Guarda valores entre -128 a 127.
	 *
	 * short (16 bits): Guarda valores entre -32.768 a 32.767.
	 *
	 * int(32 bits): Guarda valores entre -2.147.483.648 a 2.147.483.647.
	 *
	 * long(64 bits): Guarda valores esntre -9.223.372.036.854.808 a
	 * 9.223.372.036.854.807
	 *
	 * Obs.: Agregue um 'l' ao final do valor que for atribuido a toda variável
	 * long.
	 *
	 * = Reais (ponto flutiante)
	 *
	 * float(32 bits): Guarda um valor relativo ao int, pois sua capacidade será
	 * interferida de acordo com as casas decimais usadas.
	 *
	 * Obs2.: Agregue um 'f' ao final do valor que for atribuido a toda variável
	 * float com casas decimais.
	 *
	 * double(64 bits): Guarda um valor relativo ao long, pois sua capacidade será
	 * interferida de aconrdo com as casas decimais usadas.
	 *
	 * Obs3.: Aguegue um 'd' ao final do valor que for atribuido a uma variável
	 * double com casas decimais.
	 *
	 * Obs4.: Ponto flutuante é um formato de representação digital de números
	 * racionais, onde podemos deslocar a vírgula, permitindo assim o uso de uma
	 * possível notação científica. Exemplo o número 150.000 em notação cientifica
	 * ficaria 1.5 * 10 ^5 em ponto flutiante seria 1.5E5, onde E será '*10 elevado
	 * a'.
	 *
	 * = Caracter =
	 *
	 * Este tipo de variável podem ser usadas de duas maneiras, uma é atribuindo um
	 * caracter a ela, mas também podemos agregar o código do caracter desejado (ver
	 * tabela ASCII).
	 *
	 * char(padrão UTS-16 ou 2 bytes): Guarda valores entre 0 a 65.535. Podemos
	 * agregar valores em exadecimal onde '\u0000' = 0 e '\uffff' é 65.535
	 *
	 * Obs5.: '\uffff' formato unicode (Estude pela internet)
	 *
	 * String(bits indefinidos): Toda String é um objeto, sendo assim posssui possui
	 * atributos e métodos, mas no momento vamos tratala como uma variável
	 * primitiva.
	 */
	public void variaveisPrimitivas() {
		String mensagem = "-= Variaveis Primitivas =-";
		boolean bool1 = true;
		boolean bool2 = false;
		byte bt1 = -128;
		byte bt2 = 127;
		short shrt1 = -32768;
		short shrt2 = 32767;
		int i1 = -2147483648;
		int i2 = 2147483647;
		long lng1 = -9223372036854808l;
		long lng2 = 9223372036854807l;
		float flt = 1.598f;
		double dbl = -1.5E5;
		char chr1 = '\u03EE';
		char chr2 = 'c';
		char chr3 = 45;

		System.out.println(mensagem + "\nboolean1: " + bool1 + "\nboolean2: " + bool2 + "\nbyte1: " + bt1 + "\nbyte2: "
				+ bt2 + "\nshort1: " + shrt1 + "\nshort2: " + shrt2 + "\nint1: " + i1 + "\nint2: " + i2 + "\nlong1: "
				+ lng1 + "\nlong2: " + lng2 + "\nfloat: " + flt + "\ndouble: " + dbl + "\nchar1: " + chr1 + "\nchar2: "
				+ chr2 + "\nchar3: " + chr3
				/*
				 * Podemos imprimir o valor de um char utilizando 'cast', de a preferencia do
				 * int, pois um short (16 bits ou 2 bytes) guarda valores positivos até 32767
				 * deixando 50% dos possiveis valores de fora, já um int 9223372036854807l
				 */
				+ "\nchar2B: " + (int) chr2);
	}

	/**
	 * OPERADORES ARITMÉTICOS EM JAVA ===========================================
	 * ==========================================================================
	 * São os simbolos usados para realizar as operações aritméticas no sistema.
	 * ------------------------------------------------------------------------- '+'
	 * (Adição): Usado como adição aritmética entre dois numeros.
	 *
	 * Ex001.: 10 = 5 + 5.
	 *
	 * Obs.: Tambem pode ser usado como forma de agregação de um texto a outro.
	 * Ex002.: "Eu comi 2 chocolates" = "Eu comi " + 2 + " chocolates".
	 * ------------------------------------------------------------------------- '-'
	 * (Subtração): Usado como subtração aritmética para diminuir um valor de um
	 * número atravez de outro.
	 *
	 * Ex003.: 0 = 5 - 5
	 * ------------------------------------------------------------------------- '*'
	 * (Multiplicação): Usado como multiplicador para obter o produto entre 2
	 * números.
	 *
	 * Ex004.: 10 = 2 * 5
	 * ------------------------------------------------------------------------- '/'
	 * (Divisão): Usado como divisor aritmético para obter a quantidade de vezes que
	 * um numero pode ser partido igualmente por um valor discreto.
	 *
	 * Ex005.: 2 = 10 / 5
	 * ------------------------------------------------------------------------- '%'
	 * (Resto): Usado como resto aritmético para obter a sobra de uma divisão não
	 * exata.
	 *
	 * EX006: 1 = 10 % 3 .
	 */
	public void operadoresAritmeticos() {
		int ex001;
		ex001 = 5 + 5;
		System.out.println("Ex001: " + ex001);// ex002
		int ex003;
		ex003 = 5 - 5;
		System.out.println("Ex003: " + ex003);// ex002
		int ex004;
		ex004 = 2 * 5;
		System.out.println("Ex004: " + ex004);// ex002
		int ex005;
		ex005 = 10 / 5;
		System.out.println("Ex005: " + ex005);// ex002
		int ex006;
		ex006 = 10 % 3;
		System.out.println("Ex006: " + ex006);// ex002
	}

	/**
	 * OPERADORES LÓGICOS EM JAVA ==============================================
	 * ========================================================================= São
	 * chamados conectivos lógicos por unirem duas expressões simples numa composta.
	 * ------------------------------------------------------------------------- '&'
	 * e '&&' ('E' lógico e 'E' lógico com curto cirquito): Operador que representa
	 * a tabela verdade 'E'.
	 *
	 * EX007.: false & true & true = false.
	 *
	 * Ex008.: false && true && true = false (é dito 'E' com curto cirquito, pois
	 * caso encontre um estado lógico igual a false, a operação ligada ao símbolo
	 * será interrompida, pois a operação ligada ao 'E' será dada como false).
	 * ------------------------------------------------------------------------- '|'
	 * e '||' ('OU' lógico e 'OU' lógico com curto cirquito): Operador que
	 * represenra a tabela verdade 'OU'.
	 *
	 * Ex009.: false | true | true = true.
	 *
	 * EX010.: false || true ||true = true (oposto ao EX008).
	 * ------------------------------------------------------------------------- '!'
	 * (negação): Simbolo que troca o estalo lógico de uma operação.
	 *
	 * Ex011.: !false = true.
	 */
	public void operadoresLogicos() {
		boolean ex007_ex008;
		ex007_ex008 = false && true & true;
		System.out.println("Ex007 e Ex008: " + ex007_ex008);
		boolean ex009_ex010;
		ex009_ex010 = false || true | true;
		System.out.println("Ex009 e Ex010: " + ex009_ex010);
		boolean ex011;
		ex011 = !false;
		System.out.println("Ex011: " + ex011);
	}

	/**
	 * OPERADORES RELACIONAIS EM JAVA ==========================================
	 * =========================================================================
	 * Utilizados para comparar valores numa expressão relaciona onde resultara em
	 * um valor booleano.
	 * ------------------------------------------------------------------------- '>'
	 * (Maior): verifica se o valor da esquerda é maior que o da direita.
	 *
	 * Ex012: false = 10 > 10
	 * -------------------------------------------------------------------------
	 * '>=' (Maior ou igual): Verifica se o valor da esquerda é maior ou igual ao da
	 * direita.
	 *
	 * ex013: true = 10 >= 10
	 * ------------------------------------------------------------------------- '<'
	 * (Menor): Verifica se o valor da esquerda é menor que o da direita.
	 *
	 * Ex014: false = 10 < 10
	 * -------------------------------------------------------------------------
	 * '<=' (Menor ou igual) Verifica se o valor da esquerda é menor ou igual ao da
	 * direita.
	 *
	 * Ex015: true = 10 <= 10
	 * -------------------------------------------------------------------------
	 * '==' (igual): Verifica se ambos os valores são iguais.
	 *
	 * Ex016: true = 10 == 10
	 * -------------------------------------------------------------------------
	 * '!=' (diferente): Verifica se ambos os valores são diferentes.
	 *
	 * Ex017: true = !false
	 */
	public void operadoresRelacionais() {
		boolean ex012;
		ex012 = 10 > 10;
		System.out.println("Ex012: " + ex012);

		boolean ex013;
		ex013 = 10 >= 10;
		System.out.println("Ex013: " + ex013);

		boolean ex014;
		ex014 = 10 < 10;
		System.out.println("Ex014: " + ex014);

		boolean ex015;
		ex015 = 10 <= 10;
		System.out.println("Ex015: " + ex015);

		boolean ex016;
		ex016 = true == true;
		System.out.println("Ex016: " + ex016);

		boolean ex017;
		ex017 = !false;
		System.out.println("Ex017: " + ex017);
	}

	/**
	 * =Estruturas de Decisões´=
	 *
	 * São usadas para criar caminhos dentro de um bloco de código atravez de
	 * operadores relacionais tendo como propósito, um resultado lógico.
	 *
	 * 'if' - 'else if' - 'else': Normalmente usado para poucas escolhar, muito
	 * eficiente, mas com pouca visibilidade.
	 *
	 * Ex018: Demonstração da estrutura completa de 'if'
	 *
	 * 'switch - case - default': Uma estrutura if normalmente usada para uma melhor
	 * visualização. Sua eficiencia é inferior ao if, pois possui mais passos a
	 * serem executados. Apenas valores inteiros podem ser usados no parametro de
	 * switch (como 'char' pode ser representado como um numero inteiro, ele também
	 * pode ser usado na estrutura tanto como numero quanto como caracter e String
	 * pode ser usado pois possui um número de controle obtido pelo método
	 * .hashCode():int que representa o valor numério dela).
	 *
	 * Obs.: como 'char
	 *
	 * Ex019: Demonstração da estrutura compleda de switch - case - default
	 */
	public void estruturasDecisoes(int index) {
		byte ex018;

		if (index < 0) {/* necessário único */
			ex018 = -5;
		} else if (index == 0) {/* opcional e pode ser usado quantas vezes for necessario */
			ex018 = 0;
		} else if (index >= 1 && index <= 10) {
			ex018 = 1;
		} else if (index > 20 && index < 70) { // opcional e única
			ex018 = 2;
		} else {
			ex018 = 3;
		}
		System.out.println("index: " + index);
		System.out.println("EX018: " + ex018);
		System.out.print("Ex019: ");

		/* dentro do parametro, coloque a variavel a ser verificada */
		switch (ex018) {
		/**
		 * após a palavra 'case' coloque um valor absoluto (não é suportado uma
		 * expressão condicional) e logo após coloque ':', assim será aberto o bloco de
		 * código
		 */
		case -5:
			System.out.println("case -5");
			/*
			 * Uma boa prática, é usar a palavra 'break' ao final de um 'case', pois se não
			 * usar, o compilador após (ou se) encontrar o valor desejado, executará todos
			 * os próximos blocos de código ignorando os 'case's.
			 */
			break;// Sai do bloco do código onde foi inserido
		case 0:
			System.out.println("case 0");
		case 1:
			System.out.println("case 1");
		case 2:
			System.out.println("case 2");
		default:
			System.out.println("default " + ex018);
		}
	}

	/**
	 * CONTROLE DE FLUXO ou LOOPs ============================================== Faz
	 * uma tarefa ser executada repetidamente enquanto uma dada condição seja
	 * verdadeira. Existem três controles de fluxo naturais na programação que são o
	 * 'while', o 'do-while' e o 'for',
	 *
	 * while: Só entrara no fluxo se a condição especificada for verdadeira.
	 *
	 * do-while: Executa uma vez o bloco de código do fluxo para então verificar a
	 * condição especificada e continuar o loop.
	 *
	 * for: Só entra no fluxo se a condição especificada for verdadeira, mas também
	 * possui uma área reservada para criação de uma variável e outra para uma
	 * espressão de agregação de valor.
	 */
	public void controleFluxo(int i) {
		/*
		 * Este rxemplo sera expliacdo usando os três fluxos, dando apenas um resultado
		 * final
		 */
		int apoio = i;// guarda o valor passado por parâmetro

		boolean bool;
		bool = true;
		System.out.println(">> inicio do while");
		while (bool == true) {// verifica a condição
			// executa este bloco de código se a condição for verdadeira
			if (i == 0) {
				break;// Sai do bloco do código onde foi inserido (sai do while)
			}
			System.out.println(i);
			i = i - 1;
		} // retorne a condição
		System.out.println("<< fim do while");

		i = apoio;

		System.out.println(">> Início do do-while");
		do {// executa uma vez o bloco de código

			if (i < 1) {
				bool = !bool;
			}
			System.out.println(i);
			i--;
		} while (bool != false);// verifica a condição, se for verdadeira volta ao 'do{'
		System.out.println("<<fim do do-while");

		System.out.println(">>início do for");
		for (int index = apoio; i < index; i++) {
			if (3 < i && i < 6) {
				continue;// volta pro topo do fluxo
			}
			System.out.println(i);
		}
		System.out.println("<<fim for");
	}
}

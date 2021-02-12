package arrumar.exceptons;

/**
 * Uma classe Exception deve ser criada sempre quando necessitamos informar para
 * o usuario que pode ser gerado uma exception, mas que ela é particular
 * daquele pacote (um filtro que determina de onde veio o erro).
 *
 * Existem dois tipos de excessões:
 *
 * Exceção verificadas: São condições que não podemos ter controle pleno
 * (como tentar estabelecer uma conexão) então ela deve ser previamente
 * tratada.
 *
 * Exceção não verificadas: São condições que não devem acontecer, (como
 * fazer uma divisão por zero), elas serão disparadas apenas quando o método
 * ou construtor estiver sendo usado indevidamente.
 *
 * ESPECIFICAÇÃO
 * 
 * Extenda a classa para Exception para ser uma excessão verificavel.
 *
 * - Para uma classe ser de característica 'Exceção não verificada' torne
 * ela uma extenção da classe RuntimeException
 *
 * BASE: Ao menos crie um construtor em que o 'super()' carregue uma mensagem
 * com a definição, mas para uma classe excepton ser completa o ideal é usar
 * o construtor que carrega a mensage de definição do erro (String) e a causa
 * do problema(Throwable). Lembre-se que mesmo sendo uma classe expecifica pra
 * definição de uma exceção de uma classe, ela ainda é uma classe e pode
 * possuir mais coisas que só o necessário, como atributos, metodos etc, caso
 * haja a necessidade.
 *
 * OBS.: Procure evitar criar classes extendidas da classe Throwable, pois
 * captura exceções derivadas de Error.
 *
 * (CRIAR USO DE BOAS MANEIRAS DEFININDOAS NO CODIGO)
 *
 * @author Wellington Pires de Oliveira.
 * @date 21/10/2016
 */
public class ExceptionClasses {

	/**
	 * EXCEÇÃO VERIFICADA
	 */
	class VerificadaException extends Exception {

		private static final long serialVersionUID = 1L;

		public VerificadaException() {
			super("NÃO FOI POSSIVEL CARREGAR TAL COISA");
		}

		public VerificadaException(String message, Throwable cause) {
			super("NÃO FOI POSSIVEL CARREGAR TAL COISA", new Throwable("DADO X NULO"));
		}
	}

	/**
	 * EXCEÇÃO NÃO VERIFICADA
	 *
	 * Tambem pode ser encarado como um ERRO do programador
	 */
	class NaoVerificada extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public NaoVerificada() {
			super("NÃO FOI POSSIVEL CARREGAR TAL COISA");
		}

		public NaoVerificada(String message, Throwable cause) {
			super("NÃO FOI POSSIVEL CARREGAR TAL COISA", new Throwable("DADO X NULO"));
		}
	}

}
package arrumar.exceptons;

/**
 * DEFINIÃ‡ÃƒO: As classes Exceptions sÃ£o criadas para definir
 * exceÃ§Ãµeses especÃ­ficas de uma determinada classe
 *
 * CARACTERÃ�STICA
 *
 * ExceÃ§Ã£o verificada: SÃ£o as exceÃ§Ãµes em que o desenvolvedor
 * serÃ¡ obrigado a tratadas ou relanÃ§adas.
 *
 * ExceÃ§Ã£o nÃ£o verificadas: sÃ£o as exceÃ§Ãµes que nÃ£o tem a
 * necessidade de ser tratadas ou relanÃ§adas.
 *
 * COMO AS USAR
 *
 * - Para uma classe ser de caracterÃ­stica 'ExceÃ§Ã£o Verificada', torne
 * ela uma exceÃ§Ã£o da classe Exception
 *
 * - Para uma classe ser de caracteristica 'Excecao nao verificada' torne ela
 * uma excecao da classe RuntimeException
 *
 * BASE: Ao menos crie um construtor em que o 'super()' carregue uma mensagem
 * com a definicao, mas para uma classe excepton ser completa o ideal Ã© usar
 * o construtor que carrega a mensage de definicao do erro (String) e a causa do
 * problema(Throwable). Lembre-se que mesmo sendo uma classe expecifica pra
 * definiÃ§Ã£o de uma excecao de uma classe, ela ainda Ã© uma classe e
 * pode possuir mais coisas que sÃ³ o necessÃ¡rio, como atributos, metodos
 * etc, caso haja a necessidade.
 *
 * OBS.: Procure evitar criar classes extendidas da classe Throwable, pois
 * captura exceÃ§Ãµes derivadas de Error.
 *
 * (CRIAR USO DE BOAS MANEIRAS DEFININDOAS NO CODIGO)
 *
 * @author Wellington Pires de Oliveira.
 * @date 21/10/2016
 */
public class ExceptionClass {

	/**
	 * EXCEÃ‡ÃƒO VERIFICADA
	 */
	class VerificadaException extends Exception {

		private static final long serialVersionUID = 1L;

		public VerificadaException() {
			super("NAO FOI POSSIVEL CARREGAR TAL COISA");
		}

		public VerificadaException(String message, Throwable cause) {
			super("NAO FOI POSSIVEL CARREGAR TAL COISA", new Throwable("DADO X NULO"));
		}

	}

	/**
	 * EXCEÃ‡ÃƒO NÃƒO VERIFICADA
	 *
	 * Tambem pode ser encarado como um ERRO do programador
	 */
	class NaoVerificada extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public NaoVerificada() {
			super("NAO FOI POSSIVEL CARREGAR TAL COISA");
		}

		public NaoVerificada(String message, Throwable cause) {
			super("NAO FOI POSSIVEL CARREGAR TAL COISA", new Throwable("DADO X NULO"));
		}

	}

}

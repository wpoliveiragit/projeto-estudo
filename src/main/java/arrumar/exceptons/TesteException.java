package arrumar.exceptons;

/**
 * @author Wellington Pires de Oliveira.
 * @date 11/10/2016
 */
public class TesteException extends Throwable {

	private static final long serialVersionUID = 1L;

	public TesteException() {
		super("Teste");
	}

	public static void main(String[] args) {
		try {
			throw new TesteException();
		} catch (TesteException ex) {
			System.out.println(ex.getMessage());
			System.out.println("dddd");
		}
	}
}

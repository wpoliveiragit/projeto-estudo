package frame;

import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 * Definição do que a classe representa ou administra
 *
 * @author Wellington Pires de Oliveira.
 * @date 17/04/2019
 * @path Estudo.Frame.PainelCadastro
 */
public class PainelCadastro extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Cria um painel de cadastro.
	 */
	public PainelCadastro() {
		super(new MigLayout());
		add(new JLabel("Nome"));
		add(new TextField(15));
		add(new JLabel("Sobre Nome"), "gap unrelated");
		add(new TextField(15), "wrap");
		add(new JLabel("Endereço"));
		add(new TextField(), "span, grow");
	}
}

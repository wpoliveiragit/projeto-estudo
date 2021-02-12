package arrumar.frame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Cria um frame com configurações básicas.
 *
 * @author Wellington Pires de Oliveira.
 * @date 20/05/2017.
 */
public class FrameCadastro {

	/**
	 * O frame principal.
	 */
	private final JFrame f;

	/**
	 * Cria um frame com seus métodos mais tradicionais de uso.
	 *
	 * @param configuracao Configurasões do frame.
	 * @param repaint      executa estas rotinas no momento da atualização do
	 *                     frame. Nulo indica que é pra atualizar normalmente.
	 */
	public FrameCadastro(FrameInitConfig configuracao, FrameRepaint repaint) {
		if (repaint == null) {
			f = new FrameSemRotina(configuracao);
			return;
		}
		f = new FrameComRotina(configuracao, repaint);
		addListeners();
	}

	/**
	 * Um frame que possui apenas as configurações básicas de inicialização.
	 */
	private class FrameSemRotina extends JFrame {

		private static final long serialVersionUID = 1L;

		/**
		 * Cria um frame que possui apenas as configurações básicas indicada no
		 * objeto de parâmetro.
		 *
		 * @param Config As configurações básicas do frame.
		 */
		public FrameSemRotina(FrameInitConfig Config) {
			super(Config.nome);
			setSize(Config.dimensoes);

			// Indica que ao clicar no 'X' da janela, o aplicativo ira fechar
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Desativa o redimensionamento da janela.
			setResizable(Config.redimencionavel);

			// true para a retirar a barra de título
			setUndecorated(Config.retirarTitulo);

			// Centraliza o eixo do x de acordo com o tamanho do frame.
			int centralEixoX = (((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2);

			// Centraliza o eixo do y de acordo com o tamanho do frame
			int centralEixoY = (((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2);

			// Posiciona o frame no centro
			setLocation(centralEixoX, centralEixoY);
		}

	}

	/**
	 * Um frame que possui a rotina de atualização do frame alterada.
	 */
	private class FrameComRotina extends FrameSemRotina {

		private static final long serialVersionUID = 1L;

		/**
		 * A interferencia da atualização.
		 */
		private final FrameRepaint repaint;

		/**
		 * Cria um frame que possui a rotina de atualização do frame alterada.
		 *
		 * @param config  as configurações básicas do frame
		 * @param repaint a interferencia na rotina de atualização do frame.
		 */
		public FrameComRotina(FrameInitConfig config, FrameRepaint repaint) {
			super(config);
			this.repaint = repaint;
		}

		@Override
		public void paint(Graphics g) {
			repaint.preRepaint(g);
			repaint();
			repaint.posRepaint(g);
		}

	}

	/**
	 * Adiciona um novo componente ao frame.
	 *
	 * @param componente O componente a ser adicionado.
	 */
	public void addComponent(Component componente) {
		f.add(componente);
	}

	/**
	 * Reajusta o frame aos objetos inseridos nele.
	 */
	public final void reajustarFrame() {
		f.pack();
	}

	/**
	 * Valida as alterações feitas no layout dos objetos inseridos.
	 */
	public final void validarLayout() {
		f.validate();
	}

	/**
	 * Retorna as dimenções máximas do frame.
	 *
	 * @return As dimenções máximas do frame.
	 */
	public final Dimension getSize() {
		return f.getSize();
	}

	/**
	 * Centraliza o frame na tela e o torna visível.
	 *
	 * @param visivel true para tornar visível.
	 */
	public final void setVisible(boolean visivel) {
		f.setVisible(visivel);// cria a área gráfica do frame e a deixa visível
	}

	/**
	 * Configura um novo painel para o frame.
	 *
	 * @param panel O painel configurado.
	 */
	public final void setContentPane(JPanel panel) {
		f.setContentPane(panel);
	}

	/**
	 * Revalida os componentes da hierarquia.
	 */
	public final void revalidate() {
		f.revalidate();
	}

	/**
	 * Adiciona as rotinas de captura dos eventos do mouse.
	 *
	 * @param mouse As rotinas de captura dos eventos do mouse.
	 */
	public final void addMouseListener(MouseListener mouse) {
		f.addMouseListener(mouse);
	}

	/**
	 * Adiciona as rotinas de captura dos eventos do teclado.
	 *
	 * @param teclado As rotinas de captura dos eventos do teclado
	 */
	public final void addKeyListener(KeyListener teclado) {
		f.addKeyListener(teclado);
	}

	/**
	 * Adiciona todos os listener do frame.
	 */
	private void addListeners() {
		f.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("[ A janela se tornou visivel ]");
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("[ Todos os processos foram finalizados ]");
			}

			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println("[Janela minimizada]");
			}

			@Override
			public void windowClosed(WindowEvent e) { // ignoraso
				// ao tentar fechar uma janela como resultado da chamada de descarte na janela.
				System.out.println("[ Closed ]");// ainda não descobrir como usar
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				System.out.println("[Janela maximizada]");
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println("[A janela perdeu foco]");
			}

			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("[A janela ganhou foco]");
			}

		});
	}

	

}

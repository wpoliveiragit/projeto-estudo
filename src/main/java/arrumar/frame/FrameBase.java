package frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class FrameBase extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Cria a base de um JFrame em uma configuração básica.
	 * 
	 * @param nome          O nome do projeto que irá aparecer no título da janela.
	 * @param dimencao      as dimenções do frame.
	 * @param dimencionavel true para janela dimencionavel.
	 * @param decoracao     false para retirar as decorações de borda.
	 */
	public FrameBase(String nome, Dimension dimencao, boolean dimencionavel, boolean decoracao) {
		super(nome);
		setSize(dimencao);
		setResizable(dimencionavel);
		setUndecorated(decoracao);
		// Indica que ao clicar no 'X' da janela, o aplicativo ira fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Centraliza o eixo do x de acordo com o tamanho do frame.
		int centralEixoX = (((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2);
		// Centraliza o eixo do y de acordo com o tamanho do frame
		int centralEixoY = (((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2);
		// Posiciona o frame no centro
		setLocation(centralEixoX, centralEixoY);
	}

}

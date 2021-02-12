package arrumar.frame;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class FrameImprimeDigito extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] arg) {
		FrameImprimeDigito fid = new FrameImprimeDigito();

		fid.setVisible(true);
	}

	public FrameImprimeDigito() {
		super("Teste");
		setSize(800, 600);
		setResizable(false);
		setUndecorated(false);
		// Indica que ao clicar no 'X' da janela, o aplicativo ira fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Centraliza o eixo do x de acordo com o tamanho do frame.
		int centralEixoX = (((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2);
		// Centraliza o eixo do y de acordo com o tamanho do frame
		int centralEixoY = (((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2);
		// Posiciona o frame no centro
		setLocation(centralEixoX, centralEixoY);

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				System.out.println(e.getKeyChar() + "-" + e.getKeyCode());

			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(">" + e.getKeyCode());
			}
		});
	}

}

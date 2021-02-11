package frame.bola;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

import frame.FrameCadastro;
import frame.FrameInitConfig;

public class FramePingPong extends FrameCadastro {

	public FramePingPong(FrameInitConfig config) {
		super(config, null);
		addComponent(new Bola());
		setVisible(true);
	}

	private class Bola extends Container {
		private static final long serialVersionUID = 1L;
		private int eixoX = 0;
		private int eixoY = 0;
		private int direcao = 1;
		private int seguir = 0;

		Bola() {
			addMouseListener(new MouseListener() {

				@Override // mouse pressionado
				public void mousePressed(MouseEvent e) {

				}

				@Override // click sem movimento
				public void mouseClicked(MouseEvent e) {

				}

				@Override // ao soltar o botão do mouse
				public void mouseReleased(MouseEvent e) {
					eixoX = e.getX();
					eixoY = e.getY();
				}

				@Override // mouse dentro do frame
				public void mouseEntered(MouseEvent e) {
				}

				@Override // mouse fora do frame
				public void mouseExited(MouseEvent e) {
				}
			});
		}

		@Override
		public void paint(Graphics g) {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
			}
			repaint();

			g.fillOval(eixoX, eixoY, 20, 20);

			if (eixoX != seguir) {
				eixoX += direcao;
				return;
			}
			if (seguir == 0) {
				seguir = getWidth() - 20;
				direcao = 1;
				return;
			}

			seguir = 0;
			direcao = -1;

		}
	}

	public static void main(String args[]) {
		FrameInitConfig fd = new FrameInitConfig("Linhas com o Mouse", new Dimension(600, 600), false, false);
		new FramePingPong(fd);
	}
}

package arrumar.frame.bola;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;

/**
 * Definição do que a classe representa ou administra
 *
 * @author Wellington Pires de Oliveira.
 * @date 26/04/2019
 * @path Estudo.FrameObjeto.Bola
 */
public class Bola extends Container {

	private static final long serialVersionUID = 1L;

	private final static String pathImagem = "recursos\\geral\\bola.png"; // caminho da imagem

	private Point pI; // Ponto inicial do segmento.
	private Point pF; // Ponto final do segmento.
	private Point pC; // Ponto corrente do sguimento
	private float crescimento; // % do tamanho do vetos AB (1 = 100%)
	private ImageIcon imagem; // Imagem dos extremos do segmento
	private ThreadLoop rotina; // thread da rotina
	private Ponto[] pontos; // Os pontos que desenhão as estruturas do predio

	/**
	 * Cria um segmento sem pontos armazenados.
	 */
	public Bola() {
		if (new File(pathImagem).exists()) {
			crescimento = 1; // Afirma o vetor AB está em 100%
			imagem = new ImageIcon(pathImagem);
			pC = new Point();
			pontos = new Ponto[] { new Ponto(10, 100), new Ponto(10, 70), new Ponto(30, 70), new Ponto(30, 80),
					new Ponto(40, 80), new Ponto(40, 40), new Ponto(60, 40), new Ponto(60, 20), new Ponto(90, 20),
					new Ponto(90, 60), new Ponto(110, 60), new Ponto(110, 90), new Ponto(125, 90),
					new Ponto(125, 100) };

			rotina = new ThreadLoop(10) {

				@Override
				public void blocoRotina() {
					/**
					 * De x em x milisegundos é verificado se o segmento está completo (1 = 100%),
					 * enquanto não estiver será impresso uma linha que cresce gradualmente 5% da
					 * distancia entre os pontos até que una os dois pontos.
					 */
					if (crescimento < 1) {
						crescimento += .05f;
					}
				}
			};

			addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override // ao soltar o botão do mouse
				public void mouseReleased(MouseEvent e) {
					pI = pF;
					pF = e.getPoint();
					crescimento = 0;
					// Ajuste de posição no frame
					if (pF.getX() < 27) {
						pF.x = 27;
					} else if (pF.x > getSize().getWidth() - 25) {
						pF.x = (int) getSize().getWidth() - 25;
					}
					if (pF.y < 15) {
						pF.y = 15;
					} else if (pF.y > getSize().getHeight() - 40) {
						pF.y = (int) getSize().getHeight() - 40;
					}
					if (pI == null) {
						return;
					}
					rotina.encerrar();
					rotina = new ThreadLoop(25) {

						@Override
						public void blocoRotina() {
							/**
							 * De x em x milisegundos é verificado se o segmento está completo (1 = 100%),
							 * enquanto não estiver será impresso uma linha que cresce gradualmente 5% da
							 * distancia entre os pontos até que una os dois pontos.
							 */
							if (crescimento < 1) {
								crescimento += .05f;
							}
						}
					};
					rotina.iniciar();
				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}

			});
			return;
		}
		System.out.println("Imagem '" + pathImagem + "' não encontrada");
		System.exit(0);
	}

	@Override
	public void paint(Graphics g) {
		repaint();
		/**
		 * Imprime a linha de encontrol entre os dois pontos usando como base de
		 * porcentagem a variável 'vetorAB'
		 */
		if (pI == null || pF == null) {
			return;
		}
		g.setColor(Color.yellow);

		// bola de origem
		g.drawImage(imagem.getImage(), pI.x - 10, pI.y - 10, 20, 20, null);

		// bola de movimento
		pC.x = (int) ((pF.x - pI.x) * crescimento + pI.x);
		pC.y = (int) ((pF.y - pI.y) * crescimento + pI.y);

		// desenha a linha de conexão das bolas
		g.drawLine(pI.x, pI.y, pC.x, pC.y);

		g.drawString("(" + pC.x + "," + pC.y + ")", pC.x - 26, pC.y - 13);// imprime o texto da bola de movimento
		g.setColor(Color.yellow);
		g.fillOval(pC.x - 20, pC.y - 10, 30, 20);
		g.drawImage(imagem.getImage(), pC.x - 10, pC.y - 10, 20, 20, null);

		g.setColor(Color.black);
		g.fillPolygon(
				new int[] { pontos[0].x, pontos[1].x, pontos[2].x, pontos[3].x, pontos[4].x, pontos[5].x, pontos[6].x,
						pontos[7].x, pontos[8].x, pontos[9].x, pontos[10].x, pontos[11].x, pontos[12].x, pontos[13].x },
				new int[] { pontos[0].y, pontos[1].y, pontos[2].y, pontos[3].y, pontos[4].y, pontos[5].y, pontos[6].y,
						pontos[7].y, pontos[8].y, pontos[9].y, pontos[10].y, pontos[11].y, pontos[12].y, pontos[13].y },
				pontos.length);

	}

	private class Ponto {

		int x;
		int y;

		Ponto(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

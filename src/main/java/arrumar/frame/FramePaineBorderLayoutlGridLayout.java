package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FramePaineBorderLayoutlGridLayout extends FrameCadastro {

	public FramePaineBorderLayoutlGridLayout(FrameInitConfig configuracao) {
		super(configuracao, null);
		setContentPane(new PainelBorderLayout());
		setVisible(true);
	}

	/**
	 * Painel gradeado de botoes
	 */
	private class PainelGridLayout extends JPanel {

		private static final long serialVersionUID = 1L;

		int linhas;// linhas
		int colunas;// coluas
		final JButton[][] matriz;
		Cor[] cores = new Cor[] { new Cor(Color.orange, "Laranja"), new Cor(Color.red, "Vermelho"),
				new Cor(Color.white, "Branco"), new Cor(Color.GREEN, "Verde"), new Cor(Color.BLUE, "Azul"),
				new Cor(Color.BLACK, "Preto"), new Cor(Color.cyan, "Cyano"), new Cor(Color.PINK, "Rosa"),
				new Cor(Color.DARK_GRAY, "Cinza") };

		/**
		 * Cria um painel de objetos.
		 *
		 * @param colunas A quantidade de colunas que este painel deverá possuir.
		 * @param linhas  A quantidade de linhas que o painel
		 */
		private PainelGridLayout(int linhas, int colunas) {
			this.linhas = linhas;
			this.colunas = colunas;
			matriz = new JButton[colunas][linhas];
			setLayout(new GridLayout(colunas, linhas));

			class BotaoApoio extends JButton {
				private static final long serialVersionUID = 1L;

				public BotaoApoio(String label) {
					super(label);
					addActionListener(new ActionListener() {

						Random random = new Random();

						@Override
						public void actionPerformed(ActionEvent e) {
							setBackground(cores[random.nextInt(cores.length)]);
						}
					});
				}
			}

			for (int l = 0, b = 1; l < linhas; l++) {
				for (int c = 0; c < colunas; c++) {
					add(matriz[l][c] = new BotaoApoio("" + b++));
				}
			}
		}
	}

	/**
	 * Painel dos botoes laterais do painel
	 */
	private class PainelBorderLayout extends JPanel {

		private static final long serialVersionUID = 1L;

		public PainelBorderLayout() {
			setLayout(new BorderLayout());

			PainelGridLayout painelGrid = new PainelGridLayout(3, 3);

			class BotaoApoio extends JButton {
				private static final long serialVersionUID = 1L;

				BotaoApoio(String label, int i) {
					super(label);
					addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							for (int l = 0; l < painelGrid.linhas; l++) {
								for (int c = 0; c < painelGrid.colunas; c++) {
									painelGrid.matriz[l][c].setBackground(painelGrid.cores[i]);
								}
							}
						}
					});
				}
			}
			add(BorderLayout.NORTH, new BotaoApoio(painelGrid.cores[0].toString(), 0));
			add(BorderLayout.WEST, new BotaoApoio(painelGrid.cores[01].toString(), 1));
			add(BorderLayout.EAST, new BotaoApoio(painelGrid.cores[2].toString(), 2));
			add(BorderLayout.SOUTH, new BotaoApoio(painelGrid.cores[3].toString(), 3));
			add(BorderLayout.CENTER, painelGrid);
		}
	}

	class Cor extends Color {
		private static final long serialVersionUID = 1L;
		private final String nome;

		public Cor(Color cor, String nome) {
			super(cor.getRed(), cor.getGreen(), cor.getBlue());
			this.nome = nome;
		}

		@Override
		public String toString() {
			return nome;
		}
	}

	public static void main(String[] args) {
		FrameInitConfig cf = new FrameInitConfig("Grid Layout", new Dimension(300, 300), false, false);
		 new FramePaineBorderLayoutlGridLayout(cf);
	}
}

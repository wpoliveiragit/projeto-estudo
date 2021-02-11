package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A ideia é criar um frame onde possuira 2 paineis
 *
 * - O Frame será executado com o painel A como plado de fundo inicial
 *
 * - Painel A
 *
 * -- terá seu fundo Azul
 *
 * -- terá um botão de rotulo "Add Fundo B", que coloca o Painel B como plano
 * de fundo no forme.
 *
 * - Painel B
 *
 * -- Terá seu fundo Vermelho
 *
 * -- Terá um botão de rótulo "Add Fundo A", que colocara o Painel A como
 * plano de fundo no forme.
 *
 * @author Wellington Pires de Oliveira.
 * @date 23/05/2017.
 */
public class FrameStepPanel extends FrameCadastro {

	SuportePainel painelA;
	SuportePainel PainelB;

	public FrameStepPanel(FrameInitConfig configuracaoFrame) {
		super(configuracaoFrame, null);
		init();
	}

	private void init() {

		painelA = new SuportePainel("A >>> B (Fundo Azul)", Color.yellow);
		PainelB = new SuportePainel("A <<< B (Fundo Amarelo)", Color.blue);

		painelA.botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(PainelB);
			}
		});

		PainelB.botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(painelA);
			}
		});

		setContentPane(painelA);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				FrameInitConfig cf = new FrameInitConfig("", new Dimension(200, 200), false, false);
				new FrameStepPanel(cf);
			}
		});
	}

	class SuportePainel extends JPanel {

		private static final long serialVersionUID = 1L;

		JButton botao;

		SuportePainel(String nomeBotao, Color backgroundPainel) {
			setBackground(backgroundPainel);
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			botao = new JButton(nomeBotao);
			add(botao);
			validate();
		}

	}

}

package arrumar.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

/**
 * Definição do que a classe representa ou administra
 *
 * @author Wellington Pires de Oliveira.
 * @date 12/04/2019
 * @path Estudo.Frame.Teste
 */
public class Teste {

	public static void main(String[] args) {
		FrameInitConfig fd = new FrameInitConfig("teste", new Dimension(500, 500), false, false);
		
		FrameCadastro fe = new FrameCadastro(fd, null);
		JButton botao = new JButton();
		botao.setFont(new Font("Jokerman", 1, 18));
		botao.setForeground(new Color(0, 0, 102));
		botao.setText(" teste ");
		botao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 102), 3));
		botao.setRequestFocusEnabled(false);
		botao.setRolloverEnabled(false);
		botao.setMargin(new Insets(2, 1000, 2, 14));
		fe.addComponent(botao);
		fe.setVisible(true);
	}

}

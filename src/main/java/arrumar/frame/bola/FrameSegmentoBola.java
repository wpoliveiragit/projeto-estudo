package arrumar.frame.bola;

import java.awt.Dimension;

import arrumar.frame.FrameCadastro;
import arrumar.frame.FrameInitConfig;

/**
 * Definição.
 *
 * @author Wellington Pires de Oliveira.
 * @date 21/05/2017.
 */
public class FrameSegmentoBola extends FrameCadastro {

    public FrameSegmentoBola(FrameInitConfig configuracao) {
        super(configuracao, null);
        addComponent(new Bola());
        setVisible(true);
    }

    public static void main(String[] args) {

        new FrameSegmentoBola(new FrameInitConfig("Segmento",
                new Dimension(600, 600), false, false)).setVisible(true);
    }

}

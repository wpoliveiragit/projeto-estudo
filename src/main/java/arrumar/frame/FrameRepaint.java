package frame;

import java.awt.Graphics;

/**
 * Definição do que a classe representa ou administra
 *
 * @author Wellington Pires de Oliveira.
 * @date 25/04/2019
 * @path Estudo.Frame.FrameRepaint
 */
public interface FrameRepaint {

    /**
     * Comandos executados antes de executar o repaint() do frame. Este método é
     * o ideal para adicionar um atraso de tempo de atualização.
     *
     * @param g Objeto de desenvolvimento gráfico do frame.
     */
    abstract public void preRepaint(Graphics g);

    /**
     * Comandos executados após executar o repaint() do frame.
     *
     * @param g Objeto de desenvolvimento gráfico do frame.
     */
    abstract public void posRepaint(Graphics g);

}

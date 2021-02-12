package arrumar.frame;

import java.awt.Dimension;

/**
 * Definição do que a classe representa ou administra
 *
 * @author Wellington Pires de Oliveira.
 * @date 12/04/2019
 * @path Estudo.Frame.ConfiguracaoFrame
 */
public class FrameInitConfig {

    /**
     * Nome do frame
     */
    String nome;
    /**
     * O tamanho do frame.
     */
    Dimension dimensoes;
    /**
     * True para deixar a tela redimencionável.
     */
    boolean redimencionavel;
    /**
     * true para retirar a barra de título.
     */
    boolean retirarTitulo;

    /**
     * Cria a configuração de um frame.
     *
     * @param nome O nome do frame.
     * @param dimensoes As dimenções do frame. O valor nulo gerará a definição
     * 500x500.
     * @param redimencionavel Habilita o botão de redimencionar da janela
     * @param retirarTitulo Retira a barra de título.
     */
    public FrameInitConfig(String nome, Dimension dimensoes,
            boolean redimencionavel, boolean retirarTitulo) {
        this.nome = (nome == null) ? "" : nome;
        this.redimencionavel = redimencionavel;
        this.retirarTitulo = retirarTitulo;
        this.dimensoes = (dimensoes == null)
                ? new Dimension(500, 500) : dimensoes;
    }

}

package arrumar.utilitarios;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Um coletor de informações do computador.
 *
 * @author Wellington Pires de Oliveira.
 * @date 22/05/2017.
 */
public final class Utilitarios {

    /**
     * Retorna a dimenção do monitor.
     *
     * @return A dimenção do monitor.
     */
    public final static Dimension getDimencaoMonitor() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * Retorna o horário atual do sistema no formato HH:mm:ss, onde a hora é de
     * 0 a 23h
     *
     * @return O horário atual do sistema no formato HH:mm:ss, onde a hora é de
     * 0 a 23h
     */
    public final static String getHoraAtual() {
        return (new SimpleDateFormat("HH:mm:ss")).format(new Date());
    }

    /**
     * retorna a data atual do sistema no formato YYYY/MM/dd.
     *
     * @return A data atual do sistema no formato YYYY/MM/dd.
     */
    public final static String getDataAtual() {
        return (new SimpleDateFormat("YYYY/MM/dd")).format(new Date());
    }

    /**
     * Gera uma data futura baseada na data atual do sistema no formato
     * YYYY/MM/dd.
     *
     * @param dias Os dia que serão adicionados na data atual.
     * @return (Adata atual + dias) do futura YYYY/MM/dd.
     */
    public final static String geraDataFutura(int dias) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_WEEK, dias);
        return (new SimpleDateFormat("YYYY/MM/dd")).format(c.getTime());
    }

    /**
     * Emite um beep
     */
    public final static void bip() {
        Toolkit.getDefaultToolkit().beep();
    }

    /**
     * Abre uma janela ou um programa.
     *
     * @param path Uma instancia de onde fica o arquivo.
     */
    public static void abrePastaPrograma(File path) {
        try {
            Runtime.getRuntime().exec("explorer " + path.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("[ERRO] problemas em abrir o caminho \""
                    + path.getAbsolutePath() + "\"");
        }
    }

}

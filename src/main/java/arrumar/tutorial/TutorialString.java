package tutorial;

/**
 * Classe que explica como usar grande parte dos métodos da classe String.
 *
 * @author Wellington Pires de Oliveira.
 * @date 27/04/2018.
 */
public class TutorialString {

    public static void main(String[] args) {
        //alterar
        String texto = "O mundo vai acabar!";
        System.out.println("< antigo > " + texto);
        texto = alterar(texto, "vai acabar", "esta acabando!");
        System.out.println("<alterado> " + texto);

        //Array de char para String
        texto = arrayCharToString(new char[]{'M', 'A', 'R', 'A'});
        System.out.println("\n>>>" + texto);

        //fsdfs
        System.out.println("\n>>>" + getChar(texto, 0));
    }

    public static String arrayCharToString(char array[]) {
        return new String(array);
    }

    public static String alterar(
            String texto, String encontrar, String substituir) {
        if (texto == null || encontrar == null || substituir == null) {
            return texto;
        }
        return texto.replaceAll(encontrar, substituir);
    }

    public static char getChar(String texto, int indice) {
        return  texto.charAt(indice);
    }

}

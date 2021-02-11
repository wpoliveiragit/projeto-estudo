package tutorial;

/**
 *
 * @author Wellington Pires de Oliveira
 */
public class StringEstudo {

    public static void main(StringEstudo[] args) {
        //Como alterar um texto dentro de uma string
        String s = "Ola como vc esta\n  eu estou bem e voce?\n  Estou legal";
        String velho = "  estou bem";
        String novo = "  estou muito bem";

        s = s.replaceAll(novo, velho);
        //Obs.: Caso o q seja buscado seja um char use apenas .replace(char,char)
        System.out.println(s);

        //SEPARANDO um testo por marcadores 
        s = "oi-*tudo-*bem?";

        String[] s1 = s.split("-*");

        for (String z : s1) {
            System.out.println(z);
        }

    }

}

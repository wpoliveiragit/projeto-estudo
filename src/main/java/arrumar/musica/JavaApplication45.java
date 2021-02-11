/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica;


import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 *
 * @author Thon
 */
public class JavaApplication45 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Este projeto precisa do import jfugue.jar*/
        Player player = new Player();
        Pattern pattern = new Pattern("C D E F G A B");
        player.play(pattern);
       

        System.exit(0);
    }

}

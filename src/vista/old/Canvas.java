package vista.old;

import modelo.Palabra;

import javax.swing.*;
import java.awt.*;


/**
 * Clase que gestiona la palabra a presentar
 * en cuanto a sus atributos de color y demás.
 */
public class Canvas extends JPanel {

    private Palabra palabra;

    private String infoPanel;

    private Font font;

    /**
     * Método constructor
     */
    public Canvas(){

        this.setBackground( new Color(47, 161, 30));
        infoPanel = " Fijate muy bien en las palabras presentadas\ndeberas recordarlas dentro de poco..suerte\n";
        font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 27);

    }

    /**
     * Método que trata el objeto tipo Graphics (palabra).
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        String receptor = "";
      //  receptor = palabra.getPalabra_a_Memorizar();
        g.setFont(font);
        g.drawString("La palabra a memorizar es" + receptor,20,20);


    }
}

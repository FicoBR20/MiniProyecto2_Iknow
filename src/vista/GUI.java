package vista;

import javax.swing.*;
import java.awt.*;

/**
 * (DEPRECATED)...
 *
 * Esta clase gestiona los recursos gráficos del juego.
 * @version v.1.0.0 date:1/06/2023
 */
public class GUI extends JFrame {

    private Panel_1_Inicial frontInicial;

    /**
     * JPanels contenedores.
     */
    private JPanel jPanel_Principal, jPanel_Lateral1, getjPanel_Lateral2;
    /**
     * JButtons que recibiran la decision del usuario en cada frame.
     */

    private int estado_panel;
    private Color  colorBack = new Color(82,25,196);
    private Color colorFront = new Color(188, 234, 192);

    /**
     * Constructor of GUI class
     */
    public GUI(){

        estado_panel = 0;

        //Default JFrame configuration
        this.setTitle("¡ESA ME LA SE!");
        this.setSize(800,500);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

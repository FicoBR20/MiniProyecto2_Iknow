package vista;

import modelo.Palabra;

import javax.swing.*;
import java.awt.*;

public class Panel_4_canvas extends JPanel {

    private Palabra palabra;

    private String infoPanel;

    private Font font;
    private  final Botones atras_boton;

    public Panel_4_canvas(){

        this.setBackground( new Color(47, 161, 30));
        infoPanel = " Fijate muy bien en las palabras presentadas\ndeberas recordarlas dentro de poco..suerte\n";
        font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 27);

        atras_boton = new Botones();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets.set(0,0,0,700);
        gbc.gridx=3; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=3; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.anchor=GridBagConstraints.LINE_START;
        this.add(atras_boton.getBoton_style_1("ATRAS"), gbc);

    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        String receptor = "";
      //  receptor = palabra.getPalabra_a_Memorizar();
        g.setFont(font);
        g.drawString("La palabra a memorizar es" + receptor,20,20);


    }

}

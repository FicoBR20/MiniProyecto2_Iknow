package vista;

import javax.swing.*;
import java.awt.*;


public class Panel_2_menu extends JPanel {


    private  Botones atras_boton;
    private   Area_de_Texto area_de_texto;

    public Panel_2_menu(){


        atras_boton = new Botones();
        atras_boton.setTamaño_fuente(20);
        area_de_texto = new Area_de_Texto();

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setSize(400,400);
        this.setBackground(new Color(13, 64, 123));
        initGui();

    }

    public void initGui(){
        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.weightx = 1; // no se deformara
//        gbc.weighty = 1; // no se deformara


        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(area_de_texto.menu(), gbc);

        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(atras_boton.getBoton_style_1("ATRAS"), gbc);

    }

}

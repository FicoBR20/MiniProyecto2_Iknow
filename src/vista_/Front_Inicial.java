package vista_;

import javax.swing.*;
import java.awt.*;


public class Front_Inicial extends JPanel {


    private  Botones si_boton, no_boton;
    private   Area_de_Texto area_de_texto;

    public Front_Inicial(){

        si_boton = new Botones();
        si_boton.setSize(new Dimension(10000,20));
        no_boton = new Botones();
        area_de_texto = new Area_de_Texto();

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setSize(400,400);
        this.setBackground(new Color(13, 64, 123));
        initGui();

    }

    public void initGui(){

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=5; // ocupara 4 columnas
        gbc.gridheight=2; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        //gbc.fill = GridBagConstraints.BOTH; // se proporcionara parejo
        this.add(area_de_texto.getInfo_al_Jugador(), gbc);

        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        //gbc.fill = GridBagConstraints.BOTH; // se proporcionara parejo
        this.add(si_boton.getBoton_style_1("SI"), gbc);

        gbc.gridx=3; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        //gbc.fill = GridBagConstraints.BOTH; // se proporcionara parejo
        this.add(no_boton.getBoton_style_2("NO"), gbc);

    }

}

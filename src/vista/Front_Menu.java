package vista;

import javax.swing.*;
import java.awt.*;


public class Front_Menu extends JPanel {


    private Botones_ si_boton, no_boton;
    private   Area_de_Texto area_de_texto;

    public Front_Menu(){

        si_boton = new Botones_("SI",40,70,30);
        no_boton = new Botones_("NO",40,70,30);
        area_de_texto = new Area_de_Texto();

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setSize(400,400);
        this.setBackground(new Color(123, 68, 13));
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
        this.add(area_de_texto.menu(), gbc);

        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        //gbc.fill = GridBagConstraints.BOTH; // se proporcionara parejo
        this.add(si_boton, gbc);

        gbc.gridx=3; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        //gbc.fill = GridBagConstraints.BOTH; // se proporcionara parejo
        this.add(no_boton, gbc);

    }

}

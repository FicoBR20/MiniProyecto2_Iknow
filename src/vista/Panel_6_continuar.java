package vista;

import java.awt.*;


public class Panel_6_continuar extends FondoPanel {

    private  final Botones continuar_boton, atras_boton;

    public Panel_6_continuar(){
        continuar_boton = new Botones();
        atras_boton = new Botones();

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
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
      //  this.add(area_de_texto.continuar(), gbc);

        gbc.insets.set(0,0,5,5);
        gbc.gridx=1; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(continuar_boton.getBoton_style_0("SEGUIR"), gbc);

        gbc.gridx=1; // columna 0
        gbc.gridy=2; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(atras_boton.getBoton_style_0("ATRAS"), gbc);
    }

}

package vista;

import javax.swing.*;
import java.awt.*;


public class Panel_1_Inicial extends JPanel {

    private  final Botones continuar_boton, opcion_boton, jugar_boton, reglas_boton;
    private  final Area_de_Texto area_de_texto;

    public Panel_1_Inicial(){

        continuar_boton = new Botones();
        opcion_boton = new Botones();
        reglas_boton = new Botones();
        jugar_boton = new Botones();

        area_de_texto = new Area_de_Texto();

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setSize(400,400);
        this.setBackground(new Color(13, 64, 123));
        initGui();

    }

    public void initGui(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.ipady = 10;
        gbc.insets.set(0,0,0,0);


        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(area_de_texto.inicial(), gbc);

        gbc.insets.set(50,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(continuar_boton.getBoton_style_1("CONTINUAR"), gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=2; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(jugar_boton.getBoton_style_1("NUEVO JUEGO"), gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(opcion_boton.getBoton_style_1("OPCIONES"), gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=4; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(reglas_boton.getBoton_style_1("COMO JUGAR"), gbc);

    }

}

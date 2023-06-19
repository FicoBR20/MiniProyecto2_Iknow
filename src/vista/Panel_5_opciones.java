package vista;

import java.awt.*;


public class Panel_5_opciones extends FondoPanel {

    private  final Botones sonido_boton, grafico_boton, idioma_boton, atras_boton;
    private  final Area_de_Texto area_de_texto;

    public Panel_5_opciones(){

        sonido_boton = new Botones();
        grafico_boton = new Botones();
        atras_boton = new Botones();
        idioma_boton = new Botones();

        area_de_texto = new Area_de_Texto();

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setSize(400,400);
        this.setBackground(new Color(13, 64, 123));
        initGui();

    }

    public void initGui(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.ipady=15;
        gbc.ipadx=15;



        gbc.insets.set(0,0,50,5);
        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(area_de_texto.opciones(), gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(sonido_boton.getBoton_style_0("SONIDO"), gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=2; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(idioma_boton.getBoton_style_0("IDIOMA"), gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=2; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(grafico_boton.getBoton_style_0("GRAFICO"), gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=2; // columna 0
        gbc.gridy=2; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(atras_boton.getBoton_style_0("ATRAS"), gbc);

    }

}

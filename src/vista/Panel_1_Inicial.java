package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Panel_1_Inicial extends FondoPanel{


    private Botones boton;
    private  final Area_de_Texto area_de_texto;
    private FondoPanel logo;
    private Escucha escucha;
    private Timer timer;
    private int cont_1;
    private int cont_2;

    public Panel_1_Inicial(){

        boton = new Botones();
        area_de_texto = new Area_de_Texto();
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setSize(400,400);
        this.setBackground(new Color(13, 64, 123));
        initGui();

    }

    public void initGui(){
        escucha = new Escucha();
        cont_1 = 0;  cont_2 = 0;

        logo = new FondoPanel();
        logo.set_ruta_fondo("/resources/fondos/logo.png");
        logo.setPreferredSize(new Dimension(700,208));

        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.ipady = 2;
        gbc.insets.set(0,0,0,0);


        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(logo, gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
//        this.add(boton.getBoton_style_0("CONTINUAR"), gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=2; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        boton = new Botones();
        this.add(boton.getBoton_style_0("NUEVO JUEGO"), gbc);


        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        boton = new Botones();
//        this.add(boton.getBoton_style_0("OPCIONES"), gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=4; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        boton = new Botones();
        this.add(boton.getBoton_style_0("COMO JUGAR"), gbc);

        timer = new Timer(0,escucha);
        timer.start();
    }

    public class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==timer && cont_1 <= 13 && cont_2 < 0) {
                timer.stop();
                logo.set_ruta_fondo("/resources/animaciones/logo/"+cont_1+".png");
                cont_1++;
                timer = new Timer(50, escucha);
                timer.start();
            }else if (e.getSource()==timer && cont_1 > 13 && cont_2 < 0){
                logo.set_ruta_fondo("/resources/animaciones/logo/0.png");
                timer.stop();
            }


        }
    }
}

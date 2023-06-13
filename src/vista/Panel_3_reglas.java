package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Panel_3_reglas extends FondoPanel{


    private Botones boton_salir, boton_sguiente, boton_atras;
    private Area_de_Texto area_de_texto;
    private Escucha escucha2;
    private Timer timer;
    private FondoPanel box;
    private  int cont;

    public Panel_3_reglas(){

        set_ruta_fondo(2);
        area_de_texto = new Area_de_Texto();
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setSize(400,400);
        this.setBackground(new Color(13, 64, 123));
        initGui();

    }

    public void initGui(){
        escucha2 = new Escucha();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.ipady = 10;
        cont = 6;

        FondoPanel logo = new FondoPanel();
        logo.set_ruta_fondo("/resources/fondos/logo.png");
        logo.setPreferredSize(new Dimension(330,100));
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.insets.set(0,0,260,0);
        this.add(logo, gbc);

        gbc.insets.set(30,0,0,0);
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(area_de_texto.reglas(), gbc);


        box = new FondoPanel();
        box.set_ruta_fondo("/resources/fondos/f7.png");
        box.setPreferredSize(new Dimension(600,250));
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.insets.set(70,0,0,0);
        this.add(box, gbc);


        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        boton_salir = new Botones();
        boton_salir.setVisible(false);
        this.add(boton_salir.getBoton_style_0("SALIR"), gbc);

        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        boton_sguiente = new Botones();
        boton_sguiente.addActionListener(escucha2);
        this.add(boton_sguiente.getBoton_style_0(" SIGUIENTE "), gbc);


        gbc.insets.set(0,0,0,0);
        gbc.gridx=0; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        boton_atras = new Botones();
        boton_atras.setVisible(false);
        boton_atras.addActionListener(escucha2);
        this.add(boton_atras.getBoton_style_0(" ATRAS "), gbc);

        timer = new Timer(2000,escucha2);
        timer.start();

    }

    public class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==boton_sguiente){

                area_de_texto.reglas_2();
                boton_atras.setVisible(true);
                boton_sguiente.setVisible(false);
                boton_salir.setVisible(true);
            }
            else if (e.getSource()==boton_atras){

                area_de_texto.reglas();
                boton_atras.setVisible(false);
                boton_sguiente.setVisible(true);
                boton_salir.setVisible(false);
            }

            if (e.getSource()==timer && cont >= 0) {
                timer.stop();
                System.out.println("Entro "+cont);
                box.set_ruta_fondo("/resources/fondos/f" + (cont) + ".png");
                cont--;
                timer = new Timer(25,escucha2);
                timer.start();
            }else {
                timer.stop();
//                box.set_ruta_fondo("/resources/fondos/f" + (cont) + ".png");
//                cont;
            }

        }
    }
}

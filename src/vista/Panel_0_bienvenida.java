package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Panel_0_bienvenida extends FondoPanel{


    private Botones boton_sguiente;
    private Area_de_Texto area_de_texto;
    private Escucha escucha;
    private Timer timer;
    private FondoPanel logo;
    private  int cont;
    private  int cont_2;
    private  JProgressBar progressBar;

    public Panel_0_bienvenida(){

        set_ruta_fondo(2);
        area_de_texto = new Area_de_Texto();
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setSize(400,400);
        this.setBackground(new Color(13, 64, 123));
        initGui();

    }

    public void initGui(){
        escucha = new Escucha();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.ipady = 10;
        cont = 0;
        cont_2=-99;


        progressBar = new JProgressBar();

        progressBar.setPreferredSize(new Dimension(500,10));
        progressBar.setMaximum(0);
        progressBar.setMaximum(13);
        progressBar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setValue(0);

        gbc.gridx=0; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.insets.set(0,0,0,0);
        this.add(progressBar, gbc);

        logo = new FondoPanel();
        logo.set_ruta_fondo("/resources/fondos/logo.png");
        logo.setPreferredSize(new Dimension(700,178));
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.insets.set(0,0,0,0);
        this.add(logo, gbc);


        gbc.insets.set(0,0,0,0);
        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        boton_sguiente = new Botones();
        boton_sguiente.addActionListener(escucha);
        boton_sguiente.setVisible(false);
        this.add(boton_sguiente.getBoton_style_0("ENTRAR"), gbc);


        timer = new Timer(2000, escucha);
        timer.start();

    }

    public class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

//
            if (e.getSource()==timer && cont <= 13 && cont_2 < 0) {
                timer.stop();
                logo.set_ruta_fondo("/resources/animaciones/logo/"+cont+".png");
                progressBar.setValue(cont);
                cont++;
                timer = new Timer(100, escucha);
                timer.start();

            }else if (e.getSource()==timer && cont > 13 && cont_2 < 0){
                progressBar.setVisible(false);
                logo.set_ruta_fondo("/resources/animaciones/logo/0.png");
                cont_2 = 13;
            }

            else  if (e.getSource()==timer && cont_2 > 0 && cont > 0) {
                logo.set_ruta_fondo("/resources/animaciones/logo/"+cont_2+".png");
                cont_2--;
                boton_sguiente.setVisible(true);
            }else if (e.getSource()==timer &&  cont > 13 && cont_2 == 0){
                timer.stop();
                cont = 0;
            }


        }
    }
}

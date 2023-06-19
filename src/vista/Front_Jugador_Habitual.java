package vista;

import controlador.Jugador;
import modelo.Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase que mostrará la información de un jugador habitual
 * previamente registrado que ya ha logrado superar algunos
 * niveles y cuenta con un registro de los puntos logrados.
 */
public class Front_Jugador_Habitual extends JPanel {

    private Jugador jugador;

    private Juego juego_Ik;


    private String name_Player;

    private Escucha escucha;



    private Botones boton_SI, boton_NO, boton_Actualizar;


    private JLabel jlabel_Nos_Agrada_Tenerte, jLabel_NombreJugador, jLabel_PuntosLogrados, jLabel_NivelSuperado, jLabel_DeseasContinuar;


    private JTextField jTextField_NombreJugador, jTextField_PuntosLogrados, jTextField_NivelSuperado;


    //private

    private Teclado teclado;

    public String getName_Player() {
        return name_Player;
    }

    public void setName_Player(String name_Player) {
        this.name_Player = name_Player;
    }

    private Color verdeClaro = new Color(188, 234, 192);
    private Color fondoLila = new Color(82, 25, 196);
    /**
     * Constructor
     */
    public Front_Jugador_Habitual(){
        init_Panel();
        //this.setSize(300,400);
        this.setPreferredSize(new Dimension(600,400));
        this.setBackground(fondoLila);


    }

    public void init_Panel(){

        jugador = new Jugador();

        juego_Ik =  new Juego();

        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);
        jlabel_Nos_Agrada_Tenerte = new JLabel(" Nos agrada tenerte de nuevo ");
        jlabel_Nos_Agrada_Tenerte.setFont(font);
        jlabel_Nos_Agrada_Tenerte.setBackground(fondoLila);
        jlabel_Nos_Agrada_Tenerte.setForeground(verdeClaro);


        jLabel_NombreJugador = new JLabel(" Nombre Jugador ");
        jLabel_NombreJugador.setFont(font);
        jLabel_NombreJugador.setBackground(fondoLila);
        jLabel_NombreJugador.setForeground(verdeClaro);

        jLabel_PuntosLogrados = new JLabel(" Puntos Logrados ");
        jLabel_PuntosLogrados.setFont(font);
        jLabel_PuntosLogrados.setBackground(fondoLila);
        jLabel_PuntosLogrados.setForeground(verdeClaro);

        jLabel_NivelSuperado = new JLabel(" Nivel Superado ");
        jLabel_NivelSuperado.setFont(font);
        jLabel_NivelSuperado.setBackground(fondoLila);
        jLabel_NivelSuperado.setForeground(verdeClaro);

        jLabel_DeseasContinuar = new JLabel(" Deseas Continuar ");
        jLabel_DeseasContinuar.setFont(font);
        jLabel_DeseasContinuar.setBackground(fondoLila);
        jLabel_DeseasContinuar.setForeground(verdeClaro);


        jTextField_NombreJugador = new JTextField("",20);
        jTextField_NombreJugador.setSize(new Dimension(100,60));
        jTextField_PuntosLogrados = new JTextField("",20);
        jTextField_PuntosLogrados.setSize(new Dimension(100,60));
        jTextField_NivelSuperado = new JTextField("",20);
        jTextField_NivelSuperado.setSize(new Dimension(100,60));




        boton_SI = new Botones("SI",15,70,30);
        boton_NO = new Botones("NO",15,70,30);
        boton_Actualizar = new Botones("ACTUALIZAR",15,70,30);



        escucha = new Escucha();
       // teclado = new Teclado();

        boton_SI.addMouseListener(escucha);
        boton_NO.addMouseListener(escucha);
        boton_Actualizar.addMouseListener(escucha);


       // jTextField_NombreJugador.addKeyListener(teclado);



        GridBagLayout gridBagLayout = new GridBagLayout();

        this.setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=5; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        this.add(jlabel_Nos_Agrada_Tenerte, gbc);

        gbc.gridx=1; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        this.add(jLabel_NombreJugador, gbc);

        gbc.gridx=3; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        this.add(jTextField_NombreJugador, gbc);
        jTextField_NombreJugador.requestFocus();


        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=3; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        this.add(boton_SI.getBoton_style_1("INICIAR"), gbc);

    }



    /**
     * inner class implements Listeners used by Front_Inicial class
     */
    /**
     * inner class implements Listeners used by Front_Inicial class
     */

    private class Teclado extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
        }
    }
    private class Escucha extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (e.getSource()==boton_SI){
                System.out.println(" el jugador desea continuar al siguiente nivel");
                }
            else if (e.getSource()==boton_NO) {
                System.out.println(" el jugador NO desea continuar al siguiente nivel");

            }
        }
    }
}

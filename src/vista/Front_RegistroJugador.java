package vista;

import controlador.Control_FileManager;
import modelo.Juego;
import vista.old.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Front_RegistroJugador extends FondoPanel {

    private Juego juego_Ik;
    private Header header;
    private String name_Player;
    private Botones iniciar_Juego,atras_boton;
    private JLabel jlabel_Title, jLabel_NombreJugador;
    private JTextField jTextField_NombreJugador;
    private Escucha escucha;
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
    public Front_RegistroJugador(){
        init_Panel();
        //this.setSize(300,400);
        this.setPreferredSize(new Dimension(600,400));
        this.setBackground(fondoLila);


    }

    public void init_Panel(){

        juego_Ik =  new Juego();

        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);

        header = new Header(" Registro del Jugador ", verdeClaro);
        header.setPreferredSize(new Dimension(600,20));

        jlabel_Title = new JLabel(" Ingrese sus datos ");
        jlabel_Title.setFont(font);
        jlabel_Title.setBackground(fondoLila);
        jlabel_Title.setForeground(verdeClaro);

        jLabel_NombreJugador = new JLabel(" Nombre del jugador ");
        jLabel_NombreJugador.setFont(font);
        jLabel_NombreJugador.setBackground(fondoLila);
        jLabel_NombreJugador.setForeground(verdeClaro);

        jTextField_NombreJugador = new JTextField("",20);
        jTextField_NombreJugador.setSize(new Dimension(100,60));

        escucha = new Escucha();
        teclado = new Teclado();

        jTextField_NombreJugador.addKeyListener(teclado);

        GridBagLayout gridBagLayout = new GridBagLayout();

        this.setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();



        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=5; // ocupara n columnas
        gbc.gridheight=1; // ocupara n filas
//        gbc.weightx = 1.0; // no se deformara
//        gbc.weighty = 1.0; // no se deformara
        gbc.ipadx=15;//relleno interno en x pixels
        gbc.ipady=15;//relleno interno en y pixels
//        gbc.anchor=GridBagConstraints.PAGE_START;//cuando el componente es mas pequenno que el area de visualización.tambien PAGE_START, PAGE_END, LINE_START, LINE_END, FIRST_LINE_START, FIRST_LINE_END, LAST_LINE_ENDy LAST_LINE_START.
//        this.add(header, gbc);

        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,50,0);
        this.add(jlabel_Title, gbc);

        gbc.gridx=0; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        this.add(jLabel_NombreJugador, gbc);

        gbc.gridx=1; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        this.add(jTextField_NombreJugador, gbc);
        jTextField_NombreJugador.requestFocus();
//<<<<<<< HEAD
//=======
//
//>>>>>>> makecontroller

        iniciar_Juego = new Botones();
        iniciar_Juego.desactivar();
        iniciar_Juego.addMouseListener(escucha);
        gbc.gridx=0; // columna 0
        gbc.gridy=2; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(50,0,0,0);
        this.add(iniciar_Juego.getBoton_style_0("INICIAR"), gbc);

        atras_boton = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        this.add(atras_boton.getBoton_style_0("ATRAS"), gbc);
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

            if (e.getSource()==jTextField_NombreJugador && e.getKeyChar()==KeyEvent.VK_ENTER){
                iniciar_Juego.activar();

                name_Player = jTextField_NombreJugador.getText();

                juego_Ik.setNivel(1);
                juego_Ik.setEstado(4);//vamos al frame del juego en el Nivel 1

                name_Player = name_Player + " " + Integer.toString(juego_Ik.getNivel());

                new Control_FileManager().writer_Jugador(name_Player);

                jTextField_NombreJugador.setText(name_Player);
//                jTextField_NombreJugador.setText(name_Player + "registrado [nombre] [nivel]");
                jTextField_NombreJugador.setEnabled(false);

                System.out.println(" Hemos registrado sus datos " + name_Player + " nivel del juego " + Integer.toString(juego_Ik.getNivel()));
            }
        }
    }
    private class Escucha extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (e.getSource() == iniciar_Juego) {
//                jTextField_NombreJugador.setText(" ");
//                new Juego().setNivel(1);
//                new Juego().setEstado(4);// nos lleva al frame del primer nivel del juego.
//                new Prueba_Frame_001_Inicial().lanza_frames(new Juego().getEstado());
                System.out.println(" Empezamos a jugar en el nivel = 1 ");


            }

        }
    }




}

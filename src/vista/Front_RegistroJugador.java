package vista;

import controlador.Control_FileManager;
import controlador.Jugador;
import modelo.Juego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Front_RegistroJugador extends FondoPanel {

    private JTextArea jTextArea;

    private Control_FileManager controlFileManager;

    private Jugador jugador;

    private Juego juego_Ik;

    /**
     * Atributo para el nombre del jugador.
     */
    private String name_Player;



    private Botones iniciar_Juego, atras_boton;


    private JLabel jlabel_Title, jLabel_NombreJugador;


    private JTextField jTextField_NombreJugador;


    /**
     * Atributo MouseAdapter
     */
    private Escucha escucha;

    /**
     * Atributo KeyAdapter
     */
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
        this.setPreferredSize(new Dimension(800,500));
        this.setBackground(fondoLila);

    }

    /**
     * Método que inicializa los atrubutos de la clase.
      */
    public void init_Panel(){
        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);
//        String info_Registro= "Ingrese su nombre de jugador\n" +
//                "Generamos la info de los niveles superados y puntos logrados\n" +
//                "Acumula 10 puntos por acierto\n";
        jTextArea = new JTextArea("Ingrese su nombre de jugador\n" +
                "Generamos la info de los niveles superados y puntos logrados\n" +
                "Acumula 10 puntos por acierto\n");
        jTextArea.setFont(font);
        jTextArea.setColumns(8);
        jTextArea.setRows(5);
        jTextArea.setForeground(verdeClaro);
//        jTextArea.setText("Ingrese su nombre de jugador\n" +
//                "Generamos la info de los niveles superados y puntos logrados\n" +
//                "Acumula 10 puntos por acierto\n");
        jTextArea.setOpaque(false);


        jugador = new Jugador();

        juego_Ik =  new Juego();

        jlabel_Title = new JLabel(" \nIngrese su nombre de jugador\n" +
                "generaremos un registro de los niveles que logra superar y\n" +
                "el puntaje obtenido\n Sumará 10 puntos por cada acierto.\n");
        jlabel_Title.setFont(font);
        jlabel_Title.setBackground(fondoLila);
        jlabel_Title.setForeground(verdeClaro);


        jLabel_NombreJugador = new JLabel("Nombre de Jugador");
        jLabel_NombreJugador.setFont(font);
        jLabel_NombreJugador.setBackground(fondoLila);
        jLabel_NombreJugador.setForeground(verdeClaro);


        jTextField_NombreJugador = new JTextField("",20);
        jTextField_NombreJugador.setSize(new Dimension(100,60));

        iniciar_Juego = new Botones("START",20,210,60);
        iniciar_Juego.getBoton_style_0("INICIAR");
        iniciar_Juego.desactivar();



        escucha = new Escucha();
        teclado = new Teclado();

        iniciar_Juego.addMouseListener(escucha);
        jTextField_NombreJugador.addKeyListener(teclado);

        GridBagLayout gridBagLayout = new GridBagLayout();

        this.setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=8; // ocupara 4 columnas
        gbc.gridheight=5; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        gbc.insets.set(5,0,0,0);
        this.add(jTextArea, gbc);

        gbc.gridx=1; // columna 0
        gbc.gridy=7; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        gbc.insets.set(0,150,0,0);
        this.add(jLabel_NombreJugador, gbc);

        gbc.gridx=2; // columna 0
        gbc.gridy=7; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        gbc.insets.set(0,0,0,150);
        this.add(jTextField_NombreJugador, gbc);
        jTextField_NombreJugador.requestFocus();

        gbc.gridx=1; // columna 0
        gbc.gridy=8; // fila 0
        gbc.gridwidth=3; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(50,0,0,0);
        this.add(iniciar_Juego.getBoton_style_0("INICIAR"), gbc);

        atras_boton = new Botones();
        gbc.gridx=1; // columna 0
        gbc.gridy=9; // fila 0
        gbc.gridwidth=3; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        this.add(atras_boton.getBoton_style_0("ATRAS"), gbc);
    }





    /**
     * inner class extends kdyAdapter
      */
    private class Teclado extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
// Registro Jugador por primera vez.

            if (e.getSource()==jTextField_NombreJugador && e.getKeyChar()==KeyEvent.VK_ENTER){
                iniciar_Juego.activar();

                name_Player = jTextField_NombreJugador.getText();

                String db = new Control_FileManager().reader_Jugador();


                if (name_Player.contains(" ") || name_Player.isEmpty()==true || name_Player.length()!=5 ) {
                    System.out.println(" debe ingresar un nombre sin espacios para registrarse ");

                    iniciar_Juego.setEnabled(false);


                }
                else if (db.contains(name_Player)){
                    System.out.println(" Ese nombre ya existe..use otro nombre..");


                    iniciar_Juego.setEnabled(false);
                    juego_Ik.setEstado(12); // presenta de nuevo el panel de registro de jugador
                }else {

                    // se registran los datos del nuevo jugador.

                    jugador.setNombre(name_Player);
                    //Nota cambie esto juego_Ik.getNivel() a 0
                    jugador.setNivel_Superado(0); // nivel sera 1

                    juego_Ik.setEstado(4);//.....con estado 4 DEBEMOS PROGRAMAR IR AL JUEGO AL NIVEL 1

//TODO...se prueba el lector de arrays....
                    new Control_FileManager().array_writer_Jugador(jugador.ToString_Jugador()); // toda la info del jugador

                    jTextField_NombreJugador.setText(name_Player);
                    jTextField_NombreJugador.setEnabled(false);
                    iniciar_Juego.setEnabled(true);


                    System.out.println(" Hemos registrado sus datos " + name_Player + " nivel del juego " + Integer.toString(juego_Ik.getNivel()));
                    System.out.println(" to string es " + jugador.ToString_Jugador());

                }
            }
        }
    }


    /**
     * inner class extends MouseAdapter
     */
    private class Escucha extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (e.getSource() == iniciar_Juego) {

                System.out.println(" Empezamos a jugar en el nivel = 1 ");

            }
        }
    }
}

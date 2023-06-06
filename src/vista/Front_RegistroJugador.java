package vista;

import controlador.Control_FileManager;
import modelo.Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Front_RegistroJugador extends JPanel {

    private String name_Player;



    private JButton iniciar_Juego;


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

        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);


        jlabel_Title = new JLabel(" Registro del Jugador ");
        jlabel_Title.setFont(font);
        jlabel_Title.setBackground(fondoLila);
        jlabel_Title.setForeground(verdeClaro);


        jLabel_NombreJugador = new JLabel(" Nombre del jugador ");
        jLabel_NombreJugador.setFont(font);
        jLabel_NombreJugador.setBackground(fondoLila);
        jLabel_NombreJugador.setForeground(verdeClaro);


        jTextField_NombreJugador = new JTextField("",20);
        jTextField_NombreJugador.setSize(new Dimension(100,60));




        iniciar_Juego = new JButton();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/Boton_Inicio.png"));
        ImageIcon imageIcon_Pressed = new ImageIcon(getClass().getResource("/resources/Boton_Inicio_PRESSED.png"));
        iniciar_Juego.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        iniciar_Juego.setBorder(BorderFactory.createEmptyBorder());
        iniciar_Juego.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        iniciar_Juego.setEnabled(false);



        escucha = new Escucha();
        teclado = new Teclado();

        iniciar_Juego.addMouseListener(escucha);
        jTextField_NombreJugador.addKeyListener(teclado);

        GridBagLayout gridBagLayout = new GridBagLayout();

        this.setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=5; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        this.add(jlabel_Title, gbc);

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

        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=3; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        this.add(iniciar_Juego, gbc);

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

                name_Player = jTextField_NombreJugador.getText();

                new Juego().setNivel(1);
                new Juego().setEstado(4);//vamos al frame del juego en el Nivel 1

                name_Player = name_Player + " " + Integer.toString(new Juego().getNivel());

                new Control_FileManager().writer(name_Player);

                iniciar_Juego.setEnabled(true);
                jTextField_NombreJugador.setText(name_Player + "registrado [nombre] [nivel]");
                jTextField_NombreJugador.setEnabled(false);



                System.out.println(" Hemos registrado sus datos " + name_Player + " nivel del juego " + Integer.toString(new Juego().getNivel()));
            }

        }
    }
    private class Escucha extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (e.getSource() == iniciar_Juego) {
                jTextField_NombreJugador.setText(" ");
                new Juego().setNivel(1);
                new Juego().setEstado(4);// nos lleva al frame del primer nivel del juego.
                new Prueba_Frame_001_Inicial().lanza_frames(new Juego().getEstado());
                System.out.println(" Empezamos a jugar en el nivel = 1 ");


            }

        }
    }




}

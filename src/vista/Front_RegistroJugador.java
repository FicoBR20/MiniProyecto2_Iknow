package vista;

import controlador.Control_FileManager;
import modelo.Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase que gestiona la Gui para el registro del jugador
 */
public class Front_RegistroJugador extends JPanel {

    private Juego juego_Ik;

    private Header header;

    /**
     * Atributo para el nombre del jugador.
     */
    private String name_Player;



    private JButton iniciar_Juego;


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
        //this.setSize(300,400);
        this.setPreferredSize(new Dimension(600,400));
        this.setBackground(fondoLila);


    }

    /**
     * Método que inicializa los atrubutos de la clase.
      */
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



        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=5;
        gbc.gridheight=1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipady=5;
        gbc.anchor=GridBagConstraints.PAGE_START;
        this.add(header, gbc);


        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=5;
        gbc.gridheight=1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        this.add(jlabel_Title, gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        this.add(jLabel_NombreJugador, gbc);

        gbc.gridx=3;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        this.add(jTextField_NombreJugador, gbc);

        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        this.add(iniciar_Juego, gbc);

    }





    /**
     * inner class extends kdyAdapter
      */
    private class Teclado extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            if (e.getSource()==jTextField_NombreJugador && e.getKeyChar()==KeyEvent.VK_ENTER){

                name_Player = jTextField_NombreJugador.getText();

                juego_Ik.setNivel(1);
                juego_Ik.setEstado(4);

                name_Player = name_Player + " " + Integer.toString(juego_Ik.getNivel());

                new Control_FileManager().writer_Jugador(name_Player);

                iniciar_Juego.setEnabled(true);
                jTextField_NombreJugador.setText(name_Player + "registrado [nombre] [nivel]");
                jTextField_NombreJugador.setEnabled(false);



                System.out.println(" Hemos registrado sus datos " + name_Player + " nivel del juego " + Integer.toString(juego_Ik.getNivel()));
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

                juego_Ik.setEstado(8);//estao =8 iniciael juego en el nivel 1

                System.out.println(" ..Panel en desarrollo..prsentará el juego en el Nivel 1 ");


            }

        }
    }




}

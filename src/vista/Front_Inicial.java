package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;

/**
 * Clase que gestiona el Frame de inicio de la app.
 */
public class Front_Inicial extends JPanel {

    private JLabel jLabel;

    private Header header;


    private JButton si_Juego_Front_Inicial;

    private JButton no_Juego_Front_Inicial;

    private JTextArea info_al_Jugador;


    private Escucha escucha;


    private Color verdeClaro = new Color(188, 234, 192);
    private Color fondoLila = new Color(82, 25, 196);


    /**
     * Método Constructor
     */
    public Front_Inicial(){
        init_Panel();
        this.setPreferredSize(new Dimension(600,400));
        this.setBackground(fondoLila);

    }

    /**
     * Metodo que inicializa los componentes gráficos.
     */
    public void init_Panel(){


        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);

        header = new Header(" Bienvenidos ", verdeClaro);
        header.setPreferredSize(new Dimension(600,20));


        si_Juego_Front_Inicial = new JButton();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/Boton_SI.png"));
        ImageIcon imageIcon_Pressed = new ImageIcon(getClass().getResource("/resources/Boton_SI_PRESSED.png"));
        si_Juego_Front_Inicial.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        si_Juego_Front_Inicial.setBorder(BorderFactory.createEmptyBorder());
        si_Juego_Front_Inicial.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));

        escucha = new Escucha();

        no_Juego_Front_Inicial = new JButton();
        imageIcon = new ImageIcon(getClass().getResource("/resources/Boton_NO.png"));
        imageIcon_Pressed = new ImageIcon(getClass().getResource("/resources/Boton_NO_PRESSED.png"));
        no_Juego_Front_Inicial.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        no_Juego_Front_Inicial.setBorder(BorderFactory.createEmptyBorder());
        no_Juego_Front_Inicial.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));



        si_Juego_Front_Inicial.addActionListener(escucha);
        no_Juego_Front_Inicial.addActionListener(escucha);


        info_al_Jugador = new JTextArea();
        info_al_Jugador.append("I know that word\n" +
                "Es un divertido juego para ejercitar su memoria \n" +
                "Desea probar en que estado \nse encuentra su memoria Episódica ?\n");
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);
        info_al_Jugador.setEditable(false);
        info_al_Jugador.setOpaque(false);
        info_al_Jugador.setFocusable(false);

        jLabel = new JLabel(" Desea Jugar ?");
        jLabel.setFont(font);
        jLabel.setForeground(verdeClaro);
        jLabel.setBackground(verdeClaro);

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


        gbc.gridx=2;
        gbc.gridy=1;
        gbc.gridwidth=5;
        gbc.gridheight=1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        this.add(info_al_Jugador, gbc);

        gbc.gridx=2;
        gbc.gridy=2;
        gbc.gridwidth=5;
        gbc.gridheight=1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        this.add(jLabel, gbc);

    }





    /**
     * inner class implements Listeners used by Front_Inicial class
     */
    private class Escucha implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()== si_Juego_Front_Inicial){
                new Juego().setEstado(2);
                new Prueba_Frame_001_Inicial().lanza_frames(new Juego().getEstado());
                System.out.println(" le doy las reglas " + Integer.toString(new Juego().getEstado()));
            }
            else if(e.getSource()== no_Juego_Front_Inicial){
                new Juego().setEstado(99);
                new Prueba_Frame_001_Inicial().lanza_frames(new Juego().getEstado());
                System.out.println(" cierre de la app..fin");
            }

        }
    }





}

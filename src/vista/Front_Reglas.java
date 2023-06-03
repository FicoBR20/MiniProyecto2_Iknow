package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Front_Reglas extends JPanel {


    private JButton si_Juego;

    private JButton no_Juego;

    private JButton prueba;


    private JTextArea info_al_Jugador;


    private Escucha escucha;

    private Header encabezado;


    private Color verdeClaro = new Color(188, 234, 192);
    private Color fondoLila = new Color(82, 25, 196);
    /**
     * Constructor
     */
    public Front_Reglas(){
        init_Panel();
        //this.setSize(300,400);
        this.setPreferredSize(new Dimension(600,400));
        this.setBackground(fondoLila);


    }

    public void init_Panel(){


        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 20);

        si_Juego = new JButton();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/Boton_SI.png"));
        ImageIcon imageIcon_Pressed = new ImageIcon(getClass().getResource("/resources/Boton_SI_PRESSED.png"));
        si_Juego.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        si_Juego.setBorder(BorderFactory.createEmptyBorder());
        si_Juego.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));

        escucha = new Escucha();

//        no_Juego = new JButton();
//        imageIcon = new ImageIcon(getClass().getResource("/resources/Boton_NO.png"));
//        imageIcon_Pressed = new ImageIcon(getClass().getResource("/resources/Boton_NO_PRESSED.png"));
//        no_Juego.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
//        no_Juego.setBorder(BorderFactory.createEmptyBorder());
//        no_Juego.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));



//        si_Juego.addActionListener(escucha);
//        no_Juego.addActionListener(escucha);


        info_al_Jugador = new JTextArea();
        info_al_Jugador.append("Aqui van las reglas del juego\n" +
                "Informacion clara para el jugador\n" +
                ".... exitos.\nexitos.\nexitos.\nexitos.\n y más exitos.\n");
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);
        info_al_Jugador.setBackground(fondoLila);
        info_al_Jugador.setEditable(false);
        info_al_Jugador.setFocusable(false);
        info_al_Jugador.setPreferredSize(new Dimension(550,350));

        GridBagLayout gridBagLayout = new GridBagLayout();

        this.setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=1; // ubicacion columna 0
        gbc.gridy=0; // ubicacion fila 0
        gbc.gridwidth=5; // columnoas que ocuparȧ
        gbc.gridheight=2; // filas que ocupará
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara

        this.add(info_al_Jugador, gbc);

        gbc.gridx=2; // columna 0
        gbc.gridy=5; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        this.add(si_Juego, gbc);
//
//        gbc.gridx=3; // columna 0
//        gbc.gridy=3; // fila 0
//        gbc.gridwidth=1; // ocupara 4 columnas
//        gbc.gridheight=1; // ocupara 3 filas
//        gbc.weightx = 1.0; // no se deformara
//        gbc.weighty = 1.0; // no se deformara
//        this.add(no_Juego, gbc);

    }



    /**
     * inner class implements Listeners used by Front_Inicial class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            if (e.getSource()==si_Juego){
//
////                System.out.println(" que empieze el juego ");
//            }
//            else if(e.getSource()==no_Juego){
//                System.out.println(" aqui se termina el juego y se muestra de nuevo el ingreso");
//            }

        }
    }





}

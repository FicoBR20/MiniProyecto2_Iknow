package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import vista.Front_Reglas;
import vista.GUI;

public class Front_Inicial extends JPanel {


    private JButton si_Juego;

    private JButton no_Juego;

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

        si_Juego = new JButton();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/Boton_SI.png"));
        ImageIcon imageIcon_Pressed = new ImageIcon(getClass().getResource("/resources/Boton_SI_PRESSED.png"));
        si_Juego.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        si_Juego.setBorder(BorderFactory.createEmptyBorder());
        si_Juego.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));

        escucha = new Escucha();

        no_Juego = new JButton();
        imageIcon = new ImageIcon(getClass().getResource("/resources/Boton_NO.png"));
        imageIcon_Pressed = new ImageIcon(getClass().getResource("/resources/Boton_NO_PRESSED.png"));
        no_Juego.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        no_Juego.setBorder(BorderFactory.createEmptyBorder());
        no_Juego.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));



        si_Juego.addActionListener(escucha);
        no_Juego.addActionListener(escucha);


        info_al_Jugador = new JTextArea();
        info_al_Jugador.append("I know that word\n" +
                "Es un divertido juego para ejercitar su memoria \n" +
                "Desea probar en que estado \nse encuentra su memoria Episódica ?\n");
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);
        info_al_Jugador.setEditable(false);
        info_al_Jugador.setOpaque(false);
        info_al_Jugador.setFocusable(false);

        GridBagLayout gridBagLayout = new GridBagLayout();

        this.setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=6; // ocupara 4 columnas
        gbc.gridheight=2; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        this.add(info_al_Jugador, gbc);

        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        this.add(si_Juego, gbc);

        gbc.gridx=4; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        this.add(no_Juego, gbc);

    }

    public void cierrePanel(JPanel jPanel){

        this.removeAll();
        this.add(jPanel);
    }



    /**
     * inner class implements Listeners used by Front_Inicial class
     */
    private class Escucha implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==si_Juego){
                new Juego().setEstado(2);
                new Juego().getEstado();
                new Prueba_Frame_001_Inicial().initGUI();
                System.out.println(" le doy las reglas ");
            }
            else if(e.getSource()==no_Juego){
                new Juego().setEstado(99);
              //  new Prueba_Frame_001_Inicial().initGUI();
                System.out.println(" cierre de la app..fin");
            }

        }
    }





}

package vista;

import modelo.Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Front_Reglas extends JPanel {

    private Header header;


    private JButton si_Juego;

    private JButton no_Juego;

    private JLabel desea_Jugar;


    private JTextArea info_al_Jugador;


    private Escucha escucha;

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

        header = new Header(" Reglas del Juego ", verdeClaro);
        header.setPreferredSize(new Dimension(600,20));


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
        info_al_Jugador.append("Aqui van las reglas del juego\n" +
                "Informacion clara para el jugador\n" +
                ".... exitos.\nexitos.\nexitos.\nexitos.\n y más exitos.\n");
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);
        info_al_Jugador.setBackground(fondoLila);
        info_al_Jugador.setEditable(false);
        info_al_Jugador.setFocusable(false);

        GridBagLayout gridBagLayout = new GridBagLayout();

        this.setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();



        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=5; // ocupara n columnas
        gbc.gridheight=1; // ocupara n filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        gbc.ipady=5;//relleno interno en y pixels
        gbc.anchor=GridBagConstraints.PAGE_START;//cuando el componente es mas pequenno que el area de visualización.tambien PAGE_START, PAGE_END, LINE_START, LINE_END, FIRST_LINE_START, FIRST_LINE_END, LAST_LINE_ENDy LAST_LINE_START.
        this.add(header, gbc);




        gbc.gridx=2; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=5; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        // gbc.fill = gbc.HORIZONTAL; // maximo width
        this.add(info_al_Jugador, gbc);



        desea_Jugar = new JLabel("Desea Jugar ? ");
        desea_Jugar.setFont(font);
        desea_Jugar.setBackground(fondoLila);
        desea_Jugar.setForeground(verdeClaro);
        gbc.gridx=2; // columna 0
        gbc.gridy=2; // fila 0
        gbc.gridwidth=5; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        gbc.insets.set(2,2,50,2);//espacio externo para el componente.101010
        this.add(desea_Jugar, gbc);



    }



    /**
     * inner class implements Listeners used by Front_Inicial class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==si_Juego){
                new Juego().setEstado(3);
                new Prueba_Frame_001_Inicial().lanza_frames(new Juego().getEstado());
                System.out.println(" se registrará al jugador ");
            }
            else if(e.getSource()==no_Juego){
                new Juego().setEstado(99);
                new Prueba_Frame_001_Inicial().lanza_frames(new Juego().getEstado());
                System.out.println(" aqui se le dice ...otra vez será..lo esperamos..");
            }

        }
    }





}

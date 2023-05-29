package vista;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Front_Inicial extends JPanel {


    private JButton si_Juego;

    private JButton no_Juego;

    private JButton prueba;


    private JTextArea info_al_Jugador;

    private Escucha escucha;


    public Front_Inicial(){
        initGui();
        this.setSize(400,300);
        this.setOpaque(true);


    }

    public void initGui(){


        Color verdeClaro = new Color(188, 234, 192);
        Color fondoLila = new Color(82, 25, 196);

        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 36);

        si_Juego = new JButton();

         ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/Boton.png"));

        si_Juego.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        si_Juego.setBorder(BorderFactory.createEmptyBorder());
        escucha = new Escucha();


        no_Juego = new JButton(" NO ");

        si_Juego.addActionListener(escucha);
        no_Juego.addActionListener(escucha);


        info_al_Jugador = new JTextArea();
        info_al_Jugador.append("I know that word\n" +
                "Ejercite su memoria episódica\n" +
                "Desea jugar?");
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);;
        info_al_Jugador.setOpaque(false);

        GridBagLayout gridBagLayout = new GridBagLayout();

        this.setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=5; // ocupara 4 columnas
        gbc.gridheight=2; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        //gbc.fill = GridBagConstraints.BOTH; // se proporcionara parejo
        this.add(info_al_Jugador, gbc);

        gbc.gridx=1; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        //gbc.fill = GridBagConstraints.BOTH; // se proporcionara parejo
        this.add(si_Juego, gbc);

        gbc.gridx=3; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        //gbc.fill = GridBagConstraints.BOTH; // se proporcionara parejo
        this.add(no_Juego, gbc);




    }

    /**
     * inner class implements Listeners used by Front_Inicial class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==si_Juego){
                System.out.println(" que empieze el juego ");
            }
            else if(e.getSource()==no_Juego){
                System.out.println(" aqui se termina el juego y se muestra de nuevo el ingreso");
            }

        }
    }





}

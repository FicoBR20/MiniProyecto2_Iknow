package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Front_Inicial extends JPanel {

    private JButton si_Juego, no_Juego;
    private JLabel info_al_Jugador;

    private Escucha escucha;

    public Front_Inicial(String title, Color colorBack){
        this.setBackground(new Color(108, 40, 162));
        this.setOpaque(true);

    }

    public void initGui(){
        escucha = new Escucha();

        si_Juego = new JButton(" SI ");
        no_Juego = new JButton(" NO ");

        si_Juego.addActionListener(escucha);
        no_Juego.addActionListener(escucha);

        info_al_Jugador = new JLabel("I know that word\n" +
                "Ejercite su memoria episódica\n" +
                "Desea jugar?");
        info_al_Jugador.setSize(new Dimension(400,300));

        this.add(info_al_Jugador, BorderLayout.CENTER);
        this.add(si_Juego, BorderLayout.SOUTH);
        this.add(no_Juego, BorderLayout.SOUTH);

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

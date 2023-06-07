package vista;

import javax.swing.*;
import java.awt.*;

public class Area_de_Texto {

    private final JTextArea info_al_Jugador;

    public Area_de_Texto() {
        info_al_Jugador = new JTextArea();
    }

    public JTextArea getInfo_al_Jugador() {
        Color verdeClaro = new Color(188, 234, 192);
        Color fondoLila = new Color(82, 25, 196);

        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 36);
        info_al_Jugador.append("I know that word\n" +
                "Ejercite su memoria episódica\n" +
                "Desea jugar ?\n");
        info_al_Jugador.setCaretColor(new Color(255, 255, 255, 0));
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);
        info_al_Jugador.setEditable(false);
        info_al_Jugador.setBackground(null);
        return info_al_Jugador;
    }
    public JTextArea menu() {
        Color verdeClaro = new Color(188, 234, 192);
        Color fondoLila = new Color(82, 25, 196);

        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 36);
        info_al_Jugador.append(":::MENU:::\n" +
                "menu\n" +
                "menu ?\n");
        info_al_Jugador.setCaretColor(new Color(255, 255, 255, 0));
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);
        info_al_Jugador.setEditable(false);
        info_al_Jugador.setBackground(null);
        return info_al_Jugador;
    }
    public JTextArea reglas() {
        Color verdeClaro = new Color(188, 234, 192);
        Color fondoLila = new Color(82, 25, 196);

        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 36);
        info_al_Jugador.append(":::REGLAS:::\n" +
                "menu\n" +
                "menu ?\n");
        info_al_Jugador.setCaretColor(new Color(255, 255, 255, 0));
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);
        info_al_Jugador.setEditable(false);
        info_al_Jugador.setBackground(null);
        return info_al_Jugador;
    }
}

package vista;

import javax.swing.*;
import java.awt.*;

public class Area_de_Texto {

    private final JTextArea info_al_Jugador;

    public Area_de_Texto() {
        info_al_Jugador = new JTextArea();
        Color verdeClaro = new Color(188, 234, 192);
        Color fondoLila = new Color(82, 25, 196);
        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 25);
        info_al_Jugador.append("I know that word\n" +
                "Ejercite su memoria episódica\n" +
                "Desea jugar ?\n");
        info_al_Jugador.setCaretColor(new Color(255, 255, 255, 0));
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);
        info_al_Jugador.setEditable(false);
        info_al_Jugador.setBackground(null);
    }

    public JTextArea Info_al_Jugador() {
        info_al_Jugador.append("I know that word\n" +
                "Ejercite su memoria episódica\n" +
                "Desea jugar ?\n");
        return info_al_Jugador;
    }
    public JTextArea menu() {
        info_al_Jugador.append(":::MENU:::\n" +
                "menu\n" +
                "menu ?\n");
        return info_al_Jugador;
    }
    public JTextArea reglas() {
        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 20);
        info_al_Jugador.setFont(font);
        info_al_Jugador.append("Aqui van las reglas del juego\n" +
                "Informacion clara para el jugador\n" +
                ".... exitos.\nexitos.\nexitos.\nexitos.\n y más exitos.\n");
        return info_al_Jugador;
    }
    public JTextArea final_info() {
        info_al_Jugador.append("....Aqui se cierra el juego...\n" +
                "Recuerda ejercitar tu memoria \n" +
                "..hasta pronto..\n");
        return info_al_Jugador;
    }

    public JTextArea nivel_1() {
        info_al_Jugador.append("I know that word\n" +
                "Es un divertido juego para ejercitar su memoria \n" +
                "Desea probar en que estado \nse encuentra su memoria Episódica ?\n");
        return info_al_Jugador;
    }
}

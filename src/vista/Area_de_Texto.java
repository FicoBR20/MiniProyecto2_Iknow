package vista;

import javax.swing.*;
import java.awt.*;

public class Area_de_Texto {

    private final JTextArea info_al_Jugador;

    public Area_de_Texto() {
        info_al_Jugador = new JTextArea();
        Color verdeClaro = new Color(188, 234, 192);
        Color fondoLila = new Color(82, 25, 196);
        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);
        info_al_Jugador.setCaretColor(new Color(255, 255, 255, 0));
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);
        info_al_Jugador.setEditable(false);
        info_al_Jugador.setBackground(null);
    }

    public JTextArea inicial() {
        info_al_Jugador.append("I know that word\n" +
                "Es un divertido juego para ejercitar su memoria \n" +
                "Desea probar en que estado \nse encuentra su memoria Episódica ?\n");
        return info_al_Jugador;
    }

    public JTextArea menu() {
        info_al_Jugador.append(":::MENU:::\n" +
                "menu\n" +
                "menu ?\n");
        return info_al_Jugador;
    }

    public JTextArea reglas() {
        info_al_Jugador.append(":::REGLAS:::\n" +
                "menu\n" +
                "menu ?\n");
        return info_al_Jugador;
    }

    public JTextArea opciones() {
        info_al_Jugador.append(":::OPCIONES:::\n" +
                "Aqui van las opciones del \n" +
                "menu ?\n");
        return info_al_Jugador;
    }

    public JTextArea continuar() {
        info_al_Jugador.append(":::CONTINUAR:::\n" +
                "Este panel permite ingresar \n" +
                "a una partida previa ?\n");
        return info_al_Jugador;
    }

    public JTextArea seText(String palabra) {
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 80);
        info_al_Jugador.setFont(font);
        info_al_Jugador.setText(palabra);
        return info_al_Jugador;
    }

    public JTextArea seText_2(String palabra) {
        info_al_Jugador.setText(palabra);
        return info_al_Jugador;
    }
}

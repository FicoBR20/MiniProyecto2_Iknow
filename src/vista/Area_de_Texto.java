package vista;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Area_de_Texto {

    private final JTextArea info_al_Jugador;
    private JLabel label_letra;
    private JPanel jPanel;
    private ImageIcon imageIcon;
    private ImageIcon imageIcon_Pressed;

    public Area_de_Texto() {
        info_al_Jugador = new JTextArea();
        jPanel= new JPanel();

        label_letra = new JLabel();
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones_nivel/nivel.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones_nivel/nivel_pressed.png")));
        label_letra.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        label_letra.setDisabledIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));

        Color verdeClaro = new Color(188, 234, 192);
        Color fondoLila = new Color(82, 25, 196);
        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);
        info_al_Jugador.setCaretColor(new Color(255, 255, 255, 0));
        info_al_Jugador.setFont(font);
        info_al_Jugador.setForeground(verdeClaro);
        info_al_Jugador.setEditable(false);
        info_al_Jugador.setBackground(new Color(0x0000000, true));
    }

    public JTextArea inicial() {
        info_al_Jugador.append("I know that word\n" +
                "Es un divertido juego para ejercitar su memoria\n" +
                "Desea probar en que estado \nse encuentra su memoria Episódica?\n");

        return info_al_Jugador;
    }

    public JTextArea menu() {
        info_al_Jugador.append(":::MENU:::\n" +
                "menu\n" +
                "menu ?\n");
        return info_al_Jugador;
    }

    public JTextArea reglas() {
        info_al_Jugador.append(":::_REGLAS 1_:::\n" +
                "menu\n" +
                "menu ?\n");
        return info_al_Jugador;
    }

    public JTextArea reglas_2() {
        info_al_Jugador.append(":::_REGLAS 2_:::\n" +
                "menu\n" +
                "menu ?\n");
        return info_al_Jugador;
    }

    public JTextArea opciones() {
        info_al_Jugador.append(":::OPCIONES:::\n" +
                "Aqui van las opciones del\n" +
                "menu?\n");
        return info_al_Jugador;
    }


    public JTextArea continuar() {
        info_al_Jugador.append(":::CONTINUAR:::\n" +
                "Este panel permite ingresar\n" +
                "a una partida previa?\n");
        return info_al_Jugador;
    }


    public JTextArea seText(String palabra) {
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 50);
        info_al_Jugador.setFont(font);
        info_al_Jugador.setText(palabra);
        return info_al_Jugador;
    }

    public JTextArea seText_2(String palabra) {
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 35);
        info_al_Jugador.setFont(font);
        int anchoTotal = 40; // Ancho total del espacio en el que se centrará el texto

        String[] lineas = palabra.split("\n");
        StringBuilder resultado = new StringBuilder();

        for (String linea : lineas) {
            int espacios = (anchoTotal - linea.length()) / 2;
            String lineaCentrada = String.format("%" + espacios + "s%s%" + espacios + "s", "", linea, "");
            resultado.append(lineaCentrada).append("\n");
        }

        info_al_Jugador.setText(resultado.toString());
        return info_al_Jugador;
    }

}

package vista;

import controlador.Lanza_app_Prueba;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Botones extends  JButton{
    private Lanza_app_Prueba.Escucha escucha;
    private ImageIcon imageIcon;
    private ImageIcon imageIcon_Pressed;
    private final int tamanho_fuente,ancho,alto;

    public void activar() {
        this.setEnabled(true);
    }

    public void desactivar() {
        this.setEnabled(false);
    }
    public Botones() {
        tamanho_fuente = 40;
        ancho = 70;
        alto = 30;
        escucha = new Lanza_app_Prueba.Escucha();
        this.setBackground(null);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.addActionListener(escucha);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        imageIcon = new ImageIcon();
        imageIcon_Pressed = new ImageIcon();
        getBoton_style_1();
    }

    public Botones(String titulo, int tamaño, int _ancho, int _alto  ) {
        this.setText(titulo);
        tamanho_fuente = tamaño;
        ancho = _ancho;
        alto = _alto;
        escucha = new Lanza_app_Prueba.Escucha();
        this.setBackground(null);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.addActionListener(escucha);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        imageIcon = new ImageIcon();
        imageIcon_Pressed = new ImageIcon();
        getBoton_style_1();
    }


    public JButton getBoton_style_1() {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton_PRESSED.png")));
        this.setForeground(Color.white);
        this.setFont(new Font(null,Font.BOLD, tamanho_fuente));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        this.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        return this;
    }

    public JButton getBoton_style_2() {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton_2.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton_PRESSED_2.png")));
        this.setForeground(Color.white);
        this.setFont(new Font(null,Font.BOLD, tamanho_fuente));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        this.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        return this;
    }

}

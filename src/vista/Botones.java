package vista;

import controlador.Lanza_app_Prueba;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Botones extends  JButton{
    private Lanza_app_Prueba.Escucha escucha;
    private ImageIcon imageIcon;
    private ImageIcon imageIcon_Pressed;
    private int tamaño_fuente,alto,ancho;

    public int getTamaño_fuente() {
        return tamaño_fuente;
    }

    public void setTamaño_fuente(int tamaño_fuente) {
        this.tamaño_fuente = tamaño_fuente;
    }
    public void setTamaño_boton(int ancho, int  alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public void activar() {
        this.setEnabled(true);
    }

    public void desactivar() {
        this.setEnabled(false);
    }
    public Botones() {
        tamaño_fuente = 15;
        ancho=120;
        alto = 40;
        escucha = new Lanza_app_Prueba.Escucha();
        this.setBackground(null);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.addActionListener(escucha);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        imageIcon = new ImageIcon();
        imageIcon_Pressed = new ImageIcon();
    }

    public Botones(String titulo, int tamaño, int _ancho, int _alto  ) {
        this.setText(titulo);
        tamaño_fuente = tamaño;
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
        getBoton_style_1(titulo);
    }


    public JButton getBoton_style_1(String titulo ) {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton_PRESSED.png")));
        this.setForeground(Color.white);
        this.setText(titulo);
        this.setFont(new Font(null,Font.BOLD,tamaño_fuente));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        this.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        return this;
    }

    public JButton getBoton_style_2(String titulo) {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton_2.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton_PRESSED_2.png")));
        this.setForeground(Color.white);
        this.setText(titulo);
        this.setFont(new Font(null,Font.BOLD,tamaño_fuente));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        this.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        return this;
    }

}

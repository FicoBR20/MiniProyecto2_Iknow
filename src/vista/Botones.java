package vista;

import controlador.Lanza_app_Prueba;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Botones extends  JButton{
//    private JButton boton;
    private Lanza_app_Prueba.Escucha escucha;
    private ImageIcon imageIcon;
    private ImageIcon imageIcon_Pressed;
    private int tamaño_fuente;

    public Botones() {
        tamaño_fuente = 40;
        escucha = new Lanza_app_Prueba.Escucha();
//        boton = new JButton();
        this.setBackground(null);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.addActionListener(escucha);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        imageIcon = new ImageIcon();
        imageIcon_Pressed = new ImageIcon();
    }


    public JButton getBoton_style_1(String nombre) {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton_PRESSED.png")));
        this.setText(nombre);
        this.setForeground(Color.white);
        this.setFont(new Font(null,Font.BOLD,tamaño_fuente));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        this.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        return this;
    }

    public JButton getBoton_style_2(String nombre) {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton_2.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton_PRESSED_2.png")));
        this.setText(nombre);
        this.setForeground(Color.white);
        this.setFont(new Font(null,Font.BOLD,tamaño_fuente));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        this.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        return this;
    }

}

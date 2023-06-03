package vista;

import controlador.Escucha;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Botones {
    private  JButton boton;
    private  Escucha escucha;
    private ImageIcon imageIcon;
    private ImageIcon imageIcon_Pressed;

    public Botones() {
        boton = new JButton();
        boton.setBackground(null);
        escucha = new Escucha();
        imageIcon = new ImageIcon();
        imageIcon_Pressed = new ImageIcon();
    }


    public JButton getBoton_style_1(String nombre) {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/Boton.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/Boton_PRESSED.png")));
        boton.setText(nombre);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setForeground(Color.white);
        boton.setFont(new Font(null,Font.BOLD,40));
        boton.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        boton.setBorder(BorderFactory.createEmptyBorder());
        boton.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        boton.addActionListener(escucha);
        return boton;
    }

    public JButton getBoton_style_2(String nombre) {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/Boton_2.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/Boton_PRESSED_2.png")));
        boton.setText(nombre);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setForeground(Color.white);
        boton.setFont(new Font(null,Font.BOLD,40));
        boton.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        boton.setBorder(BorderFactory.createEmptyBorder());
        boton.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        boton.addActionListener(escucha);
        return boton;
    }

}

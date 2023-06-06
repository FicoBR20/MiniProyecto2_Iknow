package vista;

import controlador.Lanza_app_Prueba;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Botones {
    private JButton boton;
    private Lanza_app_Prueba.Escucha escucha;
    private ImageIcon imageIcon;
    private ImageIcon imageIcon_Pressed;

    public Botones() {
        escucha = new Lanza_app_Prueba.Escucha();
        boton = new JButton();
        boton.setBackground(null);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder());
        boton.addActionListener(escucha);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        imageIcon = new ImageIcon();
        imageIcon_Pressed = new ImageIcon();
    }


    public JButton getBoton_style_1(String nombre) {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/Boton.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/Boton_PRESSED.png")));
        boton.setText(nombre);
        boton.setForeground(Color.white);
        boton.setFont(new Font(null,Font.BOLD,40));
        boton.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        boton.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        return boton;
    }

    public JButton getBoton_style_2(String nombre) {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/Boton_2.png")));
        imageIcon_Pressed = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/Boton_PRESSED_2.png")));
        boton.setText(nombre);
        boton.setForeground(Color.white);
        boton.setFont(new Font(null,Font.BOLD,40));
        boton.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        boton.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(120,62,Image.SCALE_SMOOTH)));
        return boton;
    }

}

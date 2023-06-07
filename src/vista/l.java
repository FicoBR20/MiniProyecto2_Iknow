package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class l extends JFrame {
    private JPanel panelActual;

    public l() {
        // Configura la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Crea e inicializa los paneles
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        // Establece el panel inicial
        panelActual = panel1;
        setContentPane(panelActual);

        // Crea un botón para cambiar los paneles
        JButton botonCambiarPanel = new JButton("Cambiar Panel");
        botonCambiarPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPanel();
            }
        });
        panelActual.add(botonCambiarPanel);
    }

    private void cambiarPanel() {
        // Crea el nuevo panel
        JPanel nuevoPanel = new JPanel();

        // Actualiza el panel actual
        panelActual = nuevoPanel;
        setContentPane(panelActual);

        // Vuelve a dibujar la ventana
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            l ventana = new l();
            ventana.setVisible(true);
        });
    }
}

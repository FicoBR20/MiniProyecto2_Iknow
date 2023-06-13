package vista;

import javax.swing.*;
import java.awt.*;

public class FondoPanel extends JPanel {
    private Image image;
    private String imageIcon;
    private int index;

    public FondoPanel() {
        index = 1;
       imageIcon = "/resources/fondos/fondo_"+index+".png";
    }

    @Override
    public void paint(Graphics g) {
        image = new ImageIcon(getClass().getResource(get_ruta_icono())).getImage();
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        this.setBackground(null);
        super.paint(g);
    }

    public String get_ruta_icono() {
        return imageIcon;
    }

    public void set_ruta_fondo(String imageIcon) {
        this.imageIcon = imageIcon;
    }
    public void set_ruta_fondo(int index) {
        this.imageIcon = "/resources/fondos/fondo_"+index+".png";
    }
}

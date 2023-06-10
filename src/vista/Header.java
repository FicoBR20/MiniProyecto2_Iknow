package vista;

import javax.swing.*;
import java.awt.*;


public class Header extends JLabel {
    /**
     * Constructor of the Header class
     * @param title String that contains Header text
     * @param colorBackground Color object to be assigned for the Header background
     */
    public Header(String title, Color colorBackground){
        this.setText(title);
        this.setBackground(colorBackground);
        this.setForeground(new Color(82, 25, 196));
        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 20);
        this.setFont(font);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }

    public void inicio(){

    }
}

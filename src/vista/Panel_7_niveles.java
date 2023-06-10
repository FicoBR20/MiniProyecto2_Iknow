package vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Panel_7_niveles extends JPanel {

    private ArrayList<Botones> nivel;
    private  final Area_de_Texto area_de_texto;

    public Panel_7_niveles(){

        nivel = new ArrayList<>();
        for (int i=0;i<=9;i++){
            nivel.add(new Botones(""+(i+1),20,50,50));
        }

        area_de_texto = new Area_de_Texto();

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setSize(400,400);
        this.setBackground(new Color(13, 64, 123));
        initGui();

    }

    public void initGui(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.ipady = 10;
        gbc.ipadx = 10;
        gbc.insets.set(0,0,0,0);


        gbc.gridx=0; // columna 0
        gbc.gridy=4; // fila 0
        gbc.gridwidth=6; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.anchor=GridBagConstraints.CENTER;
        this.add(area_de_texto.inicial(), gbc);

        // Botones
        for (int i=0;i<=4;i++){
                gbc.insets.set(0,0,0,0);
                gbc.gridx=i; // columna 0
                gbc.gridy=2; // fila 0
                gbc.gridwidth=1; // ocupara 4 columnas
                gbc.gridheight=1; // ocupara 3 filas
                this.add(nivel.get(i).nivel(""+i), gbc);
        }
        for (int i=0;i<=4;i++){
            gbc.insets.set(0,0,0,0);
            gbc.gridx=i; // columna 0
            gbc.gridy=3; // fila 0
            gbc.gridwidth=1; // ocupara 4 columnas
            gbc.gridheight=1; // ocupara 3 filas
            this.add(nivel.get(i+5).nivel(""+(i+5)), gbc);
        }

    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
            Panel_7_niveles panel7Niveles = new Panel_7_niveles();
            miProjectGUI.setContentPane(panel7Niveles);
        });
    }

}

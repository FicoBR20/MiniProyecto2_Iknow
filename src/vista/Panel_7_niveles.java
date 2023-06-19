package vista;

import controlador.Control_FileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Panel_7_niveles extends FondoPanel {

    private ArrayList<Botones> nivel;
    private Botones atras_boton;
    private JPanel panel_botones;
    private  final Area_de_Texto area_de_texto;

    public Panel_7_niveles(){

        set_ruta_fondo(4);
        nivel = new ArrayList<>();
        for (int i=0;i<=9;i++){
            nivel.add(new Botones(""+(i+1),50,80,80));
        }
        atras_boton = new Botones();
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

        panel_botones = new JPanel();
        panel_botones.setBackground(new Color(0x0000000, true));
        panel_botones.setLayout(new GridBagLayout());

        // Botones
        for (int i=0;i<=4;i++){
                gbc.insets.set(0,0,0,0);
                gbc.gridx=i; // columna 0
                gbc.gridy=0; // fila 0
                gbc.gridwidth=1; // ocupara 4 columnas
                gbc.gridheight=1; // ocupara 3 filas
            panel_botones.add(nivel.get(i).nivel(""+(i+1)), gbc);
        }
        for (int i=0;i<=4;i++){
            gbc.insets.set(0,0,0,0);
            gbc.gridx=i; // columna 0
            gbc.gridy=1; // fila 0
            gbc.gridwidth=1; // ocupara 4 columnas
            gbc.gridheight=1; // ocupara 3 filas
            panel_botones.add(nivel.get(i+5).nivel(""+(i+6)), gbc);
        }

        for (int i=0;i<10;i++){
            nivel.get(i).nivel(""+(i+1)).setEnabled(false);
        }

        int niveles = Integer.parseInt(new Control_FileManager().leer_ultimo_jugador()[1]);
        for (int i=0;i<niveles;i++){
            nivel.get(i).nivel(""+(i+1)).setEnabled(true);
        }

        gbc.insets.set(0,0,0,0);
        gbc.gridx=0; // columna 0
        gbc.gridy=2; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(panel_botones, gbc);

        gbc.gridx=0; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.anchor=GridBagConstraints.CENTER;
        this.add(area_de_texto.inicial(), gbc);

        gbc.gridx=0; // columna 0
        gbc.gridy=4; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        this.add(atras_boton.getBoton_style_0("ATRAS"), gbc);

    }

}

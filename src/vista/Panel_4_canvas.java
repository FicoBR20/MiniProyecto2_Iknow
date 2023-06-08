package vista;

import controlador.Lanza_app_Prueba;
import modelo.File_estado;
import modelo.Juego;
import modelo.Palabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_4_canvas extends JPanel {

    private Palabra palabra;
    private String infoPanel;
    private Font font;
    private Botones atras_boton;
    private Area_de_Texto area_de_texto;
    private Timer timer;
    private Escucha escucha;
    private  int counter;
    private static Panel_4_canvas panel_4_canvas = null;
    private String memoriza;

    public Panel_4_canvas(){
        ini();
    }

    private void ini(){
        counter = 0;
        memoriza = "";
        infoPanel = " Fijate muy bien en las palabras presentadas\ndeberas recordarlas dentro de poco..suerte\n";
        font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 27);

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setBackground( new Color(47, 161, 30));

        Juego juego1 = new Juego();
        palabra = new Palabra();
        juego1.setUp_Nivel(1);
        juego1.setCategoria(2);
        palabra.setJuego(juego1);
        palabra.setPalabra_del_nivel();
        palabra.setPalabra_a_Memorizar();

        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets.set(0,0,20,5);
        area_de_texto =  new Area_de_Texto();
        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(100,0,0,0);
        this.add(area_de_texto.seText(""), gbc);

        atras_boton = new Botones();
        gbc.gridx=1; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
//        gbc.insets.set(150,0,0,0);
        this.add(atras_boton.getBoton_style_1("ATRAS"), gbc);

        escucha = new Escucha();
        timer = new Timer(1000, escucha );
        timer.start();
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
            panel_4_canvas = new Panel_4_canvas();
            miProjectGUI.setContentPane(panel_4_canvas);
        });
    }

//    protected void paintComponent(Graphics g){
//        this.area_de_texto.seText("hshsh");
//        super.paintComponent(g);
//        String receptor = "";
//      //  receptor = palabra.getPalabra_a_Memorizar();
//        g.setFont(font);
//        g.drawString("La palabra a memorizar es" + receptor,20,20);
//
//    }

    /**
     * inner class implements Listeners used by Panel_1_Inicial class
     */
    public class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time "+counter+" El timer está corriendo? " + String.valueOf(timer.isRunning()));
            if(e.getSource()==timer){
                if(counter <= palabra.getPalabra_a_Memorizar().size()-2) {

                    area_de_texto.seText(palabra.getPalabra_a_Memorizar().get(counter));
                    revalidate();
                    repaint();
//                    squareColor.setBackground(new Color(random.nextInt(256),
//                            random.nextInt(256),
//                            random.nextInt(256)));
                    counter++;
                }else{
                    timer.stop();
//                    initTimer.setEnabled(true);
//                    initTimer.addActionListener(escucha);
                }
            }else {
                counter = 0;
                timer.start();
//                initTimer.setEnabled(false);
//                initTimer.removeActionListener(escucha);
            }


        }

    }

}

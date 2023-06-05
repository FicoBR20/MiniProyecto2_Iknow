package vista;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase gestiona los recursos gráficos del juego.
 * @version v.1.0.0 date:1/06/2023
 */
public class Frame_Level_1 extends JFrame {

    private int segundero;

    private String palabraas_Presentadas;

    private Canvas canvas;

    private Header headerProject;
    /**
     * JPanels contenedores.
     */
    private JPanel jPanel_Principal;
    /**
     * JButtons que recibiran la decision del usuario en cada frame.
     */
    private JButton jBut_1_Comienzo;


    private JLabel jLabel_Central, jLabel_1_auxiliar, jLabel_2_auxiliar;


    private JTextField jTextField_Timer;

    private Color  colorBack = new Color(82,25,196);
    private Color colorFront = new Color(188, 234, 192);

    /**
     * Constructor of GUI class
     */
    public Frame_Level_1(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Nivel 1");
        this.setSize(600,400);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(colorBack);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    public void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents

        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);


        palabraas_Presentadas = "";
        segundero = 0;
        canvas = new Canvas();

        headerProject = new Header("Nivel 1 -> Presentación de palabras a memorizar", colorFront);
        headerProject.setFont(font);



        jLabel_Central = new JLabel();

        jPanel_Principal = new JPanel();
        jPanel_Principal.setPreferredSize(new Dimension(600, 400));
        jPanel_Principal.setBackground(colorBack);

        jBut_1_Comienzo = new JButton(" Inicio de presentación");

        jLabel_Central = new JLabel(" Dispones de 5 segundos para memorizar cada palabra");
        jLabel_Central.setFont(font);

        jLabel_1_auxiliar = new JLabel("Palabras a memorizar");
        jLabel_1_auxiliar.setFont(font);

        jTextField_Timer = new JTextField(" TIMER ");
        jTextField_Timer.setPreferredSize(new Dimension(100, 20));
        this.add(headerProject, BorderLayout.NORTH);

        GridBagLayout gridBagLayout = new GridBagLayout();

        jPanel_Principal.setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=3; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        jPanel_Principal.add(jLabel_Central, gbc);

        gbc.gridx=2; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=4; // ocupara 4 columnas
        gbc.gridheight=2; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        jPanel_Principal.add(jTextField_Timer, gbc);



        this.add(jPanel_Principal);




    }







    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Frame_Level_1 miProjectGUI = new Frame_Level_1();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
}

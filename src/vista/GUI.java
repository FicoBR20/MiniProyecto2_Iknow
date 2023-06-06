package vista;

import controlador.Lanza_app_Prueba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Esta clase gestiona los recursos gráficos del juego.
 * @version v.1.0.0 date:1/06/2023
 */
public class GUI extends JFrame {

    private Front_Inicial frontInicial;
    private Header headerProject;
    /**
     * JPanels contenedores.
     */
    private JPanel jPanel_Principal, jPanel_Lateral1, getjPanel_Lateral2;
    /**
     * JButtons que recibiran la decision del usuario en cada frame.
     */
    private JButton jBut_1_auxiliar, jBut_2_auxiliar, jBut_3_auxiliar, jBut_4_auxiliar ;
    private JLabel jLabel_Central, jLabel_1_auxiliar, jLabel_2_auxiliar;
    private JTextArea jTextArea_Principal, jTextArea_auxiliar;
    private JTextPane jTextPane_Principal, jTextPane_auxiliar;
    private JTextField jTextField_Principal, jTextField_1_auxiliar, jTextField_2_auxiliar;
    private int estado_panel;


    private Color  colorBack = new Color(82,25,196);
    private Color colorFront = new Color(188, 234, 192);

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();
        estado_panel = 0;

        //Default JFrame configuration
        this.setTitle("I Know that word !!");
        this.setSize(600,400);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    public void initGUI() {
        System.out.println(" ..empieza tu juego..");
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents

        jLabel_Central = new JLabel();


        headerProject = new Header(" Ejercita tu memoria ", colorFront);
        frontInicial = new Front_Inicial();
        frontInicial.setBackground(colorBack);

        jPanel_Principal = new JPanel();

        jBut_1_auxiliar = new JButton(" Si la recuerdo ");
        jBut_2_auxiliar = new JButton("NO la recueddo");

//        jPanel_Principal.add(jBut_1_auxiliar, BorderLayout.SOUTH);
//        jPanel_Principal.add(jBut_2_auxiliar, BorderLayout.SOUTH);

      //  this.add(frontInicial, BorderLayout.CENTER);

       // this.add(canvas, BorderLayout.CENTER);

        this.add(jPanel_Principal, BorderLayout.SOUTH);

        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

    }

    public void frame_001_Inicio() {

        jLabel_Central = new JLabel();


        headerProject = new Header(" Bienvenido ", colorFront);
        frontInicial = new Front_Inicial();
        frontInicial.setBackground(colorBack);


        jPanel_Principal = new JPanel();


        this.add(frontInicial, BorderLayout.CENTER);


        this.add(jPanel_Principal, BorderLayout.SOUTH);

        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

    }

    public void set_panel(int n) {
        estado_panel = n;
    }
    public int get_panel() {
        return estado_panel;
    }

}

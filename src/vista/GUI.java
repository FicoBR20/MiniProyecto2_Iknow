package vista;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Canvas canvas;

    private Header headerProject;
    /**
     * JPanel que mostrará las palabras
     */
    private JPanel muestraPalabras;
    /**
     * JButtons que recibiran la decision del usuario
     * si_es -> la palabra presentada a consideracion SI le fue mostrada y la recuerda
     * no_es -> la palabra presentada a condideracion NO le fue mostrada y esta seguro de ello.
     */
    private JButton si_es, no_es;



    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

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
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        headerProject = new Header(" Prueba tu memoria episódica verbal reciente ", Color.BLUE);


        canvas = new Canvas();

       // BorderLayout borderLayout = new BorderLayout();

        muestraPalabras = new JPanel();
       // muestraPalabras.setPreferredSize(new Dimension(500, 300));
        si_es = new JButton(" Si la recuerdo ");
        no_es = new JButton("NO la recueddo");

        muestraPalabras.add(si_es, BorderLayout.SOUTH);
        muestraPalabras.add(no_es, BorderLayout.SOUTH);

        this.add(canvas, BorderLayout.CENTER);

        this.add(muestraPalabras, BorderLayout.SOUTH);

        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
}

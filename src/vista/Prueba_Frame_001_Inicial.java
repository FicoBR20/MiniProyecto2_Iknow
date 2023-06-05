package vista;

import modelo.Juego;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase gestiona los recursos gráficos del juego.
 * @version v.1.0.0 date:1/06/2023
 */
public class Prueba_Frame_001_Inicial extends JFrame {

    private JButton jButton;

    private Front_Inicial frontInicial;
    private Front_Reglas frontReglas;

    private Front_RegistroJugador frontRegistroJugador;

    private Front_Final frontFinal;

    private Header headerProject;

    private Color  colorBack = new Color(82,25,196);
    private Color colorFront = new Color(188, 234, 192);

    /**
     * Constructor of GUI class
     */
    public Prueba_Frame_001_Inicial(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("The game");
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
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);

        jButton = new JButton(" el inicio ");
        jButton.setPreferredSize(new Dimension(200, 50));
        jButton.setBackground(Color.BLACK);
        jButton.setOpaque(true);
        jButton.setFont(font);

        frontFinal =  new Front_Final();

        frontRegistroJugador = new Front_RegistroJugador();

        frontReglas = new Front_Reglas();

        frontInicial = new Front_Inicial();



        int selector = 9999;
        selector=new Juego().getEstado();

        System.out.println(" valor de selector al inicio " + selector + "\n");

        this.add(jButton, BorderLayout.SOUTH);

       // selector_Frames(1);

//       switch (new Juego().getEstado()){
//           case 1:
//            headerProject = new Header("Bienvenidos todos", colorFront);
//            headerProject.setFont(font);
//            this.add(headerProject, BorderLayout.NORTH);
//            this.add(frontInicial);
//        System.out.println(" valor de selector al caso 1 " + selector + "\n");
//            break;
//           case 2:
//            headerProject = new Header("Reglas del Juego", colorFront);
//            headerProject.setFont(font);
//            this.add(headerProject, BorderLayout.NORTH);
//            this.add(frontReglas);
//        System.out.println(" valor de selector al caso 2" + selector + "\n");
//            break;
//           case 3:
//            headerProject = new Header("Registro de Concursante", colorFront);
//            headerProject.setFont(font);
//            this.add(headerProject, BorderLayout.NORTH);
//            this.add(frontRegistroJugador);
//        System.out.println(" valor de selector al caso 3" + selector + "\n");
//            break;
//           case 99:
//            headerProject = new Header("Mensaje de cierrep", colorFront);
//            headerProject.setFont(font);
//            this.add(headerProject, BorderLayout.NORTH);
//            this.add(frontFinal);
//        System.out.println(" valor de selector al caso 4" + selector + "\n");
//            break;
//           default:
//               System.out.println(" se terminaron las opciones..vefifique su estado");
//
//
//       }





    }

    public void selector_Frames(int selector){
        Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);

        switch (selector){
            case 1:
                headerProject = new Header("Bienvenidos todos", colorFront);
                headerProject.setFont(font);
                this.add(headerProject, BorderLayout.NORTH);
                this.add(frontInicial);
                System.out.println(" valor de selector al caso 1 " + selector + "\n");
                break;
            case 2:
                headerProject = new Header("Reglas del Juego", colorFront);
                headerProject.setFont(font);
                this.add(headerProject, BorderLayout.NORTH);
                this.add(frontReglas);
                System.out.println(" valor de selector al caso 2" + selector + "\n");
                break;
            case 3:
                headerProject = new Header("Registro de Concursante", colorFront);
                headerProject.setFont(font);
                this.add(headerProject, BorderLayout.NORTH);
                this.add(frontRegistroJugador);
                System.out.println(" valor de selector al caso 3" + selector + "\n");
                break;
            case 99:
                headerProject = new Header("Mensaje de cierrep", colorFront);
                headerProject.setFont(font);
                this.add(headerProject, BorderLayout.NORTH);
                this.add(frontFinal);
                System.out.println(" valor de selector al caso 4" + selector + "\n");
                break;
            default:
                System.out.println(" se terminaron las opciones..vefifique su estado");


        }

    }







    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Prueba_Frame_001_Inicial miProjectGUI = new Prueba_Frame_001_Inicial();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
}

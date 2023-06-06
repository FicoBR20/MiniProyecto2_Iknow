package vista;

import modelo.Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase gestiona los recursos gráficos del juego.
 * @version v.1.0.0 date:1/06/2023
 */
public class Prueba_Frame_001_Inicial extends JFrame {

    private Escucha escucha;

    private JButton jButton;

    private JPanel padrino;

    private Front_Inicial frontInicial;
    private Front_Reglas frontReglas;

    private Front_RegistroJugador frontRegistroJugador;

    private Front_Final frontFinal;

    private Header headerProject;

    private Color  colorBack = new Color(82,25,196);
    private Color colorFront = new Color(188, 234, 192);
    Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);

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
        padrino = new JPanel();
        escucha = new Escucha();

        jButton = new JButton(" el inicio ");
        jButton.setPreferredSize(new Dimension(60, 31));
        jButton.setBackground(Color.BLACK);
        jButton.setOpaque(true);
        jButton.setFont(font);
//        jButton.setLocation(50, 350);
        jButton.addActionListener(escucha);

        frontFinal =  new Front_Final();

        frontRegistroJugador = new Front_RegistroJugador();

        frontReglas = new Front_Reglas();

        frontInicial = new Front_Inicial();

        // CONFIGURACION DEL LAYOUT PARA EL JPANEL PADRINO

        GridBagLayout gridBagLayout = new GridBagLayout();

        padrino.setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.weightx = 1.0; // no se deformara
        gbc.weighty = 1.0; // no se deformara
        gbc.insets.set(20,20,20,20);//espacio externo para el componente.101010
        padrino.add(jButton, gbc);

        GridBagConstraints gbc_1 = new GridBagConstraints();

        padrino.add(frontInicial);

        this.add(padrino, BorderLayout.NORTH);


        //+++++++++++++++++++++++++++++++++++++++++++++++++






        int selector = 9999;
        selector=new Juego().getEstado();

        System.out.println(" valor de selector al inicio " + selector + "\n");





        this.add(padrino);








    }

    public void changeLabel (){
        padrino.remove(frontInicial);
      padrino.add(frontReglas, BorderLayout.CENTER);
      padrino.revalidate();
      padrino.repaint();
    pack();

}

    public void renove_Panel (JPanel old, JPanel young){
        padrino.remove(old);
        padrino.add(young, BorderLayout.CENTER);
        padrino.revalidate();
        padrino.repaint();
        pack();

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
    private class Escucha implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==jButton){

                padrino.remove(frontInicial);
                padrino.add(frontReglas);
                padrino.revalidate();
                padrino.repaint();

                System.out.println(" se incia esto ");
            }
            else {
                System.out.println(" apuntele al botom para inicial..");
            }

        }
    }

    public void lanza_frames(int estado){


        switch (estado){
            case 1:
                frontInicial.init_Panel();
                break;
            case 2:
                renove_Panel(frontFinal,frontReglas);
                padrino.revalidate();
                padrino.repaint();

                break;
            case 3:
                renove_Panel(frontReglas,frontRegistroJugador);
                padrino.revalidate();
                padrino.repaint();
                break;
            case 4:
                System.out.println(" se debe elaborar el panel del juego en el nivel 1");
                padrino.revalidate();
                padrino.repaint();
                break;
            case 99://final de la app.
                renove_Panel(frontRegistroJugador,frontFinal);
                padrino.revalidate();
                padrino.repaint();
                System.out.println(" este finalizo la app");
                break;
            default:
                System.out.println(" no hay mas ventanas");
                break;
        }
    }

}

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

    private JButton jButton_SI;
    private JButton jButton_NO;


    private JPanel padrino;
    private JPanel jPanel_Botones_front_Inicial;

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
        jPanel_Botones_front_Inicial =  new JPanel();
        jPanel_Botones_front_Inicial.setBackground(colorBack);
        padrino = new JPanel();
        escucha = new Escucha();



        jButton_SI = new JButton();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/Boton_SI.png"));
        ImageIcon imageIcon_Pressed = new ImageIcon(getClass().getResource("/resources/Boton_SI_PRESSED.png"));
        jButton_SI.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        jButton_SI.setBorder(BorderFactory.createEmptyBorder());
        jButton_SI.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        jButton_SI.setOpaque(true);
        jButton_SI.setFont(font);
        jButton_SI.addActionListener(escucha);


        jButton_NO = new JButton();
        imageIcon = new ImageIcon(getClass().getResource("/resources/Boton_NO.png"));
        imageIcon_Pressed = new ImageIcon(getClass().getResource("/resources/Boton_NO_PRESSED.png"));
        jButton_NO.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        jButton_NO.setBorder(BorderFactory.createEmptyBorder());
        jButton_NO.setPressedIcon(new ImageIcon(imageIcon_Pressed.getImage().getScaledInstance(60,31,Image.SCALE_SMOOTH)));
        jButton_NO.setOpaque(true);
        jButton_NO.setFont(font);
        jButton_NO.addActionListener(escucha);



        frontFinal =  new Front_Final();

        frontRegistroJugador = new Front_RegistroJugador();

        frontReglas = new Front_Reglas();

        frontInicial = new Front_Inicial();

        jPanel_Botones_front_Inicial.add(jButton_SI);
        jPanel_Botones_front_Inicial.add(jButton_NO);


        adiciono_JPanel_Botones(new Juego().getEstado());


        lanza_frames(new Juego().getEstado());

        this.add(padrino, BorderLayout.NORTH);



    }

    public void renove_Panel (JPanel old, JPanel young){
        padrino.remove(old);
        padrino.add(young, BorderLayout.CENTER);
        padrino.revalidate();
        padrino.repaint();

    }

    /**
     * Método que toma el JPanel de los botones y lo
     * adiciona a otro JPanel.
     */
    private void adiciono_JPanel_Botones(int estado){{


        switch (estado){
            case 1:
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx=2; // columna 0
                gbc.gridy=3; // fila 0
                gbc.gridwidth=5; // ocupara 4 columnas
                gbc.gridheight=1; // ocupara 3 filas
                gbc.weightx = 1.0; // no se deformara
                gbc.weighty = 1.0; // no se deformara
                gbc.insets.set(2,2,60,2);//espacio externo para el componente.101010
                frontInicial.add(jPanel_Botones_front_Inicial, gbc);
                break;
            case 2:
                System.out.println(" .. pendiente ubicar botones en panal reglas");

                break;
            case 3:
                System.out.println(" .. pendiente ubicar botones en panal registro");
                break;
            case 4:
                System.out.println(" .. pendiente todo el frame del nivel 1");
                break;
            case 99://final de la app.
                System.out.println(" este finalizo la app");
                break;
            default:
                System.out.println(" no hay mas ventanas");
                break;
        }
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
    private class Escucha implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()== jButton_SI){

                renove_Panel(frontInicial, frontReglas);


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
                padrino.add(frontInicial);
                break;
            case 2:
                padrino.add(frontReglas);

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

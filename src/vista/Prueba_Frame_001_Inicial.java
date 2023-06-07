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


    /**
     * Atributo de instancia modelo.Juego
     */
    private Juego juego_Ikn;

    /**
     * Atributo Action listener
     */
    private Escucha escucha;

    /**
     * JGutton
     */
    private JButton jButton_SI;
    /**
     * JGutton
     */
    private JButton jButton_NO;

    /**
     * Atributo JPanel que soporta JPanel de las
     * clases externas
     */
    private JPanel padrino;

    /**
     * Atributo JPanel soporta JButtons
      */
    private JPanel jPanel_Botones_front_Inicial;

    /**
     * Atributo JPanel que muestra el inicio de la aplicación
     */
    private Front_Inicial frontInicial;
    /**
     * Atributo JPanel que muestra las reglas del Juego
     */
    private Front_Reglas frontReglas;

    /**
     * Atributo JPanel que presenta el formulario de
     * registro para el jugador.
     */
    private Front_RegistroJugador frontRegistroJugador;

    /**
     * Atributo JPanel que muestra el inicio del juego en el nivel 1
      */
    private Front_Nivel_1 frontNivel1;

    /**
     * Atributo JPanel que muestra el final de la app.
     */
    private Front_Final frontFinal;


    /**
     * Atributos de Colores de la app
     */
    private Color  colorBack = new Color(82,25,196);
    private Color colorFront = new Color(188, 234, 192);
    Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 24);


    /**
     * Constructor of class
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
     * Método que inicializa los atributos de la clase.
     */
    public void initGUI() {

        juego_Ikn = new Juego();


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


        frontNivel1 = new Front_Nivel_1();



        frontFinal =  new Front_Final();

        frontRegistroJugador = new Front_RegistroJugador();

        frontReglas = new Front_Reglas();

        frontInicial = new Front_Inicial();


        lanza_frames(juego_Ikn.getEstado());

        this.add(padrino, BorderLayout.NORTH);



    }

    /**
     * Método para actualizar los paneles soportados
     * por el JPanel padrino.
      * @param old
     * @param young
     */
    public void renove_Panel (JPanel old, JPanel young){
        padrino.remove(old);
        padrino.add(young, BorderLayout.CENTER);
        padrino.revalidate();
        padrino.repaint();
        System.out.println(" Estoy en remove panel.." + Integer.toString(juego_Ikn.getEstado()));

    }


    /**
     * Método que adiciona el Jpanel de los Jbutton a cada
     * Jpanel de un front.
     * @param estado_en_Tramite
     */
    private void adiciono_JPanel_Botones(int estado_en_Tramite){{


        switch (estado_en_Tramite){
            case 1:
                jPanel_Botones_front_Inicial.add(jButton_SI);
                jPanel_Botones_front_Inicial.add(jButton_NO);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx=2;
                gbc.gridy=3;
                gbc.gridwidth=5;
                gbc.gridheight=1;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                gbc.insets.set(2,2,60,2);
                frontInicial.add(jPanel_Botones_front_Inicial, gbc);
                break;
            case 2:
                jPanel_Botones_front_Inicial.add(jButton_SI);
                jPanel_Botones_front_Inicial.add(jButton_NO);
                GridBagConstraints gbc1 = new GridBagConstraints();
                gbc1.gridx=2;
                gbc1.gridy=3;
                gbc1.gridwidth=5;
                gbc1.gridheight=1;
                gbc1.weightx = 1.0;
                gbc1.weighty = 1.0;
                gbc1.insets.set(2,2,60,2);
                frontReglas.add(jPanel_Botones_front_Inicial, gbc1);
                System.out.println(" .. pendiente ubicar botones en panal reglas");

                break;
            case 3:
                System.out.println(" .. pendiente ubicar botones en panal registro");
                break;
            case 4:
                System.out.println(" .. pendiente todo el frame del nivel 1");
                break;
            case 99:
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
            if (e.getSource()==jButton_SI && juego_Ikn.getEstado()==1){
                renove_Panel(frontInicial, frontReglas);
                juego_Ikn.setEstado(2);
                lanza_frames(juego_Ikn.getEstado());
                System.out.println(" en la accion inicial ..se inicio esto.vamos a las reglas." + Integer.toString(juego_Ikn.getEstado()));
            } else if (e.getSource()==jButton_SI && juego_Ikn.getEstado()==2) {
                renove_Panel(frontReglas, frontRegistroJugador);
                juego_Ikn.setEstado(3);
                lanza_frames(juego_Ikn.getEstado());
                System.out.println(" en la accion inicial ..se inicio esto. vamos al registro del jugador." + Integer.toString(juego_Ikn.getEstado()));
            } else if (e.getSource()==jButton_SI && juego_Ikn.getEstado()==3) {
                renove_Panel(frontRegistroJugador, frontFinal);
                juego_Ikn.setEstado(99);
                lanza_frames(juego_Ikn.getEstado());
                System.out.println(" en la accion inicial ..se inicio esto. vamos por ahora al fina...." + Integer.toString(juego_Ikn.getEstado()));
            }else if (e.getSource()==jButton_NO) {
                renove_Panel(frontInicial, frontFinal);
                juego_Ikn.setEstado(99);
                lanza_frames(juego_Ikn.getEstado());
                System.out.println(" es el fin ...volveremos..." + Integer.toString(juego_Ikn.getEstado()));
            }

            else {
                System.out.println(" apuntele al botom SI para INCIAR..");
            }


        }
    }

    /**
     * Método que segun el estado del juego presenta un
     * determinado Jpanel
      * @param estado_real
     */
    public void lanza_frames(int estado_real){


        switch (estado_real){
            case 1:
                adiciono_JPanel_Botones(estado_real);
                padrino.add(frontInicial);
                break;
            case 2:
                adiciono_JPanel_Botones(estado_real);
                padrino.add(frontReglas);
                break;
            case 8:
                System.out.println(" se debe presenta el juego en el nivel 1");
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

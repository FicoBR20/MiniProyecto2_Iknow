package vista;

import controlador.Jugador;
import modelo.Juego;
import modelo.Palabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_4_juego extends JPanel {

    private Jugador jugador;

    private String infoPanel;
    private Font font;
    private Botones atras_boton,si_boton,no_boton, siguiente;
    private Area_de_Texto area_de_texto, mensaje;
    private Timer timer;
    private Timer timer_acierto;
    private  Timer timer_acierto_2;
    private Escucha escucha;
    private  int cuenta_memorizar, cuenta_nivel;
    private static Panel_4_juego panel_4_canvas = null;
    private String memoriza;
    private GridBagConstraints gbc;
    private JPanel panel_botones;
    private Palabra palabra;
    private Juego juego;
    private int primer_inicio;
    private int cuenta_nivel_tiempo;


    /**
     * Presenta en el nivel actual
     */
    public Panel_4_juego(){
        juego = new Juego();
        ini();
    }

    public Panel_4_juego(Juego juego){
        this.juego = juego;
        ini();
    }

    private void ini(){
        siguiente = new Botones();
        jugador = new Jugador();


        timer_acierto_2 = new Timer(2000,escucha);
        escucha = new Escucha();
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridBagLayout());
        panel_botones.setBackground(null);
        mensaje = new Area_de_Texto();
        cuenta_memorizar = 0;
        cuenta_nivel = 0;
        primer_inicio = 0;
        cuenta_nivel_tiempo = 0;
        memoriza = "";
        infoPanel = " Fijate muy bien en las palabras presentadas\ndeberas recordarlas dentro de poco..suerte\n";
        font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 27);

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setBackground( new Color(47, 161, 30));
        gbc = new GridBagConstraints();
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.ipady=15;
        gbc.ipadx=15;

        palabra = new Palabra();
        palabra.setJuego(juego);
        palabra.setPalabra_del_nivel();
        palabra.setPalabra_a_Memorizar();

        area_de_texto =  new Area_de_Texto();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        this.add(area_de_texto.seText(""), gbc);

        mensaje =  new Area_de_Texto();
        gbc.gridx=0; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        this.add(mensaje.seText_2(""), gbc);

        si_boton = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        si_boton.addActionListener(escucha);
        panel_botones.add(si_boton.getBoton_style_1("SI"), gbc);

        no_boton = new Botones();
        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        no_boton.addActionListener(escucha);
        panel_botones.add(no_boton.getBoton_style_1("NO"), gbc);

        gbc.gridx=0; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        panel_botones.setVisible(false);
        this.add(panel_botones, gbc);

        atras_boton = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=4; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        atras_boton.addActionListener(escucha);
        atras_boton.setVisible(false);
        this.add(atras_boton.getBoton_style_1("ATRAS"), gbc);

        //Aqui se setea el temporizador para lanzar en juego
        timer = new Timer(2,escucha);
    }

    /**
     * Este métoso inicia el temporizador que muestra las palabras a memorizar
     * @nota se invoca desde la clase controladora para garantizar que
     * se inicie en el momento indicado
     */
    public void start(){
        timer.start();
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
       this.juego = juego;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        String receptor = "";
      //  receptor = palabra.getPalabra_a_Memorizar();
        g.setFont(font);
        g.drawString("Puntos "+jugador.getPuntaje_Total()+"  La palabra a memorizar es" + receptor,20,20);
    }

    /**
     * inner class implements Listeners used by Panel_1_Inicial class
     */
    public class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==timer && primer_inicio == 0){
                area_de_texto.seText("BIENVENIDO");
                mensaje.seText("I know that word");
                timer = new Timer(4000, escucha);
                timer.start();
                primer_inicio++;
            }

            else if(e.getSource()==timer && primer_inicio == 1){
                area_de_texto.seText("Ready");
                mensaje.seText("");
                timer = new Timer(2000, escucha);
                timer.start();
                primer_inicio++;
            }

            else if(e.getSource()==timer && primer_inicio == 2){
                area_de_texto.seText("¡GO!");
                timer = new Timer(2000, escucha);
                timer.start();
                primer_inicio++;
            }

            else if(e.getSource()==timer && primer_inicio == 3){
                area_de_texto.seText("");
                timer = new Timer(2000, escucha);
                timer.start();
                primer_inicio++;
            }

            /**
             * Condicion que valida las palabras a memorizar y las muestra
             */
            else if(e.getSource()==timer && cuenta_memorizar <= palabra.getPalabra_a_Memorizar().size()-1){
                System.out.println("timer 1");
                if(cuenta_memorizar <= palabra.getPalabra_a_Memorizar().size()-1) {
                System.out.println("Palabra " +palabra.getPalabra_a_Memorizar().get(cuenta_memorizar)
                    +" Time "+ cuenta_memorizar +" El timer está corriendo? " + String.valueOf(timer.isRunning()));
                    area_de_texto.seText(palabra.getPalabra_a_Memorizar().get(cuenta_memorizar));
                    cuenta_memorizar++;
                }else {
                    timer.stop();
                    mensaje.seText_2("¿Es una palabra memorizada?");
                    area_de_texto.seText(palabra.getPalabra_del_nivel().get(0));// estamos para retomar la presentacion de las palbras.
                    panel_botones.setVisible(true); // si no visibles.... atras ya venia.

//                    Inicia el temporizador para escoger la palabra memorizada
                    timer_acierto_2 = new Timer(2000,escucha);
                    timer_acierto_2.start();
                }

                //Aqui se setea el tiempo que dura cada palabra a memorizar
                timer = new Timer(1000, escucha);
                timer.start();
            }

            else if(e.getSource()==timer && cuenta_nivel <= palabra.getPalabra_del_nivel().size()-1){
                timer.stop();
                System.out.println("timer 2");
//                timer.stop();
                mensaje.seText_2("¿Es una palabra memorizada?");
                area_de_texto.seText(palabra.getPalabra_del_nivel().get(cuenta_nivel));
                panel_botones.setVisible(true);
                timer_acierto_2 = new Timer(2000, escucha);
                timer_acierto_2.start();
            }

            //cambia el estado del juego se empieza la secuencia para que el jugador empieze a decidiir
            // sobre las palabras presentadas decide si o no.
//
            if(e.getSource()==timer_acierto_2){
                System.out.println("timer 3");
                timer_acierto_2.stop();

                System.out.println("timer3");
                mensaje.seText_2("limite de tiempo");
                area_de_texto.seText("");
                cuenta_nivel++;
                timer = new Timer(2000,escucha);
                timer.start();

            }




            if (e.getSource()==si_boton && cuenta_nivel <= palabra.getPalabra_del_nivel().size()-1){///// recorderis
                timer_acierto_2.stop();
                area_de_texto.seText("");
                panel_botones.setVisible(true);

                if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(cuenta_nivel))){
                    mensaje.seText_2("CORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(cuenta_nivel)
                            +"\nsi es una palabra memorizada"
                    );
                    //acumular 10  puntos al jugador
                   juego.setPuntaje_Logrado(); //estado indica que acerto.
                    jugador.setPuntaje_Total(juego);
                    System.out.println(" el puntaje ahora es" + juego.getPuntaje_Logrado() + " el jugador lleva estos puntos " +
                            jugador.getPuntaje_Total());

                }else {
                    mensaje.seText_2("INCORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(cuenta_nivel)
                            +"\nno es una palabra memorizada"

                    );
                }
                cuenta_nivel++;
                timer = new Timer(4000,escucha);
                timer.start();
            }

            else if (e.getSource()==no_boton && cuenta_nivel <= palabra.getPalabra_del_nivel().size()-1){ // recorderis
                timer_acierto_2.stop();
                area_de_texto.seText("");
                panel_botones.setVisible(true);

                if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(cuenta_nivel))){
                    mensaje.seText_2("INCORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(cuenta_nivel)
                            +"\nsi es una palabra memorizada"
                    );

                }else {
                    mensaje.seText_2("CORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(cuenta_nivel)
                            +"\nno es una palabra memorizada"
                    );
                    //acumular 10  puntos al jugador
                    juego.setPuntaje_Logrado(); //estado indica que acerto.
                    jugador.setPuntaje_Total(juego);
                    System.out.println(" el puntaje ahora es" + juego.getPuntaje_Logrado() + " el jugador lleva estos puntos " +
                            jugador.getPuntaje_Total());
                }
                cuenta_nivel++;
                timer = new Timer(4000,escucha);
                timer.start();
            }

            else if(cuenta_nivel > palabra.getPalabra_del_nivel().size()-1){
                timer_acierto_2.stop();
                timer.stop();
                if (juego.nivel_Superado()) {

                    panel_botones.setVisible(false);
                    mensaje.seText_2("");
                    area_de_texto.seText(" PASAS AL SIGUIENTE NIVEL ");
                    atras_boton.setVisible(false);

                    gbc.gridx = 0; // columna 0
                    gbc.gridy = 5; // fila 0
                    gbc.gridwidth = 1; // ocupara 4 columnas
                    gbc.gridheight = 1; // ocupara 3 filas
                    atras_boton.addActionListener(escucha);
                    add(siguiente.getBoton_style_1("SIGUIENTE"), gbc);
                }
                else {

                    panel_botones.setVisible(false);
                    mensaje.seText_2("");
                    area_de_texto.seText(" GAME OVER ");
                    atras_boton.setVisible(false);

                    gbc.gridx = 0; // columna 0
                    gbc.gridy = 5; // fila 0
                    gbc.gridwidth = 1; // ocupara 4 columnas
                    gbc.gridheight = 1; // ocupara 3 filas
                    atras_boton.addActionListener(escucha);
                    add(siguiente.getBoton_style_1("REPETIR"), gbc);
                    juego.reset_puntos();

                }

            }
        }
    }
}

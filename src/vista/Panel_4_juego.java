package vista;

import controlador.Jugador;
import modelo.Juego;
import modelo.Palabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Panel_4_juego extends FondoPanel {

/**
 * Clase que presenta el Panel del juego, tanto las palabras memorizar
 * como todas las palabras del nivel para que el jugador realize su
 * elecctión.
 * @ genera el total de puntos logrados por el Jugador sumados todos los niveles.
 */

    private String infoPanel;
    private Font font;
    private Botones atras_boton,si_boton,no_boton, siguiente;
    private Letra_grafic botonX;
    private Area_de_Texto mensaje_puntos;
    private Area_de_Texto mensaje;
    private Timer timer;
    private Timer timer_acierto;
    private Timer timer_acierto_2;
    private Escucha escucha;
    private  int cuenta_memorizar, cuenta_nivel;
    private String memoriza;
    private GridBagConstraints gbc;
    private JPanel panel_botones;
    private  JPanel panel_palabra;
    private Palabra palabra;
    private Juego juego;
    private Jugador jugador;
    private int primer_inicio;
    private int cuenta_nivel_tiempo;
    private  FondoPanel box;


    /**
     * Constructor sin parametros
     */
    public Panel_4_juego() {
        juego = new Juego();
        jugador = new Jugador();
        ini();
    }

    /**
     * Constructor que resive un objeto de la clase Juego
     * @param juego
     */
    public Panel_4_juego(Juego juego){
        this.juego = juego;
        ini();
    }

    /**
     * Constructor que resive un objeto de la clase Juegador
     * @param jugador
     */

    public Panel_4_juego(Jugador jugador){
        this.jugador = jugador;
        ini();
    }

    public Panel_4_juego(Juego juego, Jugador jugador){
        this.jugador = jugador;
        this.juego = juego;
        ini();
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    /**
     * Este metodo inicializa las variables de la clase
     */

    private void ini(){

        set_ruta_fondo(2);
        siguiente = new Botones();
        timer_acierto_2 = new Timer(2000,escucha);
        escucha = new Escucha();
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridBagLayout());
        panel_botones.setBackground(new Color(0x0000000, true));
        panel_palabra = new JPanel();
        panel_palabra.setLayout(new GridBagLayout());
        panel_palabra.setBackground(null);
        mensaje = new Area_de_Texto();
        cuenta_memorizar = 0;
        cuenta_nivel = 0;
        primer_inicio = 0;
        cuenta_nivel_tiempo = 0;
        memoriza = "";
        infoPanel = " Fijate muy bien en las palabras presentadas\ndeberas recordarlas dentro de poco..suerte\n";

        palabra = new Palabra();
        palabra.setJuego(juego);
        palabra.setPalabra_del_nivel();
        palabra.setPalabra_a_Memorizar();


        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setBackground( new Color(13, 64, 123));
        gbc = new GridBagConstraints();
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.ipady=5;
        gbc.ipadx=5;

        //Mensaje puntos
        mensaje_puntos =  new Area_de_Texto();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,300,400);
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
//        this.add(mensaje_puntos.seText_2(""+juego.getPuntaje_Logrado()), gbc);
//        this.add(mensaje_puntos.seText_2(""+juego.getPuntaje_Logrado()), gbc);

        //mensaje
        botonX = new Letra_grafic();
        gbc.gridx=0; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=4; // ocupara 4 columnas
        gbc.gridheight=2; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.NORTH;
        this.add(botonX.sin_estilo(""), gbc);


        //3.. 2.. 1.. contador
        box = new FondoPanel();
        box.set_ruta_fondo("/resources/animaciones/conteo/32.png");
        box.setPreferredSize(new Dimension(116,167));
        gbc.gridx=0; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=4; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(60,0,0,0);
        gbc.anchor=GridBagConstraints.CENTER;
        this.add(box, gbc);

        mensaje =  new Area_de_Texto();
        gbc.gridx=0; // columna 0
        gbc.gridy=2; // fila 0
        gbc.gridwidth=4; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(100,0,0,0);
        gbc.anchor=GridBagConstraints.SOUTH;
        this.add(mensaje.seText(""), gbc);

        si_boton = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        si_boton.addActionListener(escucha);
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.LAST_LINE_START;
        this.add(si_boton.getBoton_style_0("SI"), gbc);

        no_boton = new Botones();
        gbc.gridx=2; // columna 0
        gbc.gridy=3; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        no_boton.addActionListener(escucha);
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.LAST_LINE_END;
        this.add(no_boton.getBoton_style_0("NO"), gbc);

        atras_boton = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=3; // fila 00
        gbc.gridwidth=4; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        atras_boton.addActionListener(escucha);
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.PAGE_END;
        this.add(atras_boton.getBoton_style_0("ATRAS"), gbc);


        si_boton.setVisible(false);
        no_boton.setVisible(false);
        botonX.setVisible(false);
        box.setVisible(false);
        box.setVisible(false);
        atras_boton.setVisible(false);

        //Aqui se setea el temporizador para lanzar en juego
        timer = new Timer(1000,escucha);
    }

    /**
     * Este métoso inicia el temporizador que muestra las palabras a memorizar
     *
     * @nota se invoca desde la clase controladora para garantizar que
     * se inicie en el momento indicado
     */
    public void start() {
        timer.start();
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    /**
     * inner class implements Listeners used by Panel_1_Inicial class
     */
    public class Escucha implements ActionListener {

        @Override
        /**
         * Secuencia que presenta las palabras iniciales para que el jugador las memorize
         */
        public void actionPerformed(ActionEvent e) {

            int count = 0;
            while (e.getSource()==timer && primer_inicio < 5){
                timer.stop();
                System.out.println("Entro while #3 --->"+ count);
                box.setVisible(true);
                box.set_ruta_fondo("/resources/animaciones/conteo/3"+primer_inicio+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();

            }

            count = primer_inicio - 4;
            while (e.getSource()==timer && primer_inicio >= 5 && primer_inicio < 10){
                count = 5 - count;
                timer.stop();
                System.out.println("Entro while #3 <---"+ count);
                box.setVisible(true);
                box.set_ruta_fondo("/resources/animaciones/conteo/3"+count+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }

            // espacio
            while (e.getSource()==timer && primer_inicio >= 10 && primer_inicio < 15){
                timer.stop();
                box.setVisible(false);
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }

            // Animacion del numero 2
            count = primer_inicio - 15;
            while (e.getSource()==timer && primer_inicio >= 15 && primer_inicio < 20){
                timer.stop();
                System.out.println("Entro while #2 --->"+ count);
                box.setVisible(true);
                box.set_ruta_fondo("/resources/animaciones/conteo/2"+count+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }
            count = primer_inicio - 19;
            while (e.getSource()==timer && primer_inicio >= 20 && primer_inicio < 25){
                count = 5 - count;
                timer.stop();
                System.out.println("Entro while #2 <---"+ count);
                box.setVisible(true);
                box.set_ruta_fondo("/resources/animaciones/conteo/2"+count+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }


            // espacio
            while (e.getSource()==timer && primer_inicio >= 25 && primer_inicio < 30){
                timer.stop();
                box.setVisible(false);
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }


            // Animacion del numero 1
            count = primer_inicio - 30;
            while (e.getSource()==timer && primer_inicio >= 30 && primer_inicio < 35){
                timer.stop();
                System.out.println("Entro while #1 --->"+ count);
                box.setVisible(true);
                box.set_ruta_fondo("/resources/animaciones/conteo/1"+count+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }
            count = primer_inicio - 34;
            while (e.getSource()==timer && primer_inicio >= 35 && primer_inicio < 40){
                count = 5 - count;
                timer.stop();
                System.out.println("Entro while #1 <---"+ count);
                box.setVisible(true);
                box.set_ruta_fondo("/resources/animaciones/conteo/1"+count+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }


            if (primer_inicio == 40){
                timer.stop();
                box.setVisible(false);

                botonX.setVisible(true);
                botonX.sin_estilo("hola");
//                si_boton.setVisible(true);
//                no_boton.setVisible(true);
//                atras_boton.setVisible(true);
                primer_inicio++;
                cuenta_memorizar = 0;
                timer = new Timer(1000, escucha);
                timer.start();
//                primer_inicio = 0;
            }


            /**
             * Condicion que valida las palabras a memorizar y las muestra
             */

            if(e.getSource()==timer && cuenta_memorizar <= palabra.getPalabra_a_Memorizar().size()-1 ){
                System.out.println("Flag 1");
                if(cuenta_memorizar <= palabra.getPalabra_a_Memorizar().size()-1) {
                System.out.println("Palabra " +palabra.getPalabra_a_Memorizar().get(cuenta_memorizar)
                    +" Time "+ cuenta_memorizar +" El timer está corriendo? " + String.valueOf(timer.isRunning()));

                    botonX.sin_estilo(palabra.getPalabra_a_Memorizar().get(cuenta_memorizar));
                    cuenta_memorizar++;
                    primer_inicio++;
                    timer = new Timer(3000, escucha);
                    timer.start();
                }else {
                    System.out.println("Flag 2");
                    timer.stop();
                    mensaje.seText("¿Es una palabra memorizada?");
                    botonX.sin_estilo(palabra.getPalabra_del_nivel().get(0));// estamos para retomar la presentacion de las palbras.
                    panel_botones.setVisible(true); // si no visibles.... atras ya venia.

//                    Inicia el temporizador para escoger la palabra memorizada
                    timer_acierto_2 = new Timer(2000,escucha);
                    timer_acierto_2.start();
                }

                //Aqui se setea el tiempo que dura cada palabra a memorizar
                timer = new Timer(1000, escucha);
                timer.start();
            }

            /**
             * Temporizador para encoger la palabra correcta
             */
            else if(e.getSource()==timer && cuenta_nivel <= palabra.getPalabra_del_nivel().size()){
                timer.stop();
                System.out.println("timer 2");
                mensaje.seText_2("¿Es una palabra memorizada?");
                botonX.sin_estilo(palabra.getPalabra_del_nivel().get(cuenta_nivel));
                si_boton.setVisible(true);
                no_boton.setVisible(true);
                //Temporizador para encoger la palabra correcta
                timer_acierto_2 = new Timer(5000, escucha);
                timer_acierto_2.start();
            }
//
            //cambia el estado del juego se empieza la secuencia para que el jugador empieze a decidiir
            // sobre las palabras presentadas decide si o no.
//
            if(e.getSource()==timer_acierto_2){
                System.out.println("timer 3");
                si_boton.setVisible(false);
                no_boton.setVisible(false);
                timer_acierto_2.stop();
                mensaje.seText_2("Se acabo el tiempo");
                botonX.sin_estilo("");
                cuenta_nivel++;
                timer = new Timer(2000,escucha);
                timer.start();
            }

            if (e.getSource()==si_boton && cuenta_nivel < palabra.getPalabra_del_nivel().size()){///// recorderis
                timer_acierto_2.stop();
                botonX.sin_estilo("");
                panel_botones.setVisible(true);

                if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(cuenta_nivel))){
                    si_boton.setVisible(false);
                    no_boton.setVisible(false);
                    mensaje.seText_2("CORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(cuenta_nivel)
                            +"\nsi es una palabra memorizada"
                    );
                    //acumular 10  puntos al jugador
                   juego.setPuntaje_Logrado(); //estado indica que acerto.
                    jugador.setPuntaje_Total(juego);
                    System.out.println(" el puntaje ahora es" + juego.getPuntaje_Logrado() + " el jugador lleva estos puntos " +
                            jugador.getPuntaje_Total());
                    mensaje_puntos.seText_2("Puntos "+juego.getPuntaje_Logrado());


                }else {
                    si_boton.setVisible(false);
                    no_boton.setVisible(false);
                    mensaje.seText_2("INCORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(cuenta_nivel)
                            +"\nno es una palabra memorizada"

                    );
                }
                cuenta_nivel++;
                timer = new Timer(4000,escucha);
                timer.start();
            }

            else if (e.getSource()==no_boton && cuenta_nivel < palabra.getPalabra_del_nivel().size()){ // recorderis
                timer_acierto_2.stop();
                botonX.sin_estilo("");
                panel_botones.setVisible(true);

                if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(cuenta_nivel))){
                    si_boton.setVisible(false);
                    no_boton.setVisible(false);
                    mensaje.seText_2("INCORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(cuenta_nivel)
                            +"\nsi es una palabra memorizada"
                    );

                }else {
                    si_boton.setVisible(false);
                    no_boton.setVisible(false);
                    mensaje.seText_2("CORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(cuenta_nivel)
                            +"\nno es una palabra memorizada"
                    );
                    //acumular 10  puntos al jugador
                    juego.setPuntaje_Logrado(); //estado indica que acerto.
                    jugador.setPuntaje_Total(juego);
                    System.out.println(" el puntaje ahora es" + juego.getPuntaje_Logrado() + " el jugador lleva estos puntos " +
                            jugador.getPuntaje_Total());
                    mensaje_puntos.seText_2("Puntos "+juego.getPuntaje_Logrado());
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
                    botonX.sin_estilo("PASAS AL SIGUIENTE NIVEL");
                    atras_boton.setVisible(false);

                    gbc.gridx = 0; // columna 0
                    gbc.gridy = 5; // fila 0
                    gbc.gridwidth = 4; // ocupara 4 columnas
                    gbc.gridheight = 1; // ocupara 3 filas
                    gbc.anchor=GridBagConstraints.CENTER;
                    atras_boton.addActionListener(escucha);
                    add(siguiente.getBoton_style_0("SIGUIENTE"), gbc);
                }
                else {

                    panel_botones.setVisible(false);
                    mensaje.seText_2("");
                    botonX.sin_estilo("GAME OVER");
                    atras_boton.setVisible(false);

                    gbc.gridx = 0; // columna 0
                    gbc.gridy = 5; // fila 0
                    gbc.gridwidth = 1; // ocupara 4 columnas
                    gbc.gridheight = 1; // ocupara 3 filas
                    atras_boton.addActionListener(escucha);
                    add(siguiente.getBoton_style_0("REPETIR"), gbc);
                    juego.reset_puntos();

                }
                cuenta_nivel = 0;
                cuenta_nivel_tiempo =0;
                primer_inicio = 0;

            }





        }
    }

}

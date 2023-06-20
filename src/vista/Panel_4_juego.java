package vista;

import controlador.Control_FileManager;
import modelo.Juego;
import modelo.Palabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Panel_4_juego extends FondoPanel {

    private Control_FileManager cfm;

/**
 * Clase que presenta el Panel del juego, tanto las palabras memorizar
 * como todas las palabras del nivel para que el jugador realize su
 * elecctión.
 * @ genera el total de puntos logrados por el Jugador sumados todos los niveles.
 */

    private Timer timer;
    private Timer timer_acierto_2;
    private Area_de_Texto mensaje_puntos;
    private Area_de_Texto mensaje_nivel;
    private Area_de_Texto mensaje;
    private FondoPanel conteo_321;
    private FondoPanel info_pantalla;
    private Botones boton_siguiente;
    private Botones boton_repetir;
    private Botones boton_salir;
    private Botones boton_salir_1;
    private Botones si_boton,no_boton;
    private Letra_Skim palabras_memoria;
    private Escucha escucha;
    private GridBagConstraints gbc;
    private JPanel panel_botones;
    private JPanel panel_palabra;
    private Palabra palabra;
    private Juego juego;
    private int cuenta_memorizar, cuenta_nivel;
    private int primer_inicio;
    private int pausa;

    private JPanel panel_norte;
    private JPanel panel_centro;
    private JPanel panel_sur;


    /**
     * Constructor sin parametros
     */
    public Panel_4_juego() {

        this.cfm = new Control_FileManager();
        this.juego = new Juego();
        this.juego.setNivel(1);
        iniciar();
    }

    /**
     * Constructor que resive un objeto de la clase Juego
     * @param juego
     */
    public Panel_4_juego(Juego juego){
        this.cfm = new Control_FileManager();
        this.juego = juego;;
        iniciar();
    }


    /**
     * Este metodo inicializa las variables de la clase
     */

    private void iniciar(){

//        juego.setNivel();
        juego.setNombre_leido_de_Array();
        set_ruta_fondo(2);
        GridBagLayout gridBagLayout = new GridBagLayout();

        panel_norte = new JPanel();
        panel_norte.setPreferredSize(new Dimension(700,50));
        panel_norte.setBackground(new Color(0x0000000, true));
        panel_norte.setLayout(gridBagLayout);

        panel_centro = new JPanel();
        panel_centro.setPreferredSize(new Dimension(800,290));
        panel_centro.setLayout(gridBagLayout);
        panel_centro.setBackground(new Color(0x0000000, true));

        panel_sur = new JPanel();
        panel_sur.setPreferredSize(new Dimension(700,100));
        panel_sur.setLayout(gridBagLayout);
        panel_sur.setBackground(new Color(0x0000000, true));

        this.setBackground( new Color(13, 64, 123));
        gbc = new GridBagConstraints();

        escucha = new Escucha();
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridBagLayout());
        panel_botones.setBackground(new Color(0x0000000, true));
        panel_palabra = new JPanel();
        panel_palabra.setLayout(new GridBagLayout());
        panel_palabra.setBackground(null);
        mensaje = new Area_de_Texto();
        cuenta_memorizar = 0;
        pausa = 0;
        cuenta_nivel = 0;
        primer_inicio = 99;

        palabra = new Palabra();
        palabra.setJuego(juego);
        palabra.setPalabra_del_nivel();
        palabra.setPalabra_a_Memorizar();

        /**
         * Panel norte
         */
        mensaje_puntos =  new Area_de_Texto();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,200);
        gbc.anchor=GridBagConstraints.LINE_START;

        juego.iniciar_datos();

        panel_norte.add(mensaje_puntos.seText("("+juego.getNombre()+")"+
                "       SCORE "+juego.getPuntaje_Total()+
                "   NIVEL "+juego.getNivel())
                ,gbc);

        boton_salir_1 = new Botones("",30,120,50);
        gbc.gridx=2; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.LINE_END;
        panel_norte.add(boton_salir_1.getBoton_style_0("SALIR"),gbc);
        /**
         * Panel centro
         */
        //Palabra
        palabras_memoria = new Letra_Skim();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.CENTER;
        panel_centro.add(palabras_memoria.seText_grafico("",1,1,1), gbc);

        //mensaje informacion
        info_pantalla = new FondoPanel();
        info_pantalla.set_ruta_fondo("/resources/info/listo.png");
        info_pantalla.setPreferredSize(new Dimension(548,220));
        gbc.gridx=0; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.SOUTH;
        panel_centro.add(info_pantalla, gbc);

        //3.. 2.. 1.. contador
        conteo_321 = new FondoPanel();
        conteo_321.set_ruta_fondo("/resources/animaciones/conteo/32.png");
        conteo_321.setPreferredSize(new Dimension(116,167));
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.CENTER;
        panel_centro.add(conteo_321, gbc);

        mensaje =  new Area_de_Texto();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.NORTH;
        panel_sur.add(mensaje.seText(""), gbc);

        /**
         * Panel sur
         */
        //Boton si
        si_boton = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        si_boton.addActionListener(escucha);
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.LAST_LINE_START;
        panel_sur.add(si_boton.getBoton_style_0("SI"), gbc);

        //botn no
        no_boton = new Botones();
        gbc.gridx=1; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        no_boton.addActionListener(escucha);
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.LAST_LINE_END;
        panel_sur.add(no_boton.getBoton_style_0("NO"), gbc);

        //botn siguiente
        boton_siguiente = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=1; // fila 00
        gbc.gridwidth=2; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.PAGE_END;
        panel_sur.add(boton_siguiente.getBoton_style_0("SIGUIENTE"), gbc);

        //botn repetir
        boton_repetir = new Botones();
        gbc.gridx = 0; // columna 0
        gbc.gridy = 1; // fila 0
        gbc.gridwidth = 2; // ocupara 4 columnas
        gbc.gridheight = 1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.PAGE_END;
        panel_sur.add(boton_repetir.getBoton_style_0("REPETIR"), gbc);

        //botn repetir
        boton_salir = new Botones();
        gbc.gridx = 0; // columna 0
        gbc.gridy = 1; // fila 0
        gbc.gridwidth = 2; // ocupara 4 columnas
        gbc.gridheight = 1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.PAGE_END;
        panel_sur.add(boton_salir.getBoton_style_0("SALIR"), gbc);

        this.add(panel_norte);
        this.add(panel_centro);
        this.add(panel_sur);

        //se ocultan los elementos
        si_boton.setVisible(false);
        no_boton.setVisible(false);
        palabras_memoria.setVisible(false);
        conteo_321.setVisible(false);
        conteo_321.setVisible(false);
        boton_siguiente.setVisible(false);
        info_pantalla.setVisible(false);
        palabras_memoria.setVisible(false);
        mensaje.setVisible(false);
        boton_repetir.setVisible(false);
        boton_salir.setVisible(false);
        info_pantalla.setVisible(false);
        conteo_321.setVisible(false);

        //Aqui se setea el temporizador para lanzar en juego
        timer = new Timer(1000,escucha);
        timer_acierto_2 = new Timer(2000,escucha);
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

            if (e.getSource()==timer && primer_inicio == 99){
                timer.stop();

                //se ocultan los elementos
                si_boton.setVisible(false);
                no_boton.setVisible(false);
                palabras_memoria.setVisible(false);
                conteo_321.setVisible(false);
                conteo_321.setVisible(false);
                boton_siguiente.setVisible(false);
                info_pantalla.setVisible(false);
                palabras_memoria.setVisible(false);
                mensaje.setVisible(false);
                boton_repetir.setVisible(false);
                boton_salir.setVisible(false);
                info_pantalla.setVisible(false);
                conteo_321.setVisible(false);

                juego.iniciar_datos();
                primer_inicio=0;
                info_pantalla.setVisible(true);
                mensaje.seText("NIVEL "+juego.getNivel() );
                timer = new Timer(1000, escucha);
                timer.start();
            }

            /**
             * numero 3
             */
            int count = 0;
            while (e.getSource()==timer && primer_inicio < 5){
                timer.stop();
                mensaje.seText("");
                System.out.println("Entro while #3 --->"+ count);
                conteo_321.setVisible(true);
                info_pantalla.setVisible(false);
                conteo_321.set_ruta_fondo("/resources/animaciones/conteo/3"+primer_inicio+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();

            }
            count = primer_inicio - 4;
            while (e.getSource()==timer && primer_inicio >= 5 && primer_inicio < 10){
                count = 5 - count;
                timer.stop();
                System.out.println("Entro while #3 <---"+ count);
                conteo_321.setVisible(true);
                conteo_321.set_ruta_fondo("/resources/animaciones/conteo/3"+count+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }

            /**
             * esoacio
             */
            while (e.getSource()==timer && primer_inicio >= 10 && primer_inicio < 15){
                timer.stop();
                conteo_321.setVisible(false);
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }

            /**
             * numero 2
             */
            count = primer_inicio - 15;
            while (e.getSource()==timer && primer_inicio >= 15 && primer_inicio < 20){
                timer.stop();
                System.out.println("Entro while #2 --->"+ count);
                conteo_321.setVisible(true);
                conteo_321.set_ruta_fondo("/resources/animaciones/conteo/2"+count+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }
            count = primer_inicio - 19;
            while (e.getSource()==timer && primer_inicio >= 20 && primer_inicio < 25){
                count = 5 - count;
                timer.stop();
                System.out.println("Entro while #2 <---"+ count);
                conteo_321.setVisible(true);
                conteo_321.set_ruta_fondo("/resources/animaciones/conteo/2"+count+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }

            /**
             * espacio
             */
            while (e.getSource()==timer && primer_inicio >= 25 && primer_inicio < 30){
                timer.stop();
                conteo_321.setVisible(false);
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }

            /**
             * numero 1
             */
            count = primer_inicio - 30;
            while (e.getSource()==timer && primer_inicio >= 30 && primer_inicio < 35){
                timer.stop();
                System.out.println("Entro while #1 --->"+ count);
                conteo_321.setVisible(true);
                conteo_321.set_ruta_fondo("/resources/animaciones/conteo/1"+count+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }
            count = primer_inicio - 34;
            while (e.getSource()==timer && primer_inicio >= 35 && primer_inicio < 40){
                count = 5 - count;
                timer.stop();
                System.out.println("Entro while #1 <---"+ count);
                conteo_321.setVisible(true);
                conteo_321.set_ruta_fondo("/resources/animaciones/conteo/1"+count+".png");
                primer_inicio++;
                timer = new Timer(100, escucha);
                timer.start();
            }


            /**
             * pausa ala animacion del conteo
             * hace visible las palabras a memorizar
             */
            if (primer_inicio == 40){
                timer.stop();
                conteo_321.setVisible(false);
                palabras_memoria.setVisible(true);
                primer_inicio++;
                cuenta_memorizar = 0;
                timer = new Timer(1000, escucha);
                timer.start();
            }

            /**
             * Condicion que valida las palabras a memorizar
             * y las muestra a memorizar
             */

            while (e.getSource()==timer
                    && pausa < palabra.getPalabra_a_Memorizar().size()
                    && cuenta_memorizar <= palabra.getPalabra_a_Memorizar().size() ){

                if (cuenta_memorizar <= pausa){
                    timer.stop();
                    palabras_memoria.seText_grafico(palabra.getPalabra_a_Memorizar().get(cuenta_memorizar),3,35,60,60);
                    mensaje.seText("");
                    cuenta_memorizar++;
                    timer = new Timer(2000, escucha);
                    timer.start();
                }else {
                    timer.stop();
                    palabras_memoria.seText_grafico("",1,1,1);
                    pausa++;
                    timer = new Timer(100, escucha);
                    timer.start();
                }
            }


            /**
             * esoacio
             */


            /**
             * Temporizador
             * pregunta si es una palabra memorizada
             * para encoger la palabra correcta
             */
            if(e.getSource()==timer && cuenta_nivel <= palabra.getPalabra_del_nivel().size()){
                timer.stop();
                info_pantalla.setVisible(true);
                info_pantalla.setVisible(false);
                mensaje.seText("¿Es esta una palabra memorizada?");
                palabras_memoria.seText_grafico(palabra.getPalabra_del_nivel().get(cuenta_nivel),3,35,60,60);
                si_boton.setVisible(true);
                no_boton.setVisible(true);
                timer_acierto_2 = new Timer(7000, escucha);
                timer_acierto_2.start();
            }

            /**
             * Temporizador
             * cambia la palabra si se exede el tiempo
             */
            if(e.getSource()==timer_acierto_2){
                timer_acierto_2.stop();
                System.out.println("timer 3");
                si_boton.setVisible(false);
                no_boton.setVisible(false);
                mensaje.seText("");
                info_pantalla.setVisible(true);
                info_pantalla.set_ruta_fondo("/resources/info/tiempo.png");
                palabras_memoria.seText_grafico("",1,1,1);
                cuenta_nivel++;
                timer = new Timer(2000,escucha);
                timer.start();
            }

            /**
             * Opcion SI
             * si es correcto aumenta puntos
             */
            if (e.getSource()==si_boton && cuenta_nivel < palabra.getPalabra_del_nivel().size()){///// recorderis
                timer_acierto_2.stop();
                palabras_memoria.seText_grafico("",1,1,1);
                panel_botones.setVisible(true);

                if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(cuenta_nivel))){ // acierto entonces puntos
                    si_boton.setVisible(false);
                    no_boton.setVisible(false);
                    mensaje.setVisible(false);

                    info_pantalla.setVisible(true);
                    info_pantalla.set_ruta_fondo("/resources/info/bien.png");

                    mensaje.seText("");

                    //acumular 10  puntos al jugador
                    juego.incrementar_puntaje_nivel(); //estado indica que acerto.
                    System.out.println(" el puntaje ahora es" + juego.getPuntaje_nivel() + " el jugador lleva estos puntos " +
                            juego.getPuntaje_Total());

                }else {
                    si_boton.setVisible(false);
                    no_boton.setVisible(false);
                    mensaje.setVisible(false);

                    info_pantalla.setVisible(true);
                    info_pantalla.set_ruta_fondo("/resources/info/mal.png");

                    mensaje.seText("");
                }
                cuenta_nivel++;
                timer = new Timer(2000,escucha);
                timer.start();
            }

            /**
             * Opcion NO
             * si es correcto aumenta puntos
             */
            if (e.getSource()==no_boton && cuenta_nivel < palabra.getPalabra_del_nivel().size()){ // recorderis
                timer_acierto_2.stop();

                palabras_memoria.seText_grafico("",1,1,1);
                panel_botones.setVisible(true);

                if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(cuenta_nivel))){
                    si_boton.setVisible(false);
                    no_boton.setVisible(false);
                    mensaje.setVisible(false);
                    info_pantalla.setVisible(true);
                    info_pantalla.set_ruta_fondo("/resources/info/mal.png");
                    mensaje.seText("");

                }else {
                    si_boton.setVisible(false);
                    no_boton.setVisible(false);
                    mensaje.setVisible(false);
                    info_pantalla.setVisible(true);
                    info_pantalla.set_ruta_fondo("/resources/info/bien.png");
                    mensaje.seText("");

                    //acumular 10  puntos al jugador
                    juego.incrementar_puntaje_nivel(); //estado indica que acerto.
                    System.out.println(" el puntaje ahora es" + juego.getPuntaje_nivel() + " el jugador lleva estos puntos " +
                            juego.getPuntaje_Total());

//                    mensaje_puntos.seText("Puntos      "+juego.getPuntaje_nivel());
                }
                cuenta_nivel++;
                timer = new Timer(2000,escucha);
                timer.start();
            }

            /**
             * Condicion que evalua si se gana el juego
             * si es correcto permite cambiar de nivel
             */
            if(cuenta_nivel == palabra.getPalabra_del_nivel().size()){
                timer_acierto_2.stop();
                timer.stop();

                info_pantalla.setVisible(false);
                panel_botones.setVisible(false);
                mensaje.seText("");
                if (juego.nivel_Superado() == 1) {
                    set_ruta_fondo(4);
                    palabras_memoria.seText_grafico(""
                            ,40,100,100);
                    boton_siguiente.setVisible(true);


                }
                else if (juego.nivel_Superado() == 0){
                    set_ruta_fondo(5);
                    mensaje.seText("");
                    palabras_memoria.seText_grafico(""
                            ,40,100,100);
                    boton_repetir.setVisible(true);
                }
                else if (juego.nivel_Superado() == 2){
                    set_ruta_fondo(6);
                    mensaje_puntos.setVisible(false);
                    mensaje.seText("sdfsdfsdfsdf");
                    palabras_memoria.seText_grafico("",40,70,70);
                    boton_salir.setVisible(true);
                    boton_salir_1.setVisible(false);
                }

            }
        }
        // tiene los totales ?
    }
}

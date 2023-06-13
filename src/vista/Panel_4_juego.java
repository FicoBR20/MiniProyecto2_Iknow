package vista;

import controlador.Jugador;
import modelo.Juego;
import modelo.Palabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_4_juego extends FondoPanel {

    private String infoPanel;
    private Font font;
    private Botones atras_boton,si_boton,no_boton, siguiente;
    private Letra_grafic botonX;
    private Area_de_Texto mensaje,mensaje_puntos;
    private Timer timer;
    private Timer timer_acierto;
    private  Timer timer_acierto_2;
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


    /**
     * Presenta en el nivel actual
     */
    public Panel_4_juego(){
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

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setBackground( new Color(13, 64, 123));
        gbc = new GridBagConstraints();
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.ipady=5;
        gbc.ipadx=5;

        mensaje_puntos =  new Area_de_Texto();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,300,400);
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        this.add(mensaje_puntos.seText_2("Puntos "+juego.getPuntaje_Logrado()), gbc);

        palabra = new Palabra();
        palabra.setJuego(juego);
        palabra.setPalabra_del_nivel();
        palabra.setPalabra_a_Memorizar();

        botonX = new Letra_grafic();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.CENTER;
        this.add(botonX.seText_grafico(""), gbc);
        repaint();

        mensaje =  new Area_de_Texto();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,150,0);
        gbc.anchor=GridBagConstraints.CENTER;
        this.add(mensaje.seText(""), gbc);

        si_boton = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        si_boton.addActionListener(escucha);
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.SOUTH;
        panel_botones.add(si_boton.getBoton_style_0("SI"), gbc);

        no_boton = new Botones();
        gbc.gridx=1; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        no_boton.addActionListener(escucha);
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.SOUTH;
        panel_botones.add(no_boton.getBoton_style_0("NO"), gbc);

        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        panel_botones.setVisible(false);
        this.add(panel_botones, gbc);

        atras_boton = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=0; // fila 00
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        atras_boton.addActionListener(escucha);
        gbc.insets.set(0,0,0,0);
        gbc.anchor=GridBagConstraints.SOUTH;
        atras_boton.setVisible(false);
        this.add(atras_boton.getBoton_style_0("ATRAS"), gbc);

        //Aqui se setea el temporizador para lanzar en juego
        timer = new Timer(2000,escucha);
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

//    protected void paintComponent(Graphics g){
//        super.paintComponent(g);
//        String receptor = "";
//      //  receptor = palabra.getPalabra_a_Memorizar();
//
//        g.setColor(Color.WHITE);
//        g.fillRect((800-W)/2,10 ,W,H);
//
//        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
//        Graphics g2 = image.getGraphics();
//
//        String  texto = "Puntos "+jugador.getPuntaje_Total()+"La palabra a memorizar es" + receptor;
//        FontMetrics metrics = g.getFontMetrics();
//        int anchoEnPixeles = metrics.stringWidth(texto);
//
//        g.setColor(Color.BLACK);
//        g.setFont(new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 27));
//
//        g.drawString(texto,(W-anchoEnPixeles)/2,40);
//
////        botonX = new Letra_grafic();
////        gbc.gridx=0; // columna 0
////        gbc.gridy=0; // fila 0
////        gbc.gridwidth=1; // ocupara 4 columnas
////        gbc.gridheight=1; // ocupara 3 filas
////        gbc.insets.set(0,0,0,0);
////        this.add(botonX.seText_grafico(""), gbc);
//        repaint();
//
//    }

    /**
     * inner class implements Listeners used by Panel_1_Inicial class
     */
    public class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

//            if (e.getSource()==timer) {
//                primer_inicio++;
//            }

//            switch (primer_inicio){
//                case 1 ->{
//                    timer.stop();
//                    botonX.seText_grafico("BIENVENIDO");
//                    mensaje.seText("I know that word");
//                    timer = new Timer(4000, escucha);
//                    timer.start();
//                }
//                case 2 ->{
//                    timer.stop();
//                    botonX.seText_grafico("Ready");
//                    mensaje.seText("");
//                    timer = new Timer(2000, escucha);
//                    timer.start();
//                }
//                case 3 ->{
//                    timer.stop();
//                    botonX.seText_grafico("Go");
//                    mensaje.seText("");
//                    timer = new Timer(2000, escucha);
//                    timer.start();
//                }
//                case 4 ->{
//                    timer.stop();
//                    botonX.setText("");
//                    mensaje.seText("");
//                    timer = new Timer(2000, escucha);
//                    timer.start();
//                }
//
//                case 5 ->{
////                        timer.stop();
//                        System.out.println("Palabra "
//                                +palabra.getPalabra_a_Memorizar().get(cuenta_memorizar)
//                                +" Time "+ cuenta_memorizar +"El timer está corriendo?"
//                                + String.valueOf(timer.isRunning()));
//                        botonX.seText_grafico(""+palabra.getPalabra_a_Memorizar().get(cuenta_memorizar));
//                        cuenta_memorizar++;
//                        primer_inicio = 5;
//                        timer = new Timer(2000, escucha);
//                        timer.start();
//                }
//
//
//                case 6 ->{
//
//
//                        timer.stop();
//                        mensaje.seText_2("¿Es una palabra memorizada?");
//                        botonX.seText_grafico(palabra.getPalabra_del_nivel().get(0));// estamos para retomar la presentacion de las palbras.
//                        panel_botones.setVisible(true); // si no visibles.... atras ya venia.
//
////                    Inicia el temporizador para escoger la palabra memorizada
//                        timer_acierto_2 = new Timer(2000,escucha);
//                        timer_acierto_2.start();
//
//                    //Aqui se setea el tiempo que dura cada palabra a memorizar
//                    timer = new Timer(1000, escucha);
//                    timer.start();
//                }
//
//                case 7 ->{
//                    timer.stop();
//                    System.out.println("timer 2");
//                    mensaje.seText_2("¿Es una palabra memorizada?");
//                    botonX.seText_grafico(palabra.getPalabra_del_nivel().get(cuenta_nivel));
//                    panel_botones.setVisible(true);
//                    //Temporizador para encoger la palabra correcta
//                    timer = new Timer(5000, escucha);
//                    timer.start();
//                }
//
//                case 8 ->{
//                    timer.stop();
//                    panel_botones.setVisible(false);
//                    timer_acierto_2.stop();
//                    mensaje.seText_2("Se acabo el tiempo");
//                    botonX.seText_grafico("");
//                    cuenta_nivel++;
//                    timer = new Timer(2000,escucha);
//                    timer.start();
//                }
//                case 9 ->{
//
//                    timer_acierto_2.stop();
//                    botonX.seText_grafico("");
//                    panel_botones.setVisible(true);
//
//                    if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(cuenta_nivel))){
//                        mensaje.seText_2("CORRECTO\n"
//                                +palabra.getPalabra_del_nivel().get(cuenta_nivel)
//                                +"\nsi es una palabra memorizada"
//                        );
//                        //acumular 10  puntos al jugador
//                        juego.setPuntaje_Logrado(); //estado indica que acerto.
//                        jugador.setPuntaje_Total(juego);
//                        System.out.println(" el puntaje ahora es" + juego.getPuntaje_Logrado() + " el jugador lleva estos puntos " +
//                                jugador.getPuntaje_Total());
//                        mensaje_puntos.seText_2("Puntos "+juego.getPuntaje_Logrado());
//
//                    }else {
//                        mensaje.seText_2("INCORRECTO\n"
//                                +palabra.getPalabra_del_nivel().get(cuenta_nivel)
//                                +"\nno es una palabra memorizada"
//
//                        );
//                    }
//                    cuenta_nivel++;
//                    timer = new Timer(4000,escucha);
//                    timer.start();
//                }
//                case 10 ->{
//                    timer_acierto_2.stop();
//                    botonX.seText_grafico("");
//                    panel_botones.setVisible(true);
//
//                    if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(cuenta_nivel))){
//                        mensaje.seText_2("INCORRECTO\n"
//                                +palabra.getPalabra_del_nivel().get(cuenta_nivel)
//                                +"\nsi es una palabra memorizada"
//                        );
//
//                    }else {
//                        mensaje.seText_2("CORRECTO\n"
//                                +palabra.getPalabra_del_nivel().get(cuenta_nivel)
//                                +"\nno es una palabra memorizada"
//                        );
//                        //acumular 10  puntos al jugador
//                        juego.setPuntaje_Logrado(); //estado indica que acerto.
//                        jugador.setPuntaje_Total(juego);
//                        System.out.println(" el puntaje ahora es" + juego.getPuntaje_Logrado() + " el jugador lleva estos puntos " +
//                                jugador.getPuntaje_Total());
//                        mensaje_puntos.seText_2("Puntos "+juego.getPuntaje_Logrado());
//                    }
//                    cuenta_nivel++;
//                    timer = new Timer(4000,escucha);
//                    timer.start();
//                }
//                case 11 ->{
//                    timer_acierto_2.stop();
//                    timer.stop();
//                    if (juego.nivel_Superado()) {
//
//                        panel_botones.setVisible(false);
//                        mensaje.seText_2("");
//                        botonX.seText_grafico("PASAS AL SIGUIENTE NIVEL");
//                        atras_boton.setVisible(false);
//
//                        gbc.gridx = 0; // columna 0
//                        gbc.gridy = 5; // fila 0
//                        gbc.gridwidth = 1; // ocupara 4 columnas
//                        gbc.gridheight = 1; // ocupara 3 filas
//                        atras_boton.addActionListener(escucha);
//                        add(siguiente.getBoton_style_1("SIGUIENTE"), gbc);
//                    }
//                    else {
//
//                        panel_botones.setVisible(false);
//                        mensaje.seText_2("");
//                        botonX.seText_grafico("GAME OVER");
//                        atras_boton.setVisible(false);
//
//                        gbc.gridx = 0; // columna 0
//                        gbc.gridy = 5; // fila 0
//                        gbc.gridwidth = 1; // ocupara 4 columnas
//                        gbc.gridheight = 1; // ocupara 3 filas
//                        atras_boton.addActionListener(escucha);
//                        add(siguiente.getBoton_style_1("REPETIR"), gbc);
//                        juego.reset_puntos();
//
//                    }
//                    cuenta_nivel = 0;
//                    cuenta_memorizar = 0;
//                    cuenta_nivel_tiempo =0;
//                    primer_inicio = 0;
//
//                }
//
//            }


            if(e.getSource()==timer && primer_inicio == 0){
                botonX.seText_grafico("BIENENIDO");
                mensaje.seText("I know that word");
                timer = new Timer(4000, escucha);
                timer.start();
                primer_inicio++;
                repaint();
            }

            else if(e.getSource()==timer && primer_inicio == 1){
                botonX.seText_grafico("",3);
                mensaje.seText("");
                timer = new Timer(1000, escucha);
                timer.start();
                primer_inicio++;
                repaint();
            }

            else if(e.getSource()==timer && primer_inicio == 2){
                botonX.seText_grafico("",2);
                mensaje.seText("");
                timer = new Timer(1000, escucha);
                timer.start();
                primer_inicio++;
            }

            else if(e.getSource()==timer && primer_inicio == 3){
                botonX.seText_grafico("",1);
                mensaje.seText("");
                timer = new Timer(1000, escucha);
                timer.start();
                primer_inicio++;
            }

            /**
             * Condicion que valida las palabras a memorizar y las muestra
             */

            if(e.getSource()==timer && cuenta_memorizar < palabra.getPalabra_a_Memorizar().size()){
                System.out.println("timer 1");
                if(cuenta_memorizar <= palabra.getPalabra_a_Memorizar().size()-1) {
                System.out.println("Palabra " +palabra.getPalabra_a_Memorizar().get(cuenta_memorizar)
                    +" Time "+ cuenta_memorizar +" El timer está corriendo? " + String.valueOf(timer.isRunning()));

                    botonX.seText_grafico(palabra.getPalabra_a_Memorizar().get(cuenta_memorizar));
                    cuenta_memorizar++;
                }else {
                    timer.stop();
                    mensaje.seText_2("¿Es una palabra memorizada?");
                    botonX.seText_grafico(palabra.getPalabra_del_nivel().get(0));// estamos para retomar la presentacion de las palbras.
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
                botonX.seText_grafico(palabra.getPalabra_del_nivel().get(cuenta_nivel));
                panel_botones.setVisible(true);
                //Temporizador para encoger la palabra correcta
                timer_acierto_2 = new Timer(5000, escucha);
                timer_acierto_2.start();
            }

            //cambia el estado del juego se empieza la secuencia para que el jugador empieze a decidiir
            // sobre las palabras presentadas decide si o no.
//
            if(e.getSource()==timer_acierto_2){
                System.out.println("timer 3");
                panel_botones.setVisible(false);
                timer_acierto_2.stop();
                mensaje.seText_2("Se acabo el tiempo");
                botonX.seText_grafico("");
                cuenta_nivel++;
                timer = new Timer(2000,escucha);
                timer.start();
            }

            if (e.getSource()==si_boton && cuenta_nivel < palabra.getPalabra_del_nivel().size()){///// recorderis
                timer_acierto_2.stop();
                botonX.seText_grafico("");
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
                    mensaje_puntos.seText_2("Puntos "+juego.getPuntaje_Logrado());

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

            else if (e.getSource()==no_boton && cuenta_nivel < palabra.getPalabra_del_nivel().size()){ // recorderis
                timer_acierto_2.stop();
                botonX.seText_grafico("");
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
                    botonX.seText_grafico("PASAS AL SIGUIENTE NIVEL");
                    atras_boton.setVisible(false);

                    gbc.gridx = 0; // columna 0
                    gbc.gridy = 5; // fila 0
                    gbc.gridwidth = 1; // ocupara 4 columnas
                    gbc.gridheight = 1; // ocupara 3 filas
                    atras_boton.addActionListener(escucha);
                    add(siguiente.getBoton_style_0("SIGUIENTE"), gbc);
                }
                else {

                    panel_botones.setVisible(false);
                    mensaje.seText_2("");
                    botonX.seText_grafico("GAME OVER");
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
//                cuenta_memorizar = 0;
                cuenta_nivel_tiempo =0;
                primer_inicio = 0;

            }
        }
    }
}

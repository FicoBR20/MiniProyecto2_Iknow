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
    private Botones atras_boton,si_boton,no_boton;
    private Area_de_Texto area_de_texto, area_de_texto_2;
    private Timer timer,timer_acierto;
    private  Timer timer_acierto_2;
    private Escucha escucha;
    private  int cuenta_palabras,contador;
    private static Panel_4_juego panel_4_canvas = null;
    private String memoriza;
    private GridBagConstraints gbc;
    private JPanel panel_botones;
    private Palabra palabra;
    private Juego juego;


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
        jugador = new Jugador();
        timer_acierto = new Timer(2000,escucha);
//        timer_acierto_2 = new Timer(2000,escucha);
        gbc = new GridBagConstraints();
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.ipady=15;
        gbc.ipadx=15;
        escucha = new Escucha();
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridBagLayout());
        panel_botones.setBackground(null);
        area_de_texto_2 = new Area_de_Texto();

        cuenta_palabras = 0;
        contador = 0;
        memoriza = "";
        infoPanel = " Fijate muy bien en las palabras presentadas\ndeberas recordarlas dentro de poco..suerte\n";
        font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 27);

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setBackground( new Color(47, 161, 30));

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

        area_de_texto_2 =  new Area_de_Texto();
        gbc.gridx=0; // columna 0
        gbc.gridy=1; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        gbc.insets.set(0,0,0,0);
        this.add(area_de_texto_2.seText_2(""), gbc);

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
//        panel_botones.setVisible(false);
        this.add(panel_botones, gbc);

        atras_boton = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=4; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        atras_boton.addActionListener(escucha);
        this.add(atras_boton.getBoton_style_1("ATRAS"), gbc);

        timer = new Timer(1000, escucha );
    }
    public void start(){
        timer.start();
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
       juego = juego;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        String receptor = "";
      //  receptor = palabra.getPalabra_a_Memorizar();
        g.setFont(font);
        g.drawString("La palabra a memorizar es" + receptor,20,20);

    }

    /**
     * inner class implements Listeners used by Panel_1_Inicial class
     */
    public class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==timer){
                if(cuenta_palabras <= palabra.getPalabra_a_Memorizar().size()-1) {
                    //Esta salida generaba conflictos cuando estaba afuera del este if
                        System.out.println("Palabra " +palabra.getPalabra_a_Memorizar().get(cuenta_palabras)
                            +" Time "+ cuenta_palabras +" El timer está corriendo? " + String.valueOf(timer.isRunning()));
                    area_de_texto.seText(palabra.getPalabra_a_Memorizar().get(cuenta_palabras));
                    cuenta_palabras++;
                }else{
                    timer.stop();
                    area_de_texto.seText(palabra.getPalabra_del_nivel().get(0));
                    panel_botones.setVisible(true);

//                    Inicia el temporizador para escoger la palabra memorizada
                    timer_acierto_2 = new Timer(7000,escucha);
                    timer_acierto_2.start();
                }
            }
            else{
                cuenta_palabras =0;
            }
//
            //cambia el estado del juego se empieza la secuencia para que el jugador empieze a decidiir
            // sobre las palabras presentadas decide si o no.
//
            if(e.getSource()==timer_acierto_2){

                System.out.println("timer3");
                area_de_texto_2.seText_2("limite de tiempo");
                area_de_texto.seText("");
                timer_acierto = new Timer(1000,escucha);
                timer_acierto.start();

            }


            if (e.getSource()==si_boton && contador <= palabra.getPalabra_del_nivel().size()-1){///// recorderis
                timer_acierto = new Timer(2000,escucha);
                timer_acierto.start();
//                timer_acierto_2.stop();
                area_de_texto.seText("");
                panel_botones.setVisible(true);

                if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(contador))){
                    area_de_texto_2.seText_2("CORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(contador)
                            +"\nsi es una palabra memorizada"
                    );
                    //acumular 10  puntos al jugador
                   juego.setPuntaje_Logrado(); //estado indica que acerto.
                    jugador.setPuntaje_Total(juego);
                    System.out.println(" el puntaje ahora es" + juego.getPuntaje_Logrado() + " el jugador lleva estos puntos " +
                            jugador.getPuntaje_Total());
                    contador++;
                    area_de_texto.seText(palabra.getPalabra_del_nivel().get(contador));


                }else {
                    area_de_texto_2.seText_2("INCORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(contador)
                            +"\nno es una palabra memorizada"

                    );
                    contador++;
                    area_de_texto.seText(palabra.getPalabra_del_nivel().get(contador));

                }
            }

            else if (e.getSource()==no_boton && contador <= palabra.getPalabra_del_nivel().size()-1){ // recorderis
                timer_acierto = new Timer(2000,escucha);
                timer_acierto.start();
                area_de_texto.seText("");
                panel_botones.setVisible(true);


                if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(contador))){
                    area_de_texto_2.seText_2("INCORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(contador)
                            +"\nsi es una palabra memorizada"
                    );
                    contador++;
                    area_de_texto.seText(palabra.getPalabra_del_nivel().get(contador));

                }else {
                    area_de_texto_2.seText_2("CORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(contador)
                            +"\nno es una palabra memorizada"
                    );
                    //acumular 10  puntos al jugador
                    juego.setPuntaje_Logrado(); //estado indica que acerto.
                    jugador.setPuntaje_Total(juego);
                    System.out.println(" el puntaje ahora es" + juego.getPuntaje_Logrado() + " el jugador lleva estos puntos " +
                            jugador.getPuntaje_Total());
                    contador++;
                    area_de_texto.seText(palabra.getPalabra_del_nivel().get(contador));

                }
            }

            if(e.getSource()==timer_acierto && contador <= palabra.getPalabra_del_nivel().size()-1){
                System.out.println("timer 2");
                timer_acierto.stop();
                area_de_texto_2.seText_2("");
                area_de_texto.seText(palabra.getPalabra_del_nivel().get(contador++));
                panel_botones.setVisible(true);
            }



        }
    }
}

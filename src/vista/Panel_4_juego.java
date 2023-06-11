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
    private Area_de_Texto area_de_texto, area_de_texto_2;
    private Timer timer,timer_acierto;
    private Escucha escucha;
    private  int counter,contador;
    private static Panel_4_juego panel_4_canvas = null;
    private String memoriza;
    private GridBagConstraints gbc;
    private JPanel panel_botones;
    private Palabra palabra;
    private Juego juego1;


    /**
     * Presenta en el nivel actual
     */
    public Panel_4_juego(){
        juego1 = new Juego();
        ini();
    }
    public Panel_4_juego( Juego juego){
        juego1 = juego;
        ini();
    }

    private void ini(){
        siguiente = new Botones();
        jugador = new Jugador();
        timer_acierto = new Timer(2000,escucha);
        gbc = new GridBagConstraints();
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.ipady=15;
        gbc.ipadx=15;
        escucha = new Escucha();
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridBagLayout());
        panel_botones.setBackground(null);
        area_de_texto_2 = new Area_de_Texto();

        counter = 0;
        contador = 0;
        memoriza = "";
        infoPanel = " Fijate muy bien en las palabras presentadas\ndeberas recordarlas dentro de poco..suerte\n";
        font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 27);

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setBackground( new Color(47, 161, 30));

        palabra = new Palabra();

        palabra.setJuego(juego1);
        palabra.setPalabra_del_nivel();
        palabra.setPalabra_a_Memorizar();

//        gbc.insets.set(0,0,20,5);
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
        panel_botones.setVisible(false);
        this.add(panel_botones, gbc);

        atras_boton = new Botones();
        gbc.gridx=0; // columna 0
        gbc.gridy=4; // fila 0
        gbc.gridwidth=1; // ocupara 4 columnas
        gbc.gridheight=1; // ocupara 3 filas
        atras_boton.addActionListener(escucha);
     //   atras_boton.setVisible(false);
        this.add(atras_boton.getBoton_style_1("ATRAS"), gbc);

        timer = new Timer(1000, escucha );
//        start();
    }
    public void start(){
        timer.start();
    }


    public Juego getJuego() {
        return juego1;
    }

    public void setJuego(Juego juego) {
       juego1 = juego;
    }

//    public static void main(String[] args){
//        EventQueue.invokeLater(() -> {
//            GUI miProjectGUI = new GUI();
//            panel_4_canvas = new Panel_4_juego();
//            miProjectGUI.setContentPane(panel_4_canvas);
//        });
//    }

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
        /**
         * Secuencia que presenta las palabras iniciales para que el jugador las memorize
         */
        public void actionPerformed(ActionEvent e) {
            String auxiliar = "";
            if(e.getSource()==timer){
               // System.out.println("Palabra " + palabra.getPalabra_a_Memorizar().get(counter) // counter es la ubicacion en el arreglo.
                   // +" Time "+counter+" El timer está corriendo? " + String.valueOf(timer.isRunning()));
                if(counter <= palabra.getPalabra_a_Memorizar().size()-1) {                                      // se cambia -2 por -1
                    auxiliar = palabra.getPalabra_a_Memorizar().get(counter);
                    area_de_texto.seText(auxiliar);
                    System.out.println(" presentando palabras a memorizar y counter vale " + counter + " y la palabra es " + auxiliar);
                    counter++;
                }else {
                    timer.stop();
                    area_de_texto.seText(palabra.getPalabra_del_nivel().get(0));// estamos para retomar la presentacion de las palbras.
                    panel_botones.setVisible(true); // si no visibles.... atras ya venia.

                }
            }
            else{
                counter=0;
                }

            //cambia el estado del juego se empieza la secuencia para que el jugador empieze a decidiir
            // sobre las palabras presentadas decide si o no.

            if(e.getSource()==timer_acierto){
                System.out.println("timer 2");
                timer_acierto.stop();
                area_de_texto_2.seText_2("");
                area_de_texto.seText(palabra.getPalabra_del_nivel().get(contador));
                panel_botones.setVisible(true);
                timer_acierto.stop();
            }


            if (e.getSource()==si_boton && contador <= palabra.getPalabra_del_nivel().size()-2){///// recorderis
                timer_acierto = new Timer(4000,escucha);
                timer_acierto.start();
                area_de_texto.seText("");
                panel_botones.setVisible(false);

                if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(contador))){
                    area_de_texto_2.seText_2("CORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(contador)
                            +"\nsi es una palabra memorizada"
                    );
                    //acumular 10  puntos al jugador
                   juego1.setPuntaje_Logrado(); //estado indica que acerto.
                    jugador.setPuntaje_Total(juego1);
                    System.out.println(" el puntaje ahora es" + juego1.getPuntaje_Logrado() + " el jugador lleva estos puntos " +
                            jugador.getPuntaje_Total());
                    contador++;


                }else {
                    area_de_texto_2.seText_2("INCORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(contador)
                            +"\nno es una palabra memorizada"

                    );
                    contador++;

                }
            }

            else if (e.getSource()==no_boton && contador <= palabra.getPalabra_del_nivel().size()-2){ // recorderis
                timer_acierto = new Timer(4000,escucha);
                timer_acierto.start();
                area_de_texto.seText("");
                panel_botones.setVisible(false);

                if (palabra.getPalabra_a_Memorizar().contains(palabra.getPalabra_del_nivel().get(contador))){
                    area_de_texto_2.seText_2("INCORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(contador)
                            +"\nsi es una palabra memorizada"
                    );
                    contador++;

                }else {
                    area_de_texto_2.seText_2("CORRECTO\n"
                            +palabra.getPalabra_del_nivel().get(contador)
                            +"\nno es una palabra memorizada"
                    );
                    //acumular 10  puntos al jugador
                    juego1.setPuntaje_Logrado(); //estado indica que acerto.
                    jugador.setPuntaje_Total(juego1);
                    System.out.println(" el puntaje ahora es" + juego1.getPuntaje_Logrado() + " el jugador lleva estos puntos " +
                            jugador.getPuntaje_Total());
                    contador++;


                }
            }
            else if(contador == palabra.getPalabra_del_nivel().size()-2){

              //  if (juego1.nivel_Superado()==true) {

                    panel_botones.setVisible(false);
                    area_de_texto.seText(" acabo el juego. ");
                    atras_boton.setVisible(false);

                    gbc.gridx = 0; // columna 0
                    gbc.gridy = 5; // fila 0
                    gbc.gridwidth = 1; // ocupara 4 columnas
                    gbc.gridheight = 1; // ocupara 3 filas
                    atras_boton.addActionListener(escucha);
                    //   atras_boton.setVisible(false);
                    add(siguiente.getBoton_style_1("SIGUIENTE"), gbc);
               // }
//                else {
//
//                    panel_botones.setVisible(false);
//                    area_de_texto.seText(" acabo el juego. ");
//                    atras_boton.setVisible(false);
//
//                    gbc.gridx = 0; // columna 0
//                    gbc.gridy = 5; // fila 0
//                    gbc.gridwidth = 1; // ocupara 4 columnas
//                    gbc.gridheight = 1; // ocupara 3 filas
//                    atras_boton.addActionListener(escucha);
//                    //   atras_boton.setVisible(false);
//                    add(siguiente.getBoton_style_1("REPETIR"), gbc);
//
//                }



            }
        }

        // condicicon de salida.
    }
}

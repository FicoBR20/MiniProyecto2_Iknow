package controlador;

import vista.*;
import vista.Panel_4_juego;
import vista.Front_RegistroJugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;


public class Lanza_app_Prueba {

    private Front_Jugador_Habitual frontJugadorHabitual;
    private  GUI gui;
    private  Panel_0_bienvenida panel_0_bienvenida;
    private  Panel_1_Inicial panel_1_inicial;
    private  Panel_2_menu panel_2_menu;
    private  Panel_3_reglas panel_3_reglas;
    private  Panel_4_juego panel_4_juego;
    private  Panel_5_opciones panel_5_opciones;
    private  Panel_7_niveles panel_7_niveles;
    private  Panel_6_continuar panel_6_continuar;
    private Front_RegistroJugador front_registroJugador;

//    private Jugador jugador;
    private static Lanza_app_Prueba lanzador = null;

    /**
     * Método constructor
     */
    public Lanza_app_Prueba() throws IOException {
        gui = new GUI();
        panel_0_bienvenida = new Panel_0_bienvenida();
        panel_1_inicial = new Panel_1_Inicial();
        panel_2_menu = new Panel_2_menu();
        panel_3_reglas = new Panel_3_reglas();
        panel_4_juego = new Panel_4_juego();
        panel_5_opciones = new Panel_5_opciones();
        panel_6_continuar = new Panel_6_continuar();

        frontJugadorHabitual = new Front_Jugador_Habitual();
        front_registroJugador = new Front_RegistroJugador();
        seleccionar_pantalla(0);
    }

    public void iniciar_registro(){
        new Control_FileManager().writer_Jugador("___"+" "+0+" "+0);
    }

    public void secuencia_Logica(int secuencial){

        seleccionar_pantalla(secuencial);

    }

    /**
     * Este metodo selecciona y navega entre paneles.
     * @param pantalla
     */
    public void seleccionar_pantalla(int pantalla){ // pantalla esqivlae a un juego.estado.
        switch (pantalla) {

            case 0 ->{
                gui.setContentPane(panel_0_bienvenida);
                gui.revalidate();
                gui.repaint();
            }

            case 1 ->{
                gui.setContentPane(panel_1_inicial);
                gui.revalidate();
                gui.repaint();
            }

            case 2 ->{
                gui.setContentPane(panel_2_menu);
                gui.revalidate();
                gui.repaint();
            }
            case 3 ->{
//                panel_3_reglas = new Panel_3_reglas();
                gui.setContentPane(panel_3_reglas);
                gui.revalidate();
                gui.repaint();
            }

            //Inicia un juego nuevo
            case 4 ->{

                //NOta quite jugador del argumento
                //Obtiene los valores del ultimio nivel jugado
                panel_4_juego = new Panel_4_juego(panel_4_juego.getJuego());
                panel_4_juego.start(); // inicializa timer
                gui.setContentPane(panel_4_juego);
                gui.revalidate();
                gui.repaint();
            }

            case 5 ->{
                gui.setContentPane(panel_5_opciones);
                gui.revalidate();
                gui.repaint();
            }

            case 6 ->{
                front_registroJugador = new Front_RegistroJugador();
                gui.setContentPane(front_registroJugador);
                gui.revalidate();
                gui.repaint();
            }


            case 7 ->{
                gui.setContentPane(panel_6_continuar);
                gui.revalidate();
                gui.repaint();
            }

            // Ingresa al juego y lo reanuda donde queda
            case 8->{
//                panel_4_juego = new Panel_4_juego(panel_4_juego.getJuego());
//                panel_4_juego.start(); // inicializa timer
//                gui.setContentPane(panel_4_juego);
//                gui.revalidate();
//                gui.repaint();
            }
            case 9->{
                panel_7_niveles = new Panel_7_niveles();
                gui.setContentPane(panel_7_niveles);
                gui.revalidate();
                gui.repaint();;
            }

            case 10->{
                lanzador.seleccionar_pantalla(8);
            }

            case 12->{ // para presentar front jugador habitual
                gui.setContentPane(frontJugadorHabitual);
                gui.revalidate();
                gui.repaint();

            }
            default -> {
                System.out.println(" no hay mas pantallas");
            }

        }
    }


    private  void set_lanza_app(Lanza_app_Prueba iknow) {
        lanzador = iknow;
    }
    private  Lanza_app_Prueba get_lanza_app() {
        return lanzador;
    }

    /**
     * inner class implements Listeners used by Panel_1_Inicial class
     */
    public static class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand()== "ATRAS"){
                lanzador.seleccionar_pantalla(1);
            }

            else if(e.getActionCommand()== "AVANZAR"){
                lanzador.seleccionar_pantalla(1);
            }

            else if(e.getActionCommand()== "SALIR"){
                lanzador.seleccionar_pantalla(1);
            }

            else if(Objects.equals(e.getActionCommand(), "MENÚ")){ // muestra un menu
                lanzador.seleccionar_pantalla(2);
            }

            else if(Objects.equals(e.getActionCommand(), "COMO JUGAR")){ // va a reglas
                lanzador.seleccionar_pantalla(3);
            }

            else if(Objects.equals(e.getActionCommand(), "NUEVO JUEGO")){ // va a registro jugador
                lanzador.seleccionar_pantalla(6);
            }

            else if(Objects.equals(e.getActionCommand(), "CONTINUAR")) {
                lanzador.seleccionar_pantalla(4);
            }

            else if(Objects.equals(e.getActionCommand(), "SEGUIR")) {
                lanzador.seleccionar_pantalla(9);
            }

            else if(Objects.equals(e.getActionCommand(), "OPCIONES")){
                lanzador.seleccionar_pantalla(5);
            }

            else if(Objects.equals(e.getActionCommand(), "INICIAR")){ // empieza a mostrar palabras en el Nivel 1 del juego
                lanzador.seleccionar_pantalla(4);
            }

            else if(Objects.equals(e.getActionCommand(), "ENTRAR")){
                lanzador.seleccionar_pantalla(3);
            }

            else if(Objects.equals(e.getActionCommand(), "SIGUIENTE")){
                lanzador.seleccionar_pantalla(4);
            }

            else if(Objects.equals(e.getActionCommand(), "REPETIR")){
                lanzador.seleccionar_pantalla(4);
            }
        }
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            try {
                lanzador = new Lanza_app_Prueba();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

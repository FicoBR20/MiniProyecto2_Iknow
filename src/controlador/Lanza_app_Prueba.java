package controlador;

import modelo.Juego;
import modelo.Palabra;
import vista.*;
import vista.Panel_4_juego;
import vista.Front_RegistroJugador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;


public class Lanza_app_Prueba {
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

    private  Palabra palabra;
    private Juego juego;
    private Jugador jugador;
    private int numero, navegar;
    private String texto;
    private static Lanza_app_Prueba bill = null;


    /**
     * Método constructor
     */
    public Lanza_app_Prueba() throws IOException {
        gui = new GUI();
        juego = new Juego();
        jugador = new Jugador();
        panel_0_bienvenida = new Panel_0_bienvenida();
        panel_1_inicial = new Panel_1_Inicial();
        panel_3_reglas = new Panel_3_reglas();
        panel_2_menu = new Panel_2_menu();
        panel_5_opciones = new Panel_5_opciones();
        panel_6_continuar = new Panel_6_continuar();
        panel_7_niveles = new Panel_7_niveles();
        front_registroJugador = new Front_RegistroJugador();

        seleccionar_pantalla(4);
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
               // secuencia_Logica(9);
            }
            case 2 ->{
                gui.setContentPane(panel_2_menu);
                gui.revalidate();
                gui.repaint();
            }
            case 3 ->{
                panel_3_reglas = new Panel_3_reglas();
                gui.setContentPane(panel_3_reglas);
                gui.revalidate();
                gui.repaint();
            }
            case 4 ->{
                juego.incrementar_nivel();
                System.out.println("Nivel "+juego.getNivel());
                panel_4_juego = new Panel_4_juego(juego,jugador);
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

            case 8->{
                gui.setContentPane(panel_4_juego);
                gui.revalidate();
                gui.repaint();;
            }
            case 9->{
                gui.setContentPane(panel_7_niveles);
                gui.revalidate();
                gui.repaint();;
            }
            case 10->{
                // se debe preguntar si supero el nivel.
                //....nivel +1
                jugador = panel_4_juego.getJugador();

                juego = panel_4_juego.getJuego();
                juego.incrementar_nivel();
                juego.setUp_Nivel(juego.getNivel());

                panel_4_juego = new Panel_4_juego(juego);
                bill.seleccionar_pantalla(4);

            }
            default -> {
                System.out.println(" no hay mas pantallas");
            }

        }


    }


    private  void set_lanza_app(Lanza_app_Prueba iknow) {
        bill = iknow;
    }
    private  Lanza_app_Prueba get_lanza_app() {
        return bill;
    }

    /**
     * inner class implements Listeners used by Panel_1_Inicial class
     */
    public static class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand()== "ATRAS"){
                bill.seleccionar_pantalla(1);
            }
            else if(e.getActionCommand()== "SALIR"){
                bill.seleccionar_pantalla(1);
            }

            else if(Objects.equals(e.getActionCommand(), "MENÚ")){
                bill.seleccionar_pantalla(2);
            }

            else if(Objects.equals(e.getActionCommand(), "COMO JUGAR")){
                bill.seleccionar_pantalla(3);
            }

            else if(Objects.equals(e.getActionCommand(), "NUEVO JUEGO")){
                bill.seleccionar_pantalla(6);
            }

            else if(Objects.equals(e.getActionCommand(), "CONTINUAR")) {
                bill.seleccionar_pantalla(9);
            }

            else if(Objects.equals(e.getActionCommand(), "SEGUIR")) {
                bill.seleccionar_pantalla(9);
            }

            else if(Objects.equals(e.getActionCommand(), "1")) {
                bill.seleccionar_pantalla(8);
            }

            else if(Objects.equals(e.getActionCommand(), "OPCIONES")){
                bill.seleccionar_pantalla(5);
            }

            else if(Objects.equals(e.getActionCommand(), "INICIAR")){
                bill.seleccionar_pantalla(4);
            }

            else if(Objects.equals(e.getActionCommand(), "ENTRAR")){
                bill.seleccionar_pantalla(3);
            }

            else if(Objects.equals(e.getActionCommand(), "SIGUIENTE")){
                bill.seleccionar_pantalla(10);
            }

            else if(Objects.equals(e.getActionCommand(), "REPETIR")){
                bill.seleccionar_pantalla(4);
            }

        }

    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            try {
                bill = new Lanza_app_Prueba();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

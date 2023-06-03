package controlador;

import modelo.Juego;
import vista.Canvas;
import vista.Front_Inicial;
import vista.Front_Reglas;
import vista.GUI;

import java.awt.*;


public class Lanza_app_Prueba {
    private GUI gui;
    private Canvas canvas;
    private Front_Inicial front_inicial;
    private Front_Reglas front_reglas;
    private Juego juego;


    /**
     * Método constructor
     */
    public Lanza_app_Prueba(){
        System.out.println(" ..empieza tu juego..");

        gui = new GUI();
        canvas = new Canvas();
        front_inicial = new Front_Inicial();
        front_reglas = new Front_Reglas();

        seleccionar_pantalla(2);
    }


    public void seleccionar_pantalla( int set_panel){
        switch (set_panel) {

            case 1 -> gui.add(canvas);
            case 2 -> gui.add(front_inicial);
            case 3 -> gui.add(front_reglas);
        }
        gui.initGUI();

    }


    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Lanza_app_Prueba iknow = new Lanza_app_Prueba();
        });
    }

}

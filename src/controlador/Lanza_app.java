package controlador;
import modelo.Juego;
import vista.Front_Inicial;
import vista.GUI;
import vista.Front_Inicial;
;

import java.awt.*;


public class Lanza_app {
    private GUI gui;
    private Juego juego;

    private int receptor;


    /**
     * Método constructor
     */
    public Lanza_app(){

        System.out.println(" ..empieza tu juego..");
        launch_App();
        receptor = 9999;

    }



    public void launch_App(){

        System.out.println(" estamos completando los 10 niveles");

        juego = new Juego();
        gui = new GUI();

        gui.lanza_frames(juego.getEstado());//estado=1
        System.out.println(" receptor vale arriba"+receptor);








    }








    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Lanza_app iknow = new Lanza_app();
        });
    }

}

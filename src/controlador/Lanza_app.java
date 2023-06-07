package controlador;
import modelo.Juego;
import resources.GUI;
import vista.Prueba_Frame_001_Inicial;
;

import java.awt.*;


/**
 * Clase que gestiona el lanzamiento de la app.
 */
public class Lanza_app {
    private Prueba_Frame_001_Inicial pfi;
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

        System.out.println(" intentamos completar los 10 niveles");

        juego = new Juego();
        pfi = new Prueba_Frame_001_Inicial();

        pfi.lanza_frames(juego.getEstado());


        System.out.println(" receptor vale arriba"+receptor);




    }



    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Lanza_app iknow = new Lanza_app();
        });
    }

}

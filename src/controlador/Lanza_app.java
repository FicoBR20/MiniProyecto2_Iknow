package controlador;
import modelo.Juego;
import vista.GUI;
;

import java.awt.*;


public class Lanza_app {
    private GUI gui;
    private Juego juego;





    /**
     * Método constructor
     */
    public Lanza_app(){

        System.out.println(" ..empieza tu juego..");
        gui = new GUI();
        juego = new Juego();
        launch_App();

    }



    public void launch_App(){

        if (juego.getEstado()<99){

            System.out.println(" estamos completando los 10 niveles");

            GUI gui1 = new GUI();
            gui1.frame_001_Inicio();







            // aquí debera ir la funcion de cierre cundo el jugados haya superado el nivel 10
        }

    }











    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Lanza_app iknow = new Lanza_app();
        });
    }

}

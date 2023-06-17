package controlador;

import java.awt.*;
import java.util.Scanner;

public class Persistencia {
    private Control_FileManager controlFileManager;
    private Scanner scanner;

    /**
     * Método constructor
     */
    public Persistencia() {
        inicio();
    }

    public void inicio(){
        controlFileManager = new Control_FileManager();
        scanner = new Scanner(System.in);
        String[] datos = new String[3];
        String texto = "";

        System.out.println("Jugador ");
        texto = scanner.nextLine();

        //Escribe
        controlFileManager.writer_Jugador_con_indice(texto);

//        //Rescribe segun indice
//        controlFileManager.reescribir_Datos(texto);

        datos = (controlFileManager.leer_Datos_ultimo_jugador());
        System.out.println("______________________________________");
        System.out.println("Nombre = "+datos[0]+"        Nombre = "+datos[1]+"       Nivel = "+datos[2]+"        Puntos = "+datos[3]);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
//            int intento = 0;
//            while (intento <4){
                Persistencia ff = new Persistencia();
//                intento++;
//            }
        });
    }


}

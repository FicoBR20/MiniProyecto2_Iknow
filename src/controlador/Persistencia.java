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
//        controlFileManager = new Control_FileManager();
//        scanner = new Scanner(System.in);
//        String[] datos = new String[3];
//        String texto = "";

//        System.out.println("Jugador ");
//        texto = scanner.nextLine();

        //Escribe
//        controlFileManager.reescribir_Datos(texto);

//        //Rescribe segun indice
//        controlFileManager.reescribir_Datos(texto);

//        datos = (controlFileManager.leer_ultimo_jugador());

//        for (int i = 0; i < new Control_FileManager().reader_Jugador().size(); i++) {
//            System.out.println("Dato "+new Control_FileManager().reader_Jugador().get(i));
//        }
//        System.out.println("Nombre = "+datos[0]+"        Nombre = "+datos[1]+"       Nivel = "+datos[2]+"        Puntos = "+datos[3]);
            System.out.println("Dato "+new Control_FileManager().reader_Jugador().get(0));
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

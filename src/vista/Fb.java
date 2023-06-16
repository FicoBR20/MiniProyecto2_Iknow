package vista;

import controlador.Control_FileManager;
import controlador.Lanza_app_Prueba;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Fb {
    private Control_FileManager controlFileManager;
    private Scanner scanner;

    public Fb () {
        scanner = new Scanner(System.in);
        String texto = "_________";

        System.out.println("Jugador ");
        texto = scanner.nextLine();

        new Control_FileManager().writer_Jugador(texto);
        texto = (controlFileManager.leer_ultimo_jugador());
        System.out.println("___________c___________________________");
        System.out.println(texto);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {

                Fb ff = new Fb();
        });
    }


}

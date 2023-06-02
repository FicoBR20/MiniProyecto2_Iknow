package controlador;

import modelo.Juego;
import modelo.Palabra;
import modelo.String_Basico;

import java.io.IOException;
import java.util.Scanner;

public class Lounch_Provicional {
    private  Boolean acierto;
    private  String_Basico stringBasico;
    private static Palabra palabra;

    public Lounch_Provicional() {
        stringBasico = new String_Basico();
        acierto = false;
    }

    public static void ini(){
        System.out.println("Palabras Del nivel\n");
        for (int i = 0; i <= palabra.getPalabra_del_nivel().size()-1; i++){
            System.out.println("Palabra = "+(i+1)+" "+palabra.getPalabra_del_nivel().get(i));
        }
        System.out.println("\nPalabras a memorizar\n");
        for (int i = 0; i <= palabra.getPalabra_a_Memorizar().size()-1; i++){
            System.out.println("Palabra = "+(i+1)+" "+palabra.getPalabra_a_Memorizar().get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese un número: ");
        int numero = scanner.nextInt();

        while (numero != 0){
            palabra.comparacion(palabra.getPalabra_del_nivel().get(numero-1),palabra.getPalabra_a_Memorizar());
            System.out.print("\nIngrese un número: ");
            numero = scanner.nextInt();
        }
    }


    //Usa la consola para pruebas
    public static void main(String[] args) throws IOException {
        Juego juego = new Juego();
        palabra = new Palabra();
        palabra.setPalabra_del_nivel(juego.setCategoria(3));
        palabra.setPalabra_a_Memorizar();
        ini();
    }
}

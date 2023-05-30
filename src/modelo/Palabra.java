package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Palabra {
    private  Boolean acierto;
    private final List<String>  palabra_a_Memorizar;
    private final List<String> palabra_del_Nivel;
    private  List<String> Lista_palabra_a_Memorizar;

    public  List<String>  getPalabra_a_Memorizar() {
        return palabra_a_Memorizar;
    }

    public void setPalabra_del_nivel(String categoria) throws IOException {
        for (int i = 0; i < 20; i++){
            String memoria = seleccionarPalabraAleatoria(obtenerPalabras(categoria));
            if (!palabra_del_Nivel.contains(memoria)) {
                palabra_del_Nivel.add(memoria);
            }
            else{
                String aux = "";
                while (palabra_del_Nivel.contains(memoria)){
                    memoria = seleccionarPalabraAleatoria(obtenerPalabras(categoria));
                    aux = memoria;
                }
                palabra_del_Nivel.add(aux);
            }
        }

    }


    public void setPalabra_a_Memorizar(String categoria) throws IOException {
        for (int i = 0; i < 10; i++){
            String memoria = seleccionarPalabraAleatoria(palabra_del_Nivel);
            if (!palabra_a_Memorizar.contains(memoria)) {
                palabra_a_Memorizar.add(memoria);
            }

            else{
                String aux = "";
                while (palabra_a_Memorizar.contains(memoria)){
                    memoria = seleccionarPalabraAleatoria(palabra_del_Nivel);
                    aux = memoria;
                }
                palabra_a_Memorizar.add(aux);
            }
        }
    }


    public Boolean getAcierto() {
        return acierto;
    }

    public void setAcierto(Boolean acierto) {
        this.acierto = acierto;
    }


    /**
     * Método constructor
     */
    public Palabra(){
        palabra_a_Memorizar = new ArrayList<>();
        palabra_del_Nivel = new ArrayList<>();
        acierto = false;
    }


    //Crea un método para leer el archivo de texto y obtener las palabras
    public List<String> obtenerPalabras(String archivo) throws IOException {
        Lista_palabra_a_Memorizar = new ArrayList<>();

        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String linea;

        while (lector.readLine() != null){
            linea = lector.readLine();
            linea.split("\n");
            //Recorre cada letra de una palabra
            for (String palabra : linea.split("\n")) {
                // Remplaza cualquier caracter que no sea alfabetico con un espacio vacio
                palabra = palabra.replaceAll("^[^a-zA-Z]+|[^a-zA-Z]+$", "");
                if (!linea.isEmpty()) {
                    Lista_palabra_a_Memorizar.add(palabra);
                }
            }
        }

        lector.close();

        return Lista_palabra_a_Memorizar;
    }

    //Crea un método para seleccionar una palabra aleatoria del arreglo
    public String seleccionarPalabraAleatoria(List<String> palabras) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(palabras.size());
        return palabras.get(indiceAleatorio);
    }

    public void ini(){
        System.out.println("Palabras Del nivel\n");
        for (int i = 0; i <= palabra_del_Nivel.size()-1; i++){
            System.out.println("Palabra = "+(i+1)+" "+palabra_del_Nivel.get(i));
        }
        System.out.println("\nPalabras a memorizar\n");
        for (int i = 0; i <= palabra_a_Memorizar.size()-1; i++){
            System.out.println("Palabra = "+(i+1)+" "+palabra_a_Memorizar.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese un número: ");
        int numero = scanner.nextInt();

        while (numero != 0){
            if (palabra_a_Memorizar.contains(palabra_del_Nivel.get(numero-1))){
                System.out.println("\n"+palabra_del_Nivel.get(numero-1)+" es una palabra memorizada\n");
            }
            else {
                System.out.println("\n"+palabra_del_Nivel.get(numero-1)+" No es una palabra memorizada\n");
            }
            System.out.print("\nIngrese un número: ");
            numero = scanner.nextInt();
        }
    }


    //Usa la consola para pruebas
    public static void main(String[] args) throws IOException {
        Palabra palabra = new Palabra();
        palabra.setPalabra_del_nivel("src/modelo/animales.txt");
        palabra.setPalabra_a_Memorizar("src/modelo/animales.txt");
        palabra.ini();
    }


//    /**
//     * Método que retorna true si el string ingresado es idéntico
//     * a la palabra a memorizar.
//     * @param palabra lista_de_palabras
//     * @return
//     */
//    public  Boolean comparacion(String palabra, List<String> lista_de_palabras){
//        for (int i = 0; i < lista_de_palabras.size()-1; i++){
//            if (palabra == lista_de_palabras.get(i)){
//                acierto = true;
//                break;
//            }
//            else {
//                acierto = false;
//                break;
//            }
//
//        }
//            return acierto;
//    }
}

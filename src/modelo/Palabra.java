package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Palabra {
    private String palabra_a_Memorizar;
    private Boolean acierto;
    private  List<String> Lista_palabra_a_Memorizar;

    public String getPalabra_a_Memorizar() {
        return palabra_a_Memorizar;
    }

    public void setPalabra_a_Memorizar(String palabra_a_Memorizar) {
        this.palabra_a_Memorizar = palabra_a_Memorizar;
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
        ini();
        palabra_a_Memorizar = " ";
        acierto = false;
    }


    //Crea un método para leer el archivo de texto y obtener las palabras
    public List<String> obtenerPalabrasAleatorias(String archivo) throws IOException {
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

    //Usa los métodos de obtencion y seleccion a modo de prueba
    public void ini(){
        try {
            String archivo = "src/modelo/animales.txt";
            List<String> palabras = obtenerPalabrasAleatorias(archivo);

            if (!palabras.isEmpty()) {
                String palabraAleatoria = seleccionarPalabraAleatoria(palabras);
                System.out.println("Palabra aleatoria: " + palabraAleatoria);
            } else {
                System.out.println("No se encontraron palabras en el archivo.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Palabra palabra = new Palabra();
    }




    /**
     * Método que retorna true si el string ingresado es idéntico
     * a la palabra a memorizar.
     * @param ingresado
     * @return
     */
    public Boolean comparacion (String ingresado){
        if (ingresado == getPalabra_a_Memorizar()){
            acierto = true;
        }
        else {
            acierto = false;
        }
        return acierto;
    }

}

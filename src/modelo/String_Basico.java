package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Est clase me permite leer el archivo de (.txt) y obtener las palabras
 * y las almacena en un objeto de tipo Arraylist
 * recoje una lista de palabras
 * y selecciona una palabra aleatoria de ella.
 */
public class String_Basico {

    private  List<String> lista_palabra;


    public String_Basico() {
        lista_palabra = new ArrayList<>();
    }

    /**
     *Este método me permite leer el archivo de (.txt) y obtener las palabras
     * y las almacena en un objeto de tipo Arraylist
     * @param categoria
     * @return
     * @throws IOException
     */
    public List<String> obtenerPalabras(String categoria) throws IOException {

        BufferedReader lector = new BufferedReader(new FileReader(categoria));
        String linea;

        while (lector.readLine() != null){
            linea = lector.readLine();
            linea.split("\n");
            //Recorre cada letra de una palabra
            for (String palabra : linea.split("\n")) {
                // Remplaza cualquier caracter que no sea alfabetico con un espacio vacio
                palabra = palabra.replaceAll("^[^a-zA-Z]+|[^a-zA-Z]+$", "");
                if (!linea.isEmpty()) {
                    lista_palabra.add(palabra);
                }
            }
        }

        lector.close();

        return lista_palabra;
    }

    /**
     * Este método recoje una lista de palabras
     * y selecciona una palabra aleatoria de ella.
     * @param lista_palabras
     * @return
     */
    public String seleccionarPalabraAleatoria(List<String> lista_palabras) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(lista_palabras.size());
        return lista_palabras.get(indiceAleatorio);
    }
}




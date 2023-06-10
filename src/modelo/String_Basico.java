package modelo;

import java.io.*;
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
    private Juego juego;

    private  List<String> lista_palabra;
    private BufferedReader lector;


    public String_Basico() {
        juego = new Juego();
        lista_palabra = new ArrayList<>();
    }

    /**
     *Este método me permite leer el archivo de (.txt) y obtener las palabras
     * y las almacena en un objeto de tipo Arraylist
     * @param categoria
     * @return
     * @throws IOException
     */
    public List<String> obtenerPalabras(String categoria){

        try {
            lector = new BufferedReader(new FileReader(categoria));
            String linea;


            int limite = 0;
            while (limite <= juego.getLimite_string_basico()) {
                limite ++;
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
        } catch (FileNotFoundException e) {
            System.out.println("Estoy dentro de la excepcion");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                lector.close();
            }  catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                System.out.println("Estoy dentro del finally");
                e.printStackTrace();
            }
        }

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
        int indiceAleatorio = random.nextInt(lista_palabras.size()-1);
        return lista_palabras.get(indiceAleatorio);
    }
}




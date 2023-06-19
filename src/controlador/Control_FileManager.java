package controlador;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase que registrara la información del jugador
 * en un archivo de texto y la suministrará tomándola
 * de dicho archivo de texto.
 */
public class Control_FileManager {
    private Jugador jugador;
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    /**
     * Atributo del nombre del jugador,
     * se obtiene mediante la lectura
     * de un archivo de texto
     */
    private String nombre_Obtenido;
    /**
     * Atributo del último nivel de juego superado
     * por el jugador.
     */
    private String ultimo_nivel_Obtenido;
    /**
     * Atributo de los puntos acumulados que lleva
     * el jugador hasta el último nivel superado,
     * se obtiene mediante la lectura
     * de un archivo de texto
     */
    private String total_puntos_Obtenido;

    public String getNombre_Obtenido() {
        return nombre_Obtenido;
    }

    public void setNombre_Obtenido(String nombre_Obtenido) {
        this.nombre_Obtenido = nombre_Obtenido;
    }

    public String getUltimo_nivel_Obtenido() {
        return ultimo_nivel_Obtenido;
    }

    public void setUltimo_nivel_Obtenido(String ultimo_nivel_Obtenido) {
        this.ultimo_nivel_Obtenido = ultimo_nivel_Obtenido;
    }

    public String getTotal_puntos_Obtenido() {
        return total_puntos_Obtenido;
    }

    public void setTotal_puntos_Obtenido(String total_puntos_Obtenido) {
        this.total_puntos_Obtenido = total_puntos_Obtenido;
    }

    /**
     * Método constructor
     */
    public Control_FileManager() {
//        String inicio = "Carlos" + " " + "1" + " " + "10";
//        reader_Jugador()="";
        nombre_Obtenido = "";
        ultimo_nivel_Obtenido = "";
        total_puntos_Obtenido = "";
//        jugador = new Jugador();
    }

    /**
     * Método que lee el archivo de texto con la infomación
     * de los jugadores y genera un string con dicha información.
     *
     * @return
     */
    public ArrayList<String> reader_Jugador() {
        ArrayList<String> text = new ArrayList<>();



        try {
            fileReader = new FileReader("src/resources/file/info_Jugador.txt");
            input = new BufferedReader(fileReader);

            String line = input.readLine(); // almacena lo que se escribe en el text field


            String prueba = line;

            System.out.println(" lo de line " + line + " \n");

            while (line != null) {

                for (String i : line.split("\n")) {
                    text.add(line);
                }


//                text += line;
//                text += "\n";
//                line = input.readLine();


            }
        } catch (FileNotFoundException e) {
            System.out.println("Estoy dentro de la excepcion");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("Estoy dentro del finally");
                e.printStackTrace();
            }
        }

        System.out.println(" al final de reader entrega text " + text + " \n");


        return text;
    }

    /**
     * Método que recibe un string con la información de los jugadores
     * y la escribe sobre un archivo de texto.
     *
     * @param line
     */
    public void writer_Jugador(String line) { // llega un String
        try {
            String text = "";// recepciona el String generado en el reader.

            text += line + "\n";

            fileWriter = new FileWriter("src/resources/file/info_Jugador.txt");
            output = new BufferedWriter(fileWriter);
//
//            for (int i = 0; i < reader_Jugador().size(); i++) {
//                text = reader_Jugador().get(i);
//                output.write(text);
//            }

            output.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    /**
     * Método que rebibe el nombre de un jugador,
     * lo busca en la base de datos (archivo.txt), si existe,
     * extrae la informacion de nivel y puntos
     * para ser usada.
     *
     * @param nombre_buscado
     */
    public String entrega_Info_Detallada(String nombre_buscado) {

        String info_Actualizada=" ";

        ArrayList<String> listado_Registros = reader_Jugador();

        int auxiliar =0;


        if (listado_Registros.contains(nombre_buscado)) {

            auxiliar = listado_Registros.indexOf(nombre_buscado);

            info_Actualizada = listado_Registros.get(auxiliar);



        } else {
            JOptionPane.showMessageDialog(null, " Ese nombre no está en la base de datos\n" +
                    " es un jugador nuevo.");
        }

        return info_Actualizada;


    }


    /**
     * Método que registra la información actualizada de un
     * jugador existente en la base de datos. Adiciona un registro
     * nuevo con los datos del nombre, último nivel superado, puntos
     * acumulados.
     *
     * @param infoJugador_Habitual
     */
    public void actualiza_Info_Jugador(String infoJugador_Habitual) {

        String[] puntero = infoJugador_Habitual.split( " ");
        System.out.println(" el puntero es " + puntero[0]);

        String todosJuntos_Correctos = "";

        if (reader_Jugador().contains(puntero[0])) {
            todosJuntos_Correctos = infoJugador_Habitual + reader_Jugador();
            System.out.println(" ya con la actualizacion queda asi \n" + todosJuntos_Correctos);
        } else {
            JOptionPane.showMessageDialog(null, " Ese nombre no está en la base de datos\n" +
                    " es un jugador nuevo.");
        }

    }

    /**
     * Método que reemplaza la información de un jugador
     * previamente registrado, dejando solo un registro de
     * dicho jugador en el archivo de texto
     * @param infoNueva
     */
    public void reader_Jugador_reemplaza(String infoNueva) {
        String text = infoNueva.substring(0,5);//obtiene el nombre

        try {
            fileReader = new FileReader("src/resources/info_Jugador.txt");
            input = new BufferedReader(fileReader);

            String line = input.readLine(); // almacena lo que se escribe en el text field

            String nombre_Previo = line.substring(0,5);



            while (line != null) {

                if (text==nombre_Previo){
                    line=infoNueva;
                    line = input.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Estoy dentro de la excepcion");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("Estoy dentro del finally");
                e.printStackTrace();
            }
        }

        System.out.println(" Jugadores actualizados en nivel y puntos  " + reader_Jugador());


    }

    /**
     * Método que extrae la información del ultimon jugador
     * registrado en la base de datos
     * @return
     */
    public String[] leer_ultimo_jugador() {
        String[] text = reader_Jugador().toArray(new String[0]);
        int aux = reader_Jugador().size();

        text = reader_Jugador().get(aux).split (" ");

        return text;
    }

    /**
     * Método que recibe un nombre de jugador y entrega
     * la información actualizada del mismo.
     * @param nombreJug
     * @return
     */
    public String leer_Datos_Determinado_Jugador(String nombreJug) {
        String text = "";
        if (reader_Jugador().contains(nombreJug)){
            int aux = reader_Jugador().indexOf(nombreJug);

            text = reader_Jugador().get(aux);
        }

        return text;
    }

    public void escribir_Datos(String line) {
        try {
            String text = String.valueOf(reader_Jugador());// recepciona el String generado en el reader.
            text = line + "\n" + text;
            fileWriter = new FileWriter("src/resources/file/info_Jugador.txt");
            output = new BufferedWriter(fileWriter);
            output.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

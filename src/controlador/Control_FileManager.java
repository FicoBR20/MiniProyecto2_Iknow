package controlador;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    public String reader_Jugador() {
        String text = "";

        try {
            fileReader = new FileReader("src/resources/info_Jugador.txt");
            input = new BufferedReader(fileReader);

            String line = input.readLine(); // almacena lo que se escribe en el text field

            String prueba = line;

            System.out.println(" lo de line " + line + " \n");

            while (line != null) {
                text += line;
                text += "\n";
                line = input.readLine();
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
    public void writer_Jugador(String line) {
        try {
            String text = reader_Jugador();// recepciona el String generado en el reader.
            text += line + "\n";
            fileWriter = new FileWriter("src/resources/info_Jugador.txt");
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




    /**
     * Método que rebibe el nombre de un jugador,
     * lo busca en la base de datos (archivo.txt), si existe,
     * extrae la informacion de nivel y puntos
     * para ser usada.
     *
     * @param nombre_buscado
     */
    public void entrega_Info_Detallada(String nombre_buscado) {

        String listado_Registros = reader_Jugador();


        if (listado_Registros.contains(nombre_buscado)) {
            int puntodeinicio = listado_Registros.indexOf(nombre_buscado);
            if (!(listado_Registros.substring(puntodeinicio + 5, puntodeinicio + 6).equals(" "))) {
                System.out.println(" Los datos están mal tabulados ");
                JOptionPane.showMessageDialog(null, "los datos están mal tabulados");
            } else if (listado_Registros.substring(puntodeinicio + 7, puntodeinicio + 8).equals(" ")) {// en otros niveles
                setNombre_Obtenido(listado_Registros.substring(puntodeinicio, puntodeinicio + 5));
                setUltimo_nivel_Obtenido(String.valueOf(listado_Registros.substring(puntodeinicio + 6, puntodeinicio + 7)));
                setTotal_puntos_Obtenido(String.valueOf(listado_Registros.substring(puntodeinicio + 8)));

                System.out.println(" en lo que va la funcion el punto de inicio es " + puntodeinicio +
                        " el nombre es " + getNombre_Obtenido() + " el nivel es " + getUltimo_nivel_Obtenido() +
                        " el puntaje obtenido es " + getTotal_puntos_Obtenido());
            } else if (!(listado_Registros.substring(puntodeinicio + 7, puntodeinicio + 8).equals(" "))) {// en nivel 10
                setNombre_Obtenido(listado_Registros.substring(puntodeinicio, puntodeinicio + 5));
                setUltimo_nivel_Obtenido(String.valueOf(listado_Registros.substring(puntodeinicio + 6, puntodeinicio + 8)));
                setTotal_puntos_Obtenido(String.valueOf(listado_Registros.substring(puntodeinicio + 9)));

                System.out.println(" en lo que va la funcion el punto de inicio es " + puntodeinicio +
                        " el nombre es " + getNombre_Obtenido() + " el nivel es " + getUltimo_nivel_Obtenido() +
                        " el puntaje obtenido es " + getTotal_puntos_Obtenido());
            } else {
                JOptionPane.showMessageDialog(null, "los datos están mal tabulados");
            }


        } else {
            JOptionPane.showMessageDialog(null, " Ese nombre no está en la base de datos\n" +
                    " es un jugador nuevo.");
        }


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

        String puntero = infoJugador_Habitual.substring(0, 5);
        System.out.println(" el puntero es " + puntero);

        String todosJuntos_Correctos = reader_Jugador();


        if (todosJuntos_Correctos.contains(puntero)) {
            todosJuntos_Correctos = infoJugador_Habitual + todosJuntos_Correctos;
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

    public String leer_ultimo_jugador() {
        String text = "";
        for (String linea : reader_Jugador().split("\n")){
            text = linea;
        }
        String[] paso = text.split(" ");
        return paso[0];
    }


}

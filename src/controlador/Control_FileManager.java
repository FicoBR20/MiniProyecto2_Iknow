package controlador;

import modelo.Juego;
import vista.Front_RegistroJugador;

import java.io.*;

/**
 * Clase que registrara la información del jugador
 * en un archivo de texto
 */
public class Control_FileManager {
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

//    /**
//     * Arraylist con la info de los jugadores.
//     */
//    private ArrayList<String>jugadores = new ArrayList<String>();
    /**
     * corresponde a la información que está registrada en el archivo de texto.
     */
    private String info_Completa_Jugador = (new Front_RegistroJugador().getName_Player()) + " " + Integer.toString( new Juego().getNivel());

    public String getInfo_Completa_Jugador() {
        return info_Completa_Jugador;
    }

    public void setInfo_Completa_Jugador(String el_player) {
        String nombre_Obtenido = "";
        String nivel_Obtenido= "";
        String puntos_Obtenido= "";

        if (reader_Jugador().contains(el_player)){
            nombre_Obtenido = el_player;
            int puntodeinicio = reader_Jugador().indexOf(el_player);
            nivel_Obtenido = String.valueOf(reader_Jugador().charAt(puntodeinicio+el_player.length()+2));
            puntos_Obtenido = String.valueOf(reader_Jugador().charAt(puntodeinicio+2));

            System.out.println(" en lo que va la funcion es " + nombre_Obtenido + " " + nivel_Obtenido +
                    " " + puntos_Obtenido);


        }


        el_player = nivel_Obtenido + " " + nivel_Obtenido + " " + puntos_Obtenido;

        this.info_Completa_Jugador = el_player;
    }


    /**
     * Metodo que genera un string del registro de los jugadores
     * en el archivo de texto info_Jugador.txt.
     * @return
     */
    public String reader_Jugador(){
        String text = "";

        try {
            fileReader = new FileReader("src/resources/file/info_Jugador.txt");
            input = new BufferedReader(fileReader);

            String line = input.readLine(); // almacena lo que se escribe en el text field

            String prueba = line;

            System.out.println(" lo de line " + line +" \n");

            while(line != null){
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
            }  catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                System.out.println("Estoy dentro del finally");
                e.printStackTrace();
            }
        }

        System.out.println(" al final de reader entrega text " + text +" \n");


        return text;
    }

    public void writer_Jugador(String line){
        try {
            String text = reader_Jugador();// recepciona el String generado en el reader.
            text += line + "\n";
            fileWriter = new FileWriter("src/resources/file/info_Jugador.txt");
            output = new BufferedWriter(fileWriter);
            output.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void entrega_Info_Detallada(String nombre){

        String nombre_Obtenido;
        String nivel_Obtenido;
        String puntos_Obtenido;

        if (reader_Jugador().contains(nombre)){
            nombre_Obtenido = nombre;
            int puntodeinicio = reader_Jugador().indexOf(nombre);
            nivel_Obtenido = String.valueOf(reader_Jugador().charAt(puntodeinicio+nombre.length()+2));
            puntos_Obtenido = String.valueOf(reader_Jugador().charAt(puntodeinicio+2));

            System.out.println(" en lo que va la funcion es " + nombre_Obtenido + " " + nivel_Obtenido +
                    " " + puntos_Obtenido);


        }
    }
}

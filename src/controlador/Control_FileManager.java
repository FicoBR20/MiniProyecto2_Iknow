package controlador;

import modelo.Juego;
import vista.Front_RegistroJugador;

import javax.swing.*;
import java.io.*;

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
    private String nivel_Obtenido;
    /**
     * Atributo de los puntos acumulados que lleva
     * el jugador hasta el último nivel superado,
     * se obtiene mediante la lectura
     * de un archivo de texto
     */
    private String puntos_Obtenido;

    public String getNombre_Obtenido() {
        return nombre_Obtenido;
    }

    public void setNombre_Obtenido(String nombre_Obtenido) {
        this.nombre_Obtenido = nombre_Obtenido;
    }

    public String getNivel_Obtenido() {
        return nivel_Obtenido;
    }

    public void setNivel_Obtenido(String nivel_Obtenido) {
        this.nivel_Obtenido = nivel_Obtenido;
    }

    public String getPuntos_Obtenido() {
        return puntos_Obtenido;
    }

    public void setPuntos_Obtenido(String puntos_Obtenido) {
        this.puntos_Obtenido = puntos_Obtenido;
    }

    /**
     * Método constructor
     */
    public Control_FileManager(){
        nombre_Obtenido = "";
        nivel_Obtenido = "";
        puntos_Obtenido = "";
        jugador = new Jugador();
    }

    /**
     * Método que lee el archivo de texto con la infomación
     * de los jugadores y genera un string con dicha información.
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

    /**
     * Método que recibe un string con la información de los jugadores
     * y la escribe sobre un archivo de texto.
     * @param line
     */
    public void writer_Jugador(String line){
       String infoActualizada = jugador.ToString_Jugador();
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


    /**
     * Método que rebibe el nombre de un jugador,
     * lo busca en la lista y saca la informacion
     * para ser usada.
     * @param nombre_buscado
     */
    public void entrega_Info_Detallada(String nombre_buscado){

        String listado_Registros = reader_Jugador();



        if (listado_Registros.contains(nombre_buscado)){
            int puntodeinicio = listado_Registros.indexOf(nombre_buscado);
            if (!(listado_Registros.substring(puntodeinicio+5, puntodeinicio+6).equals(" ") )) {
                System.out.println(" Los datos están mal tabulados ");
                JOptionPane.showMessageDialog(null, "los datos están mal tabulados");
            }
            else if (listado_Registros.substring(puntodeinicio+7, puntodeinicio+8).equals(" ") ) {// en otros niveles
                setNombre_Obtenido(listado_Registros.substring(puntodeinicio, puntodeinicio + 5));
                setNivel_Obtenido(String.valueOf(listado_Registros.substring(puntodeinicio + 6, puntodeinicio + 7)));
                setPuntos_Obtenido(String.valueOf(listado_Registros.substring(puntodeinicio + 8)));

                System.out.println(" en lo que va la funcion el punto de inicio es " + puntodeinicio +
                        " el nombre es " + getNombre_Obtenido() + " el nivel es " + getNivel_Obtenido() +
                        " el puntaje obtenido es " + getPuntos_Obtenido());
            } else if (!(listado_Registros.substring(puntodeinicio+7, puntodeinicio+8).equals(" ") )) {// en nivel 10
                setNombre_Obtenido(listado_Registros.substring(puntodeinicio, puntodeinicio + 5));
                setNivel_Obtenido(String.valueOf(listado_Registros.substring(puntodeinicio + 6, puntodeinicio + 8)));
                setPuntos_Obtenido(String.valueOf(listado_Registros.substring(puntodeinicio + 9)));

                System.out.println(" en lo que va la funcion el punto de inicio es " + puntodeinicio +
                        " el nombre es " + getNombre_Obtenido() + " el nivel es " + getNivel_Obtenido() +
                        " el puntaje obtenido es " + getPuntos_Obtenido());
            }

            else {
                JOptionPane.showMessageDialog(null, "los datos están mal tabulados");
            }


        }
        else{
            JOptionPane.showMessageDialog(null, " Ese nombre no está en la base de datos\n" +
                    " es un jugador nuevo.");
        }


    }


    /**
     * Método que recibe la información de un jugador y la actualiza
     * para ser escrita
      * @param infoJugador_Solo
     */
    public void actualiza_Info_Jugador(String infoJugador_Solo){

        String puntero = infoJugador_Solo.substring(0, 5);
        System.out.println(" el puntero es " + puntero);

        //todosJuntos_Correctos será el Buffer reader

        String todosJuntos_Correctos = reader_Jugador();


        if (todosJuntos_Correctos.contains(puntero)){
            int puntodeinicio = todosJuntos_Correctos.indexOf(puntero);
            if (todosJuntos_Correctos.substring(puntodeinicio+6, puntodeinicio+7).equals(" ") ) {// en nivel < 10
                String dataOld = todosJuntos_Correctos.substring(puntodeinicio, puntodeinicio+ infoJugador_Solo.length());
                char old = ' ';
                char nueva = ' ';
                for (int i = 0; i < infoJugador_Solo.length(); i++) {

                    old = dataOld.charAt(i);
                    nueva = infoJugador_Solo.charAt(i);
                    todosJuntos_Correctos.replace(old,nueva);

                }

                System.out.println(" ya con la actualizacion queda asi " + todosJuntos_Correctos);


                System.out.println(" data old  es " + dataOld + " tamaño de nombre es " + infoJugador_Solo.length() +
                        " tamaño de data old es " + dataOld.length());

            }

            else if (!(todosJuntos_Correctos.substring(puntodeinicio+5, puntodeinicio+6).equals(" ") )) {
                System.out.println(" Los datos están mal tabulados " + puntodeinicio);
                JOptionPane.showMessageDialog(null, "los datos están mal tabulados");
            }

            else {

                System.out.println(" hay que revisar");
            }


        }
        else{
            JOptionPane.showMessageDialog(null, " Ese nombre no está en la base de datos\n" +
                    " es un jugador nuevo.");
        }

    }
}

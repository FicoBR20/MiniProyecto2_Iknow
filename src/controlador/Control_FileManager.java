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
    private String info_Completa_Jugador = (new Front_RegistroJugador().getName_Player()) + " " + Integer.toString( new Juego().getNivel());

    public String getInfo_Completa_Jugador() {
        return info_Completa_Jugador;
    }

    public void setInfo_Completa_Jugador(String info_Completa_Jugador) {
        this.info_Completa_Jugador = info_Completa_Jugador;
    }


    public String reader_Jugador(){
        String text = "";

        try {
            fileReader = new FileReader("src/resources/file/info_Jugador.txt");
            input = new BufferedReader(fileReader);
            String line = input.readLine(); // almacena lo que se escribe en el text field

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
}

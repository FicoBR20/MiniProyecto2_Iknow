package vista;

import controlador.Jugador;

import javax.swing.*;
import java.io.*;

public class Probadora_de_Textos extends JFrame {

    private Jugador jugador;

    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;



    JTable jTable = new JTable();

    String datosJugador = "Carlo" + " " + "1" + " " + "10" + "\n";
    String datosJugador2 = "luisa" + " " + "3" + " " + "200" + "\n";
    String datosJugador3 = "maria" + " " + "10" + " " + "100" + "\n";
    String datosJugador4 = "josua" + " " + "7" + " " + "10000" + "\n";

    // JUGADORES CON ERROR DE TABULACION
    String jugadorErrado1 = "marta" + "7" + "   " + "10000" + "\n";
    String jugadorErrado2 = "zulia" + "  " + "710" + "   " + "10000" + "\n";

    // STRING CON LOS JUGADORES CORRECTAMENTE TABULADOS
    String todosJuntos_Correctos = datosJugador + datosJugador2 + datosJugador3 + datosJugador4;

    // STRING CON LOS JUGADORES ERRONEAMENTE TABULADOS
    String todojuntoErrores = datosJugador + datosJugador2 + datosJugador3 + datosJugador4 + jugadorErrado1 + jugadorErrado2;

    public Probadora_de_Textos() {

        jugador = new Jugador();

        //Default JFrame configuration
//        this.setTitle("Probadora de textos");
//        this.setSize(800,500);
//        //this.pack();
//        this.setResizable(true);
//        this.setVisible(true);
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void init() {
        jTable = new JTable();


    }


    public void entrega_Info_Detallada(String nombre) {

        String nombre_Obtenido;
        String nivel_Obtenido;
        String puntos_Obtenido;

        if (todosJuntos_Correctos.contains(nombre)) {
            int puntodeinicio = todosJuntos_Correctos.indexOf(nombre);
            if (!(todosJuntos_Correctos.substring(puntodeinicio + 5, puntodeinicio + 6).equals(" "))) {
                System.out.println(" Los datos están mal tabulados ");
                JOptionPane.showMessageDialog(null, "los datos están mal tabulados");
            } else if (todosJuntos_Correctos.substring(puntodeinicio + 7, puntodeinicio + 8).equals(" ")) {// en otros niveles
                nombre_Obtenido = todosJuntos_Correctos.substring(puntodeinicio, puntodeinicio + 5);
                nivel_Obtenido = String.valueOf(todosJuntos_Correctos.substring(puntodeinicio + 6, puntodeinicio + 7));
                puntos_Obtenido = String.valueOf(todosJuntos_Correctos.substring(puntodeinicio + 8));

                System.out.println(" en lo que va la funcion el punto de inicio es " + puntodeinicio +
                        " el nombre es " + nombre_Obtenido + " el nivel es " + nivel_Obtenido +
                        " el puntaje obtenido es " + puntos_Obtenido);
            } else if (!(todosJuntos_Correctos.substring(puntodeinicio + 7, puntodeinicio + 8).equals(" "))) {// en nivel 10
                nombre_Obtenido = todosJuntos_Correctos.substring(puntodeinicio, puntodeinicio + 5);
                nivel_Obtenido = String.valueOf(todosJuntos_Correctos.substring(puntodeinicio + 6, puntodeinicio + 8));
                puntos_Obtenido = String.valueOf(todosJuntos_Correctos.substring(puntodeinicio + 9));

                System.out.println(" en lo que va la funcion el punto de inicio es " + puntodeinicio +
                        " el nombre es " + nombre_Obtenido + " el nivel es " + nivel_Obtenido +
                        " el puntaje obtenido es " + puntos_Obtenido);
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
     * jugador previamente inscrito en la base de datos (archivo de texto)     NO REEMPLAZA
     * @param infoJugador_Solo
     */
    public void actualiza_Info_Jugador(String infoJugador_Solo) {

        String puntero = infoJugador_Solo.substring(0, 5);
        System.out.println(" el puntero es " + puntero);

        //todosJuntos_Correctos será el Buffer reader


        if (todosJuntos_Correctos.contains(puntero)) {
            todosJuntos_Correctos = infoJugador_Solo + todosJuntos_Correctos;
            System.out.println(" ya con la actualizacion queda asi \n" + todosJuntos_Correctos);
        }

        else {
            JOptionPane.showMessageDialog(null, " Ese nombre no está en la base de datos\n" +
                    " es un jugador nuevo.");
        }

}


    /**
     * Método que reemplaza la información de un jugador
     * previamente registrado, dejando solo un registro de
     * dicho jugador en el archivo de texto------------------>>>> SI REEMPLAZA
     *
     */
    public String reader_Jugador_1() {

        String jug_NuevoRegistro = "rosos 1 0" ; // como está en el Doc

        jugador.setName(jug_NuevoRegistro);


        String text = jugador.getName();//obtiene el nombre
        String receptor ="";

        System.out.println(" este es text " + text);


        try {
            fileReader = new FileReader("src/resources/info_Jugador_1.txt");
            input = new BufferedReader(fileReader);

            String line = input.readLine(); // almacena lo que se escribe en el text field

            String nombre_Previo = line.substring(0,5);

            System.out.println(" este es nombrePrevio " + nombre_Previo);


            while (line != null) {

                if (text==nombre_Previo){
                    line=jugador.ToString_Jugador();
                    receptor+=line;



        System.out.println(" la linea actualizada es" + line);// se imprime la linea actualizada que NO se repitio

                    line = input.readLine();
                }
                else {
                    receptor+=line;
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

        writer_Jugador_1(receptor);

    return receptor;

    }

    public void writer_Jugador_1(String line) {
        try {
            String text = reader_Jugador_1();// recepciona el String generado en el reader.
            text += line + "\n";
            fileWriter = new FileWriter("src/resources/info_Jugador_1.txt");
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




    public static void main(String[] args) {


//        String jug_OLdRegistro = "thtgf" +" "+ "1" + " " + "0" + "\n"; // como está en el Doc
//
//        String jug_NuevoRegistro = "thtgf" +" "+ "7" + " " + "80" + "\n"; // como está en el Doc


        JTable jTable = new JTable();

        String newInformation = "luisa" +" "+ "8" + " " + "200" + "\n";



        Probadora_de_Textos pt = new Probadora_de_Textos();
       // String resultado = " ";
        String nombre = "josua";

       // pt.entrega_Info_Detallada(nombre);

       pt.actualiza_Info_Jugador(newInformation);

       pt.reader_Jugador_1();
    }





}

package vista;

import javax.swing.*;

public class Probadora_de_Textos extends JFrame{

    JTable jTable = new JTable();

    String datosJugador = "Carlo" + " " + "1" + " " + "10" + "\n";
    String datosJugador2 = "luisa" + " " + "3" + " " + "200" + "\n";
    String datosJugador3 = "maria" + " " + "10" + " " + "100" + "\n";
    String datosJugador4 = "josua" + " " + "7" + " " + "10000" + "\n";

    // JUGADORES CON ERROR DE TABULACION
    String jugadorErrado1 = "marta"  + "7" + "   " + "10000" + "\n";
    String jugadorErrado2 = "zulia" + "  " + "710" + "   " + "10000" + "\n";

    // STRING CON LOS JUGADORES CORRECTAMENTE TABULADOS
    String todosJuntos_Correctos = datosJugador + datosJugador2 + datosJugador3 + datosJugador4;

    // STRING CON LOS JUGADORES ERRONEAMENTE TABULADOS
    String todojuntoErrores = datosJugador + datosJugador2 + datosJugador3 + datosJugador4 + jugadorErrado1 + jugadorErrado2;

    public Probadora_de_Textos(){

        //Default JFrame configuration
        this.setTitle("Probadora de textos");
        this.setSize(800,500);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void init(){
        jTable = new JTable();


    }




    public void entrega_Info_Detallada(String nombre){

        String nombre_Obtenido;
        String nivel_Obtenido;
        String puntos_Obtenido;

        if (todosJuntos_Correctos.contains(nombre)){
            int puntodeinicio = todosJuntos_Correctos.indexOf(nombre);
            if (!(todosJuntos_Correctos.substring(puntodeinicio+5, puntodeinicio+6).equals(" ") )) {
                System.out.println(" Los datos están mal tabulados ");
                JOptionPane.showMessageDialog(null, "los datos están mal tabulados");
            }
            else if (todosJuntos_Correctos.substring(puntodeinicio+7, puntodeinicio+8).equals(" ") ) {// en otros niveles
                nombre_Obtenido = todosJuntos_Correctos.substring(puntodeinicio, puntodeinicio + 5);
                nivel_Obtenido = String.valueOf(todosJuntos_Correctos.substring(puntodeinicio + 6, puntodeinicio + 7));
                puntos_Obtenido = String.valueOf(todosJuntos_Correctos.substring(puntodeinicio + 8));

                System.out.println(" en lo que va la funcion el punto de inicio es " + puntodeinicio +
                        " el nombre es " + nombre_Obtenido + " el nivel es " + nivel_Obtenido +
                        " el puntaje obtenido es " + puntos_Obtenido);
            } else if (!(todosJuntos_Correctos.substring(puntodeinicio+7, puntodeinicio+8).equals(" ") )) {// en nivel 10
                nombre_Obtenido = todosJuntos_Correctos.substring(puntodeinicio, puntodeinicio + 5);
                nivel_Obtenido = String.valueOf(todosJuntos_Correctos.substring(puntodeinicio + 6, puntodeinicio + 8));
                puntos_Obtenido = String.valueOf(todosJuntos_Correctos.substring(puntodeinicio + 9));

                System.out.println(" en lo que va la funcion el punto de inicio es " + puntodeinicio +
                        " el nombre es " + nombre_Obtenido + " el nivel es " + nivel_Obtenido +
                        " el puntaje obtenido es " + puntos_Obtenido);
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

    public static void main(String[] args) {

        JTable jTable = new JTable();


        Probadora_de_Textos pt = new Probadora_de_Textos();
       // String resultado = " ";
        String nombre = "josua";
        pt.entrega_Info_Detallada(nombre);
    }





}

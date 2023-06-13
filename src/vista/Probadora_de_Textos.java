package vista;

import javax.swing.*;

public class Probadora_de_Textos {

    String datosJugador = "Carlo" + " " + "1" + " " + "10" + "\n";
    String datosJugador2 = "luisa" + " " + "3" + " " + "200" + "\n";
    String datosJugador3 = "maria" + " " + "10" + " " + "100" + "\n";
    String datosJugador4 = "josua" + " " + "7" + " " + "10000" + "\n";

    String jugadorErrado1 = "marta"  + "7" + "   " + "10000" + "\n";
    String jugadorErrado2 = "zulia" + "  " + "710" + "   " + "10000" + "\n";

    String todosJuntos = datosJugador + datosJugador2 + datosJugador3 + datosJugador4;
    String todojuntoErrores = datosJugador + datosJugador2 + datosJugador3 + datosJugador4 + jugadorErrado1 + jugadorErrado2;




    public void entrega_Info_Detallada(String nombre){

        String nombre_Obtenido;
        String nivel_Obtenido;
        String puntos_Obtenido;

        if (todojuntoErrores.contains(nombre)){
            int puntodeinicio = todojuntoErrores.indexOf(nombre);
            if (!(todojuntoErrores.substring(puntodeinicio+5, puntodeinicio+6).equals(" ") )) {
                System.out.println(" Los datos están mal tabulados ");
                JOptionPane.showMessageDialog(null, "los datos están mal tabulados");
            }
            else if (todojuntoErrores.substring(puntodeinicio+7, puntodeinicio+8).equals(" ") ) {// en otros niveles
                nombre_Obtenido = todojuntoErrores.substring(puntodeinicio, puntodeinicio + 5);
                nivel_Obtenido = String.valueOf(todojuntoErrores.substring(puntodeinicio + 6, puntodeinicio + 7));
                puntos_Obtenido = String.valueOf(todojuntoErrores.substring(puntodeinicio + 8));

                System.out.println(" en lo que va la funcion el punto de inicio es " + puntodeinicio +
                        " el nombre es " + nombre_Obtenido + " el nivel es " + nivel_Obtenido +
                        " el puntaje obtenido es " + puntos_Obtenido);
            } else if (!(todojuntoErrores.substring(puntodeinicio+7, puntodeinicio+8).equals(" ") )) {// en nivel 10
                nombre_Obtenido = todojuntoErrores.substring(puntodeinicio, puntodeinicio + 5);
                nivel_Obtenido = String.valueOf(todojuntoErrores.substring(puntodeinicio + 6, puntodeinicio + 8));
                puntos_Obtenido = String.valueOf(todojuntoErrores.substring(puntodeinicio + 9));

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
        Probadora_de_Textos pt = new Probadora_de_Textos();
       // String resultado = " ";
        String nombre = "marta";
        pt.entrega_Info_Detallada(nombre);
    }





}

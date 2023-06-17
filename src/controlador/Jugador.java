package controlador;

import modelo.Juego;

import javax.swing.*;

/**
 * Clase que contiene la información relacionada con el jugador.
 */
public class Jugador{

    private  Control_FileManager lector_nombre;
   // private Juego juego;
    /**
     * Identificación del jugador.
     */
    private String name;
    /**
     * Nivel del juego que el jugador ya superó.
     * Su proximo juego iniciará en el nivel (nivel_Superado + 1)
     * el rango de valores estará entre [1 , 10]
     */
    private int nivel_Superado;

    /**
     * Indica la sumatoria de todos los puntos
     * incluye todos los niveles jugados superados.
     */
    private  int puntaje_Total;

    public String getName() {
        return name;
    }

    public void setName() {
       // this.name = lector_nombre.leer_ultimo_jugador();
        this.name = lector_nombre.leer_Datos_ultimo_jugador()[0];

//
//        JOptionPane.showMessageDialog(null,"..Linea 39.. ::Class Jugador::\n\n" +
//                "llego "+name);
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getNivel_Superado() {

        return nivel_Superado;
    }

    public void setNivel_Superado(int nivel_Superado) {

//        nivel_Superado=juego.getNivel();
        this.nivel_Superado = nivel_Superado;
    }

    public int getPuntaje_Total() {
        return puntaje_Total;
    }

    public void setPuntaje_Total(int total) {
//        total=get

//        puntaje_Total = juego.getPuntaje_juego();
        puntaje_Total = total;

    }

    /**
     * Métooo constructor
     */
    public Jugador( String nombreJugador){
        lector_nombre = new Control_FileManager();
        name = nombreJugador;
        nivel_Superado = 0;
        puntaje_Total = 0;

    }


    /**
     * Genera un String con la información del jugador.
     * @return info.
     */
    public String ToString_Jugador(){

        String info= "";
        info = getName() +" " +  getNivel_Superado() + " " + getPuntaje_Total() + "\n";

        return info;

    }

}

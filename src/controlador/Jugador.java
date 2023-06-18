package controlador;

import modelo.Juego;

import javax.swing.*;

/**
 * Clase que contiene la información relacionada con el jugador.
 */
public class Jugador{
    private  Control_FileManager lector_nombre;
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
       // Se lee nombre desde archivo
        this.name = lector_nombre.leer_Datos_ultimo_jugador()[0];

        //JOptionPane
//       JOptionPane.showMessageDialog(null,"..Linea 39.. ::Class Jugador::\n\n" +
//                "llego "+name);
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getNivel_Superado() {
        return nivel_Superado;
    }

    //todo revisar no nivel superado
    public void setNivel_Superado(int nivel_Superado) {
        this.nivel_Superado += nivel_Superado;
    }

    public int getPuntaje_Total() {
        return puntaje_Total;
    }

    public void setPuntaje_Total(Juego juego) {

        puntaje_Total= juego.getPuntaje_global();

    }

    /**
     * Métooo constructor
     */
    public Jugador(){
        lector_nombre = new Control_FileManager();
        name = " ";
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

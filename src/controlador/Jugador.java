package controlador;

import modelo.Juego;

/**
 * Clase que contiene la información relacionada con el jugador.
 */
public class Jugador {
    private Juego juego;
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

    public void setName(String name) {
        this.name = name;
    }

    public int getNivel_Superado() {
        return nivel_Superado;
    }

    public void setNivel_Superado(int nivel_Superado) {
        nivel_Superado=juego.getNivel();
        this.nivel_Superado = nivel_Superado;
    }

    public int getPuntaje_Total() {
        return puntaje_Total;
    }

    public void setPuntaje_Total(Juego juego) {

        puntaje_Total= juego.getPuntaje_Logrado_total_nivel();

    }

    /**
     * Métooo constructor
     */
    public Jugador(){
        juego = new Juego();
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

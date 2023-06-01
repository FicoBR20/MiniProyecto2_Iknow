package controlador;

/**
 * Clase que contiene la información relacionada con el jugador.
 */
public class Jugador {
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
        this.nivel_Superado = nivel_Superado;
    }

    public int getPuntaje_Total() {
        return puntaje_Total;
    }

    public void setPuntaje_Total(int puntaje_Total) {
        this.puntaje_Total = puntaje_Total;
    }

    /**
     * Métooo constructor
     */
    public Jugador(){
        name = " ";
        nivel_Superado = 0;

    }

    /**
     * Genera un String con la información del jugdor.
     * @return info.
     */
    public String ToString(){

        String info= "";
        info = getName() +" " +  getNivel_Superado() + " " + getPuntaje_Total();

        return info;

    }

}

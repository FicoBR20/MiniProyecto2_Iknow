package controlador;


import java.util.ArrayList;

/**
 * Clase que contiene la información relacionada con el jugador.
 */
public class Jugador{
    private  Control_FileManager lector_nombre;
    /**
     * Identificación del jugador.
     */
    private String nombre;
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

    public String getNombre() {

        return nombre;
    }

    //comentario Esto no es adecuado se debe hacer en el constructor
    public void setNombre_leido_de_Array() {
       // Se lee nombre desde archivo
        //TODO...se actualiza set nombre tomandolo del array.
        this.nombre = lector_nombre.array_leer_Datos_ultimo_jugador().get(0);
        //this.nombre = lector_nombre.leer_Datos_ultimo_jugador()[0];
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel_Superado() {
        return nivel_Superado;
    }

    //TODO revisar no nivel superado
    public void setNivel_Superado(int nivel_Superado) {
        this.nivel_Superado = nivel_Superado;
    }

    public int getPuntaje_Total() {
        return puntaje_Total;
    }

    public void setPuntaje_Total(int puntaje_Total) {
        this.puntaje_Total += puntaje_Total;
    }
    public void setPuntaje_Total() {
        this.puntaje_Total = Integer.parseInt(lector_nombre.leer_Datos_ultimo_jugador()[2]);
    }

    /**
     * Métooo constructor
     */
    //NOTA Cambié los iniciadores de juego
    public Jugador(){
        lector_nombre = new Control_FileManager();
        nombre = "___";
        nivel_Superado = 0;
        puntaje_Total = 0;
    }

    public void iniciar_datos(){

        String[] datos = lector_nombre.array_leer_Datos_ultimo_jugador().get(0).split(" ");

        nombre = datos[0];
        nivel_Superado = Integer.parseInt(datos[1]);
        puntaje_Total = Integer.parseInt(datos[2]);


//        nombre = lector_nombre.array_leer_Datos_ultimo_jugador().get(0).substring(0,5);
//        nivel_Superado = Integer.parseInt(lector_nombre.array_leer_Datos_ultimo_jugador().get(0).substring(6,7));
//        puntaje_Total = Integer.parseInt(lector_nombre.array_leer_Datos_ultimo_jugador().get(0).substring(8));

    }

    /**
     * Genera un String con la información del jugador.
     * @return info.
     */
    //NOTA esto enter "\n" no va ya esta en el metodo write de controlfilemanager
    public String ToString_Jugador(){

        String info= "";
        info = getNombre() +" " +  getNivel_Superado() + " " + getPuntaje_Total();

        return info;

    }

}

package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Palabra {
    private  Boolean acierto;
    private final List<String>  palabra_a_Memorizar;
    private final List<String> palabra_del_Nivel;
    private  String_Basico stringBasico;
    private Juego juego;

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public  List<String>  getPalabra_del_nivel() {
        return palabra_del_Nivel;
    }

    /**
     * Método que genera el string con la cantidad de palabras de cada nivel
     * @throws IOException
     */

    public void setPalabra_del_nivel() throws IOException {
        for (int i = 0; i < juego.getTotal_Palabras_del_Nivel(); i++){
            String memoria = stringBasico.seleccionarPalabraAleatoria(stringBasico.obtenerPalabras(juego.getRuta()));
            if (!palabra_del_Nivel.contains(memoria)) {
                palabra_del_Nivel.add(memoria);
            }
            else{
                String aux = "";
                while (palabra_del_Nivel.contains(memoria)){
                    memoria = stringBasico.seleccionarPalabraAleatoria(stringBasico.obtenerPalabras(juego.getRuta()));
                    aux = memoria;
                }
                palabra_del_Nivel.add(aux);
            }
        }

    }

    public  List<String>  getPalabra_a_Memorizar() {
        return palabra_a_Memorizar;
    }

    public void setPalabra_a_Memorizar(){
        for (int i = 0; i < juego.getCant_Palabras_a_Memorizar(); i++){
            String memoria = stringBasico.seleccionarPalabraAleatoria(palabra_del_Nivel);
            if (!palabra_a_Memorizar.contains(memoria)) {
                palabra_a_Memorizar.add(memoria);
            }
            else{
                String aux = "";
                while (palabra_a_Memorizar.contains(memoria)){
                    memoria = stringBasico.seleccionarPalabraAleatoria(palabra_del_Nivel);
                    aux = memoria;
                }
                palabra_a_Memorizar.add(aux);
            }
        }
    }


    public Boolean getAcierto() {
        return acierto;
    }

    public void setAcierto(Boolean acierto) {
        this.acierto = acierto;
    }


    /**
     * Método constructor
     */
    public Palabra(){
        juego = new Juego();
        stringBasico = new String_Basico();
        palabra_a_Memorizar = new ArrayList<>();
        palabra_del_Nivel = new ArrayList<>();
        acierto = false;
    }

    /**
     * Método que retorna true si la palabra esta en la lista de palabra a memorizar
     * @param palabra lista_de_palabras
     * @return
     */
    public  Boolean comparacion(String palabra, List<String> lista_de_palabras){
        if (lista_de_palabras.contains(palabra)){
            acierto = true;
            System.out.println("\n"+palabra+" es una palabra memorizada\n");
        }
        else {
            acierto = false;
            System.out.println("\n"+palabra+" No es una palabra memorizada\n");
        }
        return acierto;
    }

}

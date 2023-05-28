package modelo;

public class Palabra {
    private String palabra_a_Memorizar;
    private Boolean acierto;

    public String getPalabra_a_Memorizar() {
        return palabra_a_Memorizar;
    }

    public void setPalabra_a_Memorizar(String palabra_a_Memorizar) {
        this.palabra_a_Memorizar = palabra_a_Memorizar;
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
        palabra_a_Memorizar = " ";
        acierto = false;
    }

    /**
     * Método que retorna true si el string ingresado es idéntico
     * a la palabra a memorizar.
     * @param ingresado
     * @return
     */
    public Boolean comparacion (String ingresado){
        if (ingresado == getPalabra_a_Memorizar()){
            acierto = true;
        }
        else {
            acierto = false;
        }
        return acierto;
    }

}

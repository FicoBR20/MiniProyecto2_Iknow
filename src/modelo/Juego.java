package modelo;

public class Juego {

    private int nivel;
    private int palabras_a_Memorizar;
    private int palabras_del_nivel;
    private double acierto_Exigido;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPalabras_a_Memorizar() {
        return palabras_a_Memorizar;
    }

    public void setPalabras_a_Memorizar(int palabras_a_Memorizar) {
        this.palabras_a_Memorizar = palabras_a_Memorizar;
    }

    public int getPalabras_del_nivel() {
        return palabras_del_nivel;
    }

    public void setPalabras_del_nivel(int palabras_del_nivel) {
        this.palabras_del_nivel = palabras_del_nivel;
    }

    public double getAcierto_Exigido() {
        return acierto_Exigido;
    }

    public void setAcierto_Exigido(double acierto_Exigido) {
        this.acierto_Exigido = acierto_Exigido;
    }

    public Juego(){
        nivel =1;
        palabras_a_Memorizar = 10;
        palabras_del_nivel = 20;
        acierto_Exigido = 0.7;
    }

    public void setUp_Juego(int nivel_de_Juego){

        switch (nivel_de_Juego){
            case 1:
                palabras_a_Memorizar=10;
                palabras_del_nivel=20;
                acierto_Exigido=0.7;
                break;
            case 2:
                palabras_a_Memorizar=10;
                palabras_del_nivel=20;
                acierto_Exigido=0.7;
                break;
            case 3:
                palabras_a_Memorizar=10;
                palabras_del_nivel=20;
                acierto_Exigido=0.7;
                break;

        }
    }


}

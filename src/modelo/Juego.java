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

    /**
     * Método constructor
     */
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
                palabras_a_Memorizar=20;
                palabras_del_nivel=40;
                acierto_Exigido=0.7;
                break;
            case 3:
                palabras_a_Memorizar=25;
                palabras_del_nivel=50;
                acierto_Exigido=0.75;
                break;
            case 4:
                palabras_a_Memorizar=30;
                palabras_del_nivel=60;
                acierto_Exigido=0.8;
                break;
            case 5:
                palabras_a_Memorizar=35;
                palabras_del_nivel=70;
                acierto_Exigido=0.8;
                break;
            case 6:
                palabras_a_Memorizar=40;
                palabras_del_nivel=80;
                acierto_Exigido=0.85;
                break;
            case 7:
                palabras_a_Memorizar=50;
                palabras_del_nivel=100;
                acierto_Exigido=0.9;
                break;
            case 8:
                palabras_a_Memorizar=60;
                palabras_del_nivel=120;
                acierto_Exigido=0.9;
                break;
            case 9:
                palabras_a_Memorizar=70;
                palabras_del_nivel=140;
                acierto_Exigido=0.95;
                break;
            case 10:
                palabras_a_Memorizar=100;
                palabras_del_nivel=200;
                acierto_Exigido=1;
                break;
            default:
                palabras_a_Memorizar=0;
                System.out.println(" no hay mas palabras a memorizar ese nivel no existe");

        }
    }


}

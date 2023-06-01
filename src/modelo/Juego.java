package modelo;

/**
 * Esta Clase manejara la lógica del juego.
 */
public class Juego {
    /**
     * nivel: indica el nivel en que se desarrolla el juego

     * empieza en nivel 1.
     */
    private int nivel;
    /**

     * Cantidad de palabras que se le presentaran al jugador
     * y se deben memorizar para superar el nivel.
      */
    private int palabras_a_Memorizar;
    /**
     * Cantidad de palabras existentes en cada nivel
     * las cuales se le presentaran al jugador.
     * Están incluidas las palabras_a_Memorizar y las demás
     * que NO se le presentaron al jugador para ser memorizadas.
     */
    private int palabras_del_nivel;
    /**
     * Porcentaje de aciertos exigido
     * en cada nivel.
      */
    private double acierto_Exigido;
    /**
     * Acumulador que suma de a 10 puntos
     * por cada acierto del jugador.
     */
    private int puntaje_Logrado;

    /**
     * Una palabra se le presenta al jugador, el debe decidir en dos vías; SI Ó NO.
     *
     * DECISION DEL JUGADOR : SI -> la palabra SI está dentro del grupo de PALABRAS A MEMORIZAR.
     *                        NO -> la palabra NO está dentro del grupo de PALABRAS A MEMORIZAR.
     *
     * acierto_del_Jugador => true -> jugador acertó.
     *                     => false -> jugador NO acertó.
     */



    // From here implements the Class methods ==================================================

    /**
     * Constructor method.
     */
    public Juego(){

        puntaje_Logrado=0;
        acierto_del_Jugador=false;

    }

    // Getter and Setter ===============================

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCant_Palabras_a_Memorizar() {
        return cant_Palabras_a_Memorizar;
    }

    public void setCant_Palabras_a_Memorizar(int cant_Palabras_a_Memorizar) {
        this.cant_Palabras_a_Memorizar = cant_Palabras_a_Memorizar;
    }

    public int getTotal_Palabras_del_Nivel() {
        return total_Palabras_del_Nivel;
    }

    public void setTotal_Palabras_del_Nivel(int total_Palabras_del_Nivel) {
        this.total_Palabras_del_Nivel = total_Palabras_del_Nivel;
    }

    public double getAcierto_Exigido() {
        return acierto_Exigido;
    }

    public void setAcierto_Exigido(double acierto_Exigido) {
        this.acierto_Exigido = acierto_Exigido;
    }

    /**

            puntaje_Logrado +=10;
        }
        return puntaje_Logrado;
    }

    public void setPuntaje_Logrado(int puntaje_Logrado) {
        this.puntaje_Logrado = puntaje_Logrado;
    }



    // Methods of Class ===============================

    /**
     * Waiting for a method maybe boolean for have decision about the player alive or not
     * take of de value percent correct decisions over whole options.

    /**
     * Método que configura el juego según el nivel.
     * @param nivel_de_Juego
     */
    public void setUp_Nivel(int nivel_de_Juego){

        switch (nivel_de_Juego){
            case 1:
                cant_Palabras_a_Memorizar =10;
                total_Palabras_del_Nivel =20;
                acierto_Exigido=0.7;
                break;
            case 2:
                cant_Palabras_a_Memorizar =20;
                total_Palabras_del_Nivel =40;
                acierto_Exigido=0.7;
                break;
            case 3:
                cant_Palabras_a_Memorizar =25;
                total_Palabras_del_Nivel =50;
                acierto_Exigido=0.75;
                break;
            case 4:
                cant_Palabras_a_Memorizar =30;
                total_Palabras_del_Nivel =60;
                acierto_Exigido=0.8;
                break;
            case 5:
                cant_Palabras_a_Memorizar =35;
                total_Palabras_del_Nivel =70;
                acierto_Exigido=0.8;
                break;
            case 6:
                cant_Palabras_a_Memorizar =40;
                total_Palabras_del_Nivel =80;
                acierto_Exigido=0.85;
                break;
            case 7:
                cant_Palabras_a_Memorizar =50;
                total_Palabras_del_Nivel =100;
                acierto_Exigido=0.9;
                break;
            case 8:
                cant_Palabras_a_Memorizar =60;
                total_Palabras_del_Nivel =120;
                acierto_Exigido=0.9;
                break;
            case 9:
                cant_Palabras_a_Memorizar =70;
                total_Palabras_del_Nivel =140;
                acierto_Exigido=0.95;
                break;
            case 10:
                cant_Palabras_a_Memorizar =100;
                total_Palabras_del_Nivel =200;
                acierto_Exigido=1;
                break;
            default:
                cant_Palabras_a_Memorizar =0;
                estado=99;
                System.out.println(" no hay mas palabras a memorizar ese nivel no existe");

        }
    }

    /**
     * Método que certifica el acierto del jugador.
     * true -> decisión correcta del jugador
     * bien sea que la palabra SI está entre las palabras a memorizar
     * ó bien sea que la palabra NO está entre las palabras a memorizar.
     */
    public void decision_Correcta(){



}

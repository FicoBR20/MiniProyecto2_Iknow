package modelo;

/**
 * Esta Clase manejara la lógica del juego.
 */
public class Juego {
    private int limite_string_basico;
    /**
     * nivel: indica el nivel en que se desarrolla el juego
     * cada nivel define el valor de sus atributos.
     * empieza en nivel 1.
     */
    private int nivel;
    /**
     * Es un atributo del nivel que indica
     * cuantas palabras se le presentaran al jugador para que las memorize.
     */
    private int cant_Palabras_a_Memorizar;
    /**
     * Es un atributo de nivel que indica el total
     * de palabras existentes en el nivel.
     */
    private int total_Palabras_del_Nivel;
    /**
     * Es un atributo de nivel que indica el porcentaje mínimo
     * de aciertos para lograr superar el nivel que se esta jugando
     * y poder pasar al siguiente nivel.
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
    private boolean acierto_del_Jugador; // estado = 12 -> jugador acertó

    /**
     * Nos indica el estado del juego en cierto momento.
     * Dependiendo de su valor se ejecutaran acciones diversas.
     * 1 -> indica el inicio del juego, empieza en el nivel 1.
     * 2 -> indica que el jugador SI acertó en su decisión
     *   => acumulará 10 puntos
     * 3 -> indica que los 5 segundos para ver e intentar memorizar cada palabra ya pasaron.
     *   => se mostrará la próxima para palabra.
     * 4 -> indica que ya se presentaron todas las palabras a memorizar del respectivo nivel.
     *   => a continuacion se prsentarán todas las palabras del nivel para intentar acertar.
     * 5 -> indica que los 7 segundos para ver cada palabra y responder ya pasaron.
     *   => no acumulará puntos, es decir se toma como respuesta erronea y se presenta la siguiente palabra.
     * 6 -> indica que ya se presetaron todas las palabras del nivel.
     *   => se procede a verificar si el nivel se superó según el porcentaje de acierto exigido.
     *   => se le pregunta al jugador si desea seguir jugando (repetir nivel o siguiente nivel).
     *   => se registra el puntaje obtenido en el nivel por el jugador, el nivel que superó.
     * 7 ->
     *
     *
     *
     *
     * 99 -> indica un error de nivel debordado, solo existen 10 niveles.
     *
     *
     */
    private int estado;


    /**
     * Categoria nos indica cual biblioteca de palabras se usara en el juego
     * @info el jugador decidirá su preferencia.
     * @info se cuenta con 3 categorias; Ciudades, Animales, Profesiones.
     */
    private int categoria;
    private  String ruta;

    public int getLimite_string_basico() {
        return limite_string_basico;
    }

    public void setLimite_string_basico(int limite_string_basico) {
        this.limite_string_basico = limite_string_basico;
    }


    // From here implements the Class methods ==================================================

    /**
     * Constructor method.
     */
    public Juego(){
        limite_string_basico = 199;
        total_Palabras_del_Nivel = 0;
        cant_Palabras_a_Memorizar = 0;
        acierto_Exigido = 1;
        ruta = "";
        categoria = 0;
        estado=1;
        setUp_Nivel(estado);// juego inicia en nivel 1
        puntaje_Logrado=0;
        acierto_del_Jugador=false;

    }


    // Getter and Setter ===============================


    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

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
     * Acumula de a 10 puntos por cada
     * acierto del jugador.
     * @return puntaje_logrado
     */
    public int getPuntaje_Logrado() {
        if (estado==2){
            puntaje_Logrado +=10;
        }
        return puntaje_Logrado;
    }

    public void setPuntaje_Logrado(int puntaje_Logrado) {
        this.puntaje_Logrado = puntaje_Logrado;
    }

    public boolean isAcierto_del_Jugador() {
        return acierto_del_Jugador;
    }

    public void setAcierto_del_Jugador(boolean acierto_del_Jugador) {
        this.acierto_del_Jugador = acierto_del_Jugador;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCategoria() {
        return categoria;
    }

    public String setCategoria(int categoria) {

        switch (categoria) {
            case 1 -> {
                System.out.println(" la biblioteca es anmimal");
                return ruta = "src/resources/file/animales.txt";
            }
            case 2 -> {
                System.out.println(" la biblioteca es ciudades");
                return ruta = "src/resources/file/ciudades.txt";
            }
            case 3 -> {
                System.out.println(" la biblioteca es profesiones");
                return ruta = "src/resources/file/profecion.txt";
            }
            default -> {
                System.out.println(" solo hay 3 biliotecas por ahora");
                return ruta = "src/resources/file/empty.txt";
            }
        }
    }


    // Methods of Class ===============================

    /**
     * Waiting for a method maybe boolean for have decision about the player alive or not
     * take of de value percent correct decisions over whole options.
     * maybe like that "estado".. with values integers ?
     */



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
                total_Palabras_del_Nivel = 200;
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
        estado=12;
        acierto_del_Jugador=true;
    }

    /**
     * Método que indica si el jugador supera un nivel tomando como base
     * los puntos obtenidos.
     * @return true -> si logra igualar o superar el porcentaje de acierto exigido en el nivel en el cual está.
     *          false -> si NO se logra igualar o superar el porcentaje de acierto exigido en el nivel que está.
     */
    public boolean nivel_Superado(){
        if (puntaje_Logrado/10* total_Palabras_del_Nivel <acierto_Exigido){
            return false;
        }
        else {
            return true;
        }
    }


}

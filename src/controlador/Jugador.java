package controlador;

public class Jugador {
    private String name;
    private int nivel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Métooo constructor
     */
    public Jugador(){
        name = " ";
        nivel = 0;

    }

}

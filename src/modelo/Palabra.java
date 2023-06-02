package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Palabra {
    private  Boolean acierto;
    private final List<String>  palabra_a_Memorizar;
    private final List<String> palabra_del_Nivel;
    private  String_Basico stringBasico;

    public  List<String>  getPalabra_del_nivel() {
        return palabra_del_Nivel;
    }

    public void setPalabra_del_nivel(String categoria) throws IOException {
        for (int i = 0; i < 20; i++){
            String memoria = stringBasico.seleccionarPalabraAleatoria(stringBasico.obtenerPalabras(categoria));
            if (!palabra_del_Nivel.contains(memoria)) {
                palabra_del_Nivel.add(memoria);
            }
            else{
                String aux = "";
                while (palabra_del_Nivel.contains(memoria)){
                    memoria = stringBasico.seleccionarPalabraAleatoria(stringBasico.obtenerPalabras(categoria));
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
        for (int i = 0; i < 10; i++){
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
        stringBasico = new String_Basico();
        palabra_a_Memorizar = new ArrayList<>();
        palabra_del_Nivel = new ArrayList<>();
        acierto = false;
    }

    public void ini(){
        System.out.println("Palabras Del nivel\n");
        for (int i = 0; i <= palabra_del_Nivel.size()-1; i++){
            System.out.println("Palabra = "+(i+1)+" "+palabra_del_Nivel.get(i));
        }
        System.out.println("\nPalabras a memorizar\n");
        for (int i = 0; i <= palabra_a_Memorizar.size()-1; i++){
            System.out.println("Palabra = "+(i+1)+" "+palabra_a_Memorizar.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese un número: ");
        int numero = scanner.nextInt();

        while (numero != 0){
            comparacion(palabra_del_Nivel.get(numero-1),palabra_a_Memorizar);
            System.out.print("\nIngrese un número: ");
            numero = scanner.nextInt();
        }
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

    //Usa la consola para pruebas
    public static void main(String[] args) throws IOException {
        Palabra palabra = new Palabra();
        palabra.setPalabra_del_nivel("src/modelo/ciudades.txt");
        palabra.setPalabra_a_Memorizar();
        palabra.ini();
    }
}

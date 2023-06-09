package controlador;

import modelo.File_estado;
import modelo.Juego;
import modelo.Palabra;
import vista.*;
import vista.Panel_4_juego;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class Lanza_app_Prueba {
    private  GUI gui;
    private  Panel_1_Inicial panel_1_inicial;
    private  Panel_2_menu panel_2_menu;
    private  Panel_3_reglas panel_3_reglas;
    private Panel_4_juego panel_4_juego;
    private  Panel_5_opciones panel_5_opciones;
    private  Palabra palabra;
    private Juego juego;
    private int numero,estado;
    private String texto;
//    private static File_estado file_estado;
    private static Lanza_app_Prueba bill = null;


    /**
     * Método constructor
     */
    public Lanza_app_Prueba() throws IOException {
        gui = new GUI();
        panel_1_inicial = new Panel_1_Inicial();
        panel_3_reglas = new Panel_3_reglas();
        panel_2_menu = new Panel_2_menu();
        panel_4_juego = new Panel_4_juego();
        panel_5_opciones = new Panel_5_opciones();

        estado = 1;
//        numero = Integer.parseInt(texto);
//        file_estado = new File_estado();
//        file_estado.writer_estado("1");
//        texto = file_estado.reader_estado();

        seleccionar_pantalla(estado);
//        setestado();
    }


    public void set_numero (int num){
        numero = num;
    }
    public int get_numero (){
        return numero;
    }


    public void seleccionar_pantalla(int n){
        switch (n) {

            case 1 ->{
                System.out.println(" Switch 1 ");
                gui.setContentPane(panel_1_inicial);
                gui.revalidate();
                gui.repaint();
            }
            case 2 ->{
                System.out.println(" Switch 2 ");
                gui.setContentPane(panel_2_menu);
                gui.revalidate();
                gui.repaint();
            }
            case 3 ->{
                System.out.println(" Switch 3 ");
                gui.setContentPane(panel_3_reglas);
                gui.revalidate();
                gui.repaint();
            }
            case 4 ->{
                System.out.println(" Switch 4 ");
                gui.setContentPane(panel_4_juego);
                gui.revalidate();
                gui.repaint();
            }

            case 5 ->{
                System.out.println(" Switch 5 ");
                gui.setContentPane(panel_5_opciones);
                gui.revalidate();
                gui.repaint();
            }
        }
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            try {
                bill = new Lanza_app_Prueba();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private  void set_lans(Lanza_app_Prueba iknow) {
        bill = iknow;
    }
    private  Lanza_app_Prueba get_lans() {
        return bill;
    }


    public  void ini(){
        System.out.println("Palabras Del nivel\n");
        for (int i = 0; i <= palabra.getPalabra_del_nivel().size()-1; i++){
            System.out.println("Palabra = "+(i+1)+" "+palabra.getPalabra_del_nivel().get(i));
        }
        System.out.println("\nPalabras a memorizar\n");
        for (int i = 0; i <= palabra.getPalabra_a_Memorizar().size()-1; i++){
            System.out.println("Palabra = "+(i+1)+" "+palabra.getPalabra_a_Memorizar().get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese un número: ");
        int numero = scanner.nextInt();

        while (numero != 0){
            palabra.comparacion(palabra.getPalabra_del_nivel().get(numero-1),palabra.getPalabra_a_Memorizar());
            System.out.print("\nIngrese un número: ");
            numero = scanner.nextInt();
        }
    }

    /**
     * inner class implements Listeners used by Panel_1_Inicial class
     */
    public static class Escucha implements ActionListener {
        private File_estado file_estado;

        @Override
        public void actionPerformed(ActionEvent e) {

            if(Objects.equals(e.getActionCommand(), "ATRAS")){
                bill.seleccionar_pantalla(1);
            }

            else if(Objects.equals(e.getActionCommand(), "MENÚ")){
                bill.seleccionar_pantalla(2);
            }

            else if(Objects.equals(e.getActionCommand(), "COMO JUGAR")){
                bill.seleccionar_pantalla(3);
            }

            else if(Objects.equals(e.getActionCommand(), "JUGAR")){
                bill.seleccionar_pantalla(4);
            }

            else if(Objects.equals(e.getActionCommand(), "CONTINUAR")) {
                bill.seleccionar_pantalla(4);
            }

            else if(Objects.equals(e.getActionCommand(), "OPCIONES")){
                bill.seleccionar_pantalla(5);
            }

        }

    }

}

package controlador;

import modelo.File_estado;
import modelo.Juego;
import vista.*;
import vista.Canvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class Lanza_app_Prueba {
    private static GUI gui;
    private static Canvas canvas;
    private static Front_Inicial front_inicial;
    private static Front_Reglas front_reglas;
    private static Front_Menu frontMenu;
    private Juego juego;
    private int numero;
    private String texto;
    private static File_estado file_estado;
    private static Lanza_app_Prueba bill = null;


    /**
     * Método constructor
     */
    public Lanza_app_Prueba(){
        canvas = new Canvas();
        front_inicial = new Front_Inicial();
        front_reglas = new Front_Reglas();
        frontMenu = new Front_Menu();
        file_estado = new File_estado();
        file_estado.writer_estado("2");
        gui = new GUI();
//        texto = file_estado.reader_estado();
//        numero = Integer.parseInt(texto);
        gui.add(frontMenu);
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
                gui.revalidate();
                gui.repaint();
                gui.add(canvas);
            }
            case 2 ->{
                System.out.println(" Switch 2 ");
                gui.revalidate();
                gui.repaint();
                gui.add(front_inicial);
            }
            case 3 ->{
                System.out.println(" Switch 3 ");
                gui.revalidate();
                gui.repaint();
                gui.add(front_reglas);
            }
            case 4 ->{
                System.out.println(" Switch 4 ");
                gui.revalidate();
                gui.repaint();
                gui.add(frontMenu);

            }
        }
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            bill = new Lanza_app_Prueba();
            System.out.println(" Lectura del file "+file_estado.reader_estado());
        });
    }

    private static void set_lans(Lanza_app_Prueba iknow) {
        bill = iknow;
    }
    private static Lanza_app_Prueba get_lans() {
        return bill;
    }

    /**
     * inner class implements Listeners used by Front_Inicial class
     */
    public static class Escucha implements ActionListener {
        private File_estado file_estado;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (Objects.equals(e.getActionCommand(), "SI")){

//                bill = new Lanza_app_Prueba();
                bill.seleccionar_pantalla(4);
                get_lans().seleccionar_pantalla(1);
//
//                file_estado = new File_estado();
//                file_estado.writer_estado("4");
//                int numero = Integer.parseInt(file_estado.reader_estado());
//                seleccionar_pantalla(numero);

//                System.out.println(" Clase escucha Lectura del file "+numero);
                System.out.println(" que empieze el juego ");
            }
            else if(Objects.equals(e.getActionCommand(), "NO")){

                System.out.println(" aqui se termina el juego y se muestra de nuevo el ingreso");
                System.exit(0);
            }

        }

    }

}

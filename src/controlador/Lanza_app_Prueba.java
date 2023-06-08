package controlador;

import modelo.File_estado;
import modelo.Juego;
import vista.*;
import vista.Panel_4_canvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class Lanza_app_Prueba {
    private static GUI gui;
    private static Panel_1_Inicial panel_1_inicial;
    private static Panel_2_menu panel_2_menu;
    private static Panel_3_reglas panel_3_reglas;
    private static Panel_4_canvas panel_4_canvas;
    private Juego juego;
    private int numero,estado;
    private String texto;
//    private static File_estado file_estado;
    private static Lanza_app_Prueba bill = null;


    /**
     * Método constructor
     */
    public Lanza_app_Prueba(){
        gui = new GUI();
        panel_4_canvas = new Panel_4_canvas();
        panel_1_inicial = new Panel_1_Inicial();
        panel_3_reglas = new Panel_3_reglas();
        panel_2_menu = new Panel_2_menu();
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
                estado = 1;
            }
            case 2 ->{
                System.out.println(" Switch 2 ");
                gui.setContentPane(panel_2_menu);
                gui.revalidate();
                gui.repaint();
                estado = 1;
            }
            case 3 ->{
                System.out.println(" Switch 3 ");
                gui.setContentPane(panel_3_reglas);
                gui.revalidate();
                gui.repaint();
                estado = 1;
            }
            case 4 ->{
                System.out.println(" Switch 4 ");
                gui.setContentPane(panel_4_canvas);
                gui.revalidate();
                gui.repaint();
                estado = 1;

            }

            case 5 ->{
                System.out.println(" Switch 5 ");
                gui.setContentPane(panel_4_opciones);
                gui.revalidate();
                gui.repaint();
                estado = 1;

            }
        }
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            bill = new Lanza_app_Prueba();
//            System.out.println(" Lectura del file "+file_estado.reader_estado());
        });
    }

    private static void set_lans(Lanza_app_Prueba iknow) {
        bill = iknow;
    }
    private static Lanza_app_Prueba get_lans() {
        return bill;
    }

    /**
     * inner class implements Listeners used by Panel_1_Inicial class
     */
    public static class Escucha implements ActionListener {
        private File_estado file_estado;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (Objects.equals(e.getActionCommand(), "SI")){

                bill.seleccionar_pantalla(bill.estado);

//                file_estado = new File_estado();
//                file_estado.writer_estado("3");
//                int numero = Integer.parseInt(file_estado.reader_estado());
//                get_lans().seleccionar_pantalla(numero);
//                System.out.println(" Clase escucha Lectura del file "+numero);

                System.out.println(" que empieze el juego ");
            }
            else if(Objects.equals(e.getActionCommand(), "ATRAS")){
                bill.seleccionar_pantalla(1);
            }
            else if(Objects.equals(e.getActionCommand(), "JUGAR")){
                bill.seleccionar_pantalla(4);
            }
            else if(Objects.equals(e.getActionCommand(), "OPCIONES")){
                bill.seleccionar_pantalla(2);
            }
            else if(Objects.equals(e.getActionCommand(), "NO")){
                bill.seleccionar_pantalla(bill.estado);
            }
            else if(Objects.equals(e.getActionCommand(), "SALIR")){
                bill.seleccionar_pantalla(bill.estado);
            }

        }

    }

}

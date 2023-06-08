package controlador;

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


    /**
     * Método constructor
     */
    public Lanza_app_Prueba(){
        canvas = new Canvas();
        front_inicial = new Front_Inicial();
        front_reglas = new Front_Reglas();
        frontMenu = new Front_Menu();
        gui = new GUI();
        seleccionar_pantalla(1);
    }

    public void seleccionar_pantalla(int n){
        switch (n) {

            case 1 ->{
                System.out.println(" Switch 1 ");
                gui.add(canvas);
                gui.revalidate();
                gui.repaint();
            }
            case 2 ->{
                System.out.println(" Switch 2 ");
                gui.add(front_inicial);
                gui.revalidate();
                gui.repaint();
            }
            case 3 ->{
                System.out.println(" Switch 3 ");
                gui.add(front_reglas);
                gui.revalidate();
                gui.repaint();
            }
            case 4 ->{
                System.out.println(" Switch 4 ");
                gui.add(frontMenu);
                gui.revalidate();
                gui.repaint();

            }
        }
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Lanza_app_Prueba bill = new Lanza_app_Prueba();
//            System.out.println(" Lectura del file "+file_estado.reader_estado());
        });
    }

    /**
     * inner class implements Listeners used by Front_Inicial class
     */
    public static class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (Objects.equals(e.getActionCommand(), "SI")){
                Lanza_app_Prueba bill = new Lanza_app_Prueba();
                bill.seleccionar_pantalla(4);
                System.out.println(" que empieze el juego ");
            }
            else if(Objects.equals(e.getActionCommand(), "NO")){

                System.out.println(" aqui se termina el juego y se muestra de nuevo el ingreso");
                System.exit(0);
            }

        }

    }

}

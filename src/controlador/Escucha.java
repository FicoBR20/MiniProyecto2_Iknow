//package controlador;
//
//
//
//import modelo.File_estado;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Objects;
//
///**
// * inner class implements Listeners used by Front_Inicial class
// */
//public class Escucha implements ActionListener {
//    private File_estado file_estado;
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if (Objects.equals(e.getActionCommand(), "SI")){
//            file_estado = new File_estado();
//            file_estado.writer_estado("4");
//            System.out.println(" Clase escucha Lectura del file "+file_estado.reader_estado());
//            System.out.println(" que empieze el juego ");
//        }
//        else if(Objects.equals(e.getActionCommand(), "NO")){
//
//            System.out.println(" aqui se termina el juego y se muestra de nuevo el ingreso");
//            System.exit(0);
//        }
//
//    }
//
//}

package controlador;

import vista.Botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * inner class implements Listeners used by Front_Inicial class
 */
public class Escucha implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Objects.equals(e.getActionCommand(), "SI")){

            System.out.println(" que empieze el juego ");
        }
        else if(Objects.equals(e.getActionCommand(), "NO")){
            System.out.println(" aqui se termina el juego y se muestra de nuevo el ingreso");
        }

    }

}

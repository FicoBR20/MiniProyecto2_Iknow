package vista;


import javax.swing.JFrame;
        import javax.swing.JTextField;

public class v {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo Enfocar JTextField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        frame.getContentPane().add(textField);

        frame.pack();
        frame.setVisible(true);

        // Enfocar el JTextField
        textField.requestFocus();
    }
}

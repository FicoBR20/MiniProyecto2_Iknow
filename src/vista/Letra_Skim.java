package vista;

import controlador.Lanza_app_Prueba;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Letra_Skim extends  JLabel{
    private Lanza_app_Prueba.Escucha escucha;
    private ImageIcon imageIcon;
    private int tamaño_fuente,alto,ancho;
    private JPanel panel_palabra;
    private JPanel panel_linea;
    private String rutaFuente;

    private ArrayList<JButton> palabras_array;

    public int getTamaño_fuente() {
        return tamaño_fuente;
    }

    public void setTamaño_fuente(int tamaño_fuente) {
        this.tamaño_fuente = tamaño_fuente;
    }
    public void setTamaño_boton(int ancho, int  alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public void activar() {
        this.setEnabled(true);
    }

    public void desactivar() {
        this.setEnabled(false);
    }
    public Letra_Skim() {
        rutaFuente = "";
        panel_palabra = new JPanel();
        panel_linea = new JPanel();
        palabras_array = new ArrayList<>();
        tamaño_fuente = 15;
        ancho=120;
        alto = 40;
        escucha = new Lanza_app_Prueba.Escucha();
        this.setBackground(null);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setFocusable(false); //Quita linea de los botones
        imageIcon = new ImageIcon();
    }

    /**
     * Método de sobrecarga la clase Botones que estos parametros
     * @param titulo
     * @param tamaño
     * @param _ancho
     * @param _alto
     */

    public Letra_Skim(String titulo, int tamaño, int _ancho, int _alto  ) {
        this.setText(titulo);
        tamaño_fuente = tamaño;
        ancho = _ancho;
        alto = _alto;
        escucha = new Lanza_app_Prueba.Escucha();
        this.setBackground(new Color(0x0000000, true));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setFocusable(false);//Quita linea de los botones
        imageIcon = new ImageIcon();
        getBoton_style_1(titulo);
    }

    public void set_font(String rutaFuente) {
        this.rutaFuente = rutaFuente;
    }

    public JLabel sin_estilo(String titulo) {
        // Reemplaza con la ruta correcta de tu fuente

        // Cargar la fuente desde el archivo
        Font nuevaFuente = cargarFuente(rutaFuente, Font.PLAIN, 100); // Establece el estilo y tamaño deseado

        // Crear un JLabel con la fuente cargada
        JLabel etiqueta = new JLabel("Texto con fuente cargada");
        this.setForeground(Color.white);
        this.setText(titulo);
        this.setFont(nuevaFuente);
//        this.setFont(new Font(null,Font.BOLD,50));
        return this;
    }


    public JLabel getBoton_style_1(String titulo ) {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton.png")));
        this.setForeground(Color.white);
        this.setText(titulo);
        this.setFont(new Font(null,Font.BOLD,tamaño_fuente));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        return this;
    }

    public JLabel getBoton_style_2(String titulo) {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/Boton_2.png")));
        this.setForeground(Color.white);
        this.setText(titulo);
        this.setFont(new Font(null,Font.BOLD,tamaño_fuente));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        return this;
    }
    public JPanel seText_grafico(String palabra) {
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gridBagLayout = new GridBagLayout();

        panel_palabra.removeAll();
        panel_palabra.setBackground(null);
        panel_palabra.setLayout(gridBagLayout);

        panel_linea.removeAll();
        panel_linea.setBackground(null);
        panel_linea.setLayout(gridBagLayout);

        int cont_y = 0;
        int cont_x = 0;

        for ( String linea : palabra.split(" ")) {
            gbc.gridwidth=1; // ocupara 1 columnas
            gbc.gridheight=1; // ocupara 1 filas

            for ( String letra : linea.split("")) {
                gbc.gridx=cont_x; // columna
                gbc.gridy=cont_y; // fila

                Letra_Skim botonX = new Letra_Skim();
                imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones_nivel/nivel.png")));
                botonX.setForeground(Color.white);
                botonX.setFont(new Font(null,Font.BOLD,30));
                botonX.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)));
                botonX.setText(letra);

                panel_palabra.add(botonX,gbc);
                cont_x++;
            }
            panel_linea.add(panel_palabra,gbc);

            cont_y++;
            cont_x=0;
        }
        panel_linea.setBackground(new Color(0x0000000, true));
        return panel_linea;
    }


    public JPanel seText_grafico(String palabra, int skim, int tamaño,int ancho,int alto) {
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gridBagLayout = new GridBagLayout();

        panel_palabra.removeAll();
        panel_palabra.setBackground(null);
        panel_palabra.setLayout(gridBagLayout);

        panel_linea.removeAll();
        panel_linea.setBackground(null);
        panel_linea.setLayout(gridBagLayout);

        int cont_y = 0;
        int cont_x = 0;

        for ( String linea : palabra.split(" ")) {
            gbc.ipady = 15;
//            gbc.ipadx = 15;
            gbc.gridwidth=1; // ocupara 1 columnas
            gbc.gridheight=1; // ocupara 1 filas

            for ( String letra : linea.split("")) {
                gbc.gridx=cont_x; // columna
                gbc.gridy=cont_y; // fila

                Letra_Skim botonX = new Letra_Skim();
                imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/botones/"+skim+".png")));
                botonX.setForeground(Color.white);
                botonX.setFont(new Font(null,Font.BOLD,tamaño));
                botonX.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
                botonX.setText(letra);

                panel_palabra.add(botonX,gbc);
                cont_x++;
            }
            gbc.anchor=GridBagConstraints.CENTER;
            panel_linea.add(panel_palabra,gbc);

            cont_y++;
            cont_x=0;
        }
        panel_linea.setBackground(new Color(0x0000000, true));
        return panel_linea;
    }


    public JPanel seText_grafico(String palabra, int tamaño,int ancho,int alto) {
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gridBagLayout = new GridBagLayout();

        panel_palabra.removeAll();
        panel_palabra.setBackground(null);
        panel_palabra.setLayout(gridBagLayout);

        panel_linea.removeAll();
        panel_linea.setBackground(null);
        panel_linea.setLayout(gridBagLayout);

        int cont_y = 0;
        int cont_x = 0;

        for ( String linea : palabra.split(" ")) {
            gbc.ipady = 15;
            gbc.ipadx = 15;
            gbc.gridwidth=1; // ocupara 1 columnas
            gbc.gridheight=1; // ocupara 1 filas

            for ( String letra : linea.split("")) {
                gbc.gridx=cont_x; // columna
                gbc.gridy=cont_y; // fila

                Letra_Skim botonX = new Letra_Skim();
                botonX.setForeground(Color.white);
                botonX.setFont(new Font(null,Font.BOLD,tamaño));
                botonX.setText(letra);

                panel_palabra.add(botonX,gbc);
                cont_y++;
            }
            panel_linea.add(panel_palabra,gbc);

//            cont_y++;
//            cont_x=0;
        }
        panel_linea.setBackground(new Color(0x0000000, true));
        return panel_linea;
    }


    public Font cargarFuente(String ruta, int estilo, int tamaño) {
        try {

            Font fuente = Font.createFont(Font.TRUETYPE_FONT, new File(ruta));

            return fuente.deriveFont(estilo, tamaño);
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, devolver una fuente por defecto
            return new Font(Font.SERIF, estilo, tamaño);
        }
    }
}

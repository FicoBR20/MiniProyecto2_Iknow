package modelo;

import java.io.*;

public class File_estado {

    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    public String reader_estado(){
        String text = "";

        try {
            fileReader = new FileReader("src/resources/estado/estado.txt");
            input = new BufferedReader(fileReader);
            String line = input.readLine(); // almacena lo que se escribe en el text field

            while(line != null){
                text += line;
//                text += "\n";
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Estoy dentro de la excepcion");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            }  catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                System.out.println("Estoy dentro del finally");
                e.printStackTrace();
            }
        }

        return text;
    }

    public void writer_estado(String line){
        try {
//            String text = reader_estado();// recepciona el String generado en el reader.
//            text += line + "\n";
            fileWriter = new FileWriter("src/resources/estado/estado.txt");
            output = new BufferedWriter(fileWriter);
            output.write(line);
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package sistemapaneles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter; // Agrega esta importación
import java.io.BufferedWriter; // Agrega esta importación

public class Historial {
    // Especifica la ruta de tu archivo .txt
    private String rutaDelArchivo = "./src/sistemapaneles/historial.txt";

    public void leerHistorial() {
        try {
            File archivo = new File(rutaDelArchivo);

            // Verifica si el archivo existe
            if (archivo.exists()) {
                // Crea un FileReader para leer el archivo
                FileReader fileReader = new FileReader(archivo);
                
                // Crea un BufferedReader para leer el archivo de manera eficiente
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                
                String linea;
                
                // Lee y muestra cada línea del archivo
                while ((linea = bufferedReader.readLine()) != null) {
                    System.out.println(linea);
                }
                
                // Cierra el BufferedReader y el FileReader
                bufferedReader.close();
                fileReader.close();
            } else {
                System.err.println("El archivo no existe en la ruta especificada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void agregarTextoAlHistorial(String texto) {
        try {
            // Crea un FileWriter para escribir en el archivo (el 'true' permite agregar al archivo existente)
            FileWriter fileWriter = new FileWriter(rutaDelArchivo, true);

            // Crea un BufferedWriter para escribir de manera eficiente
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribe la cadena de texto en el archivo
            bufferedWriter.newLine(); // Agrega una nueva línea
            bufferedWriter.write(texto);
            bufferedWriter.newLine(); // Agrega una nueva línea

            // Cierra el BufferedWriter y el FileWriter
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

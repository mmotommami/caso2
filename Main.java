/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemapaneles;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mariangel Alfaro Diaz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("./src/sistemapaneles/dispositivos.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray dispositivosArray = (JSONArray) jsonObject.get("dispositivos");

            PanelSolar p1 =new PanelSolar(500.0);
            PanelSolar p2 =new PanelSolar(500.0);
            
            Bateria bateria = new Bateria(1000.0);
            bateria.addPanel(p1);
            bateria.addPanel(p2);
            
            Casa casa = new Casa(bateria);

            for (Object dispositivoObj : dispositivosArray) {
                JSONObject dispositivoJSON = (JSONObject) dispositivoObj;
                String nombre = (String) dispositivoJSON.get("nombre");
                double consumoEnergico = (Double) dispositivoJSON.get("consumo");
                int horasActivo = ((Long) dispositivoJSON.get("activo")).intValue();
                int horaInicio = ((Long) dispositivoJSON.get("inicio")).intValue();

                Dispositivo dispositivo = new Dispositivo(nombre, consumoEnergico, horasActivo, horaInicio);
                casa.agregarDispositivo(dispositivo);
                
            }
            ThreadCasa t1 = new ThreadCasa(0,casa);
            t1.run();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    
}

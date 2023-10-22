package sistemapaneles;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Jsonparse {
    private String nombre;
    private double consumo;
    private double capacidadB;
    private double capacidadP;
    private JSONArray dispositivosArray; 
    
    public void cargar() {
        JSONParser parser = new JSONParser();

       try {
    	   Object obj = parser.parse(new FileReader("./src/sistemapaneles/dispositivos.json"));
           JSONObject jsonObject = (JSONObject) obj;
           dispositivosArray = (JSONArray) jsonObject.get("dispositivos");
           JSONArray panelesArray = (JSONArray) jsonObject.get("panel");
           JSONArray bateriasArray = (JSONArray) jsonObject.get("bateria");
           
           JSONObject panelObject = (JSONObject) panelesArray.get(0);
           capacidadP = (Double) panelObject.get("capacidad");
           System.out.println("Capacidad del panel: " + capacidadP);
           
           JSONObject bateriaObject = (JSONObject) bateriasArray.get(0);
           capacidadB = (Double) bateriaObject.get("capacidad");
           System.out.println("Capacidad de la bateria: " + capacidadB);

       } 
       
       catch (Exception e) {
           e.printStackTrace();
           }
    }
    // Getter para el atributo nombre
       public String getNombre() {
           return nombre;
       }

       // Getter para el atributo consumo
       public double getConsumo() {
           return consumo;
       }

       // Getter para el atributo capacidadB
       public double getCapacidadB() {
           return capacidadB;
       }

       // Getter para el atributo capacidadP
       public double getCapacidadP() {
           return capacidadP;
       }
       
       // Getter para el atributo dispositivosArray
       public JSONArray getDispositivosArray() {
           return dispositivosArray;
       }
   }





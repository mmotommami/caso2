
package sistemapaneles;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileOutputStream;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mariangel Alfaro Diaz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		
	    
		
		Historial historial = new Historial();
		
	    Jsonparse jsonParser = new Jsonparse();
	    jsonParser.cargar();

	    // Obtener el valor de capacidadB
	    double capacidadB = jsonParser.getCapacidadB();
	    System.out.println("Capacidad de la bateria: " + capacidadB);

	    // Obtener el valor de capacidadP
	    double capacidadP = jsonParser.getCapacidadP();
	    System.out.println("Capacidad del panel: " + capacidadP);
	    
	    // Obtener el JSONArray de dispositivos
	    JSONArray dispositivosArray = jsonParser.getDispositivosArray();

	    PanelSolar p1 = new PanelSolar(capacidadP,historial);
	    PanelSolar p2 = new PanelSolar(capacidadP,historial);
	    
	    Bateria bateria = new Bateria(capacidadB,historial);
	    bateria.addPanel(p1);
	    bateria.addPanel(p2);
	    
	    Casa casa = new Casa(bateria, historial);

	    for (Object dispositivoObj : dispositivosArray) {
	        JSONObject dispositivoJSON = (JSONObject) dispositivoObj;
	        String nombre = (String) dispositivoJSON.get("nombre");
	        double consumoEnergico = (Double) dispositivoJSON.get("consumo");
	        int horasActivo = ((Long) dispositivoJSON.get("activo")).intValue();
	        int horaInicio = ((Long) dispositivoJSON.get("inicio")).intValue();
	        
	        Dispositivo dispositivo = new Dispositivo(nombre, consumoEnergico, horasActivo, horaInicio);
	        casa.agregarDispositivo(dispositivo);
	        
	    }
	    // Crear una instancia de la ventana de interfaz gráfica y pasar la Casa como argumento
	    //SwingUtilities.invokeLater(new Runnable() {
	    //    public void run() {
	    //        VentanaInterfaz ventana = new VentanaInterfaz(casa);
	    //        ventana.setVisible(true);
	    //   }
	    //});
	    
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CuadrosGUI(casa);
            }
        });
	    
	    ThreadCasa t1 = new ThreadCasa(0,casa,historial);
	    t1.run();
	   
	    
	}
}
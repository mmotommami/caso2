/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemapaneles;

import java.util.ArrayList;

/**
 *
 * @author Mariangel Alfaro Diaz
 */
public class Bateria extends FuenteDeEnergia{
    //Atributo de la clase
    private ArrayList<PanelSolar> paneles = new ArrayList<>();
    
    /**
     * Constructor de la clase
     * @param capacidadMaxima 
     */
    public Bateria(double capacidadMaxima,Historial historial) {
        this.capacidadMaxima = capacidadMaxima;
        this.energiaDisponible = capacidadMaxima;
        this.historial = historial;
    }
    
    /**
     * Metodo para recargar la energia de la bateria usando energia de los paneles
     * @param horaActual 
     */
    public void recargar(int horaActual){
        if(17 >= horaActual){ // Los paneles solo se recargan de 5 am a 5pm
            if(horaActual >= 5){
                recargarPaneles();
            }
        }
        for (int i = 0; i < paneles.size(); i++) {
            if (getCapacidadMaxima() !=  energiaDisponible){ // Verifica si falta energia
                if (paneles.get(i).energiaDisponible>0.0){ //Verifica si el panel tiene energia
                    if(paneles.get(i).energiaDisponible< getCapacidadMaxima()-energiaDisponible){ //Verifica si la energia del panel puede llenar la bateria
                        this.energiaDisponible += paneles.get(i).energiaDisponible;
                        paneles.get(i).setEnUso(paneles.get(i).energiaDisponible);
                    }
                    else{
                        paneles.get(i).setEnUso(getCapacidadMaxima()-energiaDisponible);
                        this.energiaDisponible += getCapacidadMaxima()-energiaDisponible;
                        System.out.println("Bateria cargada completamente" );
                        historial.agregarTextoAlHistorial("Bateria cargada completamente" );
                    }
                }
            }
        }
        System.out.println("Energia disponible en la bateria: " + this.energiaDisponible );
        historial.agregarTextoAlHistorial("Energia disponible en la bateria: " + this.energiaDisponible );
    }
    
    /**
     * Metodo para recargar los paneles del ArrayList
     */
    public void recargarPaneles(){
       for (int i = 0; i < paneles.size(); i++) {
            paneles.get(i).recargar(50.0,i);
        } 
    }
    
    /**
     * Metodo para ligar un panel solar a la bateria
     * @param newPanel 
     */
    public void addPanel(PanelSolar newPanel){
        this.paneles.add(newPanel);
    }
    
}

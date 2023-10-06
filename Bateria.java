/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareamari;

import java.util.ArrayList;

/**
 *
 * @author XPC
 */
public class Bateria extends FuenteDeEnergia{
    private ArrayList<PanelSolar> paneles = new ArrayList<>();
    
    public Bateria(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.energiaDisponible = capacidadMaxima;
    }
    
    public void recargar(int horaActual){
        if(17 >= horaActual){
            if(horaActual >= 5){
                recargarPaneles();
            }
        }
        for (int i = 0; i < paneles.size(); i++) {
            if (getCapacidadMaxima() !=  energiaDisponible){
                if (paneles.get(i).energiaDisponible>0.0){
                    if(paneles.get(i).energiaDisponible< getCapacidadMaxima()-energiaDisponible){
                        this.energiaDisponible += paneles.get(i).energiaDisponible;
                        paneles.get(i).setEnUso(paneles.get(i).energiaDisponible);
                    }
                    else{
                        paneles.get(i).setEnUso(getCapacidadMaxima()-energiaDisponible);
                        this.energiaDisponible += getCapacidadMaxima()-energiaDisponible;
                        System.out.println("Bateria cargada completamente" );
                    }
                }
            }
        }
        System.out.println("Energia disponible en la bateria: " + this.energiaDisponible );

    }
    
    public void recargarPaneles(){
       for (int i = 0; i < paneles.size(); i++) {
            paneles.get(i).recargar(50.0,i);
        } 
    }
    
    public void addPanel(PanelSolar newPanel){
        this.paneles.add(newPanel);
    }
    
}

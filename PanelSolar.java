/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareamari;

/**
 *
 * @author XPC
 */
public class PanelSolar extends FuenteDeEnergia {
    
    public PanelSolar(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.energiaDisponible = 0.0;
    }
    
    public void recargar(double extra, int numPanel){
        int aux = numPanel+1;
        if(getCapacidadMaxima() == energiaDisponible){
            System.out.println("El panel " + aux + " esta cargado completamente");
        }else{
            if (getCapacidadMaxima() < energiaDisponible + extra){
                this.energiaDisponible = getCapacidadMaxima();
                System.out.println("El panel " + aux + " esta cargado completamente");
            }else{
               this.energiaDisponible += extra;
               System.out.println("Energia disponible en el panel " + aux + ": " + this.energiaDisponible );
            }
        }
    }
    
}

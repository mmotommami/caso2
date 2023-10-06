/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareamari;

/**
 *
 * @author XPC
 */
public class FuenteDeEnergia {
    double capacidadMaxima;
    double enUso;
    double energiaDisponible;

    public FuenteDeEnergia() {
        this.capacidadMaxima = 0.0;
        this.enUso = 0.0;
    }
    
    
    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getEnUso() {
        return enUso;
    }

    public void setEnUso(double enUso) {
        this.energiaDisponible -= enUso;
        this.enUso += enUso;
        //getEnergiaDisponible();
    }
    
    public double getEnergiaDisponible(){
        double disponible = this.energiaDisponible-this.enUso;
        this.energiaDisponible = disponible;
        return this.energiaDisponible;
    }

    public void setEnergiaDisponible(double energiaDisponible) {
        this.energiaDisponible = energiaDisponible;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemapaneles;

/**
 *
 * @author Mariangel Alfaro Diaz
 */
public class FuenteDeEnergia {
    // Atributos de la clase
    double capacidadMaxima;
    double enUso;
    double energiaDisponible;
    Historial historial;
    
    /**
     * Constructor de la clase
     */
    public FuenteDeEnergia() {
        this.capacidadMaxima = 0.0;
        this.enUso = 0.0;
    }
    
    /**
     * Metodo para agregar energia usada y quitarle energia disponible
     * @param enUso 
     */
    public void setEnUso(double enUso) {
        this.energiaDisponible -= enUso;
        this.enUso += enUso;
    }
    
    // Getters y setters de la clase
    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getEnUso() {
        return enUso;
    }
    
    public void setEnergiaDisponible(double energiaDisponible) {
        this.energiaDisponible = energiaDisponible;
    }
    
    
}

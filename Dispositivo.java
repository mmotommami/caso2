/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemapaneles;

/**
 *
 * @author Mariangel Alfaro Diaz
 */
public class Dispositivo {
    private String nombre;
    private double consumoEnergico;
    private boolean activo;
    private int horasActivo;
    private int horaInicio;
    
    /**
     * Constructor de la clase
     * @param nombre
     * @param consumoEnergico
     * @param horasActivo
     * @param horaInicio 
     */
    public Dispositivo(String nombre, double consumoEnergico, int horasActivo, int horaInicio) {
        this.nombre = nombre;
        this.consumoEnergico = consumoEnergico;
        this.activo = false;
        this.horasActivo = horasActivo;
        this.horaInicio = horaInicio;

    }
    
    // Getters y setters de la clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getConsumoEnergico() {
        return consumoEnergico;
    }

    public void setConsumoEnergico(double consumoEnergico) {
        this.consumoEnergico = consumoEnergico;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getHorasActivo() {
        return horasActivo;
    }

    public void setHorasActivo(int horasActivo) {
        this.horasActivo = horasActivo;
    }
    
    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }
    
}

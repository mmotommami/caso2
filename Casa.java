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
public class Casa {
    // Atributos de la clase
    private Bateria bateria;
    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();
    
    
    /**
     * Constructor de la clase
     * @param bateria 
     */
    public Casa(Bateria bateria) {
        this.bateria = bateria;
    }
    
    /**
     * Metodo para agregar un dispositivo a la casa
     * @param nuevo 
     */
    public void agregarDispositivo(Dispositivo nuevo){
        dispositivos.add(nuevo);
        System.out.println("Dispositivo " + nuevo.getNombre() + " agregado correctamente. Se conectara a la(s) " + nuevo.getHoraInicio() + " hora(s) por un tiempo de " + nuevo.getHorasActivo() + " hora(s)");
    }
    
    /**
     * Metodo para encender a la hora indicada cada dispositivo de la casa
     * @param hora 
     */
    public void encenderDispositivos(int hora){
        this.bateria.recargar(hora);
        for (int i = 0; i < dispositivos.size(); i++) {
            if(!dispositivos.get(i).isActivo() && hora == dispositivos.get(i).getHoraInicio()){ //Verifica si el dispositivo debe conectarse
                if(this.bateria.energiaDisponible> dispositivos.get(i).getConsumoEnergico()){ // Verifica si hay energia para conectarlo
                    dispositivos.get(i).setActivo(true);
                    this.bateria.setEnUso(dispositivos.get(i).getConsumoEnergico());
                    System.out.println("El dispositivo " + dispositivos.get(i).getNombre() + " se conecto correctamente");
                    System.out.println("Energia disponible en la bateria: " + this.bateria.energiaDisponible);
                }
                else{
                    System.out.println("El dispositivo " + dispositivos.get(i).getNombre() + " no se conecto debido a que la energia de la bateria esta ocupada");
                }
            }
        }
    }
    
    /**
     * Metodo para apagar los dispositivos despues de su ciclo
     * @param hora 
     */
    public void apagarDispositivos(int hora){
        for (int i = 0; i < dispositivos.size(); i++) {
            if(dispositivos.get(i).isActivo() && hora == dispositivos.get(i).getHoraInicio() + dispositivos.get(i).getHorasActivo()){
                dispositivos.get(i).setActivo(false);
                this.bateria.setEnUso(-dispositivos.get(i).getConsumoEnergico());
                System.out.println("El dispositivo " + dispositivos.get(i).getNombre() + " se desconecto correctamente");
            }
        }
    }
}

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
public class Casa {
    private Bateria bateria;
    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public Casa(Bateria bateria) {
        this.bateria = bateria;
    }
    
    public void agregarDispositivo(Dispositivo nuevo){
        dispositivos.add(nuevo);
        System.out.println("Dispositivo " + nuevo.getNombre() + " agregado correctamente. Se conectara a la(s) " + nuevo.getHoraInicio() + " hora(s) por un tiempo de " + nuevo.getHorasActivo() + " hora(s)");
    }
    
    public void encenderDispositivos(int hora){
        this.bateria.recargar(hora);
        for (int i = 0; i < dispositivos.size(); i++) {
            if(!dispositivos.get(i).isActivo() && hora == dispositivos.get(i).getHoraInicio()){
                if(this.bateria.energiaDisponible> dispositivos.get(i).getConsumoEnergico()){
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

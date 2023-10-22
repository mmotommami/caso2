/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemapaneles;

import static java.lang.Thread.sleep;
import java.util.Scanner;

/**
 *
 * @author Mariangel Alfaro Diaz
 */
public class ThreadCasa extends Thread {
    private boolean running = true;
    private boolean paused = false;
    private int horaInicio;
    private Casa casa;
    private Historial historial;
    
    /**
     * Constructor de la clase
     * @param horaInicio
     * @param casa 
     */
    public ThreadCasa(int horaInicio, Casa casa, Historial historial) {
        this.horaInicio = horaInicio;
        this.casa = casa;
        this.historial = historial;
    }
    
    /**
     * Metodo que inicializa el hilo
     */
    @Override
    public void run() {
        int horaActual = horaInicio;
        while (running){
            
            try {
                sleep(1500);
                System.out.println("Hora actual: " + horaActual + ":00");
                historial.agregarTextoAlHistorial("Hora actual: " + horaActual + ":00");
                this.casa.encenderDispositivos(horaActual);  
                this.casa.apagarDispositivos(horaActual);
                if (horaActual == 23){
                    horaActual = 0;
                }else{
                    horaActual++;
                }
                if (horaInicio == horaActual){
                    Scanner input = new Scanner(System.in);  
                    System.out.println("Desea continuar? y/n: ");

                    String respuesta = input.nextLine();
                    if(respuesta.toLowerCase().trim().equals("n")){
                        detener();
                    }else{
                        System.out.println("--------------------------------------------------");
                    }
                }

            } catch (InterruptedException ex) {
                
            }
        }        
    }
    
    /**
     * Metodo para verificar el estado del hilo
     * @return boolean
     */
    public boolean isRunning() {
        return running;
    }
    
    /**
     * Metodo para detener el hilo
     */
    public void detener(){
        this.running = false;
    }
    
    
    
}

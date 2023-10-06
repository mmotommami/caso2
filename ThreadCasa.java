/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareamari;

import static java.lang.Thread.sleep;

/**
 *
 * @author XPC
 */
public class ThreadCasa extends Thread {
    private boolean running = true;
    private boolean paused = false;
    private int horaInicio;
    private Casa casa;

    public ThreadCasa(int horaInicio, Casa casa) {
        this.horaInicio = horaInicio;
        this.casa = casa;
    }
    
    @Override
    public void run() {
        int horaActual = horaInicio;
        while (running){
            
            try {
                sleep(1500);
                System.out.println("Hora actual: " + horaActual + ":00");
                this.casa.encenderDispositivos(horaActual);
                this.casa.apagarDispositivos(horaActual);
                if (horaActual == 23){
                    horaActual = 0;
                }else{
                    horaActual++;
                }
                if (horaInicio == horaActual){
                    detener();
                }

            } catch (InterruptedException ex) {
                
            }
        }        
    }

    public boolean isRunning() {
        return running;
    }
    
    public void pause(){
        this.paused = !this.paused;
    }

    public boolean isPaused() {
        return paused;
    }
    
    public void detener(){
        this.running = false;
    }
    
    
    
}
